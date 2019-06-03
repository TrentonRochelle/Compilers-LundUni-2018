package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test
	public void validSyntaxMethod() {
		Util.testValidSyntax(TEST_DIRECTORY, "method.in");
	}

	@Test
	public void validSyntaxMethodIf() {
		Util.testValidSyntax(TEST_DIRECTORY, "method_if.in");
	}

	
	@Test
	public void validSyntaxManyIf() {
		Util.testValidSyntax(TEST_DIRECTORY, "many_if.in");
	}

	@Test
	public void validSyntaxWhile() {
		Util.testValidSyntax(TEST_DIRECTORY, "while.in");
	}

	@Test
        public void validSyntaxbigtest() {
                Util.testValidSyntax(TEST_DIRECTORY, "main.in");
        }


	@Test
	public void validSyntaxIfElse() {
		Util.testValidSyntax(TEST_DIRECTORY, "ifelse.c");
	}
	
	@Test
	public void validSyntaxDeclare() {
		Util.testValidSyntax(TEST_DIRECTORY, "declare.c");
	}
	 @Test
        public void validSyntaxManyFunc() {
                Util.testValidSyntax(TEST_DIRECTORY, "manyFunc.c");
        }


	@Test
	public void validSyntaxIf() {
		Util.testValidSyntax(TEST_DIRECTORY, "if.c");
	}
	

}
