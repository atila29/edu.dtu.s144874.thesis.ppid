/*
 * generated by Xtext 2.24.0
 */
grammar InternalPpid;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package edu.dtu.s144874.thesis.ppid.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package edu.dtu.s144874.thesis.ppid.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.dtu.s144874.thesis.ppid.services.PpidGrammarAccess;

}

@parser::members {

 	private PpidGrammarAccess grammarAccess;

    public InternalPpidParser(TokenStream input, PpidGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected PpidGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getEntitesEntityParserRuleCall_0_0());
				}
				lv_entites_0_0=ruleEntity
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"entites",
						lv_entites_0_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Entity");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getSourcesSourceParserRuleCall_1_0());
				}
				lv_sources_1_0=ruleSource
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"sources",
						lv_sources_1_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Source");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getSinksSinkParserRuleCall_2_0());
				}
				lv_sinks_2_0=ruleSink
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"sinks",
						lv_sinks_2_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Sink");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_3_0());
				}
				lv_rules_3_0=ruleRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"rules",
						lv_rules_3_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getStartStartRuleParserRuleCall_4_0());
				}
				lv_start_4_0=ruleStartRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					set(
						$current,
						"start",
						lv_start_4_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.StartRule");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getEndEndRuleParserRuleCall_5_0());
				}
				lv_end_5_0=ruleEndRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					set(
						$current,
						"end",
						lv_end_5_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.EndRule");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleEntity
entryRuleEntity returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityRule()); }
	iv_ruleEntity=ruleEntity
	{ $current=$iv_ruleEntity.current; }
	EOF;

// Rule Entity
ruleEntity returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='entity'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
				}
				lv_properties_3_0=ruleProperty
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityRule());
					}
					add(
						$current,
						"properties",
						lv_properties_3_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Property");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleSource
entryRuleSource returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSourceRule()); }
	iv_ruleSource=ruleSource
	{ $current=$iv_ruleSource.current; }
	EOF;

// Rule Source
ruleSource returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='source'
		{
			newLeafNode(otherlv_0, grammarAccess.getSourceAccess().getSourceKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSourceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				lv_topic_2_0=RULE_STRING
				{
					newLeafNode(lv_topic_2_0, grammarAccess.getSourceAccess().getTopicSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSourceRule());
					}
					setWithLastConsumed(
						$current,
						"topic",
						lv_topic_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSourceRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getSourceAccess().getEntityEntityCrossReference_3_0());
				}
			)
		)
	)
;

// Entry rule entryRuleSink
entryRuleSink returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSinkRule()); }
	iv_ruleSink=ruleSink
	{ $current=$iv_ruleSink.current; }
	EOF;

// Rule Sink
ruleSink returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='sink'
		{
			newLeafNode(otherlv_0, grammarAccess.getSinkAccess().getSinkKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSinkAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSinkRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSinkRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getSinkAccess().getEntityEntityCrossReference_2_0());
				}
			)
		)
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTypeAccess().getEntityReferenceParserRuleCall_0());
		}
		this_EntityReference_0=ruleEntityReference
		{
			$current = $this_EntityReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getSimpleDataTypeParserRuleCall_1());
		}
		this_SimpleDataType_1=ruleSimpleDataType
		{
			$current = $this_SimpleDataType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getArrayTypeParserRuleCall_2());
		}
		this_ArrayType_2=ruleArrayType
		{
			$current = $this_ArrayType_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleArrayType
entryRuleArrayType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArrayTypeRule()); }
	iv_ruleArrayType=ruleArrayType
	{ $current=$iv_ruleArrayType.current; }
	EOF;

// Rule ArrayType
ruleArrayType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getArrayTypeAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getArrayTypeAccess().getTypeTypeParserRuleCall_1_0());
				}
				lv_type_1_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArrayTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_1_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=']'
		{
			newLeafNode(otherlv_2, grammarAccess.getArrayTypeAccess().getRightSquareBracketKeyword_2());
		}
	)
;

// Entry rule entryRuleEntityReference
entryRuleEntityReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityReferenceRule()); }
	iv_ruleEntityReference=ruleEntityReference
	{ $current=$iv_ruleEntityReference.current; }
	EOF;

