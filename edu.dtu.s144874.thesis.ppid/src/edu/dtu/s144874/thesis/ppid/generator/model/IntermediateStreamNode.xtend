package edu.dtu.s144874.thesis.ppid.generator.model

import java.util.Optional
import com.google.common.collect.Iterables
import java.util.ArrayList
import java.util.List
import edu.dtu.s144874.thesis.ppid.ppid.Predicate
import edu.dtu.s144874.thesis.ppid.ppid.Source

class IntermediateStreamNode {
	Optional<IntermediateStreamNode> leftNode = Optional.empty
	Optional<IntermediateStreamLeaf> leftLeaf = Optional.empty
	Optional<IntermediateStreamLeaf> rightLeaf = Optional.empty
	
	Optional<IntermediateStreamNode> parent = Optional.empty
	
	static int outputStreamIndex = 0
	
	def hasRight() {
		rightLeaf.present
	}
	
	def insertRight(IntermediateStreamLeaf leaf) {
		rightLeaf = Optional.of(leaf)
	}
	
	
	def static create(IntermediateStreamLeaf left)  {
		
		val result =  new IntermediateStreamNode
		result.leftLeaf = Optional.of(left)
		
		return result
	}
	
	def static create(IntermediateStreamNode left)  {
		
		val result =  new IntermediateStreamNode
		result.leftNode = Optional.of(left)
		
		return result
	}
	
	def getIsLeftLeaf() {
		this.leftLeaf.isPresent
	}
	
	def getLeftLeaf() {
		this.leftLeaf.get
	}
	
	def getLeftNode() {
		this.leftNode.get
	}
	
	def getFirst() {
		if(this.isLeftLeaf){
			return this
		} else {
			return this.leftNode.get.first
		}
	}
	
	def setParent(IntermediateStreamNode parent) {
		this.parent = Optional.of(parent)
	}
	
	def getParent(){
		this.parent
	}
	
	def getOutputStream(){
		'''OutputStream«outputStreamIndex++»'''
	}
	
	def getPreviousOutputStream(){
		'''OutputStream«outputStreamIndex-1»'''
	}
	
	def compileSource() {
		previousOutputStream
	}
	
	def String compileSelect() {
		if(!leftNode.present) {
			return '''«leftLeaf.get.compileParentSelect(previousOutputStream)», «IF rightLeaf.isPresent»«rightLeaf.get.compileParentSelect(previousOutputStream)»«ENDIF»'''
		} else {			
			return '''«rightLeaf.get.compileParentSelect(previousOutputStream)», «leftNode.get.compileSelect»'''
		}
	}
	
	def String compileNode() {
		'''
		«IF leftLeaf.isPresent»
			@info(name='first')  
			from «leftLeaf.get.compileSource»«IF rightLeaf.isPresent» join «rightLeaf.get.compileSource»«ENDIF»
			select «leftLeaf.get.compileSelect»«IF rightLeaf.isPresent», «rightLeaf.get.compileSelect»«ENDIF»
			insert into «outputStream»;
		«ELSE»
			«IF leftNode.isPresent»«leftNode.get.compileNode»«ENDIF»
			
			
			@info(name='TODO Improve name')
			from «leftNode.get.compileSource» join «rightLeaf.get.compileSource»
			select «rightLeaf.get.compileSelect», «leftNode.get.compileSelect»
			insert into «outputStream»;
		«ENDIF»
		'''
	}
	
	def Iterable<IntermediateStreamNode> asNodeIterable() {
		val list = new ArrayList()
		list.add(this)
		var left = this.leftNode
		while(left.present) {
			list.add(left.get)
			left = left.get.leftNode
		}
		return list
	}
	
	def insertPredicates(Source source, List<Predicate> predicates) {
		if(this.leftLeaf.present) {
			if(this.leftLeaf.get.source===source) {
				this.leftLeaf.get.predicates = predicates
			}
		}
		if(this.rightLeaf.present) {
			if(this.rightLeaf.get.source===source) {
				this.rightLeaf.get.predicates = predicates
			}
		}
	}
	
	def has(Source source) {
		if(this.leftLeaf.present) {
			if(this.leftLeaf.get.source===source) {
				return true
			}
		}
		if(this.rightLeaf.present) {
			if(this.rightLeaf.get.source===source) {
				return true
			}
		}
		return false
	}
	
//	def compileHaving() {
//		throw new UnsupportedOperationException("TODO: auto-generated method stub")
//	}
	
}
