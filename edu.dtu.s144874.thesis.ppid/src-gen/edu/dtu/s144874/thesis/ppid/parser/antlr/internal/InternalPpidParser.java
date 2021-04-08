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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPpidParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "'}'", "'source'", "'sink'", "'['", "']'", "':'", "','", "'.'", "'and'", "'=>'", "'into'", "'start'", "'end'", "'above'", "'('", "')'", "'below'", "'change'", "'is'", "'not'", "'number'", "'string'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalPpidParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPpidParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPpidParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPpid.g"; }



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




    // $ANTLR start "entryRuleModel"
    // InternalPpid.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPpid.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalPpid.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalPpid.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_entites_0_0= ruleEntity ) )* ( (lv_sources_1_0= ruleSource ) )* ( (lv_sinks_2_0= ruleSink ) )* ( (lv_rules_3_0= ruleRule ) )* ( (lv_start_4_0= ruleStartRule ) )? ( (lv_end_5_0= ruleEndRule ) )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_entites_0_0 = null;

        EObject lv_sources_1_0 = null;

        EObject lv_sinks_2_0 = null;

        EObject lv_rules_3_0 = null;

        EObject lv_start_4_0 = null;

        EObject lv_end_5_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:78:2: ( ( ( (lv_entites_0_0= ruleEntity ) )* ( (lv_sources_1_0= ruleSource ) )* ( (lv_sinks_2_0= ruleSink ) )* ( (lv_rules_3_0= ruleRule ) )* ( (lv_start_4_0= ruleStartRule ) )? ( (lv_end_5_0= ruleEndRule ) )? ) )
            // InternalPpid.g:79:2: ( ( (lv_entites_0_0= ruleEntity ) )* ( (lv_sources_1_0= ruleSource ) )* ( (lv_sinks_2_0= ruleSink ) )* ( (lv_rules_3_0= ruleRule ) )* ( (lv_start_4_0= ruleStartRule ) )? ( (lv_end_5_0= ruleEndRule ) )? )
            {
            // InternalPpid.g:79:2: ( ( (lv_entites_0_0= ruleEntity ) )* ( (lv_sources_1_0= ruleSource ) )* ( (lv_sinks_2_0= ruleSink ) )* ( (lv_rules_3_0= ruleRule ) )* ( (lv_start_4_0= ruleStartRule ) )? ( (lv_end_5_0= ruleEndRule ) )? )
            // InternalPpid.g:80:3: ( (lv_entites_0_0= ruleEntity ) )* ( (lv_sources_1_0= ruleSource ) )* ( (lv_sinks_2_0= ruleSink ) )* ( (lv_rules_3_0= ruleRule ) )* ( (lv_start_4_0= ruleStartRule ) )? ( (lv_end_5_0= ruleEndRule ) )?
            {
            // InternalPpid.g:80:3: ( (lv_entites_0_0= ruleEntity ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPpid.g:81:4: (lv_entites_0_0= ruleEntity )
            	    {
            	    // InternalPpid.g:81:4: (lv_entites_0_0= ruleEntity )
            	    // InternalPpid.g:82:5: lv_entites_0_0= ruleEntity
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getEntitesEntityParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_entites_0_0=ruleEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entites",
            	    						lv_entites_0_0,
            	    						"edu.dtu.s144874.thesis.ppid.Ppid.Entity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalPpid.g:99:3: ( (lv_sources_1_0= ruleSource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPpid.g:100:4: (lv_sources_1_0= ruleSource )
            	    {
            	    // InternalPpid.g:100:4: (lv_sources_1_0= ruleSource )
            	    // InternalPpid.g:101:5: lv_sources_1_0= ruleSource
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getSourcesSourceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_sources_1_0=ruleSource();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sources",
            	    						lv_sources_1_0,
            	    						"edu.dtu.s144874.thesis.ppid.Ppid.Source");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalPpid.g:118:3: ( (lv_sinks_2_0= ruleSink ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPpid.g:119:4: (lv_sinks_2_0= ruleSink )
            	    {
            	    // InternalPpid.g:119:4: (lv_sinks_2_0= ruleSink )
            	    // InternalPpid.g:120:5: lv_sinks_2_0= ruleSink
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getSinksSinkParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_sinks_2_0=ruleSink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sinks",
            	    						lv_sinks_2_0,
            	    						"edu.dtu.s144874.thesis.ppid.Ppid.Sink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalPpid.g:137:3: ( (lv_rules_3_0= ruleRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPpid.g:138:4: (lv_rules_3_0= ruleRule )
            	    {
            	    // InternalPpid.g:138:4: (lv_rules_3_0= ruleRule )
            	    // InternalPpid.g:139:5: lv_rules_3_0= ruleRule
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_rules_3_0=ruleRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_3_0,
            	    						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalPpid.g:156:3: ( (lv_start_4_0= ruleStartRule ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalPpid.g:157:4: (lv_start_4_0= ruleStartRule )
                    {
                    // InternalPpid.g:157:4: (lv_start_4_0= ruleStartRule )
                    // InternalPpid.g:158:5: lv_start_4_0= ruleStartRule
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getStartStartRuleParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_start_4_0=ruleStartRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"start",
                    						lv_start_4_0,
                    						"edu.dtu.s144874.thesis.ppid.Ppid.StartRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalPpid.g:175:3: ( (lv_end_5_0= ruleEndRule ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPpid.g:176:4: (lv_end_5_0= ruleEndRule )
                    {
                    // InternalPpid.g:176:4: (lv_end_5_0= ruleEndRule )
                    // InternalPpid.g:177:5: lv_end_5_0= ruleEndRule
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getEndEndRuleParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_end_5_0=ruleEndRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"end",
                    						lv_end_5_0,
                    						"edu.dtu.s144874.thesis.ppid.Ppid.EndRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEntity"
    // InternalPpid.g:198:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalPpid.g:198:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalPpid.g:199:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalPpid.g:205:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_properties_3_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:211:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // InternalPpid.g:212:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // InternalPpid.g:212:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // InternalPpid.g:213:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalPpid.g:217:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPpid.g:218:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPpid.g:218:4: (lv_name_1_0= RULE_ID )
            // InternalPpid.g:219:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalPpid.g:239:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPpid.g:240:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // InternalPpid.g:240:4: (lv_properties_3_0= ruleProperty )
            	    // InternalPpid.g:241:5: lv_properties_3_0= ruleProperty
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"properties",
            	    						lv_properties_3_0,
            	    						"edu.dtu.s144874.thesis.ppid.Ppid.Property");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSource"
    // InternalPpid.g:266:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // InternalPpid.g:266:47: (iv_ruleSource= ruleSource EOF )
            // InternalPpid.g:267:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // InternalPpid.g:273:1: ruleSource returns [EObject current=null] : (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) ( (lv_topic_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_topic_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPpid.g:279:2: ( (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) ( (lv_topic_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // InternalPpid.g:280:2: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) ( (lv_topic_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalPpid.g:280:2: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) ( (lv_topic_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) ) )
            // InternalPpid.g:281:3: otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) ( (lv_topic_2_0= RULE_STRING ) ) ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSourceAccess().getSourceKeyword_0());
            		
            // InternalPpid.g:285:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPpid.g:286:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPpid.g:286:4: (lv_name_1_0= RULE_ID )
            // InternalPpid.g:287:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalPpid.g:303:3: ( (lv_topic_2_0= RULE_STRING ) )
            // InternalPpid.g:304:4: (lv_topic_2_0= RULE_STRING )
            {
            // InternalPpid.g:304:4: (lv_topic_2_0= RULE_STRING )
            // InternalPpid.g:305:5: lv_topic_2_0= RULE_STRING
            {
            lv_topic_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_topic_2_0, grammarAccess.getSourceAccess().getTopicSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"topic",
            						lv_topic_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalPpid.g:321:3: ( (otherlv_3= RULE_ID ) )
            // InternalPpid.g:322:4: (otherlv_3= RULE_ID )
            {
            // InternalPpid.g:322:4: (otherlv_3= RULE_ID )
            // InternalPpid.g:323:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_3, grammarAccess.getSourceAccess().getEntityEntityCrossReference_3_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleSink"
    // InternalPpid.g:338:1: entryRuleSink returns [EObject current=null] : iv_ruleSink= ruleSink EOF ;
    public final EObject entryRuleSink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSink = null;


        try {
            // InternalPpid.g:338:45: (iv_ruleSink= ruleSink EOF )
            // InternalPpid.g:339:2: iv_ruleSink= ruleSink EOF
            {
             newCompositeNode(grammarAccess.getSinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSink=ruleSink();

            state._fsp--;

             current =iv_ruleSink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSink"


    // $ANTLR start "ruleSink"
    // InternalPpid.g:345:1: ruleSink returns [EObject current=null] : (otherlv_0= 'sink' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalPpid.g:351:2: ( (otherlv_0= 'sink' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) ) )
            // InternalPpid.g:352:2: (otherlv_0= 'sink' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalPpid.g:352:2: (otherlv_0= 'sink' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) )
            // InternalPpid.g:353:3: otherlv_0= 'sink' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSinkAccess().getSinkKeyword_0());
            		
            // InternalPpid.g:357:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPpid.g:358:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPpid.g:358:4: (lv_name_1_0= RULE_ID )
            // InternalPpid.g:359:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSinkAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalPpid.g:375:3: ( (otherlv_2= RULE_ID ) )
            // InternalPpid.g:376:4: (otherlv_2= RULE_ID )
            {
            // InternalPpid.g:376:4: (otherlv_2= RULE_ID )
            // InternalPpid.g:377:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSinkRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getSinkAccess().getEntityEntityCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSink"


    // $ANTLR start "entryRuleType"
    // InternalPpid.g:392:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalPpid.g:392:45: (iv_ruleType= ruleType EOF )
            // InternalPpid.g:393:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalPpid.g:399:1: ruleType returns [EObject current=null] : (this_EntityReference_0= ruleEntityReference | this_SimpleDataType_1= ruleSimpleDataType | this_ArrayType_2= ruleArrayType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_EntityReference_0 = null;

        EObject this_SimpleDataType_1 = null;

        EObject this_ArrayType_2 = null;



        	enterRule();

        try {
            // InternalPpid.g:405:2: ( (this_EntityReference_0= ruleEntityReference | this_SimpleDataType_1= ruleSimpleDataType | this_ArrayType_2= ruleArrayType ) )
            // InternalPpid.g:406:2: (this_EntityReference_0= ruleEntityReference | this_SimpleDataType_1= ruleSimpleDataType | this_ArrayType_2= ruleArrayType )
            {
            // InternalPpid.g:406:2: (this_EntityReference_0= ruleEntityReference | this_SimpleDataType_1= ruleSimpleDataType | this_ArrayType_2= ruleArrayType )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 33:
            case 34:
                {
                alt8=2;
                }
                break;
            case 16:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPpid.g:407:3: this_EntityReference_0= ruleEntityReference
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getEntityReferenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityReference_0=ruleEntityReference();

                    state._fsp--;


                    			current = this_EntityReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPpid.g:416:3: this_SimpleDataType_1= ruleSimpleDataType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getSimpleDataTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleDataType_1=ruleSimpleDataType();

                    state._fsp--;


                    			current = this_SimpleDataType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPpid.g:425:3: this_ArrayType_2= ruleArrayType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getArrayTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayType_2=ruleArrayType();

                    state._fsp--;


                    			current = this_ArrayType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleArrayType"
    // InternalPpid.g:437:1: entryRuleArrayType returns [EObject current=null] : iv_ruleArrayType= ruleArrayType EOF ;
    public final EObject entryRuleArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayType = null;


        try {
            // InternalPpid.g:437:50: (iv_ruleArrayType= ruleArrayType EOF )
            // InternalPpid.g:438:2: iv_ruleArrayType= ruleArrayType EOF
            {
             newCompositeNode(grammarAccess.getArrayTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayType=ruleArrayType();

            state._fsp--;

             current =iv_ruleArrayType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayType"


    // $ANTLR start "ruleArrayType"
    // InternalPpid.g:444:1: ruleArrayType returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleType ) ) otherlv_2= ']' ) ;
    public final EObject ruleArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:450:2: ( (otherlv_0= '[' ( (lv_type_1_0= ruleType ) ) otherlv_2= ']' ) )
            // InternalPpid.g:451:2: (otherlv_0= '[' ( (lv_type_1_0= ruleType ) ) otherlv_2= ']' )
            {
            // InternalPpid.g:451:2: (otherlv_0= '[' ( (lv_type_1_0= ruleType ) ) otherlv_2= ']' )
            // InternalPpid.g:452:3: otherlv_0= '[' ( (lv_type_1_0= ruleType ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayTypeAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalPpid.g:456:3: ( (lv_type_1_0= ruleType ) )
            // InternalPpid.g:457:4: (lv_type_1_0= ruleType )
            {
            // InternalPpid.g:457:4: (lv_type_1_0= ruleType )
            // InternalPpid.g:458:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getArrayTypeAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_type_1_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayTypeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getArrayTypeAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayType"


    // $ANTLR start "entryRuleEntityReference"
    // InternalPpid.g:483:1: entryRuleEntityReference returns [EObject current=null] : iv_ruleEntityReference= ruleEntityReference EOF ;
    public final EObject entryRuleEntityReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityReference = null;


        try {
            // InternalPpid.g:483:56: (iv_ruleEntityReference= ruleEntityReference EOF )
            // InternalPpid.g:484:2: iv_ruleEntityReference= ruleEntityReference EOF
            {
             newCompositeNode(grammarAccess.getEntityReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityReference=ruleEntityReference();

            state._fsp--;

             current =iv_ruleEntityReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityReference"


    // $ANTLR start "ruleEntityReference"
    // InternalPpid.g:490:1: ruleEntityReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleEntityReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalPpid.g:496:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalPpid.g:497:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalPpid.g:497:2: ( (otherlv_0= RULE_ID ) )
            // InternalPpid.g:498:3: (otherlv_0= RULE_ID )
            {
            // InternalPpid.g:498:3: (otherlv_0= RULE_ID )
            // InternalPpid.g:499:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEntityReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getEntityReferenceAccess().getEntityEntityCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityReference"


    // $ANTLR start "entryRuleSimpleDataType"
    // InternalPpid.g:513:1: entryRuleSimpleDataType returns [EObject current=null] : iv_ruleSimpleDataType= ruleSimpleDataType EOF ;
    public final EObject entryRuleSimpleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleDataType = null;


        try {
            // InternalPpid.g:513:55: (iv_ruleSimpleDataType= ruleSimpleDataType EOF )
            // InternalPpid.g:514:2: iv_ruleSimpleDataType= ruleSimpleDataType EOF
            {
             newCompositeNode(grammarAccess.getSimpleDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleDataType=ruleSimpleDataType();

            state._fsp--;

             current =iv_ruleSimpleDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleDataType"


    // $ANTLR start "ruleSimpleDataType"
    // InternalPpid.g:520:1: ruleSimpleDataType returns [EObject current=null] : ( (lv_type_0_0= rulePrimitiveType ) ) ;
    public final EObject ruleSimpleDataType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:526:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) )
            // InternalPpid.g:527:2: ( (lv_type_0_0= rulePrimitiveType ) )
            {
            // InternalPpid.g:527:2: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalPpid.g:528:3: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalPpid.g:528:3: (lv_type_0_0= rulePrimitiveType )
            // InternalPpid.g:529:4: lv_type_0_0= rulePrimitiveType
            {

            				newCompositeNode(grammarAccess.getSimpleDataTypeAccess().getTypePrimitiveTypeEnumRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=rulePrimitiveType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getSimpleDataTypeRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"edu.dtu.s144874.thesis.ppid.Ppid.PrimitiveType");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleDataType"


    // $ANTLR start "entryRuleProperty"
    // InternalPpid.g:549:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalPpid.g:549:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalPpid.g:550:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalPpid.g:556:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:562:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) )
            // InternalPpid.g:563:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalPpid.g:563:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            // InternalPpid.g:564:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) )
            {
            // InternalPpid.g:564:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalPpid.g:565:4: (lv_name_0_0= RULE_ID )
            {
            // InternalPpid.g:565:4: (lv_name_0_0= RULE_ID )
            // InternalPpid.g:566:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
            		
            // InternalPpid.g:586:3: ( (lv_type_2_0= ruleType ) )
            // InternalPpid.g:587:4: (lv_type_2_0= ruleType )
            {
            // InternalPpid.g:587:4: (lv_type_2_0= ruleType )
            // InternalPpid.g:588:5: lv_type_2_0= ruleType
            {

            					newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropertyRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRulePropertyReference"
    // InternalPpid.g:609:1: entryRulePropertyReference returns [EObject current=null] : iv_rulePropertyReference= rulePropertyReference EOF ;
    public final EObject entryRulePropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReference = null;


        try {
            // InternalPpid.g:609:58: (iv_rulePropertyReference= rulePropertyReference EOF )
            // InternalPpid.g:610:2: iv_rulePropertyReference= rulePropertyReference EOF
            {
             newCompositeNode(grammarAccess.getPropertyReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyReference=rulePropertyReference();

            state._fsp--;

             current =iv_rulePropertyReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyReference"


    // $ANTLR start "rulePropertyReference"
    // InternalPpid.g:616:1: rulePropertyReference returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePropertyReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPpid.g:622:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPpid.g:623:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPpid.g:623:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPpid.g:624:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPpid.g:624:3: (lv_name_0_0= RULE_ID )
            // InternalPpid.g:625:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPropertyReferenceAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPropertyReferenceRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyReference"


    // $ANTLR start "entryRuleUpdate"
    // InternalPpid.g:644:1: entryRuleUpdate returns [EObject current=null] : iv_ruleUpdate= ruleUpdate EOF ;
    public final EObject entryRuleUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdate = null;


        try {
            // InternalPpid.g:644:47: (iv_ruleUpdate= ruleUpdate EOF )
            // InternalPpid.g:645:2: iv_ruleUpdate= ruleUpdate EOF
            {
             newCompositeNode(grammarAccess.getUpdateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdate=ruleUpdate();

            state._fsp--;

             current =iv_ruleUpdate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdate"


    // $ANTLR start "ruleUpdate"
    // InternalPpid.g:651:1: ruleUpdate returns [EObject current=null] : (this_UpdateAbove_0= ruleUpdateAbove | this_UpdateBelow_1= ruleUpdateBelow | this_UpdateChange_2= ruleUpdateChange | this_UpdateIs_3= ruleUpdateIs | this_UpdateNot_4= ruleUpdateNot ) ;
    public final EObject ruleUpdate() throws RecognitionException {
        EObject current = null;

        EObject this_UpdateAbove_0 = null;

        EObject this_UpdateBelow_1 = null;

        EObject this_UpdateChange_2 = null;

        EObject this_UpdateIs_3 = null;

        EObject this_UpdateNot_4 = null;



        	enterRule();

        try {
            // InternalPpid.g:657:2: ( (this_UpdateAbove_0= ruleUpdateAbove | this_UpdateBelow_1= ruleUpdateBelow | this_UpdateChange_2= ruleUpdateChange | this_UpdateIs_3= ruleUpdateIs | this_UpdateNot_4= ruleUpdateNot ) )
            // InternalPpid.g:658:2: (this_UpdateAbove_0= ruleUpdateAbove | this_UpdateBelow_1= ruleUpdateBelow | this_UpdateChange_2= ruleUpdateChange | this_UpdateIs_3= ruleUpdateIs | this_UpdateNot_4= ruleUpdateNot )
            {
            // InternalPpid.g:658:2: (this_UpdateAbove_0= ruleUpdateAbove | this_UpdateBelow_1= ruleUpdateBelow | this_UpdateChange_2= ruleUpdateChange | this_UpdateIs_3= ruleUpdateIs | this_UpdateNot_4= ruleUpdateNot )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt9=1;
                }
                break;
            case 29:
                {
                alt9=2;
                }
                break;
            case 30:
                {
                alt9=3;
                }
                break;
            case 31:
                {
                alt9=4;
                }
                break;
            case 32:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPpid.g:659:3: this_UpdateAbove_0= ruleUpdateAbove
                    {

                    			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateAboveParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpdateAbove_0=ruleUpdateAbove();

                    state._fsp--;


                    			current = this_UpdateAbove_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPpid.g:668:3: this_UpdateBelow_1= ruleUpdateBelow
                    {

                    			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateBelowParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpdateBelow_1=ruleUpdateBelow();

                    state._fsp--;


                    			current = this_UpdateBelow_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPpid.g:677:3: this_UpdateChange_2= ruleUpdateChange
                    {

                    			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateChangeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpdateChange_2=ruleUpdateChange();

                    state._fsp--;


                    			current = this_UpdateChange_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalPpid.g:686:3: this_UpdateIs_3= ruleUpdateIs
                    {

                    			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateIsParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpdateIs_3=ruleUpdateIs();

                    state._fsp--;


                    			current = this_UpdateIs_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalPpid.g:695:3: this_UpdateNot_4= ruleUpdateNot
                    {

                    			newCompositeNode(grammarAccess.getUpdateAccess().getUpdateNotParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpdateNot_4=ruleUpdateNot();

                    state._fsp--;


                    			current = this_UpdateNot_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdate"


    // $ANTLR start "entryRuleOutputProperty"
    // InternalPpid.g:707:1: entryRuleOutputProperty returns [EObject current=null] : iv_ruleOutputProperty= ruleOutputProperty EOF ;
    public final EObject entryRuleOutputProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputProperty = null;


        try {
            // InternalPpid.g:707:55: (iv_ruleOutputProperty= ruleOutputProperty EOF )
            // InternalPpid.g:708:2: iv_ruleOutputProperty= ruleOutputProperty EOF
            {
             newCompositeNode(grammarAccess.getOutputPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputProperty=ruleOutputProperty();

            state._fsp--;

             current =iv_ruleOutputProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputProperty"


    // $ANTLR start "ruleOutputProperty"
    // InternalPpid.g:714:1: ruleOutputProperty returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleOutputValue ) ) ) ;
    public final EObject ruleOutputProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:720:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleOutputValue ) ) ) )
            // InternalPpid.g:721:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleOutputValue ) ) )
            {
            // InternalPpid.g:721:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleOutputValue ) ) )
            // InternalPpid.g:722:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleOutputValue ) )
            {
            // InternalPpid.g:722:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalPpid.g:723:4: (lv_name_0_0= RULE_ID )
            {
            // InternalPpid.g:723:4: (lv_name_0_0= RULE_ID )
            // InternalPpid.g:724:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOutputPropertyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutputPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getOutputPropertyAccess().getColonKeyword_1());
            		
            // InternalPpid.g:744:3: ( (lv_value_2_0= ruleOutputValue ) )
            // InternalPpid.g:745:4: (lv_value_2_0= ruleOutputValue )
            {
            // InternalPpid.g:745:4: (lv_value_2_0= ruleOutputValue )
            // InternalPpid.g:746:5: lv_value_2_0= ruleOutputValue
            {

            					newCompositeNode(grammarAccess.getOutputPropertyAccess().getValueOutputValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleOutputValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutputPropertyRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.OutputValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputProperty"


    // $ANTLR start "entryRuleOutputValue"
    // InternalPpid.g:767:1: entryRuleOutputValue returns [EObject current=null] : iv_ruleOutputValue= ruleOutputValue EOF ;
    public final EObject entryRuleOutputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputValue = null;


        try {
            // InternalPpid.g:767:52: (iv_ruleOutputValue= ruleOutputValue EOF )
            // InternalPpid.g:768:2: iv_ruleOutputValue= ruleOutputValue EOF
            {
             newCompositeNode(grammarAccess.getOutputValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputValue=ruleOutputValue();

            state._fsp--;

             current =iv_ruleOutputValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputValue"


    // $ANTLR start "ruleOutputValue"
    // InternalPpid.g:774:1: ruleOutputValue returns [EObject current=null] : ( ( (lv_valueInt_0_0= RULE_INT ) ) | ( (lv_valueString_1_0= RULE_STRING ) ) | ( (lv_valueRef_2_0= rulePropertyReference ) ) ) ;
    public final EObject ruleOutputValue() throws RecognitionException {
        EObject current = null;

        Token lv_valueInt_0_0=null;
        Token lv_valueString_1_0=null;
        EObject lv_valueRef_2_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:780:2: ( ( ( (lv_valueInt_0_0= RULE_INT ) ) | ( (lv_valueString_1_0= RULE_STRING ) ) | ( (lv_valueRef_2_0= rulePropertyReference ) ) ) )
            // InternalPpid.g:781:2: ( ( (lv_valueInt_0_0= RULE_INT ) ) | ( (lv_valueString_1_0= RULE_STRING ) ) | ( (lv_valueRef_2_0= rulePropertyReference ) ) )
            {
            // InternalPpid.g:781:2: ( ( (lv_valueInt_0_0= RULE_INT ) ) | ( (lv_valueString_1_0= RULE_STRING ) ) | ( (lv_valueRef_2_0= rulePropertyReference ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt10=1;
                }
                break;
            case RULE_STRING:
                {
                alt10=2;
                }
                break;
            case RULE_ID:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPpid.g:782:3: ( (lv_valueInt_0_0= RULE_INT ) )
                    {
                    // InternalPpid.g:782:3: ( (lv_valueInt_0_0= RULE_INT ) )
                    // InternalPpid.g:783:4: (lv_valueInt_0_0= RULE_INT )
                    {
                    // InternalPpid.g:783:4: (lv_valueInt_0_0= RULE_INT )
                    // InternalPpid.g:784:5: lv_valueInt_0_0= RULE_INT
                    {
                    lv_valueInt_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_valueInt_0_0, grammarAccess.getOutputValueAccess().getValueIntINTTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOutputValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"valueInt",
                    						lv_valueInt_0_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPpid.g:801:3: ( (lv_valueString_1_0= RULE_STRING ) )
                    {
                    // InternalPpid.g:801:3: ( (lv_valueString_1_0= RULE_STRING ) )
                    // InternalPpid.g:802:4: (lv_valueString_1_0= RULE_STRING )
                    {
                    // InternalPpid.g:802:4: (lv_valueString_1_0= RULE_STRING )
                    // InternalPpid.g:803:5: lv_valueString_1_0= RULE_STRING
                    {
                    lv_valueString_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_valueString_1_0, grammarAccess.getOutputValueAccess().getValueStringSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOutputValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"valueString",
                    						lv_valueString_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPpid.g:820:3: ( (lv_valueRef_2_0= rulePropertyReference ) )
                    {
                    // InternalPpid.g:820:3: ( (lv_valueRef_2_0= rulePropertyReference ) )
                    // InternalPpid.g:821:4: (lv_valueRef_2_0= rulePropertyReference )
                    {
                    // InternalPpid.g:821:4: (lv_valueRef_2_0= rulePropertyReference )
                    // InternalPpid.g:822:5: lv_valueRef_2_0= rulePropertyReference
                    {

                    					newCompositeNode(grammarAccess.getOutputValueAccess().getValueRefPropertyReferenceParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_valueRef_2_0=rulePropertyReference();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOutputValueRule());
                    					}
                    					set(
                    						current,
                    						"valueRef",
                    						lv_valueRef_2_0,
                    						"edu.dtu.s144874.thesis.ppid.Ppid.PropertyReference");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputValue"


    // $ANTLR start "entryRuleOutput"
    // InternalPpid.g:843:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalPpid.g:843:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalPpid.g:844:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalPpid.g:850:1: ruleOutput returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_properties_2_0= ruleOutputProperty ) ) (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_properties_4_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:856:2: ( ( () otherlv_1= '{' ( (lv_properties_2_0= ruleOutputProperty ) ) (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )* otherlv_5= '}' ) )
            // InternalPpid.g:857:2: ( () otherlv_1= '{' ( (lv_properties_2_0= ruleOutputProperty ) ) (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )* otherlv_5= '}' )
            {
            // InternalPpid.g:857:2: ( () otherlv_1= '{' ( (lv_properties_2_0= ruleOutputProperty ) ) (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )* otherlv_5= '}' )
            // InternalPpid.g:858:3: () otherlv_1= '{' ( (lv_properties_2_0= ruleOutputProperty ) ) (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )* otherlv_5= '}'
            {
            // InternalPpid.g:858:3: ()
            // InternalPpid.g:859:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOutputAccess().getOutputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getOutputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalPpid.g:869:3: ( (lv_properties_2_0= ruleOutputProperty ) )
            // InternalPpid.g:870:4: (lv_properties_2_0= ruleOutputProperty )
            {
            // InternalPpid.g:870:4: (lv_properties_2_0= ruleOutputProperty )
            // InternalPpid.g:871:5: lv_properties_2_0= ruleOutputProperty
            {

            					newCompositeNode(grammarAccess.getOutputAccess().getPropertiesOutputPropertyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_16);
            lv_properties_2_0=ruleOutputProperty();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutputRule());
            					}
            					add(
            						current,
            						"properties",
            						lv_properties_2_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.OutputProperty");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPpid.g:888:3: (otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==19) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPpid.g:889:4: otherlv_3= ',' ( (lv_properties_4_0= ruleOutputProperty ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_8); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOutputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalPpid.g:893:4: ( (lv_properties_4_0= ruleOutputProperty ) )
            	    // InternalPpid.g:894:5: (lv_properties_4_0= ruleOutputProperty )
            	    {
            	    // InternalPpid.g:894:5: (lv_properties_4_0= ruleOutputProperty )
            	    // InternalPpid.g:895:6: lv_properties_4_0= ruleOutputProperty
            	    {

            	    						newCompositeNode(grammarAccess.getOutputAccess().getPropertiesOutputPropertyParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_properties_4_0=ruleOutputProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOutputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"properties",
            	    							lv_properties_4_0,
            	    							"edu.dtu.s144874.thesis.ppid.Ppid.OutputProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getOutputAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleSourceUpdate"
    // InternalPpid.g:921:1: entryRuleSourceUpdate returns [EObject current=null] : iv_ruleSourceUpdate= ruleSourceUpdate EOF ;
    public final EObject entryRuleSourceUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceUpdate = null;


        try {
            // InternalPpid.g:921:53: (iv_ruleSourceUpdate= ruleSourceUpdate EOF )
            // InternalPpid.g:922:2: iv_ruleSourceUpdate= ruleSourceUpdate EOF
            {
             newCompositeNode(grammarAccess.getSourceUpdateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSourceUpdate=ruleSourceUpdate();

            state._fsp--;

             current =iv_ruleSourceUpdate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceUpdate"


    // $ANTLR start "ruleSourceUpdate"
    // InternalPpid.g:928:1: ruleSourceUpdate returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_update_4_0= ruleUpdate ) ) ) ;
    public final EObject ruleSourceUpdate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_update_4_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:934:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_update_4_0= ruleUpdate ) ) ) )
            // InternalPpid.g:935:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_update_4_0= ruleUpdate ) ) )
            {
            // InternalPpid.g:935:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_update_4_0= ruleUpdate ) ) )
            // InternalPpid.g:936:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_update_4_0= ruleUpdate ) )
            {
            // InternalPpid.g:936:3: ( (otherlv_0= RULE_ID ) )
            // InternalPpid.g:937:4: (otherlv_0= RULE_ID )
            {
            // InternalPpid.g:937:4: (otherlv_0= RULE_ID )
            // InternalPpid.g:938:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceUpdateRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(otherlv_0, grammarAccess.getSourceUpdateAccess().getSourceSourceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSourceUpdateAccess().getFullStopKeyword_1());
            		
            // InternalPpid.g:953:3: ( (otherlv_2= RULE_ID ) )
            // InternalPpid.g:954:4: (otherlv_2= RULE_ID )
            {
            // InternalPpid.g:954:4: (otherlv_2= RULE_ID )
            // InternalPpid.g:955:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceUpdateRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(otherlv_2, grammarAccess.getSourceUpdateAccess().getPropertyPropertyCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getSourceUpdateAccess().getFullStopKeyword_3());
            		
            // InternalPpid.g:970:3: ( (lv_update_4_0= ruleUpdate ) )
            // InternalPpid.g:971:4: (lv_update_4_0= ruleUpdate )
            {
            // InternalPpid.g:971:4: (lv_update_4_0= ruleUpdate )
            // InternalPpid.g:972:5: lv_update_4_0= ruleUpdate
            {

            					newCompositeNode(grammarAccess.getSourceUpdateAccess().getUpdateUpdateParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_update_4_0=ruleUpdate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSourceUpdateRule());
            					}
            					set(
            						current,
            						"update",
            						lv_update_4_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.Update");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceUpdate"


    // $ANTLR start "entryRuleRule"
    // InternalPpid.g:993:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalPpid.g:993:45: (iv_ruleRule= ruleRule EOF )
            // InternalPpid.g:994:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalPpid.g:1000:1: ruleRule returns [EObject current=null] : ( ( (lv_updates_0_0= ruleSourceUpdate ) ) (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )* (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )? otherlv_5= 'into' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_updates_0_0 = null;

        EObject lv_updates_2_0 = null;

        EObject lv_output_4_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:1006:2: ( ( ( (lv_updates_0_0= ruleSourceUpdate ) ) (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )* (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )? otherlv_5= 'into' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalPpid.g:1007:2: ( ( (lv_updates_0_0= ruleSourceUpdate ) ) (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )* (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )? otherlv_5= 'into' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalPpid.g:1007:2: ( ( (lv_updates_0_0= ruleSourceUpdate ) ) (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )* (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )? otherlv_5= 'into' ( (otherlv_6= RULE_ID ) ) )
            // InternalPpid.g:1008:3: ( (lv_updates_0_0= ruleSourceUpdate ) ) (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )* (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )? otherlv_5= 'into' ( (otherlv_6= RULE_ID ) )
            {
            // InternalPpid.g:1008:3: ( (lv_updates_0_0= ruleSourceUpdate ) )
            // InternalPpid.g:1009:4: (lv_updates_0_0= ruleSourceUpdate )
            {
            // InternalPpid.g:1009:4: (lv_updates_0_0= ruleSourceUpdate )
            // InternalPpid.g:1010:5: lv_updates_0_0= ruleSourceUpdate
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getUpdatesSourceUpdateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
            lv_updates_0_0=ruleSourceUpdate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					add(
            						current,
            						"updates",
            						lv_updates_0_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.SourceUpdate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPpid.g:1027:3: (otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPpid.g:1028:4: otherlv_1= 'and' ( (lv_updates_2_0= ruleSourceUpdate ) )
            	    {
            	    otherlv_1=(Token)match(input,21,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getAndKeyword_1_0());
            	    			
            	    // InternalPpid.g:1032:4: ( (lv_updates_2_0= ruleSourceUpdate ) )
            	    // InternalPpid.g:1033:5: (lv_updates_2_0= ruleSourceUpdate )
            	    {
            	    // InternalPpid.g:1033:5: (lv_updates_2_0= ruleSourceUpdate )
            	    // InternalPpid.g:1034:6: lv_updates_2_0= ruleSourceUpdate
            	    {

            	    						newCompositeNode(grammarAccess.getRuleAccess().getUpdatesSourceUpdateParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_updates_2_0=ruleSourceUpdate();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"updates",
            	    							lv_updates_2_0,
            	    							"edu.dtu.s144874.thesis.ppid.Ppid.SourceUpdate");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalPpid.g:1052:3: (otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPpid.g:1053:4: otherlv_3= '=>' ( (lv_output_4_0= ruleOutput ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalPpid.g:1057:4: ( (lv_output_4_0= ruleOutput ) )
                    // InternalPpid.g:1058:5: (lv_output_4_0= ruleOutput )
                    {
                    // InternalPpid.g:1058:5: (lv_output_4_0= ruleOutput )
                    // InternalPpid.g:1059:6: lv_output_4_0= ruleOutput
                    {

                    						newCompositeNode(grammarAccess.getRuleAccess().getOutputOutputParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_output_4_0=ruleOutput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleRule());
                    						}
                    						set(
                    							current,
                    							"output",
                    							lv_output_4_0,
                    							"edu.dtu.s144874.thesis.ppid.Ppid.Output");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getIntoKeyword_3());
            		
            // InternalPpid.g:1081:3: ( (otherlv_6= RULE_ID ) )
            // InternalPpid.g:1082:4: (otherlv_6= RULE_ID )
            {
            // InternalPpid.g:1082:4: (otherlv_6= RULE_ID )
            // InternalPpid.g:1083:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getSinkSinkCrossReference_4_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleStartRule"
    // InternalPpid.g:1098:1: entryRuleStartRule returns [EObject current=null] : iv_ruleStartRule= ruleStartRule EOF ;
    public final EObject entryRuleStartRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartRule = null;


        try {
            // InternalPpid.g:1098:50: (iv_ruleStartRule= ruleStartRule EOF )
            // InternalPpid.g:1099:2: iv_ruleStartRule= ruleStartRule EOF
            {
             newCompositeNode(grammarAccess.getStartRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartRule=ruleStartRule();

            state._fsp--;

             current =iv_ruleStartRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartRule"


    // $ANTLR start "ruleStartRule"
    // InternalPpid.g:1105:1: ruleStartRule returns [EObject current=null] : (otherlv_0= 'start' ( (lv_rule_1_0= ruleRule ) ) ) ;
    public final EObject ruleStartRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_rule_1_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:1111:2: ( (otherlv_0= 'start' ( (lv_rule_1_0= ruleRule ) ) ) )
            // InternalPpid.g:1112:2: (otherlv_0= 'start' ( (lv_rule_1_0= ruleRule ) ) )
            {
            // InternalPpid.g:1112:2: (otherlv_0= 'start' ( (lv_rule_1_0= ruleRule ) ) )
            // InternalPpid.g:1113:3: otherlv_0= 'start' ( (lv_rule_1_0= ruleRule ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStartRuleAccess().getStartKeyword_0());
            		
            // InternalPpid.g:1117:3: ( (lv_rule_1_0= ruleRule ) )
            // InternalPpid.g:1118:4: (lv_rule_1_0= ruleRule )
            {
            // InternalPpid.g:1118:4: (lv_rule_1_0= ruleRule )
            // InternalPpid.g:1119:5: lv_rule_1_0= ruleRule
            {

            					newCompositeNode(grammarAccess.getStartRuleAccess().getRuleRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rule_1_0=ruleRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStartRuleRule());
            					}
            					set(
            						current,
            						"rule",
            						lv_rule_1_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartRule"


    // $ANTLR start "entryRuleEndRule"
    // InternalPpid.g:1140:1: entryRuleEndRule returns [EObject current=null] : iv_ruleEndRule= ruleEndRule EOF ;
    public final EObject entryRuleEndRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndRule = null;


        try {
            // InternalPpid.g:1140:48: (iv_ruleEndRule= ruleEndRule EOF )
            // InternalPpid.g:1141:2: iv_ruleEndRule= ruleEndRule EOF
            {
             newCompositeNode(grammarAccess.getEndRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndRule=ruleEndRule();

            state._fsp--;

             current =iv_ruleEndRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndRule"


    // $ANTLR start "ruleEndRule"
    // InternalPpid.g:1147:1: ruleEndRule returns [EObject current=null] : (otherlv_0= 'end' ( (lv_rule_1_0= ruleRule ) ) ) ;
    public final EObject ruleEndRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_rule_1_0 = null;



        	enterRule();

        try {
            // InternalPpid.g:1153:2: ( (otherlv_0= 'end' ( (lv_rule_1_0= ruleRule ) ) ) )
            // InternalPpid.g:1154:2: (otherlv_0= 'end' ( (lv_rule_1_0= ruleRule ) ) )
            {
            // InternalPpid.g:1154:2: (otherlv_0= 'end' ( (lv_rule_1_0= ruleRule ) ) )
            // InternalPpid.g:1155:3: otherlv_0= 'end' ( (lv_rule_1_0= ruleRule ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEndRuleAccess().getEndKeyword_0());
            		
            // InternalPpid.g:1159:3: ( (lv_rule_1_0= ruleRule ) )
            // InternalPpid.g:1160:4: (lv_rule_1_0= ruleRule )
            {
            // InternalPpid.g:1160:4: (lv_rule_1_0= ruleRule )
            // InternalPpid.g:1161:5: lv_rule_1_0= ruleRule
            {

            					newCompositeNode(grammarAccess.getEndRuleAccess().getRuleRuleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rule_1_0=ruleRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndRuleRule());
            					}
            					set(
            						current,
            						"rule",
            						lv_rule_1_0,
            						"edu.dtu.s144874.thesis.ppid.Ppid.Rule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndRule"


    // $ANTLR start "entryRuleUpdateAbove"
    // InternalPpid.g:1182:1: entryRuleUpdateAbove returns [EObject current=null] : iv_ruleUpdateAbove= ruleUpdateAbove EOF ;
    public final EObject entryRuleUpdateAbove() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateAbove = null;


        try {
            // InternalPpid.g:1182:52: (iv_ruleUpdateAbove= ruleUpdateAbove EOF )
            // InternalPpid.g:1183:2: iv_ruleUpdateAbove= ruleUpdateAbove EOF
            {
             newCompositeNode(grammarAccess.getUpdateAboveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdateAbove=ruleUpdateAbove();

            state._fsp--;

             current =iv_ruleUpdateAbove; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateAbove"


    // $ANTLR start "ruleUpdateAbove"
    // InternalPpid.g:1189:1: ruleUpdateAbove returns [EObject current=null] : (otherlv_0= 'above' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleUpdateAbove() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_n_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPpid.g:1195:2: ( (otherlv_0= 'above' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalPpid.g:1196:2: (otherlv_0= 'above' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalPpid.g:1196:2: (otherlv_0= 'above' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalPpid.g:1197:3: otherlv_0= 'above' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getUpdateAboveAccess().getAboveKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getUpdateAboveAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPpid.g:1205:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalPpid.g:1206:4: (lv_n_2_0= RULE_INT )
            {
            // InternalPpid.g:1206:4: (lv_n_2_0= RULE_INT )
            // InternalPpid.g:1207:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_n_2_0, grammarAccess.getUpdateAboveAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateAboveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUpdateAboveAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateAbove"


    // $ANTLR start "entryRuleUpdateBelow"
    // InternalPpid.g:1231:1: entryRuleUpdateBelow returns [EObject current=null] : iv_ruleUpdateBelow= ruleUpdateBelow EOF ;
    public final EObject entryRuleUpdateBelow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateBelow = null;


        try {
            // InternalPpid.g:1231:52: (iv_ruleUpdateBelow= ruleUpdateBelow EOF )
            // InternalPpid.g:1232:2: iv_ruleUpdateBelow= ruleUpdateBelow EOF
            {
             newCompositeNode(grammarAccess.getUpdateBelowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdateBelow=ruleUpdateBelow();

            state._fsp--;

             current =iv_ruleUpdateBelow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateBelow"


    // $ANTLR start "ruleUpdateBelow"
    // InternalPpid.g:1238:1: ruleUpdateBelow returns [EObject current=null] : (otherlv_0= 'below' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleUpdateBelow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_n_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPpid.g:1244:2: ( (otherlv_0= 'below' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalPpid.g:1245:2: (otherlv_0= 'below' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalPpid.g:1245:2: (otherlv_0= 'below' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalPpid.g:1246:3: otherlv_0= 'below' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getUpdateBelowAccess().getBelowKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getUpdateBelowAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPpid.g:1254:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalPpid.g:1255:4: (lv_n_2_0= RULE_INT )
            {
            // InternalPpid.g:1255:4: (lv_n_2_0= RULE_INT )
            // InternalPpid.g:1256:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_n_2_0, grammarAccess.getUpdateBelowAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateBelowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUpdateBelowAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateBelow"


    // $ANTLR start "entryRuleUpdateChange"
    // InternalPpid.g:1280:1: entryRuleUpdateChange returns [EObject current=null] : iv_ruleUpdateChange= ruleUpdateChange EOF ;
    public final EObject entryRuleUpdateChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateChange = null;


        try {
            // InternalPpid.g:1280:53: (iv_ruleUpdateChange= ruleUpdateChange EOF )
            // InternalPpid.g:1281:2: iv_ruleUpdateChange= ruleUpdateChange EOF
            {
             newCompositeNode(grammarAccess.getUpdateChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdateChange=ruleUpdateChange();

            state._fsp--;

             current =iv_ruleUpdateChange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateChange"


    // $ANTLR start "ruleUpdateChange"
    // InternalPpid.g:1287:1: ruleUpdateChange returns [EObject current=null] : (otherlv_0= 'change' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_m_4_0= RULE_INT ) ) otherlv_5= ')' ) ;
    public final EObject ruleUpdateChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_n_2_0=null;
        Token otherlv_3=null;
        Token lv_m_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalPpid.g:1293:2: ( (otherlv_0= 'change' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_m_4_0= RULE_INT ) ) otherlv_5= ')' ) )
            // InternalPpid.g:1294:2: (otherlv_0= 'change' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_m_4_0= RULE_INT ) ) otherlv_5= ')' )
            {
            // InternalPpid.g:1294:2: (otherlv_0= 'change' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_m_4_0= RULE_INT ) ) otherlv_5= ')' )
            // InternalPpid.g:1295:3: otherlv_0= 'change' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ',' ( (lv_m_4_0= RULE_INT ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getUpdateChangeAccess().getChangeKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getUpdateChangeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPpid.g:1303:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalPpid.g:1304:4: (lv_n_2_0= RULE_INT )
            {
            // InternalPpid.g:1304:4: (lv_n_2_0= RULE_INT )
            // InternalPpid.g:1305:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            					newLeafNode(lv_n_2_0, grammarAccess.getUpdateChangeAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateChangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getUpdateChangeAccess().getCommaKeyword_3());
            		
            // InternalPpid.g:1325:3: ( (lv_m_4_0= RULE_INT ) )
            // InternalPpid.g:1326:4: (lv_m_4_0= RULE_INT )
            {
            // InternalPpid.g:1326:4: (lv_m_4_0= RULE_INT )
            // InternalPpid.g:1327:5: lv_m_4_0= RULE_INT
            {
            lv_m_4_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_m_4_0, grammarAccess.getUpdateChangeAccess().getMINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateChangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"m",
            						lv_m_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getUpdateChangeAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateChange"


    // $ANTLR start "entryRuleUpdateIs"
    // InternalPpid.g:1351:1: entryRuleUpdateIs returns [EObject current=null] : iv_ruleUpdateIs= ruleUpdateIs EOF ;
    public final EObject entryRuleUpdateIs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateIs = null;


        try {
            // InternalPpid.g:1351:49: (iv_ruleUpdateIs= ruleUpdateIs EOF )
            // InternalPpid.g:1352:2: iv_ruleUpdateIs= ruleUpdateIs EOF
            {
             newCompositeNode(grammarAccess.getUpdateIsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdateIs=ruleUpdateIs();

            state._fsp--;

             current =iv_ruleUpdateIs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateIs"


    // $ANTLR start "ruleUpdateIs"
    // InternalPpid.g:1358:1: ruleUpdateIs returns [EObject current=null] : (otherlv_0= 'is' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleUpdateIs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_n_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPpid.g:1364:2: ( (otherlv_0= 'is' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalPpid.g:1365:2: (otherlv_0= 'is' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalPpid.g:1365:2: (otherlv_0= 'is' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalPpid.g:1366:3: otherlv_0= 'is' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getUpdateIsAccess().getIsKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getUpdateIsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPpid.g:1374:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalPpid.g:1375:4: (lv_n_2_0= RULE_INT )
            {
            // InternalPpid.g:1375:4: (lv_n_2_0= RULE_INT )
            // InternalPpid.g:1376:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_n_2_0, grammarAccess.getUpdateIsAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateIsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUpdateIsAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateIs"


    // $ANTLR start "entryRuleUpdateNot"
    // InternalPpid.g:1400:1: entryRuleUpdateNot returns [EObject current=null] : iv_ruleUpdateNot= ruleUpdateNot EOF ;
    public final EObject entryRuleUpdateNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateNot = null;


        try {
            // InternalPpid.g:1400:50: (iv_ruleUpdateNot= ruleUpdateNot EOF )
            // InternalPpid.g:1401:2: iv_ruleUpdateNot= ruleUpdateNot EOF
            {
             newCompositeNode(grammarAccess.getUpdateNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpdateNot=ruleUpdateNot();

            state._fsp--;

             current =iv_ruleUpdateNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateNot"


    // $ANTLR start "ruleUpdateNot"
    // InternalPpid.g:1407:1: ruleUpdateNot returns [EObject current=null] : (otherlv_0= 'not' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleUpdateNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_n_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPpid.g:1413:2: ( (otherlv_0= 'not' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalPpid.g:1414:2: (otherlv_0= 'not' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalPpid.g:1414:2: (otherlv_0= 'not' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalPpid.g:1415:3: otherlv_0= 'not' otherlv_1= '(' ( (lv_n_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getUpdateNotAccess().getNotKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getUpdateNotAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPpid.g:1423:3: ( (lv_n_2_0= RULE_INT ) )
            // InternalPpid.g:1424:4: (lv_n_2_0= RULE_INT )
            {
            // InternalPpid.g:1424:4: (lv_n_2_0= RULE_INT )
            // InternalPpid.g:1425:5: lv_n_2_0= RULE_INT
            {
            lv_n_2_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_n_2_0, grammarAccess.getUpdateNotAccess().getNINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUpdateNotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUpdateNotAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateNot"


    // $ANTLR start "rulePrimitiveType"
    // InternalPpid.g:1449:1: rulePrimitiveType returns [Enumerator current=null] : ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'string' ) ) ;
    public final Enumerator rulePrimitiveType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPpid.g:1455:2: ( ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'string' ) ) )
            // InternalPpid.g:1456:2: ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'string' ) )
            {
            // InternalPpid.g:1456:2: ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'string' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            else if ( (LA14_0==34) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalPpid.g:1457:3: (enumLiteral_0= 'number' )
                    {
                    // InternalPpid.g:1457:3: (enumLiteral_0= 'number' )
                    // InternalPpid.g:1458:4: enumLiteral_0= 'number'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getNumberEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPrimitiveTypeAccess().getNumberEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPpid.g:1465:3: (enumLiteral_1= 'string' )
                    {
                    // InternalPpid.g:1465:3: (enumLiteral_1= 'string' )
                    // InternalPpid.g:1466:4: enumLiteral_1= 'string'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPrimitiveTypeAccess().getStringEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000300C812L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000300C012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003008012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000003000012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000600010010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000001E4000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000080000L});

}