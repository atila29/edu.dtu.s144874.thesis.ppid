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
import edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove
import edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange
import edu.dtu.s144874.thesis.ppid.ppid.UpdateIs
import edu.dtu.s144874.thesis.ppid.ppid.UpdateNot
import edu.dtu.s144874.thesis.ppid.ppid.Source
import edu.dtu.s144874.thesis.ppid.ppid.Type
import edu.dtu.s144874.thesis.ppid.ppid.EntityReference
import edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType
import edu.dtu.s144874.thesis.ppid.ppid.PrimitiveType
import edu.dtu.s144874.thesis.ppid.ppid.Predicate
import edu.dtu.s144874.thesis.ppid.ppid.GlobalVar
import edu.dtu.s144874.thesis.ppid.ppid.Command
import edu.dtu.s144874.thesis.ppid.ppid.Predicates
import edu.dtu.s144874.thesis.ppid.ppid.OutputCommand
import edu.dtu.s144874.thesis.ppid.ppid.SetVarCommand
import edu.dtu.s144874.thesis.ppid.ppid.Sink
import edu.dtu.s144874.thesis.ppid.ppid.Entity
import edu.dtu.s144874.thesis.ppid.ppid.ExtendedExpression
import edu.dtu.s144874.thesis.ppid.ppid.RightExpression
import edu.dtu.s144874.thesis.ppid.ppid.ExpressionPart
import edu.dtu.s144874.thesis.ppid.ppid.StatefulPropertyReference
import java.util.List
import java.util.Map
import edu.dtu.s144874.thesis.ppid.ppid.Output

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

		val globalVars = resource.allContents.toIterable.filter(GlobalVar).map[
			'''
			@sink(type='log') 
			define table «it.getName»(«it.type.compileVarArguments»);
			'''
		].join('\n')
			
		val processes = resource.allContents.toIterable.filter(edu.dtu.s144874.thesis.ppid.ppid.Process).map[
			val process = it
			
			return it.activities.map[
				
				val activity = it
				
				return it.trigger.map[
					
					val trigger = it
					it.predicates.hashCode
					
					val predicates = it.predicates.predicates
					
					val indexedPredicates  = predicates.map[new IndexedPredicate(predicates.indexOf(it), it)]
					
					val eventAttributes = trigger.command.compileEventAttributes(indexedPredicates)
					
					// create globalVarsReference
					val accessedGlobalVars = command.eAllContents.toIterable
					.filter(StatefulPropertyReference)
					.filter[it.source instanceof GlobalVar]
					.map[it.source as GlobalVar]
					.map['''join «it.name»''']
					.join(' ')
					
					
					return '''
«««					from every «indexedPredicates.map[it.compileFrom].join(', ')» «propertyReferences.compileJoinTables»
					from every «indexedPredicates.map[it.compileFrom].join(', ')» «accessedGlobalVars»
					select '«process.name»' as processName, '«activity.name»' as activityName«eventAttributes»
					«IF !indexedPredicates.empty && !indexedPredicates.exists[it.predicate.update instanceof UpdateChange]»having «indexedPredicates.map[it.compileHaving].join(' and ')»«ENDIF»
					insert into «trigger.command.compileTriggerOutput»;
					'''
					
					
				].join('\n')
			].join('\n')
		].join('\n')
		
		val sinks = resource.allContents.toIterable.filter(Sink).map[
			'''
			@sink(type='log')
			define stream «it.compileName» (processName string, activityName string «it.entity.compileStreamProperties»);
			'''
		].join('\n')



		fsa.generateFile('app.siddhi', '''
			«resource.allContents.toIterable.filter(Source).map[
				'''
				@source(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhidsi", topic = "«it.topic»", 
					@map(type = 'json'))
				define stream «it.name»Stream («it.entity.properties.map['''«it.name» «it.type.compile»'''].join(', ')»);
				'''
			].join('\n')»
			
			«sinks»
			

			«globalVars»

			«processes»
			
«««			@sink(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhipub", topic = "log/$processName/$caseId/$activityName",  quality.of.service= '0', @map(type='json'))
«««			define stream eventlogOut (processName string, caseId string, activityName string, ts string);
«««			
«««			
		''')

	}
	
	def compileJoinTables(Map<Source, List<StatefulPropertyReference>> map) {
		''''''
	}
	
	def compileStreamProperties(Entity entity) {
		if(entity.properties.empty) {
			''''''
		}else {
			''', «entity.properties.map['''«it.name» «it.type.compileTableArgumentType»'''].join(',')»'''
		}
		
		
	}
	
	def compileName(Sink sink){
		'''«sink.name»'''
	}
	
	def compileEventAttributes(Command command, List<IndexedPredicate> indexedPredicates) {
		if(command instanceof SetVarCommand){
			
			val assignment = command.assignment
			
			if(assignment instanceof ExtendedExpression) {
				return assignment.compileExpression(indexedPredicates)
				
			} else if(assignment instanceof Output) {
				val props = assignment.properties.map['''«it.exp.compileExpression(indexedPredicates)» as «it.name»''']
				if(props.size === 0){
					return ''''''
				}
				return ''', «props.join(', ')»'''
			}
			
			
		} else if(command instanceof OutputCommand){
			val props = command.output.properties.map['''«it.exp.compileExpression(indexedPredicates)» as «it.name»''']
			if(props.size === 0){
				return ''''''
			}
			return ''', «props.join(', ')»'''
		}
	}
	
	def compileExpression(ExtendedExpression expression, List<IndexedPredicate> indexedPredicates) {
		
		val init = expression.left.compileExpressionPart(indexedPredicates)
		
		val result = new StringBuilder(init)
		
		
		if(!expression.right.empty){
			result.append(expression.right.map[it.compileRightExpression(indexedPredicates)].join(' ')) 
		}
		
		return result.toString
	}
	
	def compileExpressionPart(ExpressionPart part, List<IndexedPredicate> indexedPredicates) {
		if(part.ref !== null){
			val source = part.ref.source
			if(source instanceof Source){
				// Needs to be the latest given event.
				
				val latestEventFromSource = indexedPredicates
				.filter[it.predicate.source.name === source.name]
				.maxBy[it.getIndex]
				
				
				'''e«latestEventFromSource.getIndex»«IF latestEventFromSource.predicate.update instanceof UpdateChange»_2«ENDIF».«part.ref.property.name»'''
//				'''«source.name»Stream.«part.ref.property.name»'''
			}
			else if(source instanceof GlobalVar) {	
				'''«source.name»«IF source.type instanceof SimpleDataType».value«ELSE».«part.ref.property.name»«ENDIF»'''
			}
			
		} else if(part.stringValue !== null){
			''''«part.stringValue»' '''
		} 
		else {
			// default to value because int
		'''«part.value»'''
		}
	}
	
