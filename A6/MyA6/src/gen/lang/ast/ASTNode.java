/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @astdecl ASTNode;
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PrettyPrint.jrag:4
   */
  public void prettyPrint(PrintStream out) {
		prettyPrint(out, "");
		out.println();
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PrettyPrint.jrag:9
   */
  public void prettyPrint(PrintStream out, String ind) {
		for (int i = 0; i < getNumChild(); ++i) {
			getChild(i).prettyPrint(out, ind);
		}
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Visitor.jrag:8
   */
  public Object accept(Visitor visitor, Object data) {
		throw new Error("Visitor: accept method not available for " + getClass().getName());
	}
  /**
   * @aspect Errors
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:22
   */
  protected ErrorMessage error(String message) {
		return new ErrorMessage(message, getLine(getStart()));
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/DumpTree.jrag:9
   */
  private static final String DUMP_TREE_INDENT = "  ";
  /**
   * @aspect DumpTree
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/DumpTree.jrag:11
   */
  public String dumpTree() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		dumpTree(new PrintStream(bytes));
		return bytes.toString();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/DumpTree.jrag:17
   */
  public void dumpTree(PrintStream out) {
		dumpTree(out, "");
		out.flush();
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/DumpTree.jrag:22
   */
  public void dumpTree(PrintStream out, String indent) {
		out.print(indent + getClass().getSimpleName());
		out.println(getTokens());
		String childIndent = indent + DUMP_TREE_INDENT;
		for (ASTNode child : astChildren()) {
			if (child == null) {
				out.println(childIndent + "null");
			} else {
				child.dumpTree(out, childIndent);
			}
		}
	}
  /**
   * @aspect DumpTree
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/DumpTree.jrag:35
   */
  public String getTokens() {
		java.util.TreeSet<java.lang.reflect.Method> methods = new java.util.TreeSet<>(
				new java.util.Comparator<java.lang.reflect.Method>() {
					public int compare(java.lang.reflect.Method m1, java.lang.reflect.Method m2) {
						return m1.getName().compareTo(m2.getName());
					}
				});

		methods.addAll(java.util.Arrays.asList(getClass().getMethods()));

		String result = "";
		for (java.lang.reflect.Method method : methods) {
			ASTNodeAnnotation.Token token = method.getAnnotation(ASTNodeAnnotation.Token.class);
			if (token != null) {
				try {
					result += String.format(" %s=\"%s\"", token.name(), method.invoke(this));
				} catch (IllegalAccessException ignored) {
				} catch (InvocationTargetException ignored) {
				}
			}
		}
		return result;
	}
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * Cached child index. Child indices are assumed to never change (AST should
   * not change after construction).
   * @apilevel internal
   * @declaredat ASTNode:18
   */
  private int childIndex = -1;
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex >= 0) {
      return node.childIndex;
    }
    for (int i = 0; children != null && i < children.length; i++) {
      if (children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public static final boolean generatedWithCacheCycle = true;
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public static final boolean generatedWithComponentCheck = false;
  /** @apilevel low-level 
   * @declaredat ASTNode:44
   */
  protected ASTNode parent;
  /** @apilevel low-level 
   * @declaredat ASTNode:47
   */
  protected ASTNode[] children;
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  private static ASTState state = new ASTState();
  /** @apilevel internal 
   * @declaredat ASTNode:54
   */
  public final ASTState state() {
    return state;
  }
  /**
   * @return an iterator that can be used to iterate over the children of this node.
   * The iterator does not allow removing children.
   * @declaredat ASTNode:63
   */
  public java.util.Iterator<T> astChildIterator() {
    return new java.util.Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < getNumChild();
      }

      @Override
      public T next() {
        return hasNext() ? (T) getChild(index++) : null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /** @return an object that can be used to iterate over the children of this node 
   * @declaredat ASTNode:85
   */
  public Iterable<T> astChildren() {
    return new Iterable<T>() {
      @Override
      public java.util.Iterator<T> iterator() {
        return astChildIterator();
      }
    };
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:95
   */
  public T getChild(int i) {
    ASTNode child = getChildNoTransform(i);
    return (T) child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:100
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:107
   */
  public final T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T)children[i];
    return child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:115
   */
  protected int numChildren;
  /** @apilevel low-level 
   * @declaredat ASTNode:118
   */
  protected int numChildren() {
    return numChildren;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:123
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * Behaves like getNumChild, but does not invoke AST transformations (rewrites).
   * @apilevel low-level
   * @declaredat ASTNode:131
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:135
   */
  public void setChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if (i >= numChildren) {
      numChildren = i+1;
    }
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:153
   */
  public void insertChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if (i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if (c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:178
   */
  public void removeChild(int i) {
    if (children != null) {
      ASTNode child = (ASTNode) children[i];
      if (child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if (children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:205
   */
  public ASTNode getParent() {
    return (ASTNode) parent;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:209
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:274
   */
  public void flushTreeCache() {
    flushCache();
    if (children != null) {
      for (int i = 0; i < children.length; i++) {
        if (children[i] != null) {
          ((ASTNode) children[i]).flushTreeCache();
        }
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:285
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:289
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:294
   */
  public void flushAttrCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:297
   */
  public void flushCollectionCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:300
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    node.flushAttrAndCollectionCache();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:306
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:325
   */
  @Deprecated
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:335
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:355
   */
  public ASTNode<T> treeCopy() {
    ASTNode tree = (ASTNode) copy();
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
  /**
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:372
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /** @apilevel internal 
   * @declaredat ASTNode:378
   */
  protected boolean is$Equal(ASTNode n1, ASTNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    return n1.is$Equal(n2);
  }
  /** @apilevel internal 
   * @declaredat ASTNode:384
   */
  protected boolean is$Equal(ASTNode node) {
    if (getClass() != node.getClass()) {
      return false;
    }
    if (numChildren != node.numChildren) {
      return false;
    }
    for (int i = 0; i < numChildren; i++) {
      if (children[i] == null && node.children[i] != null) {
        return false;
      }
      if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
        return false;
      }
    }
    return true;
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:26
   */
    /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Program_errors(_root, _map);
    }
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
  }

/** @apilevel internal */
protected boolean numLocals_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:23
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:23")
  public int numLocals() {
    if (numLocals_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.numLocals().");
    }
    numLocals_visited = true;
    int numLocals_value = lastNode().localIndex() - localIndex();
    numLocals_visited = false;
    return numLocals_value;
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:25
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:25")
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    int localIndex_value = prevNode().localIndex();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean lastNode_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:32
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:32")
  public ASTNode lastNode() {
    if (lastNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.lastNode().");
    }
    lastNode_visited = true;
    ASTNode lastNode_value = prevNode(getNumChild());
    lastNode_visited = false;
    return lastNode_value;
  }
/** @apilevel internal */
protected java.util.Set prevNode_int_visited;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:33
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:33")
  public ASTNode prevNode(int i) {
    Object _parameters = i;
    if (prevNode_int_visited == null) prevNode_int_visited = new java.util.HashSet(4);
    if (prevNode_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode(int).");
    }
    prevNode_int_visited.add(_parameters);
    ASTNode prevNode_int_value = i>0 ? getChild(i-1).lastNode() : this;
    prevNode_int_visited.remove(_parameters);
    return prevNode_int_value;
  }
  /**
   * @attribute inh
   * @aspect PredefinedFunctions
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PredefinedFunctions", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:35")
  public List<FuncStmt> PredefinedFunctions() {
    if (PredefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.PredefinedFunctions().");
    }
    PredefinedFunctions_visited = true;
    List<FuncStmt> PredefinedFunctions_value = getParent().Define_PredefinedFunctions(this, null);
    PredefinedFunctions_visited = false;
    return PredefinedFunctions_value;
  }
/** @apilevel internal */
protected boolean PredefinedFunctions_visited = false;
  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:4")
  public UnknownDecl unknownDecl() {
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownDecl().");
    }
    unknownDecl_visited = true;
    UnknownDecl unknownDecl_value = getParent().Define_unknownDecl(this, null);
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:30
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:30")
  public ASTNode prevNode() {
    if (prevNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode().");
    }
    prevNode_visited = true;
    ASTNode prevNode_value = getParent().Define_prevNode(this, null);
    prevNode_visited = false;
    return prevNode_value;
  }
/** @apilevel internal */
protected boolean prevNode_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:10")
  public IntType IntType() {
    if (IntType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.IntType().");
    }
    IntType_visited = true;
    IntType IntType_value = getParent().Define_IntType(this, null);
    IntType_visited = false;
    return IntType_value;
  }
/** @apilevel internal */
protected boolean IntType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:15")
  public UnknownType unknownType() {
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownType().");
    }
    unknownType_visited = true;
    UnknownType unknownType_value = getParent().Define_unknownType(this, null);
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:25
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:25")
  public BoolType BoolType() {
    if (BoolType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.BoolType().");
    }
    BoolType_visited = true;
    BoolType BoolType_value = getParent().Define_BoolType(this, null);
    BoolType_visited = false;
    return BoolType_value;
  }
/** @apilevel internal */
protected boolean BoolType_visited = false;
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:38
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:38")
  public UnknownFunc unknownFunc() {
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownFunc().");
    }
    unknownFunc_visited = true;
    UnknownFunc unknownFunc_value = getParent().Define_unknownFunc(this, null);
    unknownFunc_visited = false;
    return unknownFunc_value;
  }
/** @apilevel internal */
protected boolean unknownFunc_visited = false;
  /**
   * @attribute inh
   * @aspect Errors
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:28")
  public Program program() {
    if (program_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.program().");
    }
    program_visited = true;
    Program program_value = getParent().Define_program(this, null);
    program_visited = false;
    return program_value;
  }
/** @apilevel internal */
protected boolean program_visited = false;
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:30
   * @apilevel internal
   */
  public ASTNode Define_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    int i = this.getIndexOfChild(_callerNode);
    return prevNode(i);
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:30
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute prevNode
   */
  protected boolean canDefine_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  public List<FuncStmt> Define_PredefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_PredefinedFunctions(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_PredefinedFunctions(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:36
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute PredefinedFunctions
   */
  protected boolean canDefine_PredefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_lookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_lookup(self, _callerNode, name);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:76
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public Block Define_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_enclosingBlock(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_enclosingBlock(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:63
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingBlock
   */
  protected boolean canDefine_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_inExprOf(self, _callerNode, decl)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_inExprOf(self, _callerNode, decl);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:97
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return false;
  }
  /** @apilevel internal */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownDecl(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownDecl(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public IntType Define_IntType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_IntType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_IntType(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:12
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute IntType
   */
  protected boolean canDefine_IntType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownType(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:17
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public BoolType Define_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_BoolType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_BoolType(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:27
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute BoolType
   */
  protected boolean canDefine_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isVariable(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isVariable(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:32
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownFunc Define_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownFunc(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownFunc(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:39
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownFunc
   */
  protected boolean canDefine_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isFunction(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isFunction(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:47
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public FuncStmt Define_function(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_function(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_function(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:46
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_expectedType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_expectedType(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:140
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_program(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_program(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:29
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isLocalVariable(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isLocalVariable(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isLocalVariable(self, _callerNode);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:9
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isLocalVariable
   */
  protected boolean canDefine_isLocalVariable(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_checkComp(ASTNode _callerNode, ASTNode _childNode, Type t) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_checkComp(self, _callerNode, t)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_checkComp(self, _callerNode, t);
  }

  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:132
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute checkComp
   */
  protected boolean canDefine_checkComp(ASTNode _callerNode, ASTNode _childNode, Type t) {
    return false;
  }
public ASTNode rewrittenNode() { throw new Error("rewrittenNode is undefined for ASTNode"); }
}
