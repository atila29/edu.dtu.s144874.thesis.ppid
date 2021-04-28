package edu.dtu.s144874.thesis.ppid.generator.model

import edu.dtu.s144874.thesis.ppid.ppid.Property

class GroupingInformation {
	
	String sourcename
	
	Property sourceProperty
	
	Property outProperty
	
	LeafType leafType
	
	new(String sourceName, Property sourceProperty, Property outProperty, LeafType type) {
		this.sourcename = sourceName
		this.sourceProperty = sourceProperty
		this.outProperty = outProperty
		this.leafType = type
	}
	
	def getSourceName() {
		sourcename
	}
	
	def getSourceProperty() {
		sourceProperty
	}
	
	def getOutProperty() {
		outProperty
	}

	
}