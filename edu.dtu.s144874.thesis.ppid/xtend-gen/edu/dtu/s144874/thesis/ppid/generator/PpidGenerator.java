package edu.dtu.s144874.thesis.ppid.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.dtu.s144874.thesis.ppid.generator.IndexedUpdate;
import edu.dtu.s144874.thesis.ppid.ppid.EndRule;
import edu.dtu.s144874.thesis.ppid.ppid.EntityReference;
import edu.dtu.s144874.thesis.ppid.ppid.ExtendedRule;
import edu.dtu.s144874.thesis.ppid.ppid.Output;
import edu.dtu.s144874.thesis.ppid.ppid.OutputProperty;
import edu.dtu.s144874.thesis.ppid.ppid.OutputValue;
import edu.dtu.s144874.thesis.ppid.ppid.PrimitiveType;
import edu.dtu.s144874.thesis.ppid.ppid.Property;
import edu.dtu.s144874.thesis.ppid.ppid.PropertyReference;
import edu.dtu.s144874.thesis.ppid.ppid.Rule;
import edu.dtu.s144874.thesis.ppid.ppid.SimpleDataType;
import edu.dtu.s144874.thesis.ppid.ppid.Sink;
import edu.dtu.s144874.thesis.ppid.ppid.Source;
import edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate;
import edu.dtu.s144874.thesis.ppid.ppid.Type;
import edu.dtu.s144874.thesis.ppid.ppid.Update;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateAbove;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateBelow;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateChange;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateIs;
import edu.dtu.s144874.thesis.ppid.ppid.UpdateNot;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 * 
 * 
 * @info(name='VgrMoveToMpoEndQuery')
 * from every e1 = SmartFactoryVgrStream, e2 = SmartFactoryVgrStream[((e1.active==1) and (e1.code==2)) and ((e2.active==0) and (e2.code==1))]
 * select 'productionprocess' as processName, 'vgrmovetohbw' as activityName, 'end' as state, 'vgr' as resource, e2.ts as ts
 * having (e1.target=='mpo') and (e2.target=='mpo')
 * insert into SiddhiProductionOut;
 */
