package edu.dtu.s144874.thesis.ppid.tests.cases.smartfactory

import com.google.inject.Inject
import edu.dtu.s144874.thesis.ppid.ppid.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import edu.dtu.s144874.thesis.ppid.tests.cases.smartfactory.ApplicationSmartFactory
import edu.dtu.s144874.thesis.ppid.tests.PpidInjectorProvider
import static org.junit.Assert.assertTrue

@ExtendWith(InjectionExtension)
@InjectWith(PpidInjectorProvider)
class ParseTestSmartFactoty {
	
	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse(ApplicationSmartFactory.APPLICATION)
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		assertTrue(result instanceof Model)
	}
}