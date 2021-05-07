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
import edu.dtu.s144874.thesis.ppid.ppid.Update

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

		val updates = predicates.filter[it.update instanceof UpdateChange]
		if (updates.length === 0) {
			return predicates.distinctBy[it.property].map [
				'''«it.source.name».«it.property.name» as «it.compileAsPropertyName»'''
			].join(', ')
		}

		return predicates.distinctBy[it.property].map [
			'''e2.«it.property.name» as «it.compileAsPropertyName»'''
		].join(', ')

	}

	def compileAsPropertyName(Predicate predicate) {

		val property = predicate.property

		val update = predicate.update

		if (update instanceof UpdateChange) {
			if (source instanceof GlobalVar) {
			} else if (source instanceof Source) {

				'''«property.name»'''

			}
		} else {
			if (source instanceof GlobalVar) {
			} else if (source instanceof Source) {

				'''«property.name»'''

			}
		}

	}

//	def distinct<T>(List<T> original, (Object)=> Object object) {
//		
//	}
//	public static <T, R> List<R> map(List<T> original, Function1<? super T, ? extends R> transformation) {
//		return Lists.transform(original, new FunctionDelegate<T, R>(transformation));
//	}
	override compileSource() {
////		if(source instanceof GlobalVar) {
////			return this.name
////		} else if(source instanceof Source) {
////		}
//		return '''«this.predicate.source.name»#window'''
		val updates = predicates.filter[it.update instanceof UpdateChange]
		if (updates.length === 0) {
			return super.compileSource
		}

		return '''every e1 = «super.compileSource», e2 = «super.compileSource»[«updates.map['''((e1.«it.property.name»==«it.update.n») and (e2.«it.property.name»==«it.update.m»))'''].join(' and ')»]'''
	}

	def getM(Update update) {
		if (update instanceof UpdateChange) {
			return update.m
		}
		return null
	}

	override compileParentSelect(CharSequence source) {
		predicates.distinctBy[it.property].map [
			'''«source».«it.compileAsPropertyName» as «it.compileAsPropertyName»'''
		].join(', ')
	}

	def compileHaving() {

		predicates.map [

			val update = it.update

			if (update instanceof UpdateAbove) {
				'''(«it.compileAsPropertyName» > «update.n»)'''
			} else if (update instanceof UpdateBelow) {
				'''(«it.compileAsPropertyName» < «update.n»)'''
			} else if (update instanceof UpdateChange) {
				// '''
				// ((e«index»_1.«predicate.property.name»==«update.n») and (e«index»_2.«predicate.property.name»==«update.m»))'''
//				''''''
				null
			} else if (update instanceof UpdateIs) {
				'''(«it.compileAsPropertyName» == «IF update.s !== null»'«update.s»'«ELSE»«update.n»«ENDIF»)'''
			} else if (update instanceof UpdateNot) {
				'''(«it.compileAsPropertyName» !=  «IF update.s !== null»'«update.s»'«ELSE»«update.n»«ENDIF»)'''
			} else {
				'''«update.class»'''
			}

		].filterNull.join(' and ')

	}

	def static <K, V> toPairs(Map<K, V> map) {
		map.entrySet.map[it.key -> it.value].toList
	}

	def static <T, D> distinctBy(Iterable<? extends T> values, (T)=>D distinction) {
		values.groupBy(distinction).toPairs.map[value.head]
	}

}
