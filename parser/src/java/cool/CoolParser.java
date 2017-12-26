// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

	import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WS=43, THEEND=44, SINGLE_COMMENT=45, 
		COMMENT_CLOSE=46, CLOSED=47, COM_EOF=48, NEWLINE=49, ESC=50, ESC_NULL=51, 
		STR_EOF=52, ERR1=53, ERR2=54, ERR3=55, LQUOTE=56, NL=57, TAB=58, BACKSPAC=59, 
		LINEFEED=60, SLASHN=61, ESC_NL=62;
	public static final int
		RULE_program = 0, RULE_class_list = 1, RULE_class_ = 2, RULE_feature_list = 3, 
		RULE_feature = 4, RULE_formal_list = 5, RULE_formal = 6, RULE_expr_list = 7, 
		RULE_block_list = 8, RULE_branch = 9, RULE_branch_list = 10, RULE_attr = 11, 
		RULE_let_list = 12, RULE_expr = 13;
	public static final String[] ruleNames = {
		"program", "class_list", "class_", "feature_list", "feature", "formal_list", 
		"formal", "expr_list", "block_list", "branch", "branch_list", "attr", 
		"let_list", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'*)'", null, null, null, null, null, null, null, null, null, 
		null, null, "'\\t'", "'\\b'", "'\\f'", "'\\n'", "'\\\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WS", "THEEND", "SINGLE_COMMENT", "COMMENT_CLOSE", "CLOSED", "COM_EOF", 
		"NEWLINE", "ESC", "ESC_NULL", "STR_EOF", "ERR1", "ERR2", "ERR3", "LQUOTE", 
		"NL", "TAB", "BACKSPAC", "LINEFEED", "SLASHN", "ESC_NL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		String filename;
		public void setFilename(String f){
			filename = f;
		}

	/*
		DO NOT EDIT THE FILE ABOVE THIS LINE
		Add member functions, variables below.
	*/


	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public AST.program value;
		public Class_listContext cl;
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public Class_listContext class_list() {
			return getRuleContext(Class_listContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((ProgramContext)_localctx).cl = class_list();
			setState(29);
			match(EOF);

								((ProgramContext)_localctx).value =  new AST.program(((ProgramContext)_localctx).cl.value, ((ProgramContext)_localctx).cl.value.get(0).lineNo);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_listContext extends ParserRuleContext {
		public ArrayList<AST.class_> value;
		public Class_Context c;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<Class_Context> class_() {
			return getRuleContexts(Class_Context.class);
		}
		public Class_Context class_(int i) {
			return getRuleContext(Class_Context.class,i);
		}
		public Class_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_listContext class_list() throws RecognitionException {
		Class_listContext _localctx = new Class_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_list);

				((Class_listContext)_localctx).value =  new ArrayList<AST.class_>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				((Class_listContext)_localctx).c = class_();
				setState(33);
				match(SEMICOLON);
				_localctx.value.add(((Class_listContext)_localctx).c.value);
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_Context extends ParserRuleContext {
		public AST.class_ value;
		public Token temp;
		public Token typename;
		public Token basetype;
		public Feature_listContext fl;
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<TerminalNode> TYPEID() { return getTokens(CoolParser.TYPEID); }
		public TerminalNode TYPEID(int i) {
			return getToken(CoolParser.TYPEID, i);
		}
		public Feature_listContext feature_list() {
			return getRuleContext(Feature_listContext.class,0);
		}
		public Class_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_Context class_() throws RecognitionException {
		Class_Context _localctx = new Class_Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_);
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((Class_Context)_localctx).temp = match(CLASS);
				{
				setState(41);
				((Class_Context)_localctx).typename = match(TYPEID);
				}
				{
				setState(42);
				match(INHERITS);
				{
				setState(43);
				((Class_Context)_localctx).basetype = match(TYPEID);
				}
				}
				setState(45);
				match(LBRACE);
				{
				setState(46);
				((Class_Context)_localctx).fl = feature_list();
				}
				setState(47);
				match(RBRACE);

							((Class_Context)_localctx).value =  new AST.class_(((Class_Context)_localctx).typename.getText(),filename,((Class_Context)_localctx).basetype.getText(),((Class_Context)_localctx).fl.value,((Class_Context)_localctx).temp.getLine());
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				((Class_Context)_localctx).temp = match(CLASS);
				{
				setState(51);
				((Class_Context)_localctx).typename = match(TYPEID);
				}
				setState(52);
				match(LBRACE);
				{
				setState(53);
				((Class_Context)_localctx).fl = feature_list();
				}
				setState(54);
				match(RBRACE);

							((Class_Context)_localctx).value =  new AST.class_(((Class_Context)_localctx).typename.getText(),filename,"Object",((Class_Context)_localctx).fl.value,((Class_Context)_localctx).temp.getLine());
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Feature_listContext extends ParserRuleContext {
		public ArrayList<AST.feature> value;
		public FeatureContext f;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public Feature_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feature_listContext feature_list() throws RecognitionException {
		Feature_listContext _localctx = new Feature_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_feature_list);

				((Feature_listContext)_localctx).value =  new ArrayList<AST.feature>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECTID) {
				{
				{
				setState(59);
				((Feature_listContext)_localctx).f = feature();
				_localctx.value.add(((Feature_listContext)_localctx).f.value);
				setState(61);
				match(SEMICOLON);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public AST.feature value;
		public Token name;
		public Formal_listContext fl;
		public Token type;
		public ExprContext exprval;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public Formal_listContext formal_list() {
			return getRuleContext(Formal_listContext.class,0);
		}
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_feature);
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(68);
				((FeatureContext)_localctx).name = match(OBJECTID);
				}
				setState(69);
				match(LPAREN);
				{
				setState(70);
				((FeatureContext)_localctx).fl = formal_list();
				}
				setState(71);
				match(RPAREN);
				setState(72);
				match(COLON);
				{
				setState(73);
				((FeatureContext)_localctx).type = match(TYPEID);
				}
				setState(74);
				match(LBRACE);
				{
				setState(75);
				((FeatureContext)_localctx).exprval = expr(0);
				}
				setState(76);
				match(RBRACE);

							((FeatureContext)_localctx).value =  new AST.method(((FeatureContext)_localctx).name.getText(),((FeatureContext)_localctx).fl.value,((FeatureContext)_localctx).type.getText(),((FeatureContext)_localctx).exprval.value,((FeatureContext)_localctx).name.getLine());
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(79);
				((FeatureContext)_localctx).name = match(OBJECTID);
				}
				setState(80);
				match(COLON);
				{
				setState(81);
				((FeatureContext)_localctx).type = match(TYPEID);
				}
				{
				setState(82);
				match(ASSIGN);
				setState(83);
				((FeatureContext)_localctx).exprval = expr(0);
				}

							((FeatureContext)_localctx).value =  new AST.attr(((FeatureContext)_localctx).name.getText(),((FeatureContext)_localctx).type.getText(),((FeatureContext)_localctx).exprval.value,((FeatureContext)_localctx).name.getLine());
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(87);
				((FeatureContext)_localctx).name = match(OBJECTID);
				}
				setState(88);
				match(COLON);
				{
				setState(89);
				((FeatureContext)_localctx).type = match(TYPEID);
				}

							((FeatureContext)_localctx).value =  new AST.attr(((FeatureContext)_localctx).name.getText(),((FeatureContext)_localctx).type.getText(),new AST.no_expr(((FeatureContext)_localctx).name.getLine()),((FeatureContext)_localctx).name.getLine());
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_listContext extends ParserRuleContext {
		public ArrayList<AST.formal> value;
		public FormalContext f1;
		public FormalContext f2;
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Formal_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_listContext formal_list() throws RecognitionException {
		Formal_listContext _localctx = new Formal_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formal_list);

				((Formal_listContext)_localctx).value =  new ArrayList<AST.formal>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if (_la==OBJECTID) {
				{
				{
				setState(93);
				((Formal_listContext)_localctx).f1 = formal();
				_localctx.value.add(((Formal_listContext)_localctx).f1.value);
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(96);
					match(COMMA);
					{
					setState(97);
					((Formal_listContext)_localctx).f2 = formal();
					_localctx.value.add(((Formal_listContext)_localctx).f2.value);
					}
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalContext extends ParserRuleContext {
		public AST.formal value;
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			((FormalContext)_localctx).name = match(OBJECTID);
			}
			setState(108);
			match(COLON);
			{
			setState(109);
			((FormalContext)_localctx).type = match(TYPEID);
			}

						((FormalContext)_localctx).value =  new AST.formal(((FormalContext)_localctx).name.getText(),((FormalContext)_localctx).type.getText(),((FormalContext)_localctx).name.getLine());
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public ArrayList<AST.expression> value;
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr_list);

				((Expr_listContext)_localctx).value =  new ArrayList<AST.expression>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
				{
				{
				setState(112);
				((Expr_listContext)_localctx).e1 = expr(0);
				_localctx.value.add(((Expr_listContext)_localctx).e1.value);
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					{
					setState(116);
					((Expr_listContext)_localctx).e2 = expr(0);
					_localctx.value.add(((Expr_listContext)_localctx).e2.value);
					}
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_listContext extends ParserRuleContext {
		public ArrayList<AST.expression> value;
		public ExprContext e1;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Block_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBlock_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_listContext block_list() throws RecognitionException {
		Block_listContext _localctx = new Block_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block_list);

				((Block_listContext)_localctx).value =  new ArrayList<AST.expression>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
				{
				{
				{
				setState(126);
				((Block_listContext)_localctx).e1 = expr(0);
				_localctx.value.add(((Block_listContext)_localctx).e1.value);
				}
				setState(129);
				match(SEMICOLON);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchContext extends ParserRuleContext {
		public AST.branch value;
		public Token name;
		public Token typeid;
		public ExprContext e;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode DARROW() { return getToken(CoolParser.DARROW, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(136);
			((BranchContext)_localctx).name = match(OBJECTID);
			}
			setState(137);
			match(COLON);
			{
			setState(138);
			((BranchContext)_localctx).typeid = match(TYPEID);
			}
			setState(139);
			match(DARROW);
			{
			setState(140);
			((BranchContext)_localctx).e = expr(0);
			}

					((BranchContext)_localctx).value =  new AST.branch(((BranchContext)_localctx).name.getText(),((BranchContext)_localctx).typeid.getText(),((BranchContext)_localctx).e.value,((BranchContext)_localctx).name.getLine());
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Branch_listContext extends ParserRuleContext {
		public ArrayList<AST.branch> value;
		public BranchContext b;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<BranchContext> branch() {
			return getRuleContexts(BranchContext.class);
		}
		public BranchContext branch(int i) {
			return getRuleContext(BranchContext.class,i);
		}
		public Branch_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBranch_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Branch_listContext branch_list() throws RecognitionException {
		Branch_listContext _localctx = new Branch_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_branch_list);

				((Branch_listContext)_localctx).value =  new ArrayList<AST.branch>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(143);
				((Branch_listContext)_localctx).b = branch();
				}
				_localctx.value.add(((Branch_listContext)_localctx).b.value);
				setState(145);
				match(SEMICOLON);
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OBJECTID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrContext extends ParserRuleContext {
		public AST.attr value;
		public Token name;
		public Token type;
		public ExprContext exprval;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attr);
		int _la;
		try {
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(151);
				((AttrContext)_localctx).name = match(OBJECTID);
				}
				setState(152);
				match(COLON);
				{
				setState(153);
				((AttrContext)_localctx).type = match(TYPEID);
				}

								((AttrContext)_localctx).value =  new AST.attr(((AttrContext)_localctx).name.getText(),((AttrContext)_localctx).type.getText(), new AST.no_expr(((AttrContext)_localctx).name.getLine()),((AttrContext)_localctx).name.getLine());
							
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(155);
				((AttrContext)_localctx).name = match(OBJECTID);
				}
				setState(156);
				match(COLON);
				{
				setState(157);
				((AttrContext)_localctx).type = match(TYPEID);
				}
				setState(160);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(158);
					match(ASSIGN);
					{
					setState(159);
					((AttrContext)_localctx).exprval = expr(0);
					}
					}
				}


								((AttrContext)_localctx).value =  new AST.attr(((AttrContext)_localctx).name.getText(),((AttrContext)_localctx).type.getText(),((AttrContext)_localctx).exprval.value,((AttrContext)_localctx).name.getLine());
							
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Let_listContext extends ParserRuleContext {
		public ArrayList<AST.attr> value;
		public AttrContext a1;
		public AttrContext a2;
		public List<AttrContext> attr() {
			return getRuleContexts(AttrContext.class);
		}
		public AttrContext attr(int i) {
			return getRuleContext(AttrContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Let_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_listContext let_list() throws RecognitionException {
		Let_listContext _localctx = new Let_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_let_list);

				((Let_listContext)_localctx).value =  new ArrayList<AST.attr>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((Let_listContext)_localctx).a1 = attr();
			_localctx.value.add(((Let_listContext)_localctx).a1.value);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(167);
				match(COMMA);
				setState(168);
				((Let_listContext)_localctx).a2 = attr();
				_localctx.value.add(((Let_listContext)_localctx).a2.value);
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AST.expression value;
		public ExprContext caller;
		public ExprContext e1;
		public Token key;
		public Let_listContext letval;
		public ExprContext exprval;
		public Token name;
		public Expr_listContext el;
		public ExprContext e2;
		public ExprContext e3;
		public Block_listContext blocks;
		public ExprContext e;
		public Branch_listContext bl;
		public Token type;
		public Token intval;
		public Token strval;
		public Token boolval;
		public Token op;
		public Token typeid;
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public Let_listContext let_list() {
			return getRuleContext(Let_listContext.class,0);
		}
		public TerminalNode TILDE() { return getToken(CoolParser.TILDE, 0); }
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public Block_listContext block_list() {
			return getRuleContext(Block_listContext.class,0);
		}
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public Branch_listContext branch_list() {
			return getRuleContext(Branch_listContext.class,0);
		}
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public TerminalNode INT_CONST() { return getToken(CoolParser.INT_CONST, 0); }
		public TerminalNode STR_CONST() { return getToken(CoolParser.STR_CONST, 0); }
		public TerminalNode BOOL_CONST() { return getToken(CoolParser.BOOL_CONST, 0); }
		public TerminalNode STAR() { return getToken(CoolParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(CoolParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public TerminalNode EQUALS() { return getToken(CoolParser.EQUALS, 0); }
		public TerminalNode ATSYM() { return getToken(CoolParser.ATSYM, 0); }
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(177);
				((ExprContext)_localctx).key = match(LET);
				}
				{
				setState(178);
				((ExprContext)_localctx).letval = let_list();
				}
				setState(179);
				match(IN);
				setState(180);
				((ExprContext)_localctx).exprval = expr(19);

								((ExprContext)_localctx).value =  ((ExprContext)_localctx).exprval.value;
								for (int i = ((ExprContext)_localctx).letval.value.size()-1;i!=-1;--i) {
									((ExprContext)_localctx).value =  new AST.let(((ExprContext)_localctx).letval.value.get(i).name,((ExprContext)_localctx).letval.value.get(i).typeid,((ExprContext)_localctx).letval.value.get(i).value,_localctx.value,((ExprContext)_localctx).key.getLine());
								}
								
							
				}
				break;
			case 2:
				{
				{
				setState(183);
				((ExprContext)_localctx).key = match(TILDE);
				}
				setState(184);
				((ExprContext)_localctx).e1 = expr(16);

								((ExprContext)_localctx).value =  new AST.neg(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 3:
				{
				{
				setState(187);
				((ExprContext)_localctx).key = match(ISVOID);
				}
				setState(188);
				((ExprContext)_localctx).e1 = expr(15);

								((ExprContext)_localctx).value =  new AST.isvoid(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 4:
				{
				{
				setState(191);
				((ExprContext)_localctx).name = match(OBJECTID);
				}
				setState(192);
				match(LPAREN);
				{
				setState(193);
				((ExprContext)_localctx).el = expr_list();
				}
				setState(194);
				match(RPAREN);

								((ExprContext)_localctx).value =  new AST.dispatch(new AST.object("self",((ExprContext)_localctx).name.getLine()),((ExprContext)_localctx).name.getText(),((ExprContext)_localctx).el.value,((ExprContext)_localctx).name.getLine());
							
				}
				break;
			case 5:
				{
				{
				setState(197);
				((ExprContext)_localctx).key = match(IF);
				}
				setState(198);
				((ExprContext)_localctx).e1 = expr(0);
				setState(199);
				match(THEN);
				setState(200);
				((ExprContext)_localctx).e2 = expr(0);
				setState(201);
				match(ELSE);
				setState(202);
				((ExprContext)_localctx).e3 = expr(0);
				setState(203);
				match(FI);

								((ExprContext)_localctx).value =  new AST.cond(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).e3.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 6:
				{
				{
				setState(206);
				((ExprContext)_localctx).key = match(WHILE);
				}
				setState(207);
				((ExprContext)_localctx).e1 = expr(0);
				setState(208);
				match(LOOP);
				setState(209);
				((ExprContext)_localctx).e2 = expr(0);
				setState(210);
				match(POOL);

								((ExprContext)_localctx).value =  new AST.loop(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 7:
				{
				{
				setState(213);
				((ExprContext)_localctx).key = match(LBRACE);
				}
				{
				setState(214);
				((ExprContext)_localctx).blocks = block_list();
				}
				setState(215);
				match(RBRACE);

								((ExprContext)_localctx).value =  new AST.block(((ExprContext)_localctx).blocks.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 8:
				{
				{
				setState(218);
				((ExprContext)_localctx).key = match(CASE);
				}
				setState(219);
				((ExprContext)_localctx).e = expr(0);
				setState(220);
				match(OF);
				{
				setState(221);
				((ExprContext)_localctx).bl = branch_list();
				}
				setState(222);
				match(ESAC);

								((ExprContext)_localctx).value =  new AST.typcase(((ExprContext)_localctx).e.value,((ExprContext)_localctx).bl.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 9:
				{
				setState(225);
				match(NEW);
				{
				setState(226);
				((ExprContext)_localctx).type = match(TYPEID);
				}

								((ExprContext)_localctx).value =  new AST.new_(((ExprContext)_localctx).type.getText(),((ExprContext)_localctx).type.getLine());
							
				}
				break;
			case 10:
				{
				{
				setState(228);
				((ExprContext)_localctx).key = match(NOT);
				}
				{
				setState(229);
				((ExprContext)_localctx).e = expr(0);
				}

								((ExprContext)_localctx).value =  new AST.comp(((ExprContext)_localctx).e.value,((ExprContext)_localctx).key.getLine());
							
				}
				break;
			case 11:
				{
				{
				setState(232);
				((ExprContext)_localctx).name = match(OBJECTID);
				}
				setState(233);
				match(ASSIGN);
				{
				setState(234);
				((ExprContext)_localctx).e = expr(0);
				}

								((ExprContext)_localctx).value =  new AST.assign(((ExprContext)_localctx).name.getText(),((ExprContext)_localctx).e.value,((ExprContext)_localctx).name.getLine());
							
				}
				break;
			case 12:
				{
				setState(237);
				match(LPAREN);
				{
				setState(238);
				((ExprContext)_localctx).e = expr(0);
				}
				setState(239);
				match(RPAREN);

								((ExprContext)_localctx).value =  ((ExprContext)_localctx).e.value;
							
				}
				break;
			case 13:
				{
				{
				setState(242);
				((ExprContext)_localctx).name = match(OBJECTID);
				}

								((ExprContext)_localctx).value =  new AST.object(((ExprContext)_localctx).name.getText(),((ExprContext)_localctx).name.getLine());
							
				}
				break;
			case 14:
				{
				{
				setState(244);
				((ExprContext)_localctx).intval = match(INT_CONST);
				}

								((ExprContext)_localctx).value =  new AST.int_const(Integer.parseInt(((ExprContext)_localctx).intval.getText()),((ExprContext)_localctx).intval.getLine());
							
				}
				break;
			case 15:
				{
				{
				setState(246);
				((ExprContext)_localctx).strval = match(STR_CONST);
				}

								((ExprContext)_localctx).value =  new AST.string_const(((ExprContext)_localctx).strval.getText(),((ExprContext)_localctx).strval.getLine());
							
				}
				break;
			case 16:
				{
				{
				setState(248);
				((ExprContext)_localctx).boolval = match(BOOL_CONST);
				}

								((ExprContext)_localctx).value =  new AST.bool_const(Boolean.parseBoolean(((ExprContext)_localctx).boolval.getText()),((ExprContext)_localctx).boolval.getLine());
							
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						{
						setState(253);
						((ExprContext)_localctx).op = match(STAR);
						}
						setState(254);
						((ExprContext)_localctx).e2 = expr(15);

						          				((ExprContext)_localctx).value =  new AST.mul(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						{
						setState(258);
						((ExprContext)_localctx).op = match(SLASH);
						}
						setState(259);
						((ExprContext)_localctx).e2 = expr(14);

						          				((ExprContext)_localctx).value =  new AST.divide(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						{
						setState(263);
						((ExprContext)_localctx).op = match(PLUS);
						}
						setState(264);
						((ExprContext)_localctx).e2 = expr(13);

						          				((ExprContext)_localctx).value =  new AST.plus(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						{
						setState(268);
						((ExprContext)_localctx).op = match(MINUS);
						}
						setState(269);
						((ExprContext)_localctx).e2 = expr(12);

						          				((ExprContext)_localctx).value =  new AST.sub(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						{
						setState(273);
						((ExprContext)_localctx).op = match(LT);
						}
						setState(274);
						((ExprContext)_localctx).e2 = expr(11);

						          				((ExprContext)_localctx).value =  new AST.lt(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(278);
						((ExprContext)_localctx).op = match(LE);
						}
						setState(279);
						((ExprContext)_localctx).e2 = expr(10);

						          				((ExprContext)_localctx).value =  new AST.leq(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(283);
						((ExprContext)_localctx).op = match(EQUALS);
						}
						setState(284);
						((ExprContext)_localctx).e2 = expr(9);

						          				((ExprContext)_localctx).value =  new AST.eq(((ExprContext)_localctx).e1.value,((ExprContext)_localctx).e2.value,((ExprContext)_localctx).op.getLine());
						          			
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.caller = _prevctx;
						_localctx.caller = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(287);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(288);
						match(ATSYM);
						{
						setState(289);
						((ExprContext)_localctx).typeid = match(TYPEID);
						}
						setState(290);
						match(DOT);
						{
						setState(291);
						((ExprContext)_localctx).name = match(OBJECTID);
						}
						setState(292);
						match(LPAREN);
						{
						setState(293);
						((ExprContext)_localctx).el = expr_list();
						}
						setState(294);
						match(RPAREN);

						          				((ExprContext)_localctx).value =  new AST.static_dispatch(((ExprContext)_localctx).caller.value,((ExprContext)_localctx).typeid.getText(),((ExprContext)_localctx).name.getText(),((ExprContext)_localctx).el.value,((ExprContext)_localctx).name.getLine());
						          			
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.caller = _prevctx;
						_localctx.caller = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(298);
						match(DOT);
						{
						setState(299);
						((ExprContext)_localctx).name = match(OBJECTID);
						}
						setState(300);
						match(LPAREN);
						{
						setState(301);
						((ExprContext)_localctx).el = expr_list();
						}
						setState(302);
						match(RPAREN);

						          				((ExprContext)_localctx).value =  new AST.dispatch(((ExprContext)_localctx).caller.value,((ExprContext)_localctx).name.getText(),((ExprContext)_localctx).el.value,((ExprContext)_localctx).name.getLine());
						          			
						}
						break;
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 25);
		case 8:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0139\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\6\3\'\n\3\r\3\16\3(\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E\13\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7g\n\7\f"+
		"\7\16\7j\13\7\5\7l\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\tz\n\t\f\t\16\t}\13\t\5\t\177\n\t\3\n\3\n\3\n\3\n\3\n\7\n\u0086\n\n"+
		"\f\n\16\n\u0089\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\6\f\u0096\n\f\r\f\16\f\u0097\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00a3\n\r\3\r\5\r\u00a6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ae"+
		"\n\16\f\16\16\16\u00b1\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fd\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0134\n\17\f\17"+
		"\16\17\u0137\13\17\3\17\2\3\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\2\u0150\2\36\3\2\2\2\4&\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\n]\3\2\2\2\f"+
		"k\3\2\2\2\16m\3\2\2\2\20~\3\2\2\2\22\u0087\3\2\2\2\24\u008a\3\2\2\2\26"+
		"\u0095\3\2\2\2\30\u00a5\3\2\2\2\32\u00a7\3\2\2\2\34\u00fc\3\2\2\2\36\37"+
		"\5\4\3\2\37 \7\2\2\3 !\b\2\1\2!\3\3\2\2\2\"#\5\6\4\2#$\7\r\2\2$%\b\3\1"+
		"\2%\'\3\2\2\2&\"\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*+\7"+
		"\34\2\2+,\7\4\2\2,-\7!\2\2-.\7\4\2\2./\3\2\2\2/\60\7\26\2\2\60\61\5\b"+
		"\5\2\61\62\7\27\2\2\62\63\b\4\1\2\63<\3\2\2\2\64\65\7\34\2\2\65\66\7\4"+
		"\2\2\66\67\7\26\2\2\678\5\b\5\289\7\27\2\29:\b\4\1\2:<\3\2\2\2;*\3\2\2"+
		"\2;\64\3\2\2\2<\7\3\2\2\2=>\5\n\6\2>?\b\5\1\2?@\7\r\2\2@B\3\2\2\2A=\3"+
		"\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\7\5\2\2GH"+
		"\7\t\2\2HI\5\f\7\2IJ\7\n\2\2JK\7\13\2\2KL\7\4\2\2LM\7\26\2\2MN\5\34\17"+
		"\2NO\7\27\2\2OP\b\6\1\2P^\3\2\2\2QR\7\5\2\2RS\7\13\2\2ST\7\4\2\2TU\7\33"+
		"\2\2UV\5\34\17\2VW\3\2\2\2WX\b\6\1\2X^\3\2\2\2YZ\7\5\2\2Z[\7\13\2\2[\\"+
		"\7\4\2\2\\^\b\6\1\2]F\3\2\2\2]Q\3\2\2\2]Y\3\2\2\2^\13\3\2\2\2_`\5\16\b"+
		"\2`a\b\7\1\2ah\3\2\2\2bc\7\16\2\2cd\5\16\b\2de\b\7\1\2eg\3\2\2\2fb\3\2"+
		"\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2k_\3\2\2\2kl\3\2"+
		"\2\2l\r\3\2\2\2mn\7\5\2\2no\7\13\2\2op\7\4\2\2pq\b\b\1\2q\17\3\2\2\2r"+
		"s\5\34\17\2st\b\t\1\2t{\3\2\2\2uv\7\16\2\2vw\5\34\17\2wx\b\t\1\2xz\3\2"+
		"\2\2yu\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2\2~r"+
		"\3\2\2\2~\177\3\2\2\2\177\21\3\2\2\2\u0080\u0081\5\34\17\2\u0081\u0082"+
		"\b\n\1\2\u0082\u0083\3\2\2\2\u0083\u0084\7\r\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\23\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\5\2\2\u008b\u008c"+
		"\7\13\2\2\u008c\u008d\7\4\2\2\u008d\u008e\7\31\2\2\u008e\u008f\5\34\17"+
		"\2\u008f\u0090\b\13\1\2\u0090\25\3\2\2\2\u0091\u0092\5\24\13\2\u0092\u0093"+
		"\b\f\1\2\u0093\u0094\7\r\2\2\u0094\u0096\3\2\2\2\u0095\u0091\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\27\3\2\2"+
		"\2\u0099\u009a\7\5\2\2\u009a\u009b\7\13\2\2\u009b\u009c\7\4\2\2\u009c"+
		"\u00a6\b\r\1\2\u009d\u009e\7\5\2\2\u009e\u009f\7\13\2\2\u009f\u00a2\7"+
		"\4\2\2\u00a0\u00a1\7\33\2\2\u00a1\u00a3\5\34\17\2\u00a2\u00a0\3\2\2\2"+
		"\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\b\r\1\2\u00a5\u0099"+
		"\3\2\2\2\u00a5\u009d\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a8\5\30\r\2\u00a8"+
		"\u00af\b\16\1\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\5\30\r\2\u00ab\u00ac"+
		"\b\16\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae\u00b1\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\33\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b3\b\17\1\2\u00b3\u00b4\7\"\2\2\u00b4\u00b5\5\32\16"+
		"\2\u00b5\u00b6\7 \2\2\u00b6\u00b7\5\34\17\25\u00b7\u00b8\b\17\1\2\u00b8"+
		"\u00fd\3\2\2\2\u00b9\u00ba\7\23\2\2\u00ba\u00bb\5\34\17\22\u00bb\u00bc"+
		"\b\17\1\2\u00bc\u00fd\3\2\2\2\u00bd\u00be\7+\2\2\u00be\u00bf\5\34\17\21"+
		"\u00bf\u00c0\b\17\1\2\u00c0\u00fd\3\2\2\2\u00c1\u00c2\7\5\2\2\u00c2\u00c3"+
		"\7\t\2\2\u00c3\u00c4\5\20\t\2\u00c4\u00c5\7\n\2\2\u00c5\u00c6\b\17\1\2"+
		"\u00c6\u00fd\3\2\2\2\u00c7\u00c8\7\37\2\2\u00c8\u00c9\5\34\17\2\u00c9"+
		"\u00ca\7%\2\2\u00ca\u00cb\5\34\17\2\u00cb\u00cc\7\35\2\2\u00cc\u00cd\5"+
		"\34\17\2\u00cd\u00ce\7\36\2\2\u00ce\u00cf\b\17\1\2\u00cf\u00fd\3\2\2\2"+
		"\u00d0\u00d1\7&\2\2\u00d1\u00d2\5\34\17\2\u00d2\u00d3\7#\2\2\u00d3\u00d4"+
		"\5\34\17\2\u00d4\u00d5\7$\2\2\u00d5\u00d6\b\17\1\2\u00d6\u00fd\3\2\2\2"+
		"\u00d7\u00d8\7\26\2\2\u00d8\u00d9\5\22\n\2\u00d9\u00da\7\27\2\2\u00da"+
		"\u00db\b\17\1\2\u00db\u00fd\3\2\2\2\u00dc\u00dd\7\'\2\2\u00dd\u00de\5"+
		"\34\17\2\u00de\u00df\7)\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\7(\2\2\u00e1"+
		"\u00e2\b\17\1\2\u00e2\u00fd\3\2\2\2\u00e3\u00e4\7*\2\2\u00e4\u00e5\7\4"+
		"\2\2\u00e5\u00fd\b\17\1\2\u00e6\u00e7\7,\2\2\u00e7\u00e8\5\34\17\2\u00e8"+
		"\u00e9\b\17\1\2\u00e9\u00fd\3\2\2\2\u00ea\u00eb\7\5\2\2\u00eb\u00ec\7"+
		"\33\2\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee\b\17\1\2\u00ee\u00fd\3\2\2\2"+
		"\u00ef\u00f0\7\t\2\2\u00f0\u00f1\5\34\17\2\u00f1\u00f2\7\n\2\2\u00f2\u00f3"+
		"\b\17\1\2\u00f3\u00fd\3\2\2\2\u00f4\u00f5\7\5\2\2\u00f5\u00fd\b\17\1\2"+
		"\u00f6\u00f7\7\7\2\2\u00f7\u00fd\b\17\1\2\u00f8\u00f9\7\b\2\2\u00f9\u00fd"+
		"\b\17\1\2\u00fa\u00fb\7\6\2\2\u00fb\u00fd\b\17\1\2\u00fc\u00b2\3\2\2\2"+
		"\u00fc\u00b9\3\2\2\2\u00fc\u00bd\3\2\2\2\u00fc\u00c1\3\2\2\2\u00fc\u00c7"+
		"\3\2\2\2\u00fc\u00d0\3\2\2\2\u00fc\u00d7\3\2\2\2\u00fc\u00dc\3\2\2\2\u00fc"+
		"\u00e3\3\2\2\2\u00fc\u00e6\3\2\2\2\u00fc\u00ea\3\2\2\2\u00fc\u00ef\3\2"+
		"\2\2\u00fc\u00f4\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u0135\3\2\2\2\u00fe\u00ff\f\20\2\2\u00ff\u0100\7"+
		"\21\2\2\u0100\u0101\5\34\17\21\u0101\u0102\b\17\1\2\u0102\u0134\3\2\2"+
		"\2\u0103\u0104\f\17\2\2\u0104\u0105\7\22\2\2\u0105\u0106\5\34\17\20\u0106"+
		"\u0107\b\17\1\2\u0107\u0134\3\2\2\2\u0108\u0109\f\16\2\2\u0109\u010a\7"+
		"\17\2\2\u010a\u010b\5\34\17\17\u010b\u010c\b\17\1\2\u010c\u0134\3\2\2"+
		"\2\u010d\u010e\f\r\2\2\u010e\u010f\7\20\2\2\u010f\u0110\5\34\17\16\u0110"+
		"\u0111\b\17\1\2\u0111\u0134\3\2\2\2\u0112\u0113\f\f\2\2\u0113\u0114\7"+
		"\24\2\2\u0114\u0115\5\34\17\r\u0115\u0116\b\17\1\2\u0116\u0134\3\2\2\2"+
		"\u0117\u0118\f\13\2\2\u0118\u0119\7\32\2\2\u0119\u011a\5\34\17\f\u011a"+
		"\u011b\b\17\1\2\u011b\u0134\3\2\2\2\u011c\u011d\f\n\2\2\u011d\u011e\7"+
		"\25\2\2\u011e\u011f\5\34\17\13\u011f\u0120\b\17\1\2\u0120\u0134\3\2\2"+
		"\2\u0121\u0122\f\33\2\2\u0122\u0123\7\f\2\2\u0123\u0124\7\4\2\2\u0124"+
		"\u0125\7\30\2\2\u0125\u0126\7\5\2\2\u0126\u0127\7\t\2\2\u0127\u0128\5"+
		"\20\t\2\u0128\u0129\7\n\2\2\u0129\u012a\b\17\1\2\u012a\u0134\3\2\2\2\u012b"+
		"\u012c\f\32\2\2\u012c\u012d\7\30\2\2\u012d\u012e\7\5\2\2\u012e\u012f\7"+
		"\t\2\2\u012f\u0130\5\20\t\2\u0130\u0131\7\n\2\2\u0131\u0132\b\17\1\2\u0132"+
		"\u0134\3\2\2\2\u0133\u00fe\3\2\2\2\u0133\u0103\3\2\2\2\u0133\u0108\3\2"+
		"\2\2\u0133\u010d\3\2\2\2\u0133\u0112\3\2\2\2\u0133\u0117\3\2\2\2\u0133"+
		"\u011c\3\2\2\2\u0133\u0121\3\2\2\2\u0133\u012b\3\2\2\2\u0134\u0137\3\2"+
		"\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\35\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\22(;C]hk{~\u0087\u0097\u00a2\u00a5\u00af\u00fc\u0133\u0135";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}