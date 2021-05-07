package edu.dtu.s144874.thesis.ppid.generator.model

import java.util.Optional
import java.util.List
import org.eclipse.emf.ecore.EObject
import edu.dtu.s144874.thesis.ppid.ppid.GlobalVar
import edu.dtu.s144874.thesis.ppid.ppid.Source
import edu.dtu.s144874.thesis.ppid.ppid.Predicate
import edu.dtu.s144874.thesis.ppid.ppid.Type
import edu.dtu.s144874.thesis.ppid.ppid.Entity
import edu.dtu.s144874.thesis.ppid.ppid.EntityReference
import edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType
import edu.dtu.s144874.thesis.ppid.ppid.PrimitiveType

class IntermediateStreamLeaf {
	protected EObject source
	Optional<List<GroupingInformation>> properties;
	
	Optional<PredicateStreamLeaf> predicateStreamLeaf = Optional.empty
	
	
	
	new(EObject source, java.util.List<GroupingInformation> properties) {
		this.source = source
		this.properties = Optional.ofNullable(properties)
	}
	
	new(){
		
	}
	
	
	def compileSource() {
		if(source instanceof GlobalVar) {
			return this.name
		} else if(source instanceof Source) {
			return '''«this.name»«Configuration.instance.window»'''
//			return '''«this.name»'''
		}
	}
	
	def getName() {
		if(source instanceof GlobalVar) {
			return source.name
		} else if(source instanceof Source) {
			return source.name
		}
	}
	
	def compileSelect() {
		if(properties.present){
			properties.get.map['''«name».«it.sourceProperty.name» as «it.outProperty.name»'''].join(', ')
				+ '''«IF this.predicateStreamLeaf.present», «this.predicateStreamLeaf.get.compileSelect»«ENDIF»'''
		} else {
			''''''
		}
	}
	
	def CharSequence compileParentSelect(CharSequence source) {
			properties.get.map['''«source».«it.sourceProperty.name» as «it.outProperty.name»'''].join(', ')
			+ '''«IF this.predicateStreamLeaf.present», «this.predicateStreamLeaf.get.compileParentSelect(source)»«ENDIF»'''
	}
	
//	def compilePredicateSelect() {
//		predicates.map['''«name».«it.sourceProperty.name» as «it.outProperty.name»'''].join(', ')
//	}
	
	def setPredicates(java.util.List<Predicate> predicates) {
		val source = this.source
		if(source instanceof Source) {
			this.predicateStreamLeaf = Optional.of(new PredicateStreamLeaf(source, predicates))
		}
		
	}
	
	def compileParentFinalSink() {
		'''«source.compileSourceToSinkProperties»'''
	}
	
	def compileSourceToSinkProperties(EObject object) {
		if(source instanceof GlobalVar) {
			return source.type.compileToSink
		} else if(source instanceof Source) {
			return source.entity.compileToSink
		}
	}
	
	def CharSequence compileToSink(Type type) {
		if(type instanceof EntityReference) {
			return type.entity.compileToSink
		} else if(type instanceof SimpleDataType) {
			val primitiveType = type.type
			if(primitiveType === PrimitiveType.NUMBER) {
				return '''int'''
			} else if(primitiveType === PrimitiveType.STRING) {
				return '''string'''
			}
			return '''XXXXX'''
		}
		
		return '''XXXXX'''
	}
	
	def compileToSink(Entity entity) {
		entity.properties.map['''«it.name» «it.type.compileToSink»'''].join(', ')
	}
	
}