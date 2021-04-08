/*
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.scoping;

import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import edu.dtu.s144874.thesis.ppid.ppid.PpidPackage;
import edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class PpidScopeProvider extends AbstractPpidScopeProvider {
	
    @Override
    public IScope getScope(EObject context, EReference reference) {
        // We want to define the Scope for the Element's superElement cross-reference
		if (context instanceof SourceUpdate && 
				reference == PpidPackage.Literals.SOURCE_UPDATE__PROPERTY) { 
			return scope_SourceUpdate_op((SourceUpdate) context, reference);
        }
        return super.getScope(context, reference);
    }
	
	IScope scope_SourceUpdate_op(SourceUpdate sourceUpdate, EReference ref) {
        return Scopes.scopeFor(sourceUpdate.getSource().getEntity().getProperties());
    }
}