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
import edu.dtu.s144874.thesis.ppid.ppid.Property
import java.util.List
import java.util.Map
import edu.dtu.s144874.thesis.ppid.ppid.Output
import com.google.common.collect.Iterables
import java.util.stream.IntStream
import java.util.Optional
import edu.dtu.s144874.thesis.ppid.generator.model.IntermediateStreamTree
import edu.dtu.s144874.thesis.ppid.generator.model.IntermediateStreamLeaf
import org.eclipse.xtext.xtext.CurrentTypeFinder.Implementation
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.util.Pair
import java.util.ArrayList
import edu.dtu.s144874.thesis.ppid.generator.model.GroupingInformation
import edu.dtu.s144874.thesis.ppid.generator.model.LeafType
import org.eclipse.emf.ecore.EObject
import java.util.Collections
import edu.dtu.s144874.thesis.ppid.ppid.RawQuery
import edu.dtu.s144874.thesis.ppid.ppid.RawSource
import edu.dtu.s144874.thesis.ppid.ppid.Config
import edu.dtu.s144874.thesis.ppid.generator.model.Configuration
import edu.dtu.s144874.thesis.ppid.ppid.Trigger
import org.eclipse.emf.common.util.EList

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
		
		val config = resource.allContents.filter(Config).findFirst[].compileConfiguration
		
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
					
					// Map after
//					trigger.predicates.predicates.map[Tuples.create(it.source.name, it.property)]
					
					val groupedInputs = trigger.command.compileGroupings
					.groupBy[it.first]
					.mapValues[it.map[it.second]]
					
					// input is of form EObject, List<Pair<Property, Property>>
					
					
					val currentNode = new IntermediateStreamTree
					
					currentNode.addGroupedInputs(groupedInputs)
					
					trigger.predicates.predicates
//					.filter[!groupedInputs.containsKey(it.source)]
					.groupBy[it.source]
					.forEach[s, predicates|currentNode.addPredicateSource(s, predicates)]
					
//					trigger.predicates.predicates
//					.filter[groupedInputs.containsKey(it.source)]
//					.groupBy[it.source]
//					.forEach[s, predicates|currentNode.addPredicateSource(s, predicates)]


//					groupedInputs.forEach[name, props| currentNode.add(name, props)]
					
					
					val intermediateStreams =  currentNode.compileIntermediateStreams
					
					
					val predicates = it.predicates.predicates
					
					val indexedPredicates = predicates.map[new IndexedPredicate(predicates.indexOf(it), it)]
					
//					val eventAttributes = trigger.command.compileEventAttributes(indexedPredicates)
					
					val eventAttributes = "NOT WORKING!!!" // NOT SURE WHAT TO DO HERE, will make new final...
					
					// create globalVarsReference
					val accessedGlobalVars = command.eAllContents.toIterable
					.filter(StatefulPropertyReference)
					.filter[it.source instanceof GlobalVar]
					.map[it.source as GlobalVar]
					.map['''join «it.name»''']
					.join(' ')
					
					
					val having = currentNode.compileHaving
					
					
					return '''
					
					«intermediateStreams»
«««					@info(name='intermediate-sink-«it.compileName»')
«««					@sink(type='log')
«««					define «currentNode.finalInputStream» («currentNode.compileFinalSink»);
«««					@info(name='collection-«it.compileName»')
«««					from «currentNode.finalInputStream»
«««					select '«process.name»' as processName, '«activity.name»' as activityName«currentNode.compileSelect»
«««					«IF !having.empty»having «having»«ENDIF»
«««					insert into output«trigger.command.compileTriggerOutput»;
					
					@info(name='output-«it.compileName»')
					from «currentNode.finalInputStream»«process.caseId.compileCaseIdJoin»
					select '«process.name»' as processName, '«activity.name»' as activityName, «process.caseId.compileCaseId» as caseId, «currentNode.compileSelect»«command.compileSelect»
					«IF !having.empty»having «having»«ENDIF»
					insert into «trigger.command.compileTriggerOutput»;
					
«««					
«««					DEPRECATED
«««					
««««««					from every «indexedPredicates.map[it.compileFrom].join(', ')» «propertyReferences.compileJoinTables»
«««					from every «indexedPredicates.map[it.compileFrom].join(', ')» «accessedGlobalVars»
«««					select '«process.name»' as processName, '«activity.name»' as activityName«eventAttributes»
«««					«IF !indexedPredicates.empty && !indexedPredicates.exists[it.predicate.update instanceof UpdateChange]»having «indexedPredicates.map[it.compileHaving].join(' and ')»«ENDIF»
«««					insert into «trigger.command.compileTriggerOutput»;
					'''
					
					
				].join('\n')
			].join('\n')
		].join('\n')
		
		val sinks = resource.allContents.toIterable.filter(Sink).map[
			'''
			@sink(type = 'mqtt', url = "«config.url»", client.id = "«it.compileClientId»", topic = "base/$processName/$caseId/$activityName",  quality.of.service= '0', @map(type='json'))
			define stream «it.compileName» (processName string, activityName string, caseId string «it.entity.compileStreamProperties»);
			'''
		].join('\n')
