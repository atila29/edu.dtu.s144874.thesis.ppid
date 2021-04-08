/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid.impl;

import edu.dtu.s144874.thesis.ppid.ppid.EndRule;
import edu.dtu.s144874.thesis.ppid.ppid.Entity;
import edu.dtu.s144874.thesis.ppid.ppid.Model;
import edu.dtu.s144874.thesis.ppid.ppid.PpidPackage;
import edu.dtu.s144874.thesis.ppid.ppid.Rule;
import edu.dtu.s144874.thesis.ppid.ppid.Sink;
import edu.dtu.s144874.thesis.ppid.ppid.Source;
import edu.dtu.s144874.thesis.ppid.ppid.StartRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getEntites <em>Entites</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getSinks <em>Sinks</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getStart <em>Start</em>}</li>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.ModelImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getEntites() <em>Entites</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntites()
   * @generated
   * @ordered
   */
  protected EList<Entity> entites;

  /**
   * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSources()
   * @generated
   * @ordered
   */
  protected EList<Source> sources;

  /**
   * The cached value of the '{@link #getSinks() <em>Sinks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSinks()
   * @generated
   * @ordered
   */
  protected EList<Sink> sinks;

  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<Rule> rules;

  /**
   * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStart()
   * @generated
   * @ordered
   */
  protected StartRule start;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected EndRule end;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return PpidPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Entity> getEntites()
  {
    if (entites == null)
    {
      entites = new EObjectContainmentEList<Entity>(Entity.class, this, PpidPackage.MODEL__ENTITES);
    }
    return entites;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Source> getSources()
  {
    if (sources == null)
    {
      sources = new EObjectContainmentEList<Source>(Source.class, this, PpidPackage.MODEL__SOURCES);
    }
    return sources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Sink> getSinks()
  {
    if (sinks == null)
    {
      sinks = new EObjectContainmentEList<Sink>(Sink.class, this, PpidPackage.MODEL__SINKS);
    }
    return sinks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Rule> getRules()
  {
    if (rules == null)
    {
      rules = new EObjectContainmentEList<Rule>(Rule.class, this, PpidPackage.MODEL__RULES);
    }
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StartRule getStart()
  {
    return start;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStart(StartRule newStart, NotificationChain msgs)
  {
    StartRule oldStart = start;
    start = newStart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PpidPackage.MODEL__START, oldStart, newStart);
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
  public void setStart(StartRule newStart)
  {
    if (newStart != start)
    {
      NotificationChain msgs = null;
      if (start != null)
        msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PpidPackage.MODEL__START, null, msgs);
      if (newStart != null)
        msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PpidPackage.MODEL__START, null, msgs);
      msgs = basicSetStart(newStart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.MODEL__START, newStart, newStart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EndRule getEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnd(EndRule newEnd, NotificationChain msgs)
  {
    EndRule oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PpidPackage.MODEL__END, oldEnd, newEnd);
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
  public void setEnd(EndRule newEnd)
  {
    if (newEnd != end)
    {
      NotificationChain msgs = null;
      if (end != null)
        msgs = ((InternalEObject)end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PpidPackage.MODEL__END, null, msgs);
      if (newEnd != null)
        msgs = ((InternalEObject)newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PpidPackage.MODEL__END, null, msgs);
      msgs = basicSetEnd(newEnd, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.MODEL__END, newEnd, newEnd));
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
      case PpidPackage.MODEL__ENTITES:
        return ((InternalEList<?>)getEntites()).basicRemove(otherEnd, msgs);
      case PpidPackage.MODEL__SOURCES:
        return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
      case PpidPackage.MODEL__SINKS:
        return ((InternalEList<?>)getSinks()).basicRemove(otherEnd, msgs);
      case PpidPackage.MODEL__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
      case PpidPackage.MODEL__START:
        return basicSetStart(null, msgs);
      case PpidPackage.MODEL__END:
        return basicSetEnd(null, msgs);
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
      case PpidPackage.MODEL__ENTITES:
        return getEntites();
      case PpidPackage.MODEL__SOURCES:
        return getSources();
      case PpidPackage.MODEL__SINKS:
        return getSinks();
      case PpidPackage.MODEL__RULES:
        return getRules();
      case PpidPackage.MODEL__START:
        return getStart();
      case PpidPackage.MODEL__END:
        return getEnd();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PpidPackage.MODEL__ENTITES:
        getEntites().clear();
        getEntites().addAll((Collection<? extends Entity>)newValue);
        return;
      case PpidPackage.MODEL__SOURCES:
        getSources().clear();
        getSources().addAll((Collection<? extends Source>)newValue);
        return;
      case PpidPackage.MODEL__SINKS:
        getSinks().clear();
        getSinks().addAll((Collection<? extends Sink>)newValue);
        return;
      case PpidPackage.MODEL__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends Rule>)newValue);
        return;
      case PpidPackage.MODEL__START:
        setStart((StartRule)newValue);
        return;
      case PpidPackage.MODEL__END:
        setEnd((EndRule)newValue);
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
      case PpidPackage.MODEL__ENTITES:
        getEntites().clear();
        return;
      case PpidPackage.MODEL__SOURCES:
        getSources().clear();
        return;
      case PpidPackage.MODEL__SINKS:
        getSinks().clear();
        return;
      case PpidPackage.MODEL__RULES:
        getRules().clear();
        return;
      case PpidPackage.MODEL__START:
        setStart((StartRule)null);
        return;
      case PpidPackage.MODEL__END:
        setEnd((EndRule)null);
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
      case PpidPackage.MODEL__ENTITES:
        return entites != null && !entites.isEmpty();
      case PpidPackage.MODEL__SOURCES:
        return sources != null && !sources.isEmpty();
      case PpidPackage.MODEL__SINKS:
        return sinks != null && !sinks.isEmpty();
      case PpidPackage.MODEL__RULES:
        return rules != null && !rules.isEmpty();
      case PpidPackage.MODEL__START:
        return start != null;
      case PpidPackage.MODEL__END:
        return end != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl