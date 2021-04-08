/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.StartRule#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getStartRule()
 * @model
 * @generated
 */
public interface StartRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(Rule)
   * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getStartRule_Rule()
   * @model containment="true"
   * @generated
   */
  Rule getRule();

  /**
   * Sets the value of the '{@link edu.dtu.s144874.thesis.ppid.ppid.StartRule#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(Rule value);

} // StartRule
