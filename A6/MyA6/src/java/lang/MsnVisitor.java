package lang;

import lang.ast.*;

/**
 * Checks MSN in a SimpC program.
 */


public class MsnVisitor extends TraversingVisitor {
    // client method
    public static int result(ASTNode n) {
        MsnVisitor v = new MsnVisitor();
        n.accept(v, null);
        return v.counter;
    }

	    
	// state variables
    private int counter = 0;

	public Object visit(FuncStmt node, Object data) {
		counter++;
		return data;
	}

	
	public Object visit(Stmt node, Object data) {
		counter++;
		return data;
	}
	
}


