/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid.impl;

import edu.dtu.s144874.thesis.ppid.ppid.PpidPackage;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.dtu.s144874.thesis.ppid.ppid.impl.UpdateChangeImpl#getM <em>M</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateChangeImpl extends UpdateImpl implements UpdateChange
{
  /**
   * The default value of the '{@link #getM() <em>M</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getM()
   * @generated
   * @ordered
   */
  protected static final int M_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getM() <em>M</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getM()
   * @generated
   * @ordered
   */
  protected int m = M_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UpdateChangeImpl()
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
    return PpidPackage.Literals.UPDATE_CHANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getM()
  {
    return m;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setM(int newM)
  {
    int oldM = m;
    m = newM;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PpidPackage.UPDATE_CHANGE__M, oldM, m));
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
      case PpidPackage.UPDATE_CHANGE__M:
        return getM();
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
      case PpidPackage.UPDATE_CHANGE__M:
        setM((Integer)newValue);
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
      case PpidPackage.UPDATE_CHANGE__M:
        setM(M_EDEFAULT);
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
      case PpidPackage.UPDATE_CHANGE__M:
        return m != M_EDEFAULT;
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
    result.append(" (m: ");
    result.append(m);
    result.append(')');
    return result.toString();
  }

} //UpdateChangeImpl
