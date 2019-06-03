/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/lang.ast:21
 * @astdecl UnknownFunc : FuncStmt;
 * @production UnknownFunc : {@link FuncStmt};

 */
public class UnknownFunc extends FuncStmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownFunc() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
    setChild(new List(), 3);
  }
  /**
   * @declaredat ASTNode:15
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "IdDecl", "P", "Stmts"},
    type = {"Type", "IdDecl", "List<Parameter>", "List<Stmt>"},
    kind = {"Child", "Child", "List", "List"}
  )
  public UnknownFunc(Type p0, IdDecl p1, List<Parameter> p2, List<Stmt> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:27
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public UnknownFunc clone() throws CloneNotSupportedException {
    UnknownFunc node = (UnknownFunc) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public UnknownFunc copy() {
    try {
      UnknownFunc node = (UnknownFunc) clone();
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
   * @declaredat ASTNode:63
   */
  @Deprecated
  public UnknownFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public UnknownFunc treeCopyNoTransform() {
    UnknownFunc tree = (UnknownFunc) copy();
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
   * @declaredat ASTNode:93
   */
  public UnknownFunc treeCopy() {
    UnknownFunc tree = (UnknownFunc) copy();
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
   * @declaredat ASTNode:107
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
   * Replaces the P list.
   * @param list The new list node to be used as the P list.
   * @apilevel high-level
   */
  public void setPList(List<Parameter> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the P list.
   * @return Number of children in the P list.
   * @apilevel high-level
   */
  public int getNumP() {
    return getPList().getNumChild();
  }
  /**
   * Retrieves the number of children in the P list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the P list.
   * @apilevel low-level
   */
  public int getNumPNoTransform() {
    return getPListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the P list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the P list.
   * @apilevel high-level
   */
  public Parameter getP(int i) {
    return (Parameter) getPList().getChild(i);
  }
  /**
   * Check whether the P list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasP() {
    return getPList().getNumChild() != 0;
  }
  /**
   * Append an element to the P list.
   * @param node The element to append to the P list.
   * @apilevel high-level
   */
  public void addP(Parameter node) {
    List<Parameter> list = (parent == null) ? getPListNoTransform() : getPList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addPNoTransform(Parameter node) {
    List<Parameter> list = getPListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the P list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setP(Parameter node, int i) {
    List<Parameter> list = getPList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the P list.
   * @return The node representing the P list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="P")
  public List<Parameter> getPList() {
    List<Parameter> list = (List<Parameter>) getChild(2);
    return list;
  }
  /**
   * Retrieves the P list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the P list.
   * @apilevel low-level
   */
  public List<Parameter> getPListNoTransform() {
    return (List<Parameter>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the P list without
   * triggering rewrites.
   */
  public Parameter getPNoTransform(int i) {
    return (Parameter) getPListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the P list.
   * @return The node representing the P list.
   * @apilevel high-level
   */
  public List<Parameter> getPs() {
    return getPList();
  }
  /**
   * Retrieves the P list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the P list.
   * @apilevel low-level
   */
  public List<Parameter> getPsNoTransform() {
    return getPListNoTransform();
  }
  /**
   * Replaces the Stmts list.
   * @param list The new list node to be used as the Stmts list.
   * @apilevel high-level
   */
  public void setStmtsList(List<Stmt> list) {
    setChild(list, 3);
  }
  /**
   * Retrieves the number of children in the Stmts list.
   * @return Number of children in the Stmts list.
   * @apilevel high-level
   */
  public int getNumStmts() {
    return getStmtsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Stmts list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Stmts list.
   * @apilevel low-level
   */
  public int getNumStmtsNoTransform() {
    return getStmtsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Stmts list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Stmts list.
   * @apilevel high-level
   */
  public Stmt getStmts(int i) {
    return (Stmt) getStmtsList().getChild(i);
  }
  /**
   * Check whether the Stmts list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasStmts() {
    return getStmtsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Stmts list.
   * @param node The element to append to the Stmts list.
   * @apilevel high-level
   */
  public void addStmts(Stmt node) {
    List<Stmt> list = (parent == null) ? getStmtsListNoTransform() : getStmtsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addStmtsNoTransform(Stmt node) {
    List<Stmt> list = getStmtsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Stmts list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setStmts(Stmt node, int i) {
    List<Stmt> list = getStmtsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Stmts list.
   * @return The node representing the Stmts list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Stmts")
  public List<Stmt> getStmtsList() {
    List<Stmt> list = (List<Stmt>) getChild(3);
    return list;
  }
  /**
   * Retrieves the Stmts list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmts list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtsListNoTransform() {
    return (List<Stmt>) getChildNoTransform(3);
  }
  /**
   * @return the element at index {@code i} in the Stmts list without
   * triggering rewrites.
   */
  public Stmt getStmtsNoTransform(int i) {
    return (Stmt) getStmtsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Stmts list.
   * @return The node representing the Stmts list.
   * @apilevel high-level
   */
  public List<Stmt> getStmtss() {
    return getStmtsList();
  }
  /**
   * Retrieves the Stmts list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmts list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtssNoTransform() {
    return getStmtsListNoTransform();
  }
/** @apilevel internal */
protected boolean isFunction_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:52
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:52")
  public boolean isFunction() {
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute UnknownFunc.isFunction().");
    }
    isFunction_visited = true;
    boolean isFunction_value = true;
    isFunction_visited = false;
    return isFunction_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:53
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:53")
  public FuncStmt function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute UnknownFunc.function().");
    }
    function_visited = true;
    FuncStmt function_value = unknownFunc();
    function_visited = false;
    return function_value;
  }
}
