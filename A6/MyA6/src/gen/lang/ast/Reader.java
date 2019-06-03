package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast class
 * @aspect PredefinedFunctions
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:17
 */
 class Reader extends FuncStmt {
  
        	public Reader() {
            		super( new IntType(), new IdDecl( "read"), new List<Parameter>(), new List<Stmt>() );
        	}


}
