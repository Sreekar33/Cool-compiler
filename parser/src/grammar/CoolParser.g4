parser grammar CoolParser;

options {
	tokenVocab = CoolLexer;
}

@header{
	import java.util.List;
}

@members{
	String filename;
	public void setFilename(String f){
		filename = f;
	}

/*
	DO NOT EDIT THE FILE ABOVE THIS LINE
	Add member functions, variables below.
*/

}

/*
	Add appropriate actions to grammar rules for building AST below.
*/

program returns [AST.program value]	: 
			cl=class_list EOF 
				{
					$value = new AST.program($cl.value, $cl.value.get(0).lineNo);
				}
		;					

/* there should always be one class */

class_list returns [ArrayList<AST.class_> value]
	@init
	{
		$value = new ArrayList<AST.class_>();
	}
	:
		(c = class_ SEMICOLON {$value.add($c.value);})+
	;
			

class_ returns [AST.class_ value]
	: temp=CLASS (typename = TYPEID) (INHERITS (basetype = TYPEID)) LBRACE (fl = feature_list) RBRACE
		{
			$value = new AST.class_($typename.getText(),filename,$basetype.getText(),$fl.value,$temp.getLine());
		}
	| temp=CLASS (typename = TYPEID) LBRACE (fl = feature_list) RBRACE
		{
			$value = new AST.class_($typename.getText(),filename,"Object",$fl.value,$temp.getLine());
		}
	;

feature_list returns [ArrayList<AST.feature> value]
	@init
	{
		$value = new ArrayList<AST.feature>();
	}
	:
		(f=feature {$value.add($f.value);} SEMICOLON)*
	;

feature returns [AST.feature value] 
	: 
	(name=OBJECTID) LPAREN (fl=formal_list) RPAREN COLON (type=TYPEID) LBRACE (exprval=expr) RBRACE
		{
			$value = new AST.method($name.getText(),$fl.value,$type.getText(),$exprval.value,$name.getLine());
		} 
	| (name=OBJECTID) COLON (type=TYPEID) ( ASSIGN exprval=expr )
		{
			$value = new AST.attr($name.getText(),$type.getText(),$exprval.value,$name.getLine());
		}
	| (name=OBJECTID) COLON (type=TYPEID)
		{
			$value = new AST.attr($name.getText(),$type.getText(),new AST.no_expr($name.getLine()),$name.getLine());
		}
	
	;
		
formal_list returns [ArrayList<AST.formal> value]
	@init
	{
		$value = new ArrayList<AST.formal>();
	}
	:
		((f1=formal {$value.add($f1.value);}) (COMMA (f2=formal {$value.add($f2.value);}))*)?
	;
formal returns [AST.formal value]
	: 
	(name=OBJECTID) COLON (type=TYPEID)
		{
			$value = new AST.formal($name.getText(),$type.getText(),$name.getLine());
		} 
	;



expr_list returns [ArrayList<AST.expression> value]
	@init
	{
		$value = new ArrayList<AST.expression>();
	}
	:
		((e1=expr {$value.add($e1.value);}) (COMMA (e2=expr {$value.add($e2.value);}))*)?
	;

block_list returns [ArrayList<AST.expression> value]
	@init
	{
		$value = new ArrayList<AST.expression>();
	}
	:
		(((e1=expr {$value.add($e1.value);}) SEMICOLON)*)
	;
branch returns [AST.branch value]
	:
	(name=OBJECTID) COLON (typeid=TYPEID) DARROW (e=expr)
	{
		$value = new AST.branch($name.getText(),$typeid.getText(),$e.value,$name.getLine());
	}	
	;
		

branch_list returns [ArrayList<AST.branch> value]
	@init
	{
		$value = new ArrayList<AST.branch>();
	}
	:
		((b=branch) {$value.add($b.value);} SEMICOLON)+
	;

attr returns [AST.attr value]
	:
		(name=OBJECTID) COLON (type=TYPEID)
			{
				$value = new AST.attr($name.getText(),$type.getText(), new AST.no_expr($name.getLine()),$name.getLine());
			}
		|(name=OBJECTID) COLON (type=TYPEID) ( ASSIGN (exprval=expr) )?
			{
				$value = new AST.attr($name.getText(),$type.getText(),$exprval.value,$name.getLine());
			}
		
	;
	
