/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid.impl;

import edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule;
import edu.dtu.s144874.thesis.ppid.ppid.Output;
import edu.dtu.s144874.thesis.ppid.ppid.PpidPackage;
import edu.dtu.s144874.thesis.ppid.ppid.Rule;
import edu.dtu.s144874.thesis.ppid.ppid.Sink;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ExtendedRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ExtendedRuleImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ExtendedRuleImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ExtendedRuleImpl#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtendedRuleImpl extends MinimalEObjectImpl.Container implements ExtendedRule
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected Rule rule;

  /**
   * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected Output output;

  /**
   * The cached value of the '{@link #getSink() <em>Sink</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSink()
   * @generated
   * @ordered
   */
  protected Sink sink;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtendedRuleImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PpidPackage.Literals.EXTENDED_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rule getRule()
  {
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs)
  {
    Rule oldRule = rule;
    rule = newRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__RULE, oldRule, newRule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRule(Rule newRule)
  {
    if (newRule != rule)
    {
      NotificationChain msgs = null;
      if (rule != null)
        msgs = ((InternalEObject)rule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PpidPackage.EXTENDED_RULE__RULE, null, msgs);
      if (newRule != null)
        msgs = ((InternalEObject)newRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PpidPackage.EXTENDED_RULE__RULE, null, msgs);
      msgs = basicSetRule(newRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__RULE, newRule, newRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Output getOutput()
  {
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs)
  {
    Output oldOutput = output;
    output = newOutput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__OUTPUT, oldOutput, newOutput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOutput(Output newOutput)
  {
    if (newOutput != output)
    {
      NotificationChain msgs = null;
      if (output != null)
        msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PpidPackage.EXTENDED_RULE__OUTPUT, null, msgs);
      if (newOutput != null)
        msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PpidPackage.EXTENDED_RULE__OUTPUT, null, msgs);
      msgs = basicSetOutput(newOutput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__OUTPUT, newOutput, newOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Sink getSink()
  {
    if (sink != null && sink.eIsProxy())
    {
      InternalEObject oldSink = (InternalEObject)sink;
      sink = (Sink)eResolveProxy(oldSink);
      if (sink != oldSink)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PpidPackage.EXTENDED_RULE__SINK, oldSink, sink));
      }
    }
    return sink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sink basicGetSink()
  {
    return sink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSink(Sink newSink)
  {
    Sink oldSink = sink;
    sink = newSink;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.EXTENDED_RULE__SINK, oldSink, sink));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PpidPackage.EXTENDED_RULE__RULE:
        return basicSetRule(null, msgs);
      case PpidPackage.EXTENDED_RULE__OUTPUT:
        return basicSetOutput(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PpidPackage.EXTENDED_RULE__NAME:
        return getName();
      case PpidPackage.EXTENDED_RULE__RULE:
        return getRule();
      case PpidPackage.EXTENDED_RULE__OUTPUT:
        return getOutput();
      case PpidPackage.EXTENDED_RULE__SINK:
        if (resolve) return getSink();
        return basicGetSink();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PpidPackage.EXTENDED_RULE__NAME:
        setName((String)newValue);
        return;
      case PpidPackage.EXTENDED_RULE__RULE:
        setRule((Rule)newValue);
        return;
      case PpidPackage.EXTENDED_RULE__OUTPUT:
        setOutput((Output)newValue);
        return;
      case PpidPackage.EXTENDED_RULE__SINK:
        setSink((Sink)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PpidPackage.EXTENDED_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PpidPackage.EXTENDED_RULE__RULE:
        setRule((Rule)null);
        return;
      case PpidPackage.EXTENDED_RULE__OUTPUT:
        setOutput((Output)null);
        return;
      case PpidPackage.EXTENDED_RULE__SINK:
        setSink((Sink)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PpidPackage.EXTENDED_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PpidPackage.EXTENDED_RULE__RULE:
        return rule != null;
      case PpidPackage.EXTENDED_RULE__OUTPUT:
        return output != null;
      case PpidPackage.EXTENDED_RULE__SINK:
        return sink != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ExtendedRuleImpl
