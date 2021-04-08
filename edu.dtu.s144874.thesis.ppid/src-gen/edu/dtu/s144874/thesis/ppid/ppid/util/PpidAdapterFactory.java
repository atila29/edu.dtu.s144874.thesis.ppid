/**
 * generated by Xtext 2.24.0
 */
package edu.dtu.s144874.thesis.ppid.ppid.util;

import edu.dtu.s144874.thesis.ppid.ppid.ArrayType;
import edu.dtu.s144874.thesis.ppid.ppid.Connections;
import edu.dtu.s144874.thesis.ppid.ppid.EndRule;
import edu.dtu.s144874.thesis.ppid.ppid.Entity;
import edu.dtu.s144874.thesis.ppid.ppid.EntityReference;
import edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule;
import edu.dtu.s144874.thesis.ppid.ppid.Model;
import edu.dtu.s144874.thesis.ppid.ppid.Output;
import edu.dtu.s144874.thesis.ppid.ppid.OutputProperty;
import edu.dtu.s144874.thesis.ppid.ppid.OutputValue;
import edu.dtu.s144874.thesis.ppid.ppid.PpidPackage;
import edu.dtu.s144874.thesis.ppid.ppid.Property;
import edu.dtu.s144874.thesis.ppid.ppid.PropertyReference;
import edu.dtu.s144874.thesis.ppid.ppid.Rule;
import edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType;
import edu.dtu.s144874.thesis.ppid.ppid.Sink;
import edu.dtu.s144874.thesis.ppid.ppid.Source;
import edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate;
import edu.dtu.s144874.thesis.ppid.ppid.StartRule;
import edu.dtu.s144874.thesis.ppid.ppid.Type;
import edu.dtu.s144874.thesis.ppid.ppid.Update;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateIs;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateNot;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.dtu.s144874.thesis.ppid.ppid.PpidPackage
 * @generated
 */
public class PpidAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PpidPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PpidAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PpidPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PpidSwitch<Adapter> modelSwitch =
    new PpidSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseEntity(Entity object)
      {
        return createEntityAdapter();
      }
      @Override
      public Adapter caseSource(Source object)
      {
        return createSourceAdapter();
      }
      @Override
      public Adapter caseSink(Sink object)
      {
        return createSinkAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseArrayType(ArrayType object)
      {
        return createArrayTypeAdapter();
      }
      @Override
      public Adapter caseEntityReference(EntityReference object)
      {
        return createEntityReferenceAdapter();
      }
      @Override
      public Adapter caseSimpleDataType(SimpleDataType object)
      {
        return createSimpleDataTypeAdapter();
      }
      @Override
      public Adapter caseProperty(Property object)
      {
        return createPropertyAdapter();
      }
      @Override
      public Adapter casePropertyReference(PropertyReference object)
      {
        return createPropertyReferenceAdapter();
      }
      @Override
      public Adapter caseUpdate(Update object)
      {
        return createUpdateAdapter();
      }
      @Override
      public Adapter caseOutputProperty(OutputProperty object)
      {
        return createOutputPropertyAdapter();
      }
      @Override
      public Adapter caseOutputValue(OutputValue object)
      {
        return createOutputValueAdapter();
      }
      @Override
      public Adapter caseOutput(Output object)
      {
        return createOutputAdapter();
      }
      @Override
      public Adapter caseSourceUpdate(SourceUpdate object)
      {
        return createSourceUpdateAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseExtendedRule(ExtendedRule object)
      {
        return createExtendedRuleAdapter();
      }
      @Override
      public Adapter caseProcess(edu.dtu.s144874.thesis.ppid.ppid.Process object)
      {
        return createProcessAdapter();
      }
      @Override
      public Adapter caseConnections(Connections object)
      {
        return createConnectionsAdapter();
      }
      @Override
      public Adapter caseStartRule(StartRule object)
      {
        return createStartRuleAdapter();
      }
      @Override
      public Adapter caseEndRule(EndRule object)
      {
        return createEndRuleAdapter();
      }
      @Override
      public Adapter caseUpdateAbove(UpdateAbove object)
      {
        return createUpdateAboveAdapter();
      }
      @Override
      public Adapter caseUpdateBelow(UpdateBelow object)
      {
        return createUpdateBelowAdapter();
      }
      @Override
      public Adapter caseUpdateChange(UpdateChange object)
      {
        return createUpdateChangeAdapter();
      }
      @Override
      public Adapter caseUpdateIs(UpdateIs object)
      {
        return createUpdateIsAdapter();
      }
      @Override
      public Adapter caseUpdateNot(UpdateNot object)
      {
        return createUpdateNotAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Entity
   * @generated
   */
  public Adapter createEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Source <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Source
   * @generated
   */
  public Adapter createSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Sink <em>Sink</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Sink
   * @generated
   */
  public Adapter createSinkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.ArrayType
   * @generated
   */
  public Adapter createArrayTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.EntityReference <em>Entity Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.EntityReference
   * @generated
   */
  public Adapter createEntityReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType <em>Simple Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType
   * @generated
   */
  public Adapter createSimpleDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Property
   * @generated
   */
  public Adapter createPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.PropertyReference <em>Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.PropertyReference
   * @generated
   */
  public Adapter createPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Update <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Update
   * @generated
   */
  public Adapter createUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.OutputProperty <em>Output Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.OutputProperty
   * @generated
   */
  public Adapter createOutputPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.OutputValue <em>Output Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.OutputValue
   * @generated
   */
  public Adapter createOutputValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Output <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Output
   * @generated
   */
  public Adapter createOutputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate <em>Source Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate
   * @generated
   */
  public Adapter createSourceUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule <em>Extended Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule
   * @generated
   */
  public Adapter createExtendedRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Process <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Process
   * @generated
   */
  public Adapter createProcessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.Connections <em>Connections</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.Connections
   * @generated
   */
  public Adapter createConnectionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.StartRule <em>Start Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.StartRule
   * @generated
   */
  public Adapter createStartRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.EndRule <em>End Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.EndRule
   * @generated
   */
  public Adapter createEndRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove <em>Update Above</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove
   * @generated
   */
  public Adapter createUpdateAboveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow <em>Update Below</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow
   * @generated
   */
  public Adapter createUpdateBelowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.UpdateChange <em>Update Change</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.UpdateChange
   * @generated
   */
  public Adapter createUpdateChangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.UpdateIs <em>Update Is</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.UpdateIs
   * @generated
   */
  public Adapter createUpdateIsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.dtu.s144874.thesis.ppid.ppid.UpdateNot <em>Update Not</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.dtu.s144874.thesis.ppid.ppid.UpdateNot
   * @generated
   */
  public Adapter createUpdateNotAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PpidAdapterFactory
