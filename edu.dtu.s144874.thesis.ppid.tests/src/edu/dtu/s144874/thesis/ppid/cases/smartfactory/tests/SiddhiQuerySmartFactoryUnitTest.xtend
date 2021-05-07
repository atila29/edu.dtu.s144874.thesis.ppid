package edu.dtu.s144874.thesis.ppid.cases.smartfactory.tests

import com.google.inject.Inject
import edu.dtu.s144874.thesis.ppid.ppid.Model
import edu.dtu.s144874.thesis.ppid.tests.PpidInjectorProvider
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

@ExtendWith(InjectionExtension)
@InjectWith(PpidInjectorProvider)
class SiddhiQuerySmartFactoryUnitTest {
	@Inject IGenerator2 generator
//	@Inject Provider<XtextResourceSet> resourceSetProvider
	InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
//	val generator = new PpidGenerator()
	
	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	def void shouldGenerateSiddhi() {
		val model = parseHelper.parse(ApplicationSmartFactory.APPLICATION)
		generator.doGenerate(model.eResource,fsa, null)
		assertEquals(1,fsa.textFiles.size)
		val result = fsa.textFiles.get('DEFAULT_OUTPUTapplication.siddhi')
		
		assertNotNull(result)
	}
	
	@Test
	def void shouldCompileSiddhiQuery() {
		val model = parseHelper.parse(ApplicationSmartFactory.APPLICATION)
		generator.doGenerate(model.eResource,fsa, null)
		val query = fsa.textFiles.get('DEFAULT_OUTPUTapplication.siddhi')
		
		
		
	}
}