/*
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.tests

import com.google.inject.Inject
import edu.dtu.s144874.thesis.ppid.ppid.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(PpidInjectorProvider)
class PpidParsingTest {
	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
		
		
		entity A {
			a: number
			b: string
			c: [string]
		}
		entity B {
			a: A
			b: [A]
		}
		
		entity Vgr { 
		 active : number
		 code : number
		 description : string
		 station : string
		 ts : string
		}
		
		source so "f/i/state/dsi" Vgr
		source new "topic" Vgr
		
		sink verySink A
		
		so.lol.above(1) =>{ caseId: 2 } into verySink

		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
	}
}
