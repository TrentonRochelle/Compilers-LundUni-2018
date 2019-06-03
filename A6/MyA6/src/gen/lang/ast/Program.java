/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= FuncStmt*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FuncStmt}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:2
   */
  private static int next_label = 1;
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:4
   */
  public static int nextCounter(){
		return Program.next_label++;
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:50
   */
  public void genCode(PrintStream out) {
		out.println(		".global _start");
		out.println(		".data");
		out.println(		"buf: .skip 1024");
		out.println(		".text");	
		out.println(		"_start:");
		out.println(		"");	
		out.println(		"call main");	
		out.println(		"exit:");
		out.println(		"movq $0, %rdi");
		out.println(		"movq $60, %rax");
		out.println(		"syscall");
		out.println(		"");
		//END OF PROGRAM

		for(FuncStmt FS: getFuncStmtList()){
			FS.genCode(out);
		}
		printHelper(out);
	}
  /**
   * @aspect CodeGen
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/CodeGen.jrag:228
   */
  public static void printHelper(PrintStream out){
		out.println("# Procedure to read number from stdin");
		out.println("# C signature: long int read(void)");
		out.println("read:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $0, %rdi");
		out.println("        movq $buf, %rsi");
		out.println("        movq $1024, %rdx");
		out.println("        movq $0, %rax");
		out.println("        syscall                 # %rax = sys_read(0, buf, 1024)");
		out.println("        ### convert string to integer:");
		out.println("        ### %rax contains nchar");
		out.println("        ### %rsi contains ptr");
		out.println("        movq $0, %rdx           # sum = 0");
		out.println("atoi_loop:");
		out.println("        cmpq $0, %rax           # while (nchar > 0)");
		out.println("        jle atoi_done           # leave loop if nchar <= 0");
		out.println("        movzbq (%rsi), %rbx     # move byte, and sign extend to qword");
		out.println("        cmpq $0x30, %rbx        # test if < '0'");
		out.println("        jl atoi_done            # character is not numeric");
		out.println("        cmpq $0x39, %rbx        # test if > '9'");
		out.println("        jg atoi_done            # character is not numeric");
		out.println("        imulq $10, %rdx         # multiply sum by 10");
		out.println("        subq $0x30, %rbx        # value of character");
		out.println("        addq %rbx, %rdx         # add to sum");
		out.println("        incq %rsi               # step to next char");
		out.println("        decq %rax               # nchar--");
		out.println("        jmp atoi_loop           # loop back");
		out.println("atoi_done:");
		out.println("        movq %rdx, %rax         # return value in RAX");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("# Procedure to print number to stdout");
		out.println("# C signature: void print(long int)");
		out.println("print:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        ### convert integer to string");
		out.println("        movq 16(%rbp), %rax     # parameter");
		out.println("        movq $(buf+1023), %rsi  # write ptr (start from end of buf)");
		out.println("        movb $0x0a, (%rsi)      # insert newline");
		out.println("        movq $1, %rcx           # string length");
		out.println("itoa_loop:                      # do.. while (at least one iteration)");
		out.println("        movq $10, %rbx");
		out.println("        movq $0, %rdx");
		out.println("        idivq %rbx              # divide rdx:rax by 10");
		out.println("        addb $0x30, %dl         # remainder + '0'");
		out.println("        decq %rsi               # move string pointer");
		out.println("        movb %dl, (%rsi)");
		out.println("        incq %rcx               # increment string length");
		out.println("        cmpq $0, %rax");
		out.println("        jg itoa_loop            # produce more digits");
		out.println("itoa_done:");
		out.println("        movq $1, %rdi");
		out.println("        movq %rcx, %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
		out.println();
		out.println("print_string:");
		out.println("        pushq %rbp");
		out.println("        movq %rsp, %rbp");
		out.println("        movq $1, %rdi");
		out.println("        movq 16(%rbp), %rsi");
		out.println("        movq 24(%rbp), %rdx");
		out.println("        movq $1, %rax");
		out.println("        syscall");
		out.println("        popq %rbp");
		out.println("        ret");
	}
  /**
   * @aspect Visitor
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Visitor.jrag:17
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FuncStmt"},
    type = {"List<FuncStmt>"},
    kind = {"List"}
  )
  public Program(List<FuncStmt> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    PredefinedFunctions_reset();
    unknownDecl_reset();
    IntType_reset();
    BoolType_reset();
    unknownType_reset();
    unknownFunc_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:70
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:80
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:100
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:114
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncStmt list.
   * @param list The new list node to be used as the FuncStmt list.
   * @apilevel high-level
   */
  public void setFuncStmtList(List<FuncStmt> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the FuncStmt list.
   * @return Number of children in the FuncStmt list.
   * @apilevel high-level
   */
  public int getNumFuncStmt() {
    return getFuncStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FuncStmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FuncStmt list.
   * @apilevel low-level
   */
  public int getNumFuncStmtNoTransform() {
    return getFuncStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FuncStmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FuncStmt list.
   * @apilevel high-level
   */
  public FuncStmt getFuncStmt(int i) {
    return (FuncStmt) getFuncStmtList().getChild(i);
  }
  /**
   * Check whether the FuncStmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFuncStmt() {
    return getFuncStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the FuncStmt list.
   * @param node The element to append to the FuncStmt list.
   * @apilevel high-level
   */
  public void addFuncStmt(FuncStmt node) {
    List<FuncStmt> list = (parent == null) ? getFuncStmtListNoTransform() : getFuncStmtList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncStmtNoTransform(FuncStmt node) {
    List<FuncStmt> list = getFuncStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the FuncStmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFuncStmt(FuncStmt node, int i) {
    List<FuncStmt> list = getFuncStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the FuncStmt list.
   * @return The node representing the FuncStmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FuncStmt")
  public List<FuncStmt> getFuncStmtList() {
    List<FuncStmt> list = (List<FuncStmt>) getChild(0);
    return list;
  }
  /**
   * Retrieves the FuncStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncStmt list.
   * @apilevel low-level
   */
  public List<FuncStmt> getFuncStmtListNoTransform() {
    return (List<FuncStmt>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the FuncStmt list without
   * triggering rewrites.
   */
  public FuncStmt getFuncStmtNoTransform(int i) {
    return (FuncStmt) getFuncStmtListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FuncStmt list.
   * @return The node representing the FuncStmt list.
   * @apilevel high-level
   */
  public List<FuncStmt> getFuncStmts() {
    return getFuncStmtList();
  }
  /**
   * Retrieves the FuncStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncStmt list.
   * @apilevel low-level
   */
  public List<FuncStmt> getFuncStmtsNoTransform() {
    return getFuncStmtListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

/** @apilevel internal */
protected boolean PredefinedFunctions_visited = false;
  /** @apilevel internal */
  private void PredefinedFunctions_reset() {
    PredefinedFunctions_computed = false;
    
    PredefinedFunctions_value = null;
    PredefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean PredefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<FuncStmt> PredefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect PredefinedFunctions
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="PredefinedFunctions", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:28")
  public List<FuncStmt> PredefinedFunctions() {
    ASTState state = state();
    if (PredefinedFunctions_computed) {
      return PredefinedFunctions_value;
    }
    if (PredefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.PredefinedFunctions().");
    }
    PredefinedFunctions_visited = true;
    state().enterLazyAttribute();
    PredefinedFunctions_value = PredefinedFunctions_compute();
    PredefinedFunctions_value.setParent(this);
    PredefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    PredefinedFunctions_visited = false;
    return PredefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<FuncStmt> PredefinedFunctions_compute() {	
  		List<FuncStmt> funcList = new List<FuncStmt>();
  		funcList.add(new Printer());
  		funcList.add(new Reader());
  		return funcList;
  	}
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
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
    int localIndex_value = 0;
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean IntType_visited = false;
  /** @apilevel internal */
  private void IntType_reset() {
    IntType_computed = false;
    
    IntType_value = null;
    IntType_visited = false;
  }
  /** @apilevel internal */
  protected boolean IntType_computed = false;

  /** @apilevel internal */
  protected IntType IntType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:2")
  public IntType IntType() {
    ASTState state = state();
    if (IntType_computed) {
      return IntType_value;
    }
    if (IntType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.IntType().");
    }
    IntType_visited = true;
    state().enterLazyAttribute();
    IntType_value = new IntType("int");
    IntType_value.setParent(this);
    IntType_computed = true;
    state().leaveLazyAttribute();
    IntType_visited = false;
    return IntType_value;
  }
/** @apilevel internal */
protected boolean BoolType_visited = false;
  /** @apilevel internal */
  private void BoolType_reset() {
    BoolType_computed = false;
    
    BoolType_value = null;
    BoolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean BoolType_computed = false;

  /** @apilevel internal */
  protected BoolType BoolType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:4")
  public BoolType BoolType() {
    ASTState state = state();
    if (BoolType_computed) {
      return BoolType_value;
    }
    if (BoolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.BoolType().");
    }
    BoolType_visited = true;
    state().enterLazyAttribute();
    BoolType_value = new BoolType("bool");
    BoolType_value.setParent(this);
    BoolType_computed = true;
    state().leaveLazyAttribute();
    BoolType_visited = false;
    return BoolType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:6")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType("<UnknownType>");
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownFunc_visited = false;
  /** @apilevel internal */
  private void unknownFunc_reset() {
    unknownFunc_computed = false;
    
    unknownFunc_value = null;
    unknownFunc_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownFunc_computed = false;

  /** @apilevel internal */
  protected UnknownFunc unknownFunc_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:8")
  public UnknownFunc unknownFunc() {
    ASTState state = state();
    if (unknownFunc_computed) {
      return unknownFunc_value;
    }
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownFunc().");
    }
    unknownFunc_visited = true;
    state().enterLazyAttribute();
    unknownFunc_value = new UnknownFunc( unknownType(), new IdDecl("unknownFunc"), new List<Parameter>(),new List<Stmt>());
    unknownFunc_value.setParent(this);
    unknownFunc_computed = true;
    state().leaveLazyAttribute();
    unknownFunc_visited = false;
    return unknownFunc_value;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:35
   * @apilevel internal
   */
  public List<FuncStmt> Define_PredefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return PredefinedFunctions();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/PredefinedFunctions.jrag:35
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute PredefinedFunctions
   */
  protected boolean canDefine_PredefinedFunctions(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:75
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		for(FuncStmt p : PredefinedFunctions()){
    			if(p.getIdDecl().getID().equals(name)){
    				return p.getIdDecl();
    			}
    		}
    		for(int i = 0; i<getNumFuncStmt(); i++){
                            IdDecl decl = getFuncStmt(i).getIdDecl();
                            if(decl.getID().equals(name)){
                                    return decl;
                            }
    		}
    		return unknownDecl();
    	}
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:75
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:62
   * @apilevel internal
   */
  public Block Define_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return null;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:62
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingBlock
   */
  protected boolean canDefine_enclosingBlock(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/NameAnalysis.jrag:96
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		return false;
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
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:10
   * @apilevel internal
   */
  public IntType Define_IntType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return IntType();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:10
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute IntType
   */
  protected boolean canDefine_IntType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:15
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:15
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:25
   * @apilevel internal
   */
  public BoolType Define_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return BoolType();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:25
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute BoolType
   */
  protected boolean canDefine_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:30
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
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
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:38
   * @apilevel internal
   */
  public UnknownFunc Define_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:38
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownFunc
   */
  protected boolean canDefine_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:36
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
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
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:37
   * @apilevel internal
   */
  public FuncStmt Define_function(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
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
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/TypeAnalysis.jrag:138
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return new UnknownType();
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
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/h/d8/q/tr1548ro-s/Documents/A6/MyA6/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

}