//BASE/[SOURCE ID]/[PROCESS INSTANCE ID]/[ACTIVITY NAME]
		val rawQueries = resource.allContents.toIterable.filter(RawQuery).map[it.text].join('\n')
		
		val rawSources = resource.allContents.toIterable.filter(RawSource).map[it.input].join('\n')


		fsa.generateFile('application.siddhi', '''
			«resource.allContents.toIterable.filter(Source).map[
				'''
				@source(type = 'mqtt', url = "«config.url»", client.id = "«it.compileClientId»", topic = "«it.topic»", 
					«it.compileMap»)
				define stream «it.name»Stream («it.entity.properties.map['''«it.name» «it.type.compile»'''].join(', ')»);
				'''
			].join('\n')»
			
			«sinks»
			

			«globalVars»

			«processes»
			
			«rawQueries»
			
			«rawSources»
			
«««			@sink(type = 'mqtt', url = "tcp://127.0.0.1:1883", client.id = "siddhipub", topic = "log/$processName/$caseId/$activityName",  quality.of.service= '0', @map(type='json'))
«««			define stream eventlogOut (processName string, caseId string, activityName string, ts string);
«««			
«««			
		''')

	}
	
	def compileCaseIdJoin(ExtendedExpression expression) {
		expression.left.compileCaseIdJoin
	}
	
	def compileCaseIdJoin(ExpressionPart expression) {
		if(expression.ref !== null) {
			val source = expression.ref.source
			
			if(source instanceof GlobalVar) {
				''' join «source.name»'''
			} else if(source instanceof Source) {
				''''''
			}
			
		} else if(expression.stringValue !== null) {
			''''''
		} else {
			''''''
		}
	}
	
	def compileSelect(Command command) {
		if(command instanceof SetVarCommand) {
			''''''
		} else if(command instanceof OutputCommand) {
			command.output.properties.map['''«it.exp.compilePropertyValue» as «it.property.name»'''].join(', ')
		}
	}
	
	def compilePropertyValue(ExtendedExpression expression) {
		'''«expression.left.compilePropertyValue»«expression.right.compilePropertyValue»'''
	}
	
	def compilePropertyValue(ExpressionPart expression) {
		if(expression.ref !== null) {
			val source = expression.ref.source
			
			if(source instanceof GlobalVar) {
				'''«source.name».«expression.ref.property.name»'''
			} else if(source instanceof Source) {
				expression.ref.property.name
			}
			
		} else if(expression.stringValue !== null) {
			''' '«expression.stringValue»' '''
		} else {
			'''«expression.value»'''
		}
	}
	
	def compilePropertyValue(EList<RightExpression> expressions) {
		expressions.map['''«it.operator» «it.exp.compilePropertyValue»'''].join(' ')
	}
	
	
	def compileCaseId(ExtendedExpression expression) {
		'''«expression.left.compileCaseId»«expression.right.compileCaseId»'''
	}
	
	def compileCaseId(ExpressionPart expression) {
		if(expression.ref !== null) {
			val source = expression.ref.source
			
			if(source instanceof GlobalVar) {
				'''«source.name».«expression.ref.property.name»'''
			} else if(source instanceof Source) {
				expression.ref.property.name
			}
			
		} else if(expression.stringValue !== null) {
			''' '«expression.stringValue»' '''
		} else {
			'''«expression.value»'''
		}
	}
	
	def compileCaseId(List<RightExpression> expressions) {
		expressions.map['''«it.operator» «it.exp.compileCaseId»'''].join(' ')
	}
	
