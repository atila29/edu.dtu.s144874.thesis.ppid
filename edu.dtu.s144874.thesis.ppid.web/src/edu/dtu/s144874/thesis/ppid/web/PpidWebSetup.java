/*
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.dtu.s144874.thesis.ppid.PpidRuntimeModule;
import edu.dtu.s144874.thesis.ppid.PpidStandaloneSetup;
import edu.dtu.s144874.thesis.ppid.ide.PpidIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages in web applications.
 */
public class PpidWebSetup extends PpidStandaloneSetup {
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new PpidRuntimeModule(), new PpidIdeModule(), new PpidWebModule()));
	}
	
}