/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/lang.ast:25
 * @astdecl IfStmt : Stmt ::= Cond:Expr Block [ElseStmt];
 * @production IfStmt : {@link Stmt} ::= <span class="component">Cond:{@link Expr}</span> <span class="component">{@link Block}</span> <span class="component">[{@link ElseStmt}]</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PrettyPrint.jrag:113
   */
  public void prettyPrint(PrintStream out, String ind) {

		out.print(ind + "if (");
                getCond().prettyPrint(out, ind);
                out.println("){");		

		getBlock().prettyPrint(out, ind);
		out.println(ind + "}");
	
		if(hasElseStmt() && getElseStmt() != null){

			out.println(ind + "else {");
			getElseStmt().prettyPrint(out, ind);
			out.println(ind + "}");
		}
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:96
   */
  public void genCode(PrintStream out){
		int ctr = Program.nextCounter();
		String if_label = "if"+ctr;
		String else_label = "else"+ctr;
		getCond().genCode(out);
		out.println(		"cmpq $0, %rax");
		out.println(		"je "+else_label);
		out.println(if_label+	":");
		getBlock().genCode(out);
		out.println(	else_label+":");
		if(hasElseStmt()){
			getElseStmt().genCode(out);	
		}
		out.println("end"+ if_label+":");
	}
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
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
    name = {"Cond", "Block", "ElseStmt"},
    type = {"Expr", "Block", "Opt<ElseStmt>"},
    kind = {"Child", "Child", "Opt"}
  )
  public IfStmt(Expr p0, Block p1, Opt<ElseStmt> p2) {
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
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
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
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
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
  public IfStmt treeCopy() {
    IfStmt tree = (IfStmt) copy();
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
   * Replaces the Cond child.
   * @param node The new node to replace the Cond child.
   * @apilevel high-level
   */
  public void setCond(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Cond child.
   * @return The current node used as the Cond child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Cond")
  public Expr getCond() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Cond child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Cond child.
   * @apilevel low-level
   */
  public Expr getCondNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the ElseStmt child. This is the <code>Opt</code>
   * node containing the child ElseStmt, not the actual child!
   * @param opt The new node to be used as the optional node for the ElseStmt child.
   * @apilevel low-level
   */
  public void setElseStmtOpt(Opt<ElseStmt> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) ElseStmt child.
   * @param node The new node to be used as the ElseStmt child.
   * @apilevel high-level
   */
  public void setElseStmt(ElseStmt node) {
    getElseStmtOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ElseStmt child exists.
   * @return {@code true} if the optional ElseStmt child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElseStmt() {
    return getElseStmtOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ElseStmt child.
   * @return The ElseStmt child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ElseStmt getElseStmt() {
    return (ElseStmt) getElseStmtOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ElseStmt child. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * @return The optional node for child the ElseStmt child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ElseStmt")
  public Opt<ElseStmt> getElseStmtOpt() {
    return (Opt<ElseStmt>) getChild(2);
  }
  /**
   * Retrieves the optional node for child ElseStmt. This is the <code>Opt</code> node containing the child ElseStmt, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ElseStmt.
   * @apilevel low-level
   */
  public Opt<ElseStmt> getElseStmtOptNoTransform() {
    return (Opt<ElseStmt>) getChildNoTransform(2);
  }
/** @apilevel internal */
protected boolean typeError_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:158
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:158")
  public boolean typeError() {
    if (typeError_visited) {
      throw new RuntimeException("Circular definition of attribute IfStmt.typeError().");
    }
    typeError_visited = true;
    boolean typeError_value = !getCond().type().comp(new BoolType());
    typeError_visited = false;
    return typeError_value;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:116
   * @apilevel internal
   */
  public boolean Define_checkComp(ASTNode _callerNode, ASTNode _childNode, Type t) {
    if (_callerNode == getCondNoTransform()) {
      // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:122
      return t.comp(new BoolType());
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
    // @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:66
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
      collection.add(error("If-conditions must be bool!"));
    }
  }
}
