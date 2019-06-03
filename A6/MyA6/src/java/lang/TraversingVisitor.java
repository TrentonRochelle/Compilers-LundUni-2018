package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	private Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
        return data;
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FuncStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Parameter node, Object data) {
		return visitChildren(node, data);
	}

	//stmt vistors
	public Object visit(WhileStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IfStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ElseStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ReturnStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FuncCallStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(AssignDecl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Declare node, Object data) {
		return visitChildren(node, data);
	}




	//arit vistors
	public Object visit(Add node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Div node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mul node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Sub node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mod node, Object data) {
		return visitChildren(node, data);
	}
	
	//Comparative vistor
	public Object visit(NotEquiv node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Equiv node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessThanEquiv node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessThan node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(MoreThanEquiv node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(MoreThan node, Object data) {
		return visitChildren(node, data);
	}
	
	
	public Object visit(Numeral node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdDecl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);
	}
	
}
