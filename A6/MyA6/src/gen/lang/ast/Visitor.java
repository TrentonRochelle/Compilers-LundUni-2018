package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast interface
 * @aspect Visitor
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Visitor.jrag:2
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);
}
