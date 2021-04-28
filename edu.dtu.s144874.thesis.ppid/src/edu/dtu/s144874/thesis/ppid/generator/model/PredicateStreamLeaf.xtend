package edu.dtu.s144874.thesis.ppid.generator.model

import org.eclipse.emf.ecore.EObject
import java.util.List
import edu.dtu.s144874.thesis.ppid.ppid.Predicate
import edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove
import edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange
import edu.dtu.s144874.thesis.ppid.ppid.UpdateIs
import edu.dtu.s144874.thesis.ppid.ppid.UpdateNot
import edu.dtu.s144874.thesis.ppid.ppid.Source
import com.google.common.collect.Iterables
import java.util.Map
import edu.dtu.s144874.thesis.ppid.ppid.Property
import edu.dtu.s144874.thesis.ppid.ppid.GlobalVar

class PredicateStreamLeaf extends IntermediateStreamLeaf {
	

//	Predicate predicate
//	
//	new(Predicate predicate) {
//		this.predicate = predicate
//		
//	}
	
	List<Predicate> predicates
	
	new(Source source, java.util.List<edu.dtu.s144874.thesis.ppid.ppid.Predicate> predicates) {
		this.source = source
		this.predicates = predicates
	}
	
//	override getName() {
//		'''«this.predicate.property.name»«this.hashCode»'''
//	}
	
	override compileSelect() {
		predicates.distinctBy[it.property].map['''«it.source.name».«it.property.name» as «it.property.compileAsPropertyName»'''].join(', ')
	}
	
	def compileAsPropertyName(Property property) {
		if(source instanceof GlobalVar) {
			
		} else if(source instanceof Source) {
			'''«source.name»«property.name»'''
			
		}
	}
	
//	def distinct<T>(List<T> original, (Object)=> Object object) {
//		
//	}
	
//	public static <T, R> List<R> map(List<T> original, Function1<? super T, ? extends R> transformation) {
//		return Lists.transform(original, new FunctionDelegate<T, R>(transformation));
//	}
	
//	override compileSource() {
////		if(source instanceof GlobalVar) {
////			return this.name
////		} else if(source instanceof Source) {
////		}
//		return '''«this.predicate.source.name»#window'''
//	}
	
	override compileParentSelect(CharSequence source) {
		predicates.distinctBy[it.property].map['''«source».«it.property.compileAsPropertyName» as «it.property.compileAsPropertyName»'''].join(', ')
	}
	
	def compileHaving() {
		
		predicates.map[
			
			val update = it.update
		
			if (update instanceof UpdateAbove) {
				'''(«it.property.compileAsPropertyName» > «update.n»)'''
			} else if (update instanceof UpdateBelow) {
				'''(«it.property.compileAsPropertyName» < «update.n»)'''
			} else if (update instanceof UpdateChange) {
	//			'''
	//			((e«index»_1.«predicate.property.name»==«update.n») and (e«index»_2.«predicate.property.name»==«update.m»))'''
				''''''
			} else if (update instanceof UpdateIs) {
				'''(«it.property.compileAsPropertyName» == «update.n»)'''
			} else if (update instanceof UpdateNot) {
				'''(«it.property.compileAsPropertyName» != «update.n»)'''
			} else {
				'''«update.class»'''
			}
				
		].join(' ')
		
	}
	

	def static <K, V> toPairs(Map<K, V> map) {
		map.entrySet.map[it.key -> it.value].toList
	}
	
	def static <T, D> distinctBy(Iterable<? extends T> values, (T)=>D distinction) {
		values.groupBy(distinction).toPairs.map[value.head]
	}
	
}