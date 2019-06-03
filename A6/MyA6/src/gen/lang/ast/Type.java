/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/lang.ast:9
 * @astdecl Type : ASTNode ::= <ID:String>;
 * @production Type : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public abstract class Type extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Type() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID"},
    type = {"String"},
    kind = {"Token"}
  )
  public Type(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Type(beaver.Symbol p0) {
    setID(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Type clone() throws CloneNotSupportedException {
    Type node = (Type) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:47
   */
  @Deprecated
  public abstract Type fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:55
   */
  public abstract Type treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:63
   */
  public abstract Type treeCopy();
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
/** @apilevel internal */
protected boolean isUnknownType_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:19")
  public boolean isUnknownType() {
    if (isUnknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Type.isUnknownType().");
    }
    isUnknownType_visited = true;
    boolean isUnknownType_value = false;
    isUnknownType_visited = false;
    return isUnknownType_value;
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:55
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:55")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Type.type().");
    }
    type_visited = true;
    try {
    		switch(getID()) {
               		case "int": return new IntType();
                		case "bool": return new BoolType();
            	}
            	return new UnknownType();
    	}
    finally {
      type_visited = false;
    }
  }
/** @apilevel internal */
protected java.util.Set comp_Type_visited;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:62
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:62")
  public boolean comp(Type toMatch) {
    Object _parameters = toMatch;
    if (comp_Type_visited == null) comp_Type_visited = new java.util.HashSet(4);
    if (comp_Type_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Type.comp(Type).");
    }
    comp_Type_visited.add(_parameters);
    try {
    		if(toString().equals("<UnknownType>")
    		|| toMatch.getID().equals("<UnknownType>") ){
    			return true; //UnknownType compatible with all!
    		}else if(toString().equals(toMatch.toString())){
    			return true; // equal types are compatible!
    		}
    		return false;
    			
    	}
    finally {
      comp_Type_visited.remove(_parameters);
    }
  }
}
