package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// import lang.ast.LangParser.SyntaxError;

import lang.ast.LangParser;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;

public class RecursiveDescentCompiler {

	private LangScanner scanner;
	private beaver.Symbol currentToken = null;
	final static int THEN=6, NOT=7, FI=2, OD=1, DO=5, UNTIL=4, IF=11, FOR=9, ASSIGN=10, ID=3, NUMERAL=8;
	// RecursiveDescentCompiler

	public static void main(String args[]) {
		RecursiveDescentCompiler obj;
		obj = new RecursiveDescentCompiler();

		if (args.length != 1) {
			System.err.println("You must specify a source file on the command line!");
			System.exit(1);
		}

		try {
			obj.parse(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	private void parse(Reader reader) {
		LangScanner scanner = new LangScanner(reader);
		// LangParser parser = new LangParser();

		try {
			parse(scanner);
			System.out.println("Valid syntax");
		} catch (RuntimeException e) {
			System.err.println("Syntax error: " + e.getMessage());
		}
		//  catch (IOException e) {
		//	e.printStackTrace();
		// }
	}

	/** Initialize the parser and start parsing via the parseProgram() method. */
	public void parse(LangScanner scanner) {
		this.scanner = scanner;
		parseProgram();
		accept(EOF); // Ensure all input is processed.
	}

	private void parseProgram() {		
		while (peek() != EOF) {
			stmt();
		}
	}

	/** Returns the current token without proceeding to the next. */
	private int peek() {
		if (currentToken == null) accept();
		return currentToken.getId();
	}

	/** Read the next token from the scanner. */
	private void accept() {
		try {
			currentToken = scanner.nextToken();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** Ensure the current token is of a certain type; then read the next. */
	private void accept(int expectedToken) {
		if (currentToken == null) accept();

		if (peek() != expectedToken) {
			error("expected token " +
			LangParser.Terminals.NAMES[expectedToken] +
			" got token " +
			LangParser.Terminals.NAMES[currentToken.getId()]);
		}

		accept();
	}

	private static void error(String message) {
		throw new RuntimeException(message);
	}

	private void stmt() {
		switch(peek()) {
			case FOR: forStmt(); break;
			case IF: ifStmt(); break;
			case ID: assignment(); break;
			default: error("Expecting statement, found: " + peek());
		}		
	}

	private void forStmt() {
		accept(FOR);
		accept(ID);
		accept(ASSIGN);
		expr();
		accept(UNTIL);
		expr();
		accept(DO);
		stmt();
		accept(OD);
	}

	private void ifStmt() {
		accept(IF);
		expr();
		accept(THEN);
		stmt();
		accept(FI);
	}

	private void assignment() {

		accept(ID);
		accept(ASSIGN);
		expr();
	}

	private void expr() {
		switch(peek()) {
			case ID: accept(); break;
			case NUMERAL: accept(); break;
			case NOT: expr(); break;
			default: error("Expecting statement, found: " + peek());
		}
	}

}