@SuppressWarnings("all")
public class PpidGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<Source, String> _function = (Source it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@source(type = \'mqtt\', url = \"tcp://127.0.0.1:1883\", client.id = \"siddhidsi\", topic = \"");
      String _topic = it.getTopic();
      _builder_1.append(_topic);
      _builder_1.append("\", ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("@map(type = \'json\'))");
      _builder_1.newLine();
      _builder_1.append("define stream ");
      String _name = it.getName();
      _builder_1.append(_name);
      _builder_1.append("Stream (");
      final Function1<Property, String> _function_1 = (Property it_1) -> {
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_1 = it_1.getName();
        _builder_2.append(_name_1);
        _builder_2.append(" ");
        CharSequence _compile = this.compile(it_1.getType());
        _builder_2.append(_compile);
        return _builder_2.toString();
      };
      String _join = IterableExtensions.join(ListExtensions.<Property, String>map(it.getEntity().getProperties(), _function_1), ", ");
      _builder_1.append(_join);
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    };
    String _join = IterableExtensions.join(IterableExtensions.<Source, String>map(Iterables.<Source>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Source.class), _function), "\n");
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<EndRule, String> _function_1 = (EndRule it) -> {
      String _xblockexpression = null;
      {
        final EList<SourceUpdate> updates = it.getRule().getUpdates();
        final Function1<SourceUpdate, IndexedUpdate> _function_2 = (SourceUpdate it_1) -> {
          int _indexOf = updates.indexOf(it_1);
          return new IndexedUpdate(_indexOf, it_1);
        };
        final List<IndexedUpdate> indexedUpdates = ListExtensions.<SourceUpdate, IndexedUpdate>map(updates, _function_2);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("@sink(type=\'log\') ");
        _builder_1.newLine();
        _builder_1.append("define table ");
        CharSequence _compileEndName = this.compileEndName(it.getRule());
        _builder_1.append(_compileEndName);
        _builder_1.append("(instanceCount int, ts string);");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("from every ");
        final Function1<IndexedUpdate, CharSequence> _function_3 = (IndexedUpdate it_1) -> {
          return this.compileFrom(it_1);
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<IndexedUpdate, CharSequence>map(indexedUpdates, _function_3), ", ");
        _builder_1.append(_join_1);
        _builder_1.newLineIfNotEmpty();
        CharSequence _compileSelect = this.compileSelect(it);
        _builder_1.append(_compileSelect);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("having ");
        final Function1<IndexedUpdate, CharSequence> _function_4 = (IndexedUpdate it_1) -> {
          return this.compileHaving(it_1);
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<IndexedUpdate, CharSequence>map(indexedUpdates, _function_4), " and ");
        _builder_1.append(_join_2);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("insert into ");
        CharSequence _compileEndName_1 = this.compileEndName(it.getRule());
        _builder_1.append(_compileEndName_1);
        _builder_1.append(";");
        _builder_1.newLineIfNotEmpty();
        _xblockexpression = _builder_1.toString();
      }
      return _xblockexpression;
    };
    String _join_1 = IterableExtensions.join(IterableExtensions.<EndRule, String>map(Iterables.<EndRule>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), EndRule.class), _function_1), "\n");
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<Sink, String> _function_2 = (Sink it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@sink(type=\'log\')");
      _builder_1.newLine();
      _builder_1.append("define stream ");
      String _name = it.getName();
      _builder_1.append(_name);
      _builder_1.append("Out (");
      final Function1<Property, String> _function_3 = (Property it_1) -> {
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_1 = it_1.getName();
        _builder_2.append(_name_1);
        _builder_2.append(" ");
        CharSequence _compile = this.compile(it_1.getType());
        _builder_2.append(_compile);
        return _builder_2.toString();
      };
      String _join_2 = IterableExtensions.join(ListExtensions.<Property, String>map(it.getEntity().getProperties(), _function_3), ", ");
      _builder_1.append(_join_2);
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    };
    String _join_2 = IterableExtensions.join(IterableExtensions.<Sink, String>map(Iterables.<Sink>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Sink.class), _function_2), "\n");
    _builder.append(_join_2);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<ExtendedRule, String> _function_3 = (ExtendedRule it) -> {
      String _xblockexpression = null;
      {
        final EList<SourceUpdate> updates = it.getRule().getUpdates();
        final Function1<SourceUpdate, IndexedUpdate> _function_4 = (SourceUpdate it_1) -> {
          int _indexOf = updates.indexOf(it_1);
          return new IndexedUpdate(_indexOf, it_1);
        };
        final List<IndexedUpdate> indexedUpdates = ListExtensions.<SourceUpdate, IndexedUpdate>map(updates, _function_4);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("from every ");
        final Function1<IndexedUpdate, CharSequence> _function_5 = (IndexedUpdate it_1) -> {
          return this.compileFrom(it_1);
        };
        String _join_3 = IterableExtensions.join(ListExtensions.<IndexedUpdate, CharSequence>map(indexedUpdates, _function_5), ", ");
        _builder_1.append(_join_3);
        _builder_1.newLineIfNotEmpty();
        {
          Output _output = it.getOutput();
          boolean _tripleEquals = (_output == null);
          if (_tripleEquals) {
            _builder_1.append("select *");
            _builder_1.newLine();
          } else {
            CharSequence _compile = this.compile(it.getOutput());
            _builder_1.append(_compile);
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("having ");
        final Function1<IndexedUpdate, CharSequence> _function_6 = (IndexedUpdate it_1) -> {
          return this.compileHaving(it_1);
        };
        String _join_4 = IterableExtensions.join(ListExtensions.<IndexedUpdate, CharSequence>map(indexedUpdates, _function_6), " and ");
        _builder_1.append(_join_4);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("insert into ");
        String _name = it.getSink().getName();
        _builder_1.append(_name);
        _builder_1.append("Out;");
        _builder_1.newLineIfNotEmpty();
        _xblockexpression = _builder_1.toString();
      }
      return _xblockexpression;
    };
    String _join_3 = IterableExtensions.join(IterableExtensions.<ExtendedRule, String>map(Iterables.<ExtendedRule>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ExtendedRule.class), _function_3), "\n");
    _builder.append(_join_3);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<ExtendedRule, String> _function_4 = (ExtendedRule it) -> {
      String _xblockexpression = null;
      {
        final EList<SourceUpdate> updates = it.getRule().getUpdates();
        final Function1<SourceUpdate, IndexedUpdate> _function_5 = (SourceUpdate it_1) -> {
          int _indexOf = updates.indexOf(it_1);
          return new IndexedUpdate(_indexOf, it_1);
        };
        final List<IndexedUpdate> indexedUpdates = ListExtensions.<SourceUpdate, IndexedUpdate>map(updates, _function_5);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("from every ");
        String _name = it.getSink().getName();
        _builder_1.append(_name);
        _builder_1.append("Out join ");
        CharSequence _compileEndName = this.compileEndName(it.getRule());
        _builder_1.append(_compileEndName);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("select ");
        String _name_1 = it.getSink().getName();
        _builder_1.append(_name_1);
        _builder_1.append("Out.processName, str:concat(\'instance\', convert(count(");
        CharSequence _compileEndName_1 = this.compileEndName(it.getRule());
        _builder_1.append(_compileEndName_1);
        _builder_1.append(".instanceCount),\'string\')) as caseId, ");
        String _name_2 = it.getSink().getName();
        _builder_1.append(_name_2);
        _builder_1.append("Out.activityName, ");
        String _name_3 = it.getSink().getName();
        _builder_1.append(_name_3);
        _builder_1.append("Out.state, ");
        String _name_4 = it.getSink().getName();
        _builder_1.append(_name_4);
        _builder_1.append("Out.resource, ");
        String _name_5 = it.getSink().getName();
        _builder_1.append(_name_5);
        _builder_1.append("Out.ts");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("insert into eventlogOut;");
        _builder_1.newLine();
        _xblockexpression = _builder_1.toString();
      }
      return _xblockexpression;
    };
    String _join_4 = IterableExtensions.join(IterableExtensions.<ExtendedRule, String>map(Iterables.<ExtendedRule>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ExtendedRule.class), _function_4), "\n");
    _builder.append(_join_4);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("@sink(type = \'mqtt\', url = \"tcp://127.0.0.1:1883\", client.id = \"siddhipub\", topic = \"log/$processName/$caseId/$activityName\",  quality.of.service= \'0\', @map(type=\'json\'))");
    _builder.newLine();
    _builder.append("define stream eventlogOut (processName string, caseId string, activityName string, ts string);");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    fsa.generateFile("app.siddhi", _builder);
  }
  
  public CharSequence compileSelect(final EndRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1 as caseId, ts");
    return _builder;
  }
  
  public CharSequence compileEndName(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    int _hashCode = rule.hashCode();
    _builder.append(_hashCode);
    _builder.append("EndTable");
    return _builder;
  }
  
  public CharSequence compileFrom(final IndexedUpdate indexedUpdate) {
    CharSequence _xifexpression = null;
    Update _update = indexedUpdate.getUpdate().getUpdate();
    if ((_update instanceof UpdateChange)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("e");
      Integer _getIndex = indexedUpdate.getGetIndex();
      _builder.append(_getIndex);
      _builder.append("_1 = ");
      String _name = indexedUpdate.getUpdate().getSource().getName();
      _builder.append(_name);
      _builder.append("Stream, e");
      Integer _getIndex_1 = indexedUpdate.getGetIndex();
      _builder.append(_getIndex_1);
      _builder.append("_2 = ");
      String _name_1 = indexedUpdate.getUpdate().getSource().getName();
      _builder.append(_name_1);
      _builder.append("Stream[");
      CharSequence _compileFromFilter = this.compileFromFilter(indexedUpdate.getUpdate(), indexedUpdate.getGetIndex());
      _builder.append(_compileFromFilter);
      _builder.append("]");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("e");
      Integer _getIndex_2 = indexedUpdate.getGetIndex();
      _builder_1.append(_getIndex_2);
      _builder_1.append(" = ");
      String _name_2 = indexedUpdate.getUpdate().getSource().getName();
      _builder_1.append(_name_2);
      _builder_1.append("Stream");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public CharSequence compileFromFilter(final SourceUpdate sourceUpdate, final Integer index) {
    CharSequence _xblockexpression = null;
    {
      final Update update = sourceUpdate.getUpdate();
      CharSequence _xifexpression = null;
      if ((update instanceof UpdateAbove)) {
        StringConcatenation _builder = new StringConcatenation();
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((update instanceof UpdateBelow)) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _xifexpression_1 = _builder_1;
        } else {
          CharSequence _xifexpression_2 = null;
          if ((update instanceof UpdateChange)) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("((e");
            _builder_2.append(index);
            _builder_2.append("_1.");
            String _name = sourceUpdate.getProperty().getName();
            _builder_2.append(_name);
            _builder_2.append("==");
            int _n = ((UpdateChange)update).getN();
            _builder_2.append(_n);
            _builder_2.append(") and (e");
            _builder_2.append(index);
            _builder_2.append("_2.");
            String _name_1 = sourceUpdate.getProperty().getName();
            _builder_2.append(_name_1);
            _builder_2.append("==");
            int _m = ((UpdateChange)update).getM();
            _builder_2.append(_m);
            _builder_2.append("))");
            _xifexpression_2 = _builder_2;
          } else {
            CharSequence _xifexpression_3 = null;
            if ((update instanceof UpdateIs)) {
              StringConcatenation _builder_3 = new StringConcatenation();
              _xifexpression_3 = _builder_3;
            } else {
              CharSequence _xifexpression_4 = null;
              if ((update instanceof UpdateNot)) {
                StringConcatenation _builder_4 = new StringConcatenation();
                _xifexpression_4 = _builder_4;
              } else {
                StringConcatenation _builder_5 = new StringConcatenation();
                Class<? extends Update> _class = update.getClass();
                _builder_5.append(_class);
                _xifexpression_4 = _builder_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence compile(final PropertyReference property) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = property.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence compileHaving(final IndexedUpdate indexedUpdate) {
    CharSequence _xblockexpression = null;
    {
      final SourceUpdate sourceUpdate = indexedUpdate.getUpdate();
      final Update update = sourceUpdate.getUpdate();
      CharSequence _xifexpression = null;
      if ((update instanceof UpdateAbove)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(e");
        Integer _getIndex = indexedUpdate.getGetIndex();
        _builder.append(_getIndex);
        _builder.append(".");
        String _name = sourceUpdate.getProperty().getName();
        _builder.append(_name);
        _builder.append(">");
        int _n = ((UpdateAbove)update).getN();
        _builder.append(_n);
        _builder.append(")");
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((update instanceof UpdateBelow)) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("(e");
          Integer _getIndex_1 = indexedUpdate.getGetIndex();
          _builder_1.append(_getIndex_1);
          _builder_1.append(".");
          String _name_1 = sourceUpdate.getProperty().getName();
          _builder_1.append(_name_1);
          _builder_1.append("<");
          int _n_1 = ((UpdateBelow)update).getN();
          _builder_1.append(_n_1);
          _builder_1.append(")");
          _xifexpression_1 = _builder_1;
        } else {
          CharSequence _xifexpression_2 = null;
          if ((update instanceof UpdateChange)) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _xifexpression_2 = _builder_2;
          } else {
            CharSequence _xifexpression_3 = null;
            if ((update instanceof UpdateIs)) {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("(e");
              Integer _getIndex_2 = indexedUpdate.getGetIndex();
              _builder_3.append(_getIndex_2);
              _builder_3.append(".");
              String _name_2 = sourceUpdate.getProperty().getName();
              _builder_3.append(_name_2);
              _builder_3.append("==");
              int _n_2 = ((UpdateIs)update).getN();
              _builder_3.append(_n_2);
              _builder_3.append(")");
              _xifexpression_3 = _builder_3;
            } else {
              CharSequence _xifexpression_4 = null;
              if ((update instanceof UpdateNot)) {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("(e");
                Integer _getIndex_3 = indexedUpdate.getGetIndex();
                _builder_4.append(_getIndex_3);
                _builder_4.append(".");
                String _name_3 = sourceUpdate.getProperty().getName();
                _builder_4.append(_name_3);
                _builder_4.append("!=");
                int _n_3 = ((UpdateNot)update).getN();
                _builder_4.append(_n_3);
                _builder_4.append(")");
                _xifexpression_4 = _builder_4;
              } else {
                StringConcatenation _builder_5 = new StringConcatenation();
                Class<? extends Update> _class = update.getClass();
                _builder_5.append(_class);
                _xifexpression_4 = _builder_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private CharSequence compile(final Type type) {
    CharSequence _xifexpression = null;
    if ((type instanceof EntityReference)) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = ((EntityReference)type).getEntity().getName();
      _builder.append(_name);
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if ((type instanceof SimpleDataType)) {
        String _xifexpression_2 = null;
        PrimitiveType _type = ((SimpleDataType)type).getType();
        boolean _equals = Objects.equal(_type, PrimitiveType.NUMBER);
        if (_equals) {
          _xifexpression_2 = "int";
        } else {
          _xifexpression_2 = "string";
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private CharSequence compile(final Output output) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("select ");
    final Function1<OutputProperty, String> _function = (OutputProperty it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("\'");
      String _compile = this.compile(it.getValue());
      _builder_1.append(_compile, " ");
      _builder_1.append("\' as ");
      String _name = it.getName();
      _builder_1.append(_name, " ");
      _builder_1.append(" ");
      return _builder_1.toString();
    };
    String _join = IterableExtensions.join(ListExtensions.<OutputProperty, String>map(output.getProperties(), _function), ",");
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private String compile(final OutputValue value) {
    String _valueString = value.getValueString();
    boolean _tripleNotEquals = (_valueString != null);
    if (_tripleNotEquals) {
      return value.getValueString();
    }
    PropertyReference _valueRef = value.getValueRef();
    boolean _tripleNotEquals_1 = (_valueRef != null);
    if (_tripleNotEquals_1) {
      return value.getValueRef().getName();
    }
    return Integer.valueOf(value.getValueInt()).toString();
  }
}