let_list returns [ArrayList<AST.attr> value]
	@init
	{
		$value = new ArrayList<AST.attr>();
	}
	:
		a1=attr {$value.add($a1.value);} (COMMA a2=attr {$value.add($a2.value);})*
		
	;

expr returns [AST.expression value]	
	: 
		caller=expr ATSYM (typeid=TYPEID) DOT (name=OBJECTID) LPAREN (el=expr_list) RPAREN
			{
				$value = new AST.static_dispatch($caller.value,$typeid.getText(),$name.getText(),$el.value,$name.getLine());
			}
	
		|caller=expr DOT (name=OBJECTID) LPAREN (el=expr_list) RPAREN
			{
				$value = new AST.dispatch($caller.value,$name.getText(),$el.value,$name.getLine());
			}
		| (name=OBJECTID) LPAREN (el=expr_list) RPAREN
			{
				$value = new AST.dispatch(new AST.object("self",$name.getLine()),$name.getText(),$el.value,$name.getLine());
			}
		| (key=IF) e1=expr THEN e2=expr ELSE e3=expr FI
			{
				$value = new AST.cond($e1.value,$e2.value,$e3.value,$key.getLine());
			}	
		| (key=WHILE) e1=expr LOOP e2=expr POOL
			{
				$value = new AST.loop($e1.value,$e2.value,$key.getLine());
			}
		| (key=LBRACE) (blocks=block_list) RBRACE
			{
				$value = new AST.block($blocks.value,$key.getLine());
			}
		| (key=LET) (letval=let_list) IN exprval=expr
			{
				$value = $exprval.value;
				for (int i = $letval.value.size()-1;i!=-1;--i) {
					$value = new AST.let($letval.value.get(i).name,$letval.value.get(i).typeid,$letval.value.get(i).value,$value,$key.getLine());
				}
				
			}
		
		| (key=CASE) e=expr OF (bl=branch_list) ESAC
			{
				$value = new AST.typcase($e.value,$bl.value,$key.getLine());
			}
		| NEW (type=TYPEID)
			{
				$value = new AST.new_($type.getText(),$type.getLine());
			}
		| (key=TILDE) e1=expr
			{
				$value = new AST.neg($e1.value,$key.getLine());
			}
		| (key=ISVOID) e1=expr
			{
				$value = new AST.isvoid($e1.value,$key.getLine());
			}
		| e1=expr (op=STAR) e2=expr
			{
				$value = new AST.mul($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=SLASH) e2=expr
			{
				$value = new AST.divide($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=PLUS) e2=expr
			{
				$value = new AST.plus($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=MINUS) e2=expr
			{
				$value = new AST.sub($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=LT) e2=expr
			{
				$value = new AST.lt($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=LE) e2=expr
			{
				$value = new AST.leq($e1.value,$e2.value,$op.getLine());
			}
		| e1=expr (op=EQUALS) e2=expr
			{
				$value = new AST.eq($e1.value,$e2.value,$op.getLine());
			}
		| (key=NOT) (e=expr)
			{
				$value = new AST.comp($e.value,$key.getLine());
			}
		| <assoc=right>(name=OBJECTID) ASSIGN (e=expr)
			{
				$value = new AST.assign($name.getText(),$e.value,$name.getLine());
			}
		| LPAREN (e=expr) RPAREN
			{
				$value = $e.value;
			}
		| (name=OBJECTID)
			{
				$value = new AST.object($name.getText(),$name.getLine());
			}
		| (intval=INT_CONST)
			{
				$value = new AST.int_const(Integer.parseInt($intval.getText()),$intval.getLine());
			}
		| (strval=STR_CONST)
			{
				$value = new AST.string_const($strval.getText(),$strval.getLine());
			}
		| (boolval=BOOL_CONST)
			{
				$value = new AST.bool_const(Boolean.parseBoolean($boolval.getText()),$boolval.getLine());
			}
		;

