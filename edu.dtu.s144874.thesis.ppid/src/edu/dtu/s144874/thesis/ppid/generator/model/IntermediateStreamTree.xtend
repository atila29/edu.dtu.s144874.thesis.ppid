package edu.dtu.s144874.thesis.ppid.generator.model

import java.util.Optional
import java.util.Map
import org.eclipse.xtext.util.Pair
import org.eclipse.emf.ecore.EObject
import java.util.List
import edu.dtu.s144874.thesis.ppid.ppid.Property
import edu.dtu.s144874.thesis.ppid.ppid.GlobalVar
import edu.dtu.s144874.thesis.ppid.ppid.Source
import edu.dtu.s144874.thesis.ppid.ppid.Predicate
import com.google.common.collect.Iterables
import java.util.ArrayList
import edu.dtu.s144874.thesis.ppid.ppid.Process
import edu.dtu.s144874.thesis.ppid.ppid.Activity
import java.util.function.Function

class IntermediateStreamTree {
	Optional<IntermediateStreamNode> current;
	val havings = new ArrayList<Function<CharSequence, CharSequence>>()
	
	String queryNamePrefix
	

	new(Process process, Activity activity) {
		current = Optional.empty
		this.queryNamePrefix = '''«process.name»-«activity.name»'''
	}

	def isFirst() {
		current.present
	}

	def getFirst() {
		return current.get.getFirst()
	}

	def add(IntermediateStreamLeaf s) {
		if (!current.isPresent) {
			current = Optional.of(IntermediateStreamNode.create(s))
		} else {
			if (!current.get.hasRight) {
				current.get.insertRight(s)
			} else {
				val previous = current.get
				current = Optional.of(IntermediateStreamNode.create(previous))

				previous.parent = current.get

				current.get.insertRight(s)
			}
		}
	}

	def compileIntermediateStreams() {
		if (current.present) {
			current.get.compileNode(queryNamePrefix)

		} else {
			''''''
		}
	}

	def addGroupedInputs(
		java.util.Map<org.eclipse.emf.ecore.EObject, java.util.List<org.eclipse.xtext.util.Pair<edu.dtu.s144874.thesis.ppid.ppid.Property, edu.dtu.s144874.thesis.ppid.ppid.Property>>> groupedInputs) {
		groupedInputs.forEach [ key, info |
			this.add(new IntermediateStreamLeaf(key, info.map [
				new GroupingInformation(key.name, it.first, it.second, key.leafType)
			]))
		]
	}

	def String getName(EObject source) {
		if (source instanceof GlobalVar) {
			return source.name
		} else if (source instanceof Source) {
			return source.name
		}
	}

	def LeafType getLeafType(EObject source) {
		if (source instanceof GlobalVar) {
			return LeafType.TABLE
		} else if (source instanceof Source) {
			return LeafType.STREAM
		}
	}

//	def addPredicateSource(Predicate predicate) {
//		
//		val leaf = new PredicateStreamLeaf(predicate)
//		val having = leaf.compileHaving
//		havings.add(having)
//		add(leaf)
//	}
	def compileSelect() {
		'''«this.current.get.compileSelect»'''
	}

	def compileHaving(CharSequence stream) {
		this.havings.map[it.apply(stream)].join(' ')
	}

	def finalInputStream() {
		'''«current.get.previousOutputStream»'''
	}

	def addPredicateSource(edu.dtu.s144874.thesis.ppid.ppid.Source source,
		java.util.List<edu.dtu.s144874.thesis.ppid.ppid.Predicate> predicates) {

		if (current.present) {
			val node = current.get.asNodeIterable.findFirst[it.has(source)]
			val leaf = new PredicateStreamLeaf(source, predicates)
			val having = new Function<CharSequence, CharSequence>() {
				
				override apply(CharSequence arg0) {
					return leaf.compileHaving(arg0)
				}
				
			}
			havings.add(having)
			if (node === null) {
				add(leaf)
			} else {
				node.insertPredicates(source, predicates)
			}
		} else {
			val leaf = new PredicateStreamLeaf(source, predicates)
			val having = new Function<CharSequence, CharSequence>() {
				
				override apply(CharSequence arg0) {
					return leaf.compileHaving(arg0)
				}
				
			}
			havings.add(having)
			add(leaf)
		}

	}
	
	def compileFinalSink() {
		'''«this.current.get.compileFinalSink»'''
	}

//	
//	def addGroupedInputs(java.util.Map<EObject, List<org.eclipse.xtext.util.Pair<Property, Property>>> map) {
//	}
//	def addGroupedInputs(Map<String, java.util.List<GroupingInformation>> groupedInputs) {
//		groupedInputs.forEach[key, info| this.add(new IntermediateStreamLeaf(key, info))]
//	}
}
