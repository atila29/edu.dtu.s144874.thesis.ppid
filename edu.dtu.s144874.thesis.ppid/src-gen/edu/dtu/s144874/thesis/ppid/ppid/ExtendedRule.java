/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getName <em>Name</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getRule <em>Rule</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getOutput <em>Output</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getExtendedRule()
 * @model
 * @generated
 */
public interface ExtendedRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getExtendedRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(Rule)
   * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getExtendedRule_Rule()
   * @model containment="true"
   * @generated
   */
  Rule getRule();

  /**
   * Sets the value of the '{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(Rule value);

  /**
   * Returns the value of the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' containment reference.
   * @see #setOutput(Output)
   * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getExtendedRule_Output()
   * @model containment="true"
   * @generated
   */
  Output getOutput();

  /**
   * Sets the value of the '{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getOutput <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' containment reference.
   * @see #getOutput()
   * @generated
   */
  void setOutput(Output value);

  /**
   * Returns the value of the '<em><b>Sink</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sink</em>' reference.
   * @see #setSink(Sink)
   * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage#getExtendedRule_Sink()
   * @model
   * @generated
   */
  Sink getSink();

  /**
   * Sets the value of the '{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule#getSink <em>Sink</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sink</em>' reference.
   * @see #getSink()
   * @generated
   */
  void setSink(Sink value);

} // ExtendedRule
