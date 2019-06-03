package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast class
 * @aspect PredefinedFunctions
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:3
 */
 class Printer extends FuncStmt {
  
  
		public Printer() {
                        super(new IntType(), new IdDecl("print"),
                                new List<Parameter>( new Parameter( new IntType(), new IdDecl("value")) ), new List<Stmt>() );

                }

  

		boolean first = true;


}
