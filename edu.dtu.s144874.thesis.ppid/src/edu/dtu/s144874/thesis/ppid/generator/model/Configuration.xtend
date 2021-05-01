package edu.dtu.s144874.thesis.ppid.generator.model

import edu.dtu.s144874.thesis.ppid.ppid.Config
import java.util.Optional

class Configuration {
	static Optional<Configuration> instance = Optional.empty
	
	String clientId
	
	String url
	
	String window
	
	private new(Config config) {
		this.clientId = config === null || config.clientId === null ? "siddhidsi" : config.clientId
		this.url = config === null || config.url === null ? "tcp://127.0.0.1:1883" : config.url
		this.window = config === null || config.window === null ? "#length(2)" : config.window
	}
	
	def getUrl() {
		this.url
	}
	def getClientId() {
		this.clientId
	}
	def getWindow() {
		this.window
	}
	
	static def setInstance(Config config) {
		instance = Optional.of(new Configuration(config))
		instance.get
	}
	
	static def getInstance() {
		return instance.get
	}
	
}