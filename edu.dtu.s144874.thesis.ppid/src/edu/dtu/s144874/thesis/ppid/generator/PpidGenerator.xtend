//🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀💎💎💎💎💎💎💎🚀🚀🚀🚀
//
//🚀🚀🚀💎💎💎💎💎💎💎💎💎🚀🚀🚀
//
//🚀🚀💎💎💎💎💎💎💎💎💎💎💎🚀🚀
//
//🚀🚀🚀💎💎💎💎💎💎💎💎💎🚀🚀🚀
//
//🚀🚀🚀🚀💎💎💎💎💎💎💎🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀💎💎💎💎💎🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀🚀💎💎💎🚀🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀🚀🚀💎🚀🚀🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀
//
//🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀
package edu.dtu.s144874.thesis.ppid.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.dtu.s144874.thesis.ppid.ppid.Rule
import edu.dtu.s144874.thesis.ppid.ppid.Update
import edu.dtu.s144874.thesis.ppid.ppid.Output
import edu.dtu.s144874.thesis.ppid.ppid.OutputValue
import edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove
import edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange
import edu.dtu.s144874.thesis.ppid.ppid.UpdateIs
import edu.dtu.s144874.thesis.ppid.ppid.UpdateNot
import edu.dtu.s144874.thesis.ppid.ppid.Source
import edu.dtu.s144874.thesis.ppid.ppid.Sink
import edu.dtu.s144874.thesis.ppid.ppid.Type
import edu.dtu.s144874.thesis.ppid.ppid.EntityReference
import edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType
import edu.dtu.s144874.thesis.ppid.ppid.PrimitiveType
import edu.dtu.s144874.thesis.ppid.ppid.PropertyReference
import org.eclipse.emf.common.util.EList
import edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate
import java.lang.System.Logger
import edu.dtu.s144874.thesis.ppid.ppid.EndRule
import edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 * 

 * @info(name='VgrMoveToMpoEndQuery')
 * from every e1 = SmartFactoryVgrStream, e2 = SmartFactoryVgrStream[((e1.active==1) and (e1.code==2)) and ((e2.active==0) and (e2.code==1))]
 * select 'productionprocess' as processName, 'vgrmovetohbw' as activityName, 'end' as state, 'vgr' as resource, e2.ts as ts
 * having (e1.target=='mpo') and (e2.target=='mpo')
 * insert into SiddhiProductionOut;
 * 
 */



class PpidGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

		fsa.generateFile('app.siddhi', '''
			«resource.allContents.toIterable.filter(Source).map[
				'''
				@source(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhidsi", topic = "«it.topic»", 
					@map(type = 'json'))
				define stream «it.name»Stream («it.entity.properties.map['''«it.name» «it.type.compile»'''].join(', ')»);
				'''
			].join('\n')»
			
			«resource.allContents.toIterable.filter(EndRule).map[
				val updates  = it.rule.updates
				val indexedUpdates  = updates.map[new IndexedUpdate(updates.indexOf(it), it)]
				
				'''
				@sink(type='log') 
				define table «it.rule.compileEndName»(instanceCount int, ts string);
				
				from every «indexedUpdates.map[it.compileFrom].join(', ')»
				«it.compileSelect»
				having «indexedUpdates.map[it.compileHaving].join(' and ')»
				insert into «it.rule.compileEndName»;
				'''
			].join('\n')»
			
			«resource.allContents.toIterable.filter(Sink).map[
				'''
				@sink(type='log')
				define stream «it.name»Out («it.entity.properties.map['''«it.name» «it.type.compile»'''].join(', ')»);
				'''
			].join('\n')»
			
			«resource.allContents.toIterable.filter(ExtendedRule).map [				// Fix with updates from different steams/ sinks
				val updates  = it.rule.updates
				val indexedUpdates  = updates.map[new IndexedUpdate(updates.indexOf(it), it)]
			'''
«««			from every e1 = «it.source.name»Stream, e2 = «it.source.name»Stream[«it.update.compile(it)»]
			from every «indexedUpdates.map[it.compileFrom].join(', ')»
			«IF it.output === null »
			select *
			«ELSE»
			«it.output.compile»
			«ENDIF»
			having «indexedUpdates.map[it.compileHaving].join(' and ')»
			insert into «it.sink.name»Out;
			'''
			].join('\n')»
			
			«resource.allContents.toIterable.filter(ExtendedRule).map [
				// Fix with updates from different steams/ sinks
				// Should be for each sink instead of rule??
				val updates  = it.rule.updates
				val indexedUpdates  = updates.map[new IndexedUpdate(updates.indexOf(it), it)]
				
			'''
«««			from every e1 = «it.source.name»Stream, e2 = «it.source.name»Stream[«it.update.compile(it)»]
			from every «it.sink.name»Out join «it.rule.compileEndName»
«««			«it.output.compile»
			select «it.sink.name»Out.processName, str:concat('instance', convert(count(«it.rule.compileEndName».instanceCount),'string')) as caseId, «it.sink.name»Out.activityName, «it.sink.name»Out.state, «it.sink.name»Out.resource, «it.sink.name»Out.ts
«««			having «indexedUpdates.map[it.compileHaving].join(' and ')»
			insert into eventlogOut;
			'''
			].join('\n')»

			
			@sink(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhipub", topic = "log/$processName/$caseId/$activityName",  quality.of.service= '0', @map(type='json'))
			define stream eventlogOut (processName string, caseId string, activityName string, ts string);
			
			
		''')

	}
	
	def compileSelect(EndRule rule)
	'''1 as caseId, ts'''
	
	def compileEndName(Rule rule) 
	'''«rule.hashCode»EndTable'''
	
	def compileFrom(IndexedUpdate indexedUpdate) {
		if(indexedUpdate.update.update instanceof UpdateChange)
		'''
		e«indexedUpdate.getIndex»_1 = «indexedUpdate.update.source.name»Stream, e«indexedUpdate.getIndex»_2 = «indexedUpdate.update.source.name»Stream[«indexedUpdate.update.compileFromFilter(indexedUpdate.getIndex)»]'''
		else
		'''
		e«indexedUpdate.getIndex» = «indexedUpdate.update.source.name»Stream'''
	}
	
	def compileFromFilter(SourceUpdate sourceUpdate, Integer index) {
		val update = sourceUpdate.update
		
		if (update instanceof UpdateAbove) {
			'''
			'''
		} else if (update instanceof UpdateBelow) {
			''''''
		} else if (update instanceof UpdateChange) {
			'''
			((e«index»_1.«sourceUpdate.property.name»==«update.n») and (e«index»_2.«sourceUpdate.property.name»==«update.m»))'''
		} else if (update instanceof UpdateIs) {
			''''''
		} else if (update instanceof UpdateNot) {
			''''''
		} else {
			'''«update.class»'''
		}
	}
	
	def compile(PropertyReference property) { 
		'''«property.name»'''
	}
	
	def compileHaving(IndexedUpdate indexedUpdate) {
		
		val sourceUpdate = indexedUpdate.update
		val update = sourceUpdate.update
		
		if (update instanceof UpdateAbove) {
			'''(e«indexedUpdate.getIndex».«sourceUpdate.property.name»>«update.n»)'''
		} else if (update instanceof UpdateBelow) {
			'''(e«indexedUpdate.getIndex».«sourceUpdate.property.name»<«update.n»)'''
		} else if (update instanceof UpdateChange) {
			''''''
		} else if (update instanceof UpdateIs) {
			'''(e«indexedUpdate.getIndex».«sourceUpdate.property.name»==«update.n»)'''
		} else if (update instanceof UpdateNot) {
			'''(e«indexedUpdate.getIndex».«sourceUpdate.property.name»!=«update.n»)'''
		} else {
			'''«update.class»'''
		}
	}
	
	private def compile(Type type) {
		if (type instanceof EntityReference) {
			'''
				«type.entity.name»'''
		} else if (type instanceof SimpleDataType) {
			if(type.type == PrimitiveType.NUMBER) {
				'int'
			} else {
				'string'
			}
		} else {
			'''
			'''
		}
	}

	private def compile(Output output) '''
		select «output.properties.map[''' '«it.value.compile»' as «it.name» '''].join(',')»
	'''

	private def compile(OutputValue value) {
		if (value.valueString !== null) {
			return value.valueString
		}
		if (value.valueRef !== null) {
			return value.valueRef.name
		}
		return value.valueInt.toString
	}
}

class IndexedUpdate {
	
	SourceUpdate update
	
	Integer index
	
	new(int index, SourceUpdate update) {
		this.index = index
		this.update = update
	}
	
	def Integer getGetIndex() {
		index
	}
	
	def SourceUpdate getUpdate(){
		update
	}
	
}