//	@map(type = 'json', fail.on.missing.attribute="false", 
//		@attributes(id = "$.workpiece.id", state = "$.workpiece.state", $.workpiece.state))
	def compileMap(Source source) {
		if(source.mappings !== null && !source.mappings.empty) {
			'''
			@map(type = 'json', fail.on.missing.attribute="false", 
				@attributes(«source.mappings.map['''«it.name» = "«it.mapping»"'''].join(', ')»))'''
		} else {	
			'''@map(type = 'json')'''
		}
	}
	
	def compileClientId(Source source) {
		if(source.clientId !== null) {
			return source.clientId
		}
		return Configuration.instance.clientId
	}
	
	def compileClientId(Sink sink) {
//		if(source.clientId !== null) {
//			return source.clientId
//		}
		return Configuration.instance.clientId
	}
	
	def compileConfiguration(Config config) {
		Configuration.instance = config
	}
	
	def compileGroupings(Command command) {
		if(command instanceof SetVarCommand) {
			val assignment = command.assignment
			if(assignment instanceof ExtendedExpression) {
				// just prop = value -> cut corners
				
				return assignment.compileExpressionGroupings(null)
			} else if(assignment instanceof Output) {
				return assignment.properties.map[it.exp.compileExpressionGroupings(it.property)].flatten
			}
		} else if(command instanceof OutputCommand) {
			return command.output.properties.map[it.exp.compileExpressionGroupings(it.property)].flatten
		}
	}
	
	def compileGroupings(ExpressionPart exp, Property mappedProp) {
		if(exp.ref !== null) {
			val source = exp.ref.source
			return Tuples.create(source, Tuples.create(exp.ref.property, mappedProp))
		}
		return null
	}
	
	def compileExpressionGroupings(ExtendedExpression expression, Property mappedProp) {
		val result = new ArrayList<Pair<EObject, Pair<Property, Property>>>()
		if(expression.right !== null){
			result.addAll(expression.right.map[it.exp.compileGroupings(mappedProp)])		
		}
		result.add(expression.left.compileGroupings(mappedProp))
		result.filter[it !== null]
	}
	
//	def compileJoinTables(Map<Source, List<StatefulPropertyReference>> map) {
//		'''compileJoinTables'''
//	}
	
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
	
	def compileName(Trigger trigger){
		'''«trigger.predicates.predicates.map[it.source.name].join('-')»'''
	}
	
	def compileEventAttributes(Command command, List<IndexedPredicate> indexedPredicates) {
		if(command instanceof SetVarCommand){
			
			val assignment = command.assignment
			
			if(assignment instanceof ExtendedExpression) {
				return assignment.compileExpression(indexedPredicates)
				
			} else if(assignment instanceof Output) {
				val props = assignment.properties.map['''«it.exp.compileExpression(indexedPredicates)» as «it.property.name»''']
				if(props.size === 0){
					return ''''''
				}
				return ''', «props.join(', ')»'''
			}
			
			
		} else if(command instanceof OutputCommand){
			val props = command.output.properties.map['''«it.exp.compileExpression(indexedPredicates)» as «it.property.name»''']
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
			'''«command.id.name»'''
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
