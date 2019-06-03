/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/lang.ast:19
 * @astdecl Declare : Stmt ::= Type IdDecl [Expr];
 * @production Declare : {@link Stmt} ::= <span class="component">{@link Type}</span> <span class="component">{@link IdDecl}</span> <span class="component">[{@link Expr}]</span>;

 */
public class Declare extends Stmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PrettyPrint.jrag:159
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.append(ind + "int ");
		getIdDecl().prettyPrint(out, ind);
		if(hasExpr()){
			out.append(" = ");
			getExpr().prettyPrint(out, ind);
		}
		out.println(";");
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:89
   */
  public void genCode(PrintStream out){
		if(hasExpr()){
			getExpr().genCode(out);
			out.println("	movq %rax, "+getIdDecl().address());
		}
	}
  /**
   * @declaredat ASTNode:1
   */
  public Declare() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[3];
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "IdDecl", "Expr"},
    type = {"Type", "IdDecl", "Opt<Expr>"},
    kind = {"Child", "Child", "Opt"}
  )
  public Declare(Type p0, IdDecl p1, Opt<Expr> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public Declare clone() throws CloneNotSupportedException {
    Declare node = (Declare) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Declare copy() {
    try {
      Declare node = (Declare) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:61
   */
  @Deprecated
  public Declare fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public Declare treeCopyNoTransform() {
    Declare tree = (Declare) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:91
   */
  public Declare treeCopy() {
    Declare tree = (Declare) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:105
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Type child.
   * @param node The new node to replace the Type child.
   * @apilevel high-level
   */
  public void setType(Type node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Type child.
   * @return The current node used as the Type child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Type")
  public Type getType() {
    return (Type) getChild(0);
  }
  /**
   * Retrieves the Type child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Type child.
   * @apilevel low-level
   */
  public Type getTypeNoTransform() {
    return (Type) getChildNoTransform(0);
  }
  /**
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(1);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the Expr child. This is the <code>Opt</code>
   * node containing the child Expr, not the actual child!
   * @param opt The new node to be used as the optional node for the Expr child.
   * @apilevel low-level
   */
  public void setExprOpt(Opt<Expr> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) Expr child.
   * @param node The new node to be used as the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    getExprOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Expr child exists.
   * @return {@code true} if the optional Expr child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Expr child.
   * @return The Expr child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getExpr() {
    return (Expr) getExprOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Expr child. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * @return The optional node for child the Expr child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Expr")
  public Opt<Expr> getExprOpt() {
    return (Opt<Expr>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Expr. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Expr.
   * @apilevel low-level
   */
  public Opt<Expr> getExprOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(2);
  }
/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:44
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:44")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Declare.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    try {
    	//	System.out.println("Checking if "+getIdDecl().getID()+" equals "+name);
    		if(getIdDecl().getID().equals(name)){
    			return getIdDecl();
    		}
    		return unknownDecl();
    	}
    finally {
      localLookup_String_visited.remove(_parameters);
    }
  }
/** @apilevel internal */
protected boolean typeError_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:151
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:151")
  public boolean typeError() {
    if (typeError_visited) {
      throw new RuntimeException("Circular definition of attribute Declare.typeError().");
    }
    typeError_visited = true;
    try {
    		if (!hasExpr()){
                		return false;
    		}
            	return !getIdDecl().type().comp(getExpr().type());
        	}
    finally {
      typeError_visited = false;
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:96
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:97
      {
      		if(getIdDecl() == decl){
      			return true;
      		}
      		return inExprOf(decl);		
      	}
    }
    else {
      return getParent().Define_inExprOf(this, _callerNode, decl);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:96
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:8
   * @apilevel internal
   */
  public boolean Define_isLocalVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:9
      return true;
    }
    else {
      return getParent().Define_isLocalVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:8
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isLocalVariable
   */
  protected boolean canDefine_isLocalVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:30
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:32
      return true;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:30
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:37
   * @apilevel internal
   */
  public FuncStmt Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:46
      return unknownFunc();
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:37
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:47
      return false;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:142
      return getIdDecl().type();
    }
    else if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:85
      return getIdDecl().type();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:116
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode _callerNode, ASTNode _childNode, Type t) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:120
      return t.comp(getIdDecl().type());
    }
    else {
      return getParent().Define_checkComp(this, _callerNode, t);
    }
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:116
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute checkComp
   */
  protected boolean canDefine_checkComp(ASTNode _callerNode, ASTNode _childNode, Type t) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:62
    if (typeError()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (typeError()) {
      collection.add(error("cannot assign '" + getIdDecl().getID() + "' of type " + getIdDecl().type().toString() + ". Received: " + getExpr().type().toString()));
    }
  }
}
