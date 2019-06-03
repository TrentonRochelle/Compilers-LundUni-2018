package lang.ast;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.beaver".
 */
public class LangParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short RPAR = 2;
		static public final short COMMA = 3;
		static public final short INT = 4;
		static public final short BOOL = 5;
		static public final short SEMI = 6;
		static public final short IF = 7;
		static public final short WHILE = 8;
		static public final short RETURN = 9;
		static public final short RBRACKET = 10;
		static public final short ADD = 11;
		static public final short SUB = 12;
		static public final short NUMERAL = 13;
		static public final short EQ = 14;
		static public final short NEQ = 15;
		static public final short GTHN = 16;
		static public final short LTHN = 17;
		static public final short GEQ = 18;
		static public final short LEQ = 19;
		static public final short MUL = 20;
		static public final short DIV = 21;
		static public final short MOD = 22;
		static public final short LPAR = 23;
		static public final short LBRACKET = 24;
		static public final short ASSIGN = 25;
		static public final short ELSE = 26;

		static public final String[] NAMES = {
			"EOF",
			"ID",
			"RPAR",
			"COMMA",
			"INT",
			"BOOL",
			"SEMI",
			"IF",
			"WHILE",
			"RETURN",
			"RBRACKET",
			"ADD",
			"SUB",
			"NUMERAL",
			"EQ",
			"NEQ",
			"GTHN",
			"LTHN",
			"GEQ",
			"LEQ",
			"MUL",
			"DIV",
			"MOD",
			"LPAR",
			"LBRACKET",
			"ASSIGN",
			"ELSE"
		};
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjLbbm55KKFMzcCYJ1KHJCP850o6A0G0894KH5fXKtS0t13SMeLAdWbwL#AP#MNvQ5b9R" +
		"o0tvOBdpfXtvebLfMILW2148WX1rP5G9X2IJFS#$qpFJqp0IgzDE#TPS#z$HRkb#$#u1WrB" +
		"PJkYZjQB5T225F48GLzmbUeTraDo5W$w1z7Y$O3HGYhaqJpB8xxKxaOodjPBi1OyWIn16R4" +
		"3JY7jnhjzljY64A$HbxHbiMn17haors2va5jBUZ6KsOgOWZrYURxMOoYsY5EOzCGHonFXcq" +
		"WsH6QOLv7vc2XCJwf9DYKM8x4PHHebGGZ5NS5NT6soZx#0wseTNkOrGX2DeKJvUDTYFAyJ9" +
		"j9KRW3inHf4siJxPIXl2YtOegEyIeHH3KA9uk7PJzc6GxCDNkf$mb2EVUaI4xx0xE$Idwav" +
		"I$AO8uOXCIdn4MuJd4x2bx2WvgTVQt8O8RSHD6uMRSWl5ifrXOzgmzYsU5PS$PSrbOuvJLP" +
		"$kmH5cdqPA5LQqzleJuLKkcusCLsbrs5vanslZbO3eUeAt7GrY0H$0OdeYFMxCnjvKRqbgH" +
		"lEHYsejSwNbP4$Cn4tCnZS$UXRlJ42WIi$su7x3zzBF5QdIdZtchvzaPAFDb9sQqN9U1BFO" +
		"X3fuX8jy268q9U1eZxG6PWZqWNgpA5SMkY1UhCg3OW7YnAfSLkonUhCebnIw95wjoKR6Bui" +
		"MgN53iWdYnAkSLEozUhCfnnOwB5wkHe#$TCm$xfpscl6FYnQeSLEoWUB4gHnKxAbwioX75Z" +
		"eWNgt98iKFYnQeSLkomUB4gLnMxAbwiHewkBUzxJeqube5aSX98wjirUEA7FV52J$oe9txS" +
		"4pzfUsslZh8NYKlMVOBneDrBwQ7i9QSdcQVQFPJTb3tCx4xBTDjkRRERV$y9UyBDUAyO0jp" +
		"tHCCmr0gkq97yMwAUlsKqnd2T5n5hG8bokKUJoygYTy8FP#MdsWxpBigdXMkoS8KLOJwiaR" +
		"GyFBEOp3ACvRvJVWrcuBgP$ZOhSZ21GZ8RT9Gpb5cSanabiqIPqM7RBEIVBtEVddoZkNiNP" +
		"h6sQPHPc9DPfsy#nSmzzx3xvXEzPsFAkuaemt1qqceLT$GQxk2rc8J9cCBiL6KbrbE5HjTc" +
		"6KekLftLAmShFdgEtsLbcwUEMxEHhAqmhxc8zAAyZBokYV7ytmttz4elGhOW4MRg6SjRQMJ" +
		"DpqS1lqjz5cOAAHqsUrs8EnuvuzbahqRdy3$s7sDyrruioUAtzo6Pd2JY$NR$9kQwrxRTTS" +
		"z8rdsAaTnv4npDYmwRYRV9cMeigFLSd2cmR6MySfHGFwMkfuQOb7F1VDsTfAuYy15Wf9Rn7" +
		"6TOxqqVbVKt4AQEefPIgvWlfywYla5TGUmp#W$9NSTOslg0$Wlw7#Z92yYPRWrr8VKtwg$4" +
		"lgNlebz0RMNC6idT0u6bz6rKLhx0Qsnp2UEt6KjLxDVz4QQGVXvLddkTMWG42#X$ftAgXlC" +
		"qt4jDdbinFsRCv$0LzMVEUuZtSnbtKdd#CNpUj30MV17x4cmP$KdwL#bvbZ8o1fwzp3liI$" +
		"RfSTHFUB#QVf2vDwchU5z3$oxzRFhtcPDtoB6QOYhFjORlmd2UPWvpf#MxS3noTbhknZtkj" +
		"rgzCZuPNgQHsfgu7qx9MvMACU3w5Pvyn1ExwyAiys0Jqjl3BvxSD#cvmESkliRbnhACvorF" +
		"$5vc7ejzzyjzVRIxVgthltJzUjT$v$eVVVr#xub$ylVhwUzhbrFbm#Lgvfd9yDIGptyqnAe" +
		"IO9KnMRMQUqKrUTFqF62eGIfOJUArKhHHDKW5po0XLgiHNF66DIj8pMFT2h9wXLWXZLR99l" +
		"ec#ahYsNIYLXB3dINegk4k4lIeuIfDQJcrZ5f7RVu75P9CLW==");

	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

	public LangParser() {
		super(PARSING_TABLES);
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // program = func_list.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					 return new Program(a);
			}
			case 1: // funcStmt = type.type iddecl.id LPAR param_list.p RPAR LBRACKET stmt_list.t RBRACKET
			{
					final Symbol _symbol_type = _symbols[offset + 1];
					final Type type = (Type) _symbol_type.value;
					final Symbol _symbol_id = _symbols[offset + 2];
					final IdDecl id = (IdDecl) _symbol_id.value;
					final Symbol _symbol_p = _symbols[offset + 4];
					final List p = (List) _symbol_p.value;
					final Symbol _symbol_t = _symbols[offset + 7];
					final List t = (List) _symbol_t.value;
					 return new FuncStmt(type,id,p,t);
			}
			case 2: // funccall = idUse.id LPAR arg_list.l RPAR
			{
					final Symbol _symbol_id = _symbols[offset + 1];
					final IdUse id = (IdUse) _symbol_id.value;
					final Symbol _symbol_l = _symbols[offset + 3];
					final List l = (List) _symbol_l.value;
					return new FuncCall(id,l);
			}
			case 3: // funcCallStmt = funccall.a SEMI
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final FuncCall a = (FuncCall) _symbol_a.value;
					return new FuncCallStmt(a);
			}
			case 10: // ifStmt = IF LPAR expr.a RPAR LBRACKET block.t RBRACKET
			{
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_t = _symbols[offset + 6];
					final Block t = (Block) _symbol_t.value;
					return new IfStmt(a,t, new Opt());
			}
			case 11: // ifStmt = IF LPAR expr.a RPAR LBRACKET block.t RBRACKET else.e
			{
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_t = _symbols[offset + 6];
					final Block t = (Block) _symbol_t.value;
					final Symbol _symbol_e = _symbols[offset + 8];
					final ElseStmt e = (ElseStmt) _symbol_e.value;
					return new IfStmt(a,t, new Opt(e));
			}
			case 12: // param = type.type iddecl.id
			{
					final Symbol _symbol_type = _symbols[offset + 1];
					final Type type = (Type) _symbol_type.value;
					final Symbol _symbol_id = _symbols[offset + 2];
					final IdDecl id = (IdDecl) _symbol_id.value;
					 return new Parameter(type, id);
			}
			case 13: // param_list = param.par
			{
					final Symbol _symbol_par = _symbols[offset + 1];
					final Parameter par = (Parameter) _symbol_par.value;
					 return new List().add(par);
			}
			case 14: // param_list = param_list.a COMMA param.par
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_par = _symbols[offset + 3];
					final Parameter par = (Parameter) _symbol_par.value;
					 return a.add(par);
			}
			case 15: // param_list = 
			{
					 return new List();
			}
			case 17: // type = INT.t
			{
					final Symbol t = _symbols[offset + 1];
					 return new IntType(t);
			}
			case 18: // type = BOOL.t
			{
					final Symbol t = _symbols[offset + 1];
					 return new BoolType(t);
			}
			case 19: // arg_list = arg.ar
			{
					final Symbol _symbol_ar = _symbols[offset + 1];
					final Expr ar = (Expr) _symbol_ar.value;
					 return new List().add(ar);
			}
			case 20: // arg_list = arg_list.a COMMA arg.ar
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_ar = _symbols[offset + 3];
					final Expr ar = (Expr) _symbol_ar.value;
					 return a.add(ar);
			}
			case 21: // arg_list = 
			{
					 return new List();
			}
			case 22: // else = ELSE LBRACKET block.u RBRACKET
			{
					final Symbol _symbol_u = _symbols[offset + 3];
					final Block u = (Block) _symbol_u.value;
					return new ElseStmt(u);
			}
			case 23: // whileStmt = WHILE LPAR expr.a RPAR LBRACKET block.t RBRACKET
			{
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_t = _symbols[offset + 6];
					final Block t = (Block) _symbol_t.value;
					return new WhileStmt(a,t);
			}
			case 24: // block = stmt_list.sl
			{
					final Symbol _symbol_sl = _symbols[offset + 1];
					final List sl = (List) _symbol_sl.value;
					 return new Block(sl);
			}
			case 25: // declare = type.type iddecl.id SEMI
			{
					final Symbol _symbol_type = _symbols[offset + 1];
					final Type type = (Type) _symbol_type.value;
					final Symbol _symbol_id = _symbols[offset + 2];
					final IdDecl id = (IdDecl) _symbol_id.value;
					 return new Declare(type,id, new Opt());
			}
			case 26: // declare = type.type iddecl.id ASSIGN expr.a SEMI
			{
					final Symbol _symbol_type = _symbols[offset + 1];
					final Type type = (Type) _symbol_type.value;
					final Symbol _symbol_id = _symbols[offset + 2];
					final IdDecl id = (IdDecl) _symbol_id.value;
					final Symbol _symbol_a = _symbols[offset + 4];
					final Expr a = (Expr) _symbol_a.value;
					 return new Declare(type,id,new Opt(a));
			}
			case 27: // returnStmt = RETURN expr.a SEMI
			{
					final Symbol _symbol_a = _symbols[offset + 2];
					final Expr a = (Expr) _symbol_a.value;
					 return new ReturnStmt(a);
			}
			case 28: // assign = idUse.id ASSIGN expr.a SEMI
			{
					final Symbol _symbol_id = _symbols[offset + 1];
					final IdUse id = (IdUse) _symbol_id.value;
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					return new AssignDecl(id,a);
			}
			case 29: // stmt_list = stmt.st
			{
					final Symbol _symbol_st = _symbols[offset + 1];
					final Stmt st = (Stmt) _symbol_st.value;
					 return new List().add(st);
			}
			case 30: // stmt_list = stmt_list.a stmt.st
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_st = _symbols[offset + 2];
					final Stmt st = (Stmt) _symbol_st.value;
					 return a.add(st);
			}
			case 31: // func_list = funcStmt.func
			{
					final Symbol _symbol_func = _symbols[offset + 1];
					final FuncStmt func = (FuncStmt) _symbol_func.value;
					 return new List().add(func);
			}
			case 32: // func_list = func_list.a funcStmt.func
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_func = _symbols[offset + 2];
					final FuncStmt func = (FuncStmt) _symbol_func.value;
					 return a.add(func);
			}
			case 33: // compare = sum.a EQ sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Equiv(a,b);
			}
			case 34: // compare = sum.a NEQ sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new NotEquiv(a,b);
			}
			case 35: // compare = sum.a GTHN sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new MoreThan(a,b);
			}
			case 36: // compare = sum.a LTHN sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new LessThan(a,b);
			}
			case 37: // compare = sum.a GEQ sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new MoreThanEquiv(a,b);
			}
			case 38: // compare = sum.a LEQ sum.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					return new LessThan(a,b);
			}
			case 41: // sum = sum.a ADD term.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Add(a, b);
			}
			case 42: // sum = sum.a SUB term.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Sub(a, b);
			}
			case 44: // term = term.a MUL factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Mul(a, b);
			}
			case 45: // term = term.a DIV factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Div(a, b);
			}
			case 46: // term = term.a MOD factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Mod(a, b);
			}
			case 51: // numeral = NUMERAL.num
			{
					final Symbol num = _symbols[offset + 1];
					return new Numeral(num);
			}
			case 52: // idUse = ID.id
			{
					final Symbol id = _symbols[offset + 1];
					return new IdUse(id);
			}
			case 53: // iddecl = ID.id
			{
					final Symbol id = _symbols[offset + 1];
					return new IdDecl(id);
			}
			case 4: // stmt = ifStmt
			case 5: // stmt = whileStmt
			case 6: // stmt = declare
			case 7: // stmt = assign
			case 8: // stmt = returnStmt
			case 9: // stmt = funcCallStmt
			case 16: // arg = expr
			case 39: // expr = sum
			case 40: // expr = compare
			case 43: // sum = term
			case 47: // term = factor
			case 48: // factor = numeral
			case 49: // factor = funccall
			case 50: // factor = idUse
			{
				return _symbols[offset + 1];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}