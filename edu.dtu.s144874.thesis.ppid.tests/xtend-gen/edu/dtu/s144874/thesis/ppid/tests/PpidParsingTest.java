/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.tests;

import com.google.inject.Inject;
import edu.dtu.s144874.thesis.ppid.ppid.Model;
import edu.dtu.s144874.thesis.ppid.tests.PpidInjectorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(PpidInjectorProvider.class)
@SuppressWarnings("all")
public class PpidParsingTest {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("a: number");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("b: string");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("c: [string]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("entity B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("a: A");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("b: [A]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Vgr { ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("active : number");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("code : number");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("description : string");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("station : string");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ts : string");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("source so \"f/i/state/dsi\" Vgr");
      _builder.newLine();
      _builder.append("source new \"topic\" Vgr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("sink verySink A");
      _builder.newLine();
      _builder.newLine();
      _builder.append("so.lol.above(1) =>{ caseId: 2 } into verySink");
      _builder.newLine();
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", ");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("expected");
      Assertions.assertEquals(_builder_2, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