// Rule EntityReference
ruleEntityReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getEntityReferenceRule());
				}
			}
			otherlv_0=RULE_ID
			{
				newLeafNode(otherlv_0, grammarAccess.getEntityReferenceAccess().getEntityEntityCrossReference_0());
			}
		)
	)
;

// Entry rule entryRuleSimpleDataType
entryRuleSimpleDataType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleDataTypeRule()); }
	iv_ruleSimpleDataType=ruleSimpleDataType
	{ $current=$iv_ruleSimpleDataType.current; }
	EOF;

// Rule SimpleDataType
ruleSimpleDataType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getSimpleDataTypeAccess().getTypePrimitiveTypeEnumRuleCall_0());
			}
			lv_type_0_0=rulePrimitiveType
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getSimpleDataTypeRule());
				}
				set(
					$current,
					"type",
					lv_type_0_0,
					"edu.dtu.s144874.thesis.ppid.Ppid.PrimitiveType");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleProperty
entryRuleProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyRule()); }
	iv_ruleProperty=ruleProperty
	{ $current=$iv_ruleProperty.current; }
	EOF;

// Rule Property
ruleProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropertyRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePropertyReference
entryRulePropertyReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyReferenceRule()); }
	iv_rulePropertyReference=rulePropertyReference
	{ $current=$iv_rulePropertyReference.current; }
	EOF;

// Rule PropertyReference
rulePropertyReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getPropertyReferenceAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getPropertyReferenceRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRuleUpdate
entryRuleUpdate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateRule()); }
	iv_ruleUpdate=ruleUpdate
	{ $current=$iv_ruleUpdate.current; }
	EOF;

// Rule Update
ruleUpdate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateAboveParserRuleCall_0());
		}
		this_UpdateAbove_0=ruleUpdateAbove
		{
			$current = $this_UpdateAbove_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateBelowParserRuleCall_1());
		}
		this_UpdateBelow_1=ruleUpdateBelow
		{
			$current = $this_UpdateBelow_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateChangeParserRuleCall_2());
		}
		this_UpdateChange_2=ruleUpdateChange
		{
			$current = $this_UpdateChange_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateIsParserRuleCall_3());
		}
		this_UpdateIs_3=ruleUpdateIs
		{
			$current = $this_UpdateIs_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateNotParserRuleCall_4());
		}
		this_UpdateNot_4=ruleUpdateNot
		{
			$current = $this_UpdateNot_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOutputProperty
entryRuleOutputProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutputPropertyRule()); }
	iv_ruleOutputProperty=ruleOutputProperty
	{ $current=$iv_ruleOutputProperty.current; }
	EOF;

// Rule OutputProperty
ruleOutputProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getOutputPropertyAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOutputPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getOutputPropertyAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOutputPropertyAccess().getValueOutputValueParserRuleCall_2_0());
				}
				lv_value_2_0=ruleOutputValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOutputPropertyRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.OutputValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleOutputValue
entryRuleOutputValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutputValueRule()); }
	iv_ruleOutputValue=ruleOutputValue
	{ $current=$iv_ruleOutputValue.current; }
	EOF;

// Rule OutputValue
ruleOutputValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_valueInt_0_0=RULE_INT
				{
					newLeafNode(lv_valueInt_0_0, grammarAccess.getOutputValueAccess().getValueIntINTTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOutputValueRule());
					}
					setWithLastConsumed(
						$current,
						"valueInt",
						lv_valueInt_0_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		    |
		(
			(
				lv_valueString_1_0=RULE_STRING
				{
					newLeafNode(lv_valueString_1_0, grammarAccess.getOutputValueAccess().getValueStringSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOutputValueRule());
					}
					setWithLastConsumed(
						$current,
						"valueString",
						lv_valueString_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getOutputValueAccess().getValueRefPropertyReferenceParserRuleCall_2_0());
				}
				lv_valueRef_2_0=rulePropertyReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOutputValueRule());
					}
					set(
						$current,
						"valueRef",
						lv_valueRef_2_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.PropertyReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleOutput
entryRuleOutput returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutputRule()); }
	iv_ruleOutput=ruleOutput
	{ $current=$iv_ruleOutput.current; }
	EOF;

