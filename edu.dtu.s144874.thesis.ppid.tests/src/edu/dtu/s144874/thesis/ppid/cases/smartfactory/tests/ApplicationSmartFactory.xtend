package edu.dtu.s144874.thesis.ppid.cases.smartfactory.tests

class ApplicationSmartFactory {
	public static val APPLICATION = '''
	//@App:name("SiddhiFactoryMonitoring")
	// Improvements: inheritance,
	
	let ProductionInstances: Instance
	
	let StorageInstances: Instance
	
	
	entity Instance {
		instancenumber: number
		ts: string
	}
	
	
	entity BasicStream {
		active: number
		code: number 
		description: string
		station: string
	}
	
	entity BasicStreamWithTarget {
		active: number
		code: number
		description: string
		station: string
		target: string
	}
	entity StateStream {
		state: string
		id: string
	}
	
	source SmartFactoryDsi "f/i/state/dsi": BasicStream
	source SmartFactoryMpo "f/i/state/mpo": BasicStream
	source SmartFactoryVgr "f/i/state/vgr": BasicStreamWithTarget
	source SmartFactorySld "f/i/state/sld": BasicStream
	source SmartFactoryDso "f/i/state/dso": BasicStream
	source SmartFactoryHbw "f/i/state/hbw": BasicStream
	
	source SmartFactoryOrders "f/i/order" "siddhiorder": StateStream
	//source SmartFactoryOrders "f/i/order" StateStream mapping(id = "$.workpiece.id", state = "$.workpiece.state")
	
	//
	//@source(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhinfc", topic = "f/i/nfc/ds",  
	//	@map(type = 'json', fail.on.missing.attribute="false", 
	//		@attributes(id = "$.workpiece.id", state = "$.workpiece.state", $.workpiece.state)))
	//define stream SmartFactoryNfcStream (id string, state string, type string, ts string);
	// This is more complex...
	
	entity NfcStream {
		state: string
		id: string
	}
	
	source SmartFactoryNfc "f/i/nfc/ds" "siddhinfc" { id : "$.workpiece.id" state: "$.workpiece.state" } : NfcStream
	
	
	
	//# "THIS IS RAW INPUIT"
	
	entity SmartFactoryStockEntity {
		colora1: string
		colora2: string
		colora3: string
		colorb1: string
		colorb2: string
		colorb3: string
		colorc1: string
		colorc2: string
		colorc3: string
	}
	
	source SmartFactoryStock "f/i/stock" "siddhistock" {
		colora1: "$.stockItems[0].workpiece.type" colora2: "$.stockItems[1].workpiece.type" colora3: "$.stockItems[2].workpiece.type"
	    colorb1: "$.stockItems[3].workpiece.type" colorb2: "$.stockItems[4].workpiece.type" colorb3: "$.stockItems[5].workpiece.type"
	    colorc1: "$.stockItems[6].workpiece.type" colorc2: "$.stockItems[7].workpiece.type" colorc3: "$.stockItems[8].workpiece.type"
	}: SmartFactoryStockEntity
	
	
	//@sink(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhipub", topic = "siddhi/$caseId",  quality.of.service= '0', @map(type='json'))
	//define stream SiddhiOutMqtt (processName string, caseId string, activityName string, state string, resource string, ts string);
	//
	
	entity SiddhiOutMqttEntity {
		state: string
		resource: string
	}
	
	//sink SiddhiOutMqtt: SiddhiOutMqttEntity
	
	
	sink SiddhiProductionOut: SiddhiOutMqttEntity
	sink SiddhiStorageOut: SiddhiOutMqttEntity
	
	process storageprocess {
		case = global.StorageInstances.instancenumber
		
		activity piecedelivery {
			on SmartFactoryDsi.active.change(0,1) => { state: 'end', resource: 'dsi' } into SiddhiStorageOut  
		}     
		activity vgrmovetohbw { 
			on SmartFactoryVgr.active.change(0,1) and   
			SmartFactoryVgr.code.change(1,2) and    
			SmartFactoryVgr.target.is('hbw') => { state: 'start', resource: 'vgr' } into SiddhiStorageOut
			  
		}     
		  
		activity readnfc {
			 
			
			
			
	//	TODO the source attributes
	//@info(name='ReadNfcQuery')
	//from SmartFactoryNfcStream[type == 'NONE']
	//select 'storageprocess' as processName, 'readnfc' as activityName, 'end' as state, 'nfc' as resource, ts
	//insert into SiddhiStorageOut;
	//
	//@info(name='WriteNfcDeliveryQuery')
	//from every e1 = SmartFactoryNfcStream, e2 = SmartFactoryNfcStream[(e1.type) == 'NONE' and not (e2.type == 'NONE')]
	//select 'storageprocess' as processName, 'writenfc' as activityName, 'end' as state, 'nfc' as resource, e2.ts as ts
	//insert into SiddhiStorageOut;
		}
		
		activity movecontainer {
			on SmartFactoryHbw.active.change(0,1) and
			SmartFactoryHbw.code.change(1,2) => { state: 'start', resource: 'hbw' } into SiddhiStorageOut
			on SmartFactoryHbw.active.change(1,0) and
			SmartFactoryHbw.code.change(2,1) => { state: 'end', resource: 'hbw' } into SiddhiStorageOut
		}
		
		activity instancecounting {
			on SmartFactoryDsi.active.is(1) => set StorageInstances = {instancenumber: global.StorageInstances.instancenumber + 1}
		}
		
		
	}
	
	process productionprocess {
		case = global.ProductionInstances.instancenumber
		
		activity instancecounting {
			on SmartFactoryOrders.state.is('ORDERED') => set ProductionInstances = {instancenumber: global.ProductionInstances.instancenumber + 1}
		}
		activity vgrmovetohbw {
			
			on SmartFactoryVgr.active.change(0,1) and
			SmartFactoryVgr.code.change(1,2) and
			SmartFactoryVgr.target.is('hbw') => { state: 'start', resource: 'vgr' } into SiddhiProductionOut
			on SmartFactoryVgr.active.change(1,0) and
			SmartFactoryVgr.code.change(2,1) and
			SmartFactoryVgr.target.is('hbw') => { state: 'end', resource: 'vgr' } into SiddhiProductionOut
			
			on SmartFactoryVgr.active.change(0,1) and
			SmartFactoryVgr.code.change(1,2) and
			SmartFactoryVgr.target.is('mpo') => { state: 'start', resource: 'vgr' } into SiddhiProductionOut
			on SmartFactoryVgr.active.change(1,0) and
			SmartFactoryVgr.code.change(2,1) and
			SmartFactoryVgr.target.is('mpo') => { state: 'end', resource: 'vgr' } into SiddhiProductionOut
			
			on SmartFactoryVgr.active.change(0,1) and
			SmartFactoryVgr.code.change(1,2) and
			SmartFactoryVgr.target.is('dso') => { state: 'start', resource: 'vgr' } into SiddhiProductionOut
			on SmartFactoryVgr.active.change(1,0) and
			SmartFactoryVgr.code.change(2,1) and
			SmartFactoryVgr.target.is('dso') => { state: 'end', resource: 'vgr' } into SiddhiProductionOut
		}
		
		
		
		
		activity movecontainer {
			
			on SmartFactoryHbw.active.change(0,1) and
			SmartFactoryHbw.code.change(1,2) => { state: 'start', resource: 'hbw' } into SiddhiProductionOut
			on SmartFactoryHbw.active.change(1,0) and
			SmartFactoryHbw.code.change(2,1) => { state: 'end', resource: 'hbw' } into SiddhiProductionOut
		}
		
		
		activity productorder {
			on SmartFactoryOrders.state.is('ORDERED') => {state: 'end', resource: 'erp' } into SiddhiProductionOut
		}
		
		activity simulateproduction { 
			on SmartFactoryMpo.active.change(0,1) and
			SmartFactoryMpo.code.change(1,2) => { state: 'start', resource: 'mpo' } into SiddhiProductionOut
			on SmartFactoryMpo.active.change(1,0) and
			SmartFactoryMpo.code.change(2,1) => { state: 'end', resource: 'mpo' } into SiddhiProductionOut
		}
		
		activity simulateproduction {
			on SmartFactoryMpo.active.change(0,1) and
			SmartFactoryMpo.code.change(1,2) => { state: 'start', resource: 'mpo' } into SiddhiProductionOut
			on SmartFactoryMpo.active.change(1,0) and
			SmartFactoryMpo.code.change(2,1) => { state: 'end', resource: 'mpo' } into SiddhiProductionOut
		}
		
		activity sorting {
			on SmartFactorySld.active.change(0,1) and
			SmartFactorySld.code.change(1,2) => { state: 'start', resource: 'sld' } into SiddhiProductionOut
			on SmartFactorySld.active.change(1,0) and
			SmartFactorySld.code.change(2,1) => { state: 'end', resource: 'sld' } into SiddhiProductionOut
		}
		
		activity productshipped {
			on SmartFactoryOrders.state.is('SHIPPED') => { state: 'end', resource: 'dso' } into SiddhiProductionOut
		}
	}
	'''
}