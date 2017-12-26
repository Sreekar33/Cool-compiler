// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

	import cool.AST;
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
		RULE_program = 0, RULE_cl = 1, RULE_feature = 2, RULE_formal = 3, RULE_expr = 4;
	public static final String[] ruleNames = {
		"program", "cl", "feature", "formal", "expr"
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
		public List<ClContext> cl() {
			return getRuleContexts(ClContext.class);
		}
		public ClContext cl(int i) {
			return getRuleContext(ClContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				cl();
				setState(11);
				match(SEMICOLON);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			 
			               ((ProgramContext)_localctx).value = null;
			 
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

	public static class ClContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public List<TerminalNode> TYPEID() { return getTokens(CoolParser.TYPEID); }
		public TerminalNode TYPEID(int i) {
			return getToken(CoolParser.TYPEID, i);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public ClContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClContext cl() throws RecognitionException {
		ClContext _localctx = new ClContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(CLASS);
			setState(20);
			match(TYPEID);
			setState(23);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(21);
				match(INHERITS);
				setState(22);
				match(TYPEID);
				}
			}

			setState(25);
			match(LBRACE);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECTID) {
				{
				{
				setState(26);
				feature();
				setState(27);
				match(SEMICOLON);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(RBRACE);
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
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
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
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(OBJECTID);
				setState(37);
				match(LPAREN);
				setState(46);
				_la = _input.LA(1);
				if (_la==OBJECTID) {
					{
					setState(38);
					formal();
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(39);
						match(COMMA);
						setState(40);
						formal();
						}
						}
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(48);
				match(RPAREN);
				setState(49);
				match(COLON);
				setState(50);
				match(TYPEID);
				setState(51);
				match(LBRACE);
				setState(52);
				expr(0);
				setState(53);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(OBJECTID);
				setState(56);
				match(COLON);
				setState(57);
				match(TYPEID);
				setState(60);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(58);
					match(ASSIGN);
					setState(59);
					expr(0);
					}
				}

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

	public static class FormalContext extends ParserRuleContext {
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
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(OBJECTID);
			setState(65);
			match(COLON);
			setState(66);
			match(TYPEID);
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
		public List<TerminalNode> OBJECTID() { return getTokens(CoolParser.OBJECTID); }
		public TerminalNode OBJECTID(int i) {
			return getToken(CoolParser.OBJECTID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public List<TerminalNode> TYPEID() { return getTokens(CoolParser.TYPEID); }
		public TerminalNode TYPEID(int i) {
			return getToken(CoolParser.TYPEID, i);
		}
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode INT_CONST() { return getToken(CoolParser.INT_CONST, 0); }
		public TerminalNode STR_CONST() { return getToken(CoolParser.STR_CONST, 0); }
		public TerminalNode BOOL_CONST() { return getToken(CoolParser.BOOL_CONST, 0); }
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(69);
				match(OBJECTID);
				setState(70);
				match(ASSIGN);
				setState(71);
				expr(24);
				}
				break;
			case 2:
				{
				setState(72);
				match(LET);
				setState(73);
				match(OBJECTID);
				setState(74);
				match(COLON);
				setState(75);
				match(TYPEID);
				setState(78);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(76);
					match(ASSIGN);
					setState(77);
					expr(0);
					}
				}

				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(80);
					match(COMMA);
					setState(81);
					match(OBJECTID);
					setState(82);
					match(COLON);
					setState(83);
					match(TYPEID);
					setState(86);
					_la = _input.LA(1);
					if (_la==ASSIGN) {
						{
						setState(84);
						match(ASSIGN);
						setState(85);
						expr(0);
						}
					}

					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(IN);
				setState(94);
				expr(18);
				}
				break;
			case 3:
				{
				setState(95);
				match(ISVOID);
				setState(96);
				expr(15);
				}
				break;
			case 4:
				{
				setState(97);
				match(TILDE);
				setState(98);
				expr(10);
				}
				break;
			case 5:
				{
				setState(99);
				match(NOT);
				setState(100);
				expr(6);
				}
				break;
			case 6:
				{
				setState(101);
				match(OBJECTID);
				setState(102);
				match(LPAREN);
				setState(111);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
					{
					setState(103);
					expr(0);
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(104);
						match(COMMA);
						setState(105);
						expr(0);
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(113);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(114);
				match(IF);
				setState(115);
				expr(0);
				setState(116);
				match(THEN);
				setState(117);
				expr(0);
				setState(118);
				match(ELSE);
				setState(119);
				expr(0);
				setState(120);
				match(FI);
				}
				break;
			case 8:
				{
				setState(122);
				match(WHILE);
				setState(123);
				expr(0);
				setState(124);
				match(LOOP);
				setState(125);
				expr(0);
				setState(126);
				match(POOL);
				}
				break;
			case 9:
				{
				setState(128);
				match(LBRACE);
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					expr(0);
					setState(130);
					match(COMMA);
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0) );
				setState(136);
				match(RBRACE);
				}
				break;
			case 10:
				{
				setState(138);
				match(CASE);
				setState(139);
				expr(0);
				setState(140);
				match(OF);
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					match(OBJECTID);
					setState(142);
					match(COLON);
					setState(143);
					match(TYPEID);
					setState(144);
					match(DARROW);
					setState(145);
					expr(0);
					setState(146);
					match(SEMICOLON);
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OBJECTID );
				setState(152);
				match(ESAC);
				}
				break;
			case 11:
				{
				setState(154);
				match(NEW);
				setState(155);
				match(TYPEID);
				}
				break;
			case 12:
				{
				setState(156);
				match(LPAREN);
				setState(157);
				expr(0);
				setState(158);
				match(RPAREN);
				}
				break;
			case 13:
				{
				setState(160);
				match(OBJECTID);
				}
				break;
			case 14:
				{
				setState(161);
				match(INT_CONST);
				}
				break;
			case 15:
				{
				setState(162);
				match(STR_CONST);
				}
				break;
			case 16:
				{
				setState(163);
				match(BOOL_CONST);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(167);
						match(PLUS);
						setState(168);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(170);
						match(MINUS);
						setState(171);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(173);
						match(STAR);
						setState(174);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(175);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(176);
						match(SLASH);
						setState(177);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(179);
						match(LT);
						setState(180);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(182);
						match(LE);
						setState(183);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(185);
						match(EQUALS);
						setState(186);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(190);
						_la = _input.LA(1);
						if (_la==ATSYM) {
							{
							setState(188);
							match(ATSYM);
							setState(189);
							match(TYPEID);
							}
						}

						setState(192);
						match(DOT);
						setState(193);
						match(OBJECTID);
						setState(194);
						match(LPAREN);
						setState(203);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
							{
							setState(195);
							expr(0);
							setState(200);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(196);
								match(COMMA);
								setState(197);
								expr(0);
								}
								}
								setState(202);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(205);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		case 4:
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
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\5\4\61\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\5\4A\n\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6Q\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6Y\n\6\7\6[\n\6\f\6\16\6^\13\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6\5\6r\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6"+
		"\6\u0087\n\6\r\6\16\6\u0088\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\6\6\u0097\n\6\r\6\16\6\u0098\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u00a7\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c1\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6\u00c9\n\6\f\6\16\6\u00cc\13\6\5\6\u00ce\n\6"+
		"\3\6\7\6\u00d1\n\6\f\6\16\6\u00d4\13\6\3\6\2\3\n\7\2\4\6\b\n\2\2\u00f8"+
		"\2\17\3\2\2\2\4\25\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\n\u00a6\3\2\2\2\f\r\5"+
		"\4\3\2\r\16\7\r\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17\3\2"+
		"\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\b\2\1\2\24\3\3\2\2\2\25\26\7\34"+
		"\2\2\26\31\7\4\2\2\27\30\7!\2\2\30\32\7\4\2\2\31\27\3\2\2\2\31\32\3\2"+
		"\2\2\32\33\3\2\2\2\33!\7\26\2\2\34\35\5\6\4\2\35\36\7\r\2\2\36 \3\2\2"+
		"\2\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2"+
		"$%\7\27\2\2%\5\3\2\2\2&\'\7\5\2\2\'\60\7\t\2\2(-\5\b\5\2)*\7\16\2\2*,"+
		"\5\b\5\2+)\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2"+
		"\60(\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\n\2\2\63\64\7\13\2\2"+
		"\64\65\7\4\2\2\65\66\7\26\2\2\66\67\5\n\6\2\678\7\27\2\28A\3\2\2\29:\7"+
		"\5\2\2:;\7\13\2\2;>\7\4\2\2<=\7\33\2\2=?\5\n\6\2><\3\2\2\2>?\3\2\2\2?"+
		"A\3\2\2\2@&\3\2\2\2@9\3\2\2\2A\7\3\2\2\2BC\7\5\2\2CD\7\13\2\2DE\7\4\2"+
		"\2E\t\3\2\2\2FG\b\6\1\2GH\7\5\2\2HI\7\33\2\2I\u00a7\5\n\6\32JK\7\"\2\2"+
		"KL\7\5\2\2LM\7\13\2\2MP\7\4\2\2NO\7\33\2\2OQ\5\n\6\2PN\3\2\2\2PQ\3\2\2"+
		"\2Q\\\3\2\2\2RS\7\16\2\2ST\7\5\2\2TU\7\13\2\2UX\7\4\2\2VW\7\33\2\2WY\5"+
		"\n\6\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZR\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\"+
		"]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7 \2\2`\u00a7\5\n\6\24ab\7+\2\2b\u00a7"+
		"\5\n\6\21cd\7\23\2\2d\u00a7\5\n\6\fef\7,\2\2f\u00a7\5\n\6\bgh\7\5\2\2"+
		"hq\7\t\2\2in\5\n\6\2jk\7\16\2\2km\5\n\6\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2"+
		"\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qi\3\2\2\2qr\3\2\2\2rs\3\2\2\2s\u00a7"+
		"\7\n\2\2tu\7\37\2\2uv\5\n\6\2vw\7%\2\2wx\5\n\6\2xy\7\35\2\2yz\5\n\6\2"+
		"z{\7\36\2\2{\u00a7\3\2\2\2|}\7&\2\2}~\5\n\6\2~\177\7#\2\2\177\u0080\5"+
		"\n\6\2\u0080\u0081\7$\2\2\u0081\u00a7\3\2\2\2\u0082\u0086\7\26\2\2\u0083"+
		"\u0084\5\n\6\2\u0084\u0085\7\16\2\2\u0085\u0087\3\2\2\2\u0086\u0083\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\7\27\2\2\u008b\u00a7\3\2\2\2\u008c\u008d\7"+
		"\'\2\2\u008d\u008e\5\n\6\2\u008e\u0096\7)\2\2\u008f\u0090\7\5\2\2\u0090"+
		"\u0091\7\13\2\2\u0091\u0092\7\4\2\2\u0092\u0093\7\31\2\2\u0093\u0094\5"+
		"\n\6\2\u0094\u0095\7\r\2\2\u0095\u0097\3\2\2\2\u0096\u008f\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\7(\2\2\u009b\u00a7\3\2\2\2\u009c\u009d\7*\2\2\u009d\u00a7"+
		"\7\4\2\2\u009e\u009f\7\t\2\2\u009f\u00a0\5\n\6\2\u00a0\u00a1\7\n\2\2\u00a1"+
		"\u00a7\3\2\2\2\u00a2\u00a7\7\5\2\2\u00a3\u00a7\7\7\2\2\u00a4\u00a7\7\b"+
		"\2\2\u00a5\u00a7\7\6\2\2\u00a6F\3\2\2\2\u00a6J\3\2\2\2\u00a6a\3\2\2\2"+
		"\u00a6c\3\2\2\2\u00a6e\3\2\2\2\u00a6g\3\2\2\2\u00a6t\3\2\2\2\u00a6|\3"+
		"\2\2\2\u00a6\u0082\3\2\2\2\u00a6\u008c\3\2\2\2\u00a6\u009c\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00d2\3\2\2\2\u00a8\u00a9\f\20\2\2\u00a9"+
		"\u00aa\7\17\2\2\u00aa\u00d1\5\n\6\21\u00ab\u00ac\f\17\2\2\u00ac\u00ad"+
		"\7\20\2\2\u00ad\u00d1\5\n\6\20\u00ae\u00af\f\16\2\2\u00af\u00b0\7\21\2"+
		"\2\u00b0\u00d1\5\n\6\17\u00b1\u00b2\f\r\2\2\u00b2\u00b3\7\22\2\2\u00b3"+
		"\u00d1\5\n\6\16\u00b4\u00b5\f\13\2\2\u00b5\u00b6\7\24\2\2\u00b6\u00d1"+
		"\5\n\6\f\u00b7\u00b8\f\n\2\2\u00b8\u00b9\7\32\2\2\u00b9\u00d1\5\n\6\13"+
		"\u00ba\u00bb\f\t\2\2\u00bb\u00bc\7\25\2\2\u00bc\u00d1\5\n\6\n\u00bd\u00c0"+
		"\f\31\2\2\u00be\u00bf\7\f\2\2\u00bf\u00c1\7\4\2\2\u00c0\u00be\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7\30\2\2\u00c3\u00c4"+
		"\7\5\2\2\u00c4\u00cd\7\t\2\2\u00c5\u00ca\5\n\6\2\u00c6\u00c7\7\16\2\2"+
		"\u00c7\u00c9\5\n\6\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00c5\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\7\n"+
		"\2\2\u00d0\u00a8\3\2\2\2\u00d0\u00ab\3\2\2\2\u00d0\u00ae\3\2\2\2\u00d0"+
		"\u00b1\3\2\2\2\u00d0\u00b4\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0\u00ba\3\2"+
		"\2\2\u00d0\u00bd\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\13\3\2\2\2\u00d4\u00d2\3\2\2\2\26\21\31!-\60>@PX"+
		"\\nq\u0088\u0098\u00a6\u00c0\u00ca\u00cd\u00d0\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}