// Rule Output
ruleOutput returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getOutputAccess().getOutputAction_0(),
					$current);
			}
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getOutputAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOutputAccess().getPropertiesOutputPropertyParserRuleCall_2_0());
				}
				lv_properties_2_0=ruleOutputProperty
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOutputRule());
					}
					add(
						$current,
						"properties",
						lv_properties_2_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.OutputProperty");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=','
			{
				newLeafNode(otherlv_3, grammarAccess.getOutputAccess().getCommaKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOutputAccess().getPropertiesOutputPropertyParserRuleCall_3_1_0());
					}
					lv_properties_4_0=ruleOutputProperty
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOutputRule());
						}
						add(
							$current,
							"properties",
							lv_properties_4_0,
							"edu.dtu.s144874.thesis.ppid.Ppid.OutputProperty");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getOutputAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleSourceUpdate
entryRuleSourceUpdate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSourceUpdateRule()); }
	iv_ruleSourceUpdate=ruleSourceUpdate
	{ $current=$iv_ruleSourceUpdate.current; }
	EOF;

// Rule SourceUpdate
ruleSourceUpdate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSourceUpdateRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getSourceUpdateAccess().getSourceSourceCrossReference_0_0());
				}
			)
		)
		otherlv_1='.'
		{
			newLeafNode(otherlv_1, grammarAccess.getSourceUpdateAccess().getFullStopKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSourceUpdateRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getSourceUpdateAccess().getPropertyPropertyCrossReference_2_0());
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getSourceUpdateAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSourceUpdateAccess().getUpdateUpdateParserRuleCall_4_0());
				}
				lv_update_4_0=ruleUpdate
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSourceUpdateRule());
					}
					set(
						$current,
						"update",
						lv_update_4_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Update");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleRule
entryRuleRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRuleRule()); }
	iv_ruleRule=ruleRule
	{ $current=$iv_ruleRule.current; }
	EOF;

// Rule Rule
ruleRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRuleAccess().getUpdatesSourceUpdateParserRuleCall_0_0());
				}
				lv_updates_0_0=ruleSourceUpdate
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRuleRule());
					}
					add(
						$current,
						"updates",
						lv_updates_0_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.SourceUpdate");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='and'
			{
				newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getAndKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRuleAccess().getUpdatesSourceUpdateParserRuleCall_1_1_0());
					}
					lv_updates_2_0=ruleSourceUpdate
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRuleRule());
						}
						add(
							$current,
							"updates",
							lv_updates_2_0,
							"edu.dtu.s144874.thesis.ppid.Ppid.SourceUpdate");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			otherlv_3='=>'
			{
				newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getEqualsSignGreaterThanSignKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRuleAccess().getOutputOutputParserRuleCall_2_1_0());
					}
					lv_output_4_0=ruleOutput
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRuleRule());
						}
						set(
							$current,
							"output",
							lv_output_4_0,
							"edu.dtu.s144874.thesis.ppid.Ppid.Output");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5='into'
		{
			newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getIntoKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRuleRule());
					}
				}
				otherlv_6=RULE_ID
				{
					newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getSinkSinkCrossReference_4_0());
				}
			)
		)
	)
;

// Entry rule entryRuleStartRule
entryRuleStartRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStartRuleRule()); }
	iv_ruleStartRule=ruleStartRule
	{ $current=$iv_ruleStartRule.current; }
	EOF;

// Rule StartRule
ruleStartRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='start'
		{
			newLeafNode(otherlv_0, grammarAccess.getStartRuleAccess().getStartKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStartRuleAccess().getRuleRuleParserRuleCall_1_0());
				}
				lv_rule_1_0=ruleRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStartRuleRule());
					}
					set(
						$current,
						"rule",
						lv_rule_1_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEndRule
entryRuleEndRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEndRuleRule()); }
	iv_ruleEndRule=ruleEndRule
	{ $current=$iv_ruleEndRule.current; }
	EOF;