//	def boolean isGlobalVar(StatefulPropertyReference reference, Resource resource) {
//		resource.allContents.toIterable.filter(Source).exists[it.name === reference.source]
//	}
	
	def compileRightExpression(RightExpression expression, List<IndexedPredicate> indexedPredicates) {
		'''«expression.operator» «expression.exp.compileExpressionPart(indexedPredicates)»'''
	}
	
	def compileFrom(IndexedPredicate it) {
		if(it.predicate.update instanceof UpdateChange){
			'''e«it.getIndex»_1 = «it.predicate.source.name»Stream, e«it.getIndex»_2 = «it.predicate.source.name»Stream[«it.predicate.compileFromFilter(it.getIndex)»]'''
			
		} else {
			'''e«it.getIndex» = «it.predicate.source.name»Stream'''
		}
	}
	
	
		def compileFromFilter(Predicate predicate, Integer index) {
		val update = predicate.update
		
		if (update instanceof UpdateAbove) {
			'''
			'''
		} else if (update instanceof UpdateBelow) {
			''''''
		} else if (update instanceof UpdateChange) {
			'''
			((e«index»_1.«predicate.property.name»==«update.n») and (e«index»_2.«predicate.property.name»==«update.m»))'''
		} else if (update instanceof UpdateIs) {
			''''''
		} else if (update instanceof UpdateNot) {
			''''''
		} else {
			'''«update.class»'''
		}
	}
	
	def compileTriggerOutput(Command command) {
		if(command instanceof OutputCommand) {
			'''«command.sink.name»'''
		} else if(command instanceof SetVarCommand) {
			'''«command.name.name»'''
		}
	}
	
	
	def getCompileVarArguments(Type type) {
		if(type instanceof SimpleDataType) {
			if(type.type === PrimitiveType.STRING){
				return '''value string'''
			}
			if(type.type === PrimitiveType.NUMBER){
				return '''value int'''
			}
		} else if(type instanceof EntityReference) {
			 val entity = type.entity
			 return entity.properties.map['''«it.name» «it.type.compileTableArgumentType»'''].join(', ')
		}
	}
	
	def compileTableArgumentType(Type type) {
		if(type instanceof SimpleDataType) {
			if(type.type === PrimitiveType.STRING){
				return '''string'''
			}
			if(type.type === PrimitiveType.NUMBER){
				return '''int'''
			}
		} else if(type instanceof EntityReference) {
//			create index reference relationship
			
			return '''fixing'''
		}
	}
	
//	def compileSelect(EndRule rule)
//	'''1 as caseId, ts'''
//	
//	def compileEndName(Rule rule) 
//	'''«rule.hashCode»EndTable'''
//	
//	def compileFrom(IndexedUpdate indexedUpdate) {
//		if(indexedUpdate.update.update instanceof UpdateChange)
//		'''
//		e«indexedUpdate.getIndex»_1 = «indexedUpdate.update.source.name»Stream, e«indexedUpdate.getIndex»_2 = «indexedUpdate.update.source.name»Stream[«indexedUpdate.update.compileFromFilter(indexedUpdate.getIndex)»]'''
//		else
//		'''
//		e«indexedUpdate.getIndex» = «indexedUpdate.update.source.name»Stream'''
//	}
//	

	
//	def compile(PropertyReference property) { 
//		'''«property.name»'''
//	}
	
	def compileHaving(IndexedPredicate indexedPredicate) {
		
		val sourcePredicate = indexedPredicate.predicate
		val update = sourcePredicate.update
		
		if (update instanceof UpdateAbove) {
			'''(e«indexedPredicate.getIndex».«sourcePredicate.property.name»>«update.n»)'''
		} else if (update instanceof UpdateBelow) {
			'''(e«indexedPredicate.getIndex».«sourcePredicate.property.name»<«update.n»)'''
		} else if (update instanceof UpdateChange) {
			''''''
		} else if (update instanceof UpdateIs) {
			'''(e«indexedPredicate.getIndex».«sourcePredicate.property.name»==«update.n»)'''
		} else if (update instanceof UpdateNot) {
			'''(e«indexedPredicate.getIndex».«sourcePredicate.property.name»!=«update.n»)'''
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

//	private def compile(Output output) '''
//		select «output.properties.map[''' '«it.value.compile»' as «it.name» '''].join(',')»
//	'''

//	private def compile(OutputValue value) {
//		if (value.valueString !== null) {
//			return value.valueString
//		}
//		if (value.valueRef !== null) {
//			return value.valueRef.name
//		}
//		return value.valueInt.toString
//	}


}

class IndexedPredicate{
	
	Predicate predicate
	
	Integer index
	
	new(int index, Predicate predicate) {
		this.index = index
		this.predicate = predicate
	}
	
	def Integer getGetIndex() {
		index
	}
	
	def Predicate getPredicate(){
		predicate
	}
	
	def setPredicate(Predicate value){
		predicate = value
	}
	
	def setIndex(Integer value) {
		index = value
	}
	
}