// Rule EndRule
ruleEndRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='end'
		{
			newLeafNode(otherlv_0, grammarAccess.getEndRuleAccess().getEndKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEndRuleAccess().getRuleRuleParserRuleCall_1_0());
				}
				lv_rule_1_0=ruleRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEndRuleRule());
					}
					set(
						$current,
						"rule",
						lv_rule_1_0,
						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleUpdateAbove
entryRuleUpdateAbove returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateAboveRule()); }
	iv_ruleUpdateAbove=ruleUpdateAbove
	{ $current=$iv_ruleUpdateAbove.current; }
	EOF;

// Rule UpdateAbove
ruleUpdateAbove returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='above'
		{
			newLeafNode(otherlv_0, grammarAccess.getUpdateAboveAccess().getAboveKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getUpdateAboveAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_n_2_0=RULE_INT
				{
					newLeafNode(lv_n_2_0, grammarAccess.getUpdateAboveAccess().getNINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateAboveRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getUpdateAboveAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleUpdateBelow
entryRuleUpdateBelow returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateBelowRule()); }
	iv_ruleUpdateBelow=ruleUpdateBelow
	{ $current=$iv_ruleUpdateBelow.current; }
	EOF;

// Rule UpdateBelow
ruleUpdateBelow returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='below'
		{
			newLeafNode(otherlv_0, grammarAccess.getUpdateBelowAccess().getBelowKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getUpdateBelowAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_n_2_0=RULE_INT
				{
					newLeafNode(lv_n_2_0, grammarAccess.getUpdateBelowAccess().getNINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateBelowRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getUpdateBelowAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleUpdateChange
entryRuleUpdateChange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateChangeRule()); }
	iv_ruleUpdateChange=ruleUpdateChange
	{ $current=$iv_ruleUpdateChange.current; }
	EOF;

// Rule UpdateChange
ruleUpdateChange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='change'
		{
			newLeafNode(otherlv_0, grammarAccess.getUpdateChangeAccess().getChangeKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getUpdateChangeAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_n_2_0=RULE_INT
				{
					newLeafNode(lv_n_2_0, grammarAccess.getUpdateChangeAccess().getNINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateChangeRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=','
		{
			newLeafNode(otherlv_3, grammarAccess.getUpdateChangeAccess().getCommaKeyword_3());
		}
		(
			(
				lv_m_4_0=RULE_INT
				{
					newLeafNode(lv_m_4_0, grammarAccess.getUpdateChangeAccess().getMINTTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateChangeRule());
					}
					setWithLastConsumed(
						$current,
						"m",
						lv_m_4_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getUpdateChangeAccess().getRightParenthesisKeyword_5());
		}
	)
;

// Entry rule entryRuleUpdateIs
entryRuleUpdateIs returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateIsRule()); }
	iv_ruleUpdateIs=ruleUpdateIs
	{ $current=$iv_ruleUpdateIs.current; }
	EOF;

// Rule UpdateIs
ruleUpdateIs returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='is'
		{
			newLeafNode(otherlv_0, grammarAccess.getUpdateIsAccess().getIsKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getUpdateIsAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_n_2_0=RULE_INT
				{
					newLeafNode(lv_n_2_0, grammarAccess.getUpdateIsAccess().getNINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateIsRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getUpdateIsAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleUpdateNot
entryRuleUpdateNot returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUpdateNotRule()); }
	iv_ruleUpdateNot=ruleUpdateNot
	{ $current=$iv_ruleUpdateNot.current; }
	EOF;

// Rule UpdateNot
ruleUpdateNot returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='not'
		{
			newLeafNode(otherlv_0, grammarAccess.getUpdateNotAccess().getNotKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getUpdateNotAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_n_2_0=RULE_INT
				{
					newLeafNode(lv_n_2_0, grammarAccess.getUpdateNotAccess().getNINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUpdateNotRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getUpdateNotAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Rule PrimitiveType
rulePrimitiveType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='number'
			{
				$current = grammarAccess.getPrimitiveTypeAccess().getNumberEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPrimitiveTypeAccess().getNumberEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='string'
			{
				$current = grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_1());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
