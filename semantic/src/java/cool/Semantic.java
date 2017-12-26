package cool;
import java.util.*;
public class Semantic{
	private boolean errorFlag = false;
	public void reportError(String filename, int lineNo, String error){
		errorFlag = true;
		System.err.println(filename+":"+lineNo+": "+error);
	}
	public boolean getErrorFlag(){
		return errorFlag;
	}

/*
	Don't change code above this line
*/
	
	private HashMap<String,String> checkInherit(AST.program program) {
		HashMap<String,String> parents = new HashMap<String,String>();
		HashMap<String,AST.class_> data = new HashMap<String,AST.class_>();
		parents.put("Int","Object");
		parents.put("String","Object");
		parents.put("Bool","Object");
		parents.put("IO","Object");
		for (AST.class_ cl : program.classes) {
			if (parents.containsKey((Object)cl.name)) {
				reportError(cl.filename,cl.lineNo,"Class "+cl.name+" has multiple definitions"); //redefinition of class
				return new HashMap<String,String>();
			}
			else if (cl.parent.equals("Int") || cl.parent.equals("String") || cl.parent.equals("Bool")) {
				reportError(cl.filename,cl.lineNo,"Class "+cl.name+" illegally inherits from built-in type "+cl.parent); 
				return new HashMap<String,String>();
				//illegal inheritance  of built-in type
			}
			else {
				parents.put(cl.name,cl.parent);
				data.put(cl.name,cl);
				
			}
		}
		for (Map.Entry<String,String> entry : parents.entrySet()) {
			if (!(entry.getValue().equals("Object")||parents.containsKey((Object)entry.getValue()))) { //Parent does not exist
				AST.class_ cl = data.get(entry.getKey());
				reportError(cl.filename,cl.lineNo,"Class "+cl.name+" inherits from non-existent parent "+cl.parent);
				return new HashMap<String,String>();
			}
		}
		for (Map.Entry<String,String> entry : parents.entrySet()) {
			String current = entry.getKey();
			String parent = entry.getValue();
			while((!parent.equals("Object"))&&(!parent.equals(current))) {
				parent = parents.get(parent);
			}
			if (parent.equals(current)) { //inheritance cycle
				AST.class_ cl = data.get(entry.getKey());
				reportError(cl.filename,cl.lineNo,"Class "+cl.name+" is involved in a cyclic inheritance chain"); 
				return new HashMap<String,String>();
			}
			else { //add to graph
				;
			}

		}
		return parents;
	}
	private class ASTVisitor {
		private ScopeTable<String> objects;
		private HashMap<String,String> parents;
		private HashMap<String,HashMap<String,String>> feature_env;
		public String fileName;
		ASTVisitor(HashMap<String,String> _parents) {
			objects = new ScopeTable<String>();
			parents = _parents;
			feature_env = new HashMap<String,HashMap<String,String>>();
			feature_env.put("Object",new HashMap<String,String>());
			feature_env.get("Object").put("abort"," Object");
			feature_env.get("Object").put("type_name"," String");
			feature_env.get("Object").put("copy"," Object");
			feature_env.put("Bool",new HashMap<String,String>());
			feature_env.put("Int",new HashMap<String,String>());
			feature_env.put("String",new HashMap<String,String>());
			feature_env.get("String").put("length"," Int");
			feature_env.get("String").put("concat","String String");
			feature_env.get("String").put("substr","Int Int String");
			feature_env.put("IO",new HashMap<String,String>());
			feature_env.get("IO").put("out_string","String IO");
			feature_env.get("IO").put("out_int","Int IO");
			feature_env.get("IO").put("in_string"," String");
			feature_env.get("IO").put("in_int"," Int");
		}
		private boolean subtypes(String derived,String base) {
			if (derived.equals("Void")) {
				return false;
			}
			while(!(derived.equals(base)||derived.equals("Object"))) {
				derived = parents.get(derived);
			}
			if (derived.equals(base)) {
				return true;
			}
			else {
				return false;
			}
		}
		private String mrca(String type1,String type2) { //most recent common ancestor
			while (!subtypes(type1,type2)) {
				type2= parents.get(type2);
			}
			return type2;
		}
		private void visit(AST.no_expr node) {
			node.type="Void";
		}
		private void visit(AST.bool_const node){
			node.type="Bool";
		}
		private void visit(AST.string_const node){
			node.type="String";
		}
		private void visit(AST.int_const node){
			node.type="Int";
		}
		private void visit(AST.object node){
			node.type=objects.lookUpGlobal(node.name);
			if (node.type == null) { //error
				objects.insert(node.name,"Object");
				reportError(fileName,node.lineNo,"No definition for identifier "+node.name+" found");
			}
		}
		private void visit(AST.comp node){
			visit(node.e1);
			if (node.e1.type.equals("Bool")) {
				node.type="Bool";
			}
			else{
				node.type="Bool";
				reportError(fileName,node.lineNo,"Unary complement expected expression of type Bool, found "+node.e1.type);
			}	
		}
		private void visit(AST.eq node){
			visit(node.e1);
			visit(node.e2);
			if ((node.e1.type.equals("Bool")||node.e1.type.equals("Int")||node.e1.type.equals("String")||node.e2.type.equals("Bool")||node.e2.type.equals("Int")||node.e2.type.equals("String"))&&(!node.e1.type.equals(node.e2.type))) {
				node.type="Bool";
				reportError(fileName,node.lineNo,"Equality operator on built-in type expects same type on both sides");
			}
			else {
				node.type="Bool";
			}
			/*
			if (node.e1.type.equals(node.e2.type)) {
				node.type="Bool";
			}
			else{
				node.type="Bool";
				reportError(fileName,node.lineNo,"Equality check expected expressions of same type, found "+node.e1.type+" and "+);
			}
			*/
		}
		private void visit(AST.leq node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Bool";
			}
			else{
				node.type="Bool";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		
		}
		private void visit(AST.lt node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Bool";
			}
			else{
				node.type="Bool";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		}
		private void visit(AST.neg node){
			visit(node.e1);
			if (node.e1.type.equals("Int")) {
				node.type="Int";
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Negation operator expects argument of type Int, found: "+node.e1.type);
			}
		}
		private void visit(AST.divide node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Int";
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		}
		private void visit(AST.mul node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Int";
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		}
		private void visit(AST.sub node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Int";
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		}
		private void visit(AST.plus node){
			visit(node.e1);
			visit(node.e2);
			if(node.e1.type.equals("Int") && node.e2.type.equals("Int")){
				node.type="Int";
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Binary arithmetic operator expects arguments of type Int,Int, found: "+node.e1.type+","+node.e2.type);
			}
		}
		private void visit(AST.isvoid node){
			visit(node.e1);
			node.type="Bool";
		}
		private void visit(AST.new_ node) {
			if (feature_env.containsKey(node.typeid)) {
				node.type=node.typeid;
			}
			else{
				node.type="Object";
				reportError(fileName,node.lineNo,"Type "+node.typeid+"given in new-expression does not exist");
			}
		}
		private void visit(AST.assign node){
			visit(node.e1);
			String lhsType=objects.lookUpGlobal(node.name);
			if (subtypes(node.e1.type,lhsType)) {
				node.type=lhsType;
			}
			else{
				node.type="Int";
				reportError(fileName,node.lineNo,"Illegal assignment, "+node.e1.type + " does not subtype " + lhsType);
			}
		}
		private void visit(AST.block node) {
			String retType="Object";
			for (AST.expression e : node.l1) {
				visit(e);
				retType=e.type;
			}
			node.type=retType;
		}
		private void visit(AST.loop node){
			visit(node.predicate);
			visit(node.body);
			if (node.predicate.type.equals("Bool")) {
				node.type=node.body.type;
			}
			else{
				node.type=node.body.type;
				reportError(fileName,node.lineNo,"Loop predicate not of type Bool, found: "+node.predicate.type);
			}
		}
		private void visit(AST.cond node){
			visit(node.predicate);
			visit(node.ifbody);
			visit(node.elsebody);
			if (node.predicate.type.equals("Bool")) {
				node.type=mrca(node.ifbody.type,node.elsebody.type);
			}
			else{
				node.type=mrca(node.ifbody.type,node.elsebody.type);
				reportError(fileName,node.lineNo,"Conditional predicate not of type Bool, found: "+node.predicate.type);
			}
		}
		private void visit(AST.let node){
			if (objects.lookUpGlobal(node.name)==null) {
				objects.enterScope();
				objects.insert(node.name,node.typeid);
				visit(node.value);
				visit(node.body);
				objects.exitScope();
				node.type=node.body.type;
			}
			else {
				reportError(fileName,node.lineNo,"Found repeated definition of identifier "+node.name);
				objects.enterScope();
				objects.insert(node.name,node.typeid);
				visit(node.value);
				visit(node.body);
				objects.exitScope();
				node.type=node.body.type;
			}
		}
		private void visit(AST.dispatch node) {
			visit(node.caller);
			for(AST.expression e : node.actuals){
				visit(e);
			}
			String callType=node.caller.type;
			HashMap<String,String> temp = feature_env.get(callType);
			while(temp.get(node.name) == null&&(!callType.equals("Object"))){
				callType = parents.get(callType);
				temp=feature_env.get(callType);
			}
			String type=feature_env.get(callType).get(node.name);
			if(!(type==null)){
				String[] components =type.split("\\s+");
				if(components.length == node.actuals.size()+1||(components.length==2 && node.actuals.size()==0)){
					int count=0;
					boolean flag=false;
					for(AST.expression e : node.actuals) {
						if (!subtypes(e.type,components[count])) {
							flag=true;
							reportError(fileName,node.lineNo,"Type mismatch between formal("+components[count]+") and actual("+e.type+") parameter");
						}
						++count;
					}
					if (!flag) {
						node.type=components[components.length-1];
					}
					else{
						node.type=components[components.length-1];
					}
				}
				else{
					node.type=components[components.length-1];
					reportError(fileName,node.lineNo,"Mismatch between number of formals("+(components.length==2?0:components.length-1)+") and actual("+node.actuals.size()+") parameters");
				}
			}
			else{
					node.type="Object";
					reportError(fileName,node.lineNo,"Method "+node.name+" not found in "+callType);
			}
		}
		private void visit(AST.static_dispatch node) {
			visit(node.caller);
			for(AST.expression e : node.actuals){
				visit(e);
			}
			if(feature_env.containsKey(node.typeid)){
				if(subtypes(node.caller.type,node.typeid)){
					String type = feature_env.get(node.typeid).get(node.name);
					if(!(type==null)){
						String[] components =type.split("\\s+");
						if(components.length == node.actuals.size()+1){
							int count=0;
							boolean flag=false;
							for(AST.expression e : node.actuals) {
								if (!subtypes(e.type,components[count])) {
									flag=true;
									reportError(fileName,node.lineNo,"Type mismatch between formal("+components[count]+") and actual("+e.type+") parameter");
								}
								++count;
							}
							if (!flag) {
								node.type=components[components.length-1];
							}
							else {
								node.type=components[components.length-1];
								reportError(fileName,node.lineNo,"type mismatch between formals and actual parameters");	
							}
							
						}
						else {
							node.type=components[components.length-1];
							reportError(fileName,node.lineNo,"Mismatch between number of formals("+(components.length==2?0:components.length-1)+") and actual("+node.actuals.size()+") parameters");
						}	
					}
					else{
						node.type="Object";
						reportError(fileName,node.lineNo,"Method "+node.name+" not found in "+node.caller.type);	
					}
				}
				else{
					node.type="Object";
					reportError(fileName,node.lineNo,node.caller.type+" cannot be cast to specified type "+node.typeid);
				}
			}
			else{
				node.type="Object";
				reportError(fileName,node.lineNo,node.typeid+" does not exist");
			}			
		}
		private void visit(AST.typcase node){
			visit(node.predicate);
			for(AST.branch b : node.branches){
				visit(b);
			}
			String tempType=node.branches.get(0).type;
			for (AST.branch b : node.branches) {
				if (feature_env.get(b.type)==null) {
					tempType="Object";
				}
				else {
					tempType=mrca(b.type,tempType);
				}
			}
			node.type=tempType;
		}
		private void visit(AST.branch node){
			objects.enterScope();
			if (feature_env.get(node.type)!=null) {
				objects.insert(node.name,node.type);
			}
			else {
				objects.insert(node.name,"Object");
				reportError(fileName,node.lineNo,node.type+" does not exist");
			}
			visit(node.value);
			node.type=node.value.type;
			objects.exitScope();
		}
		private void visit(AST.method node,String classname) {
			boolean flag = false;
			StringBuilder functype = new StringBuilder();
			objects.enterScope();
			for (AST.formal f : node.formals) {
				if (!feature_env.containsKey(f.typeid)) {
					flag=true;
					functype.append("Object");
					functype.append(" ");
					objects.insert(f.name,"Object");
					reportError(fileName,node.lineNo,"Formal parameter type "+f.typeid+" does not exist");
				}
				else {
					functype.append(f.typeid);
					functype.append(" ");
					objects.insert(f.name,f.typeid);
				}
			}
			if (feature_env.get(classname).get(node.name)!=null) {
				reportError(fileName,node.lineNo,"Redefinition of "+node.name+" in class "+classname);
			}
			if (feature_env.containsKey(node.typeid)) {
				if(!flag){
					functype.append(node.typeid);
					feature_env.get(classname).put(node.name,functype.toString());
					visit(node.body);
				}
				else{
					functype.append(node.typeid);
					feature_env.get(classname).put(node.name,functype.toString());
					visit(node.body);
				}
			}
			else{
				functype.append(node.typeid);
				feature_env.get(classname).put(node.name,functype.toString());
				visit(node.body);
				reportError(fileName,node.lineNo,"Specified return type "+node.typeid+" does not exist");
			}
			objects.exitScope();
		}
		private void visit(AST.attr node,String classname) {
			visit(node.value);
			if (feature_env.get(classname).get(node.name)!=null) {
				reportError(fileName,node.lineNo,"Redefinition of "+node.name+" in class "+classname);
			}
			if (feature_env.containsKey(node.typeid)) {
				if(subtypes(node.value.type,node.typeid)||node.value.type.equals("Void")){
					feature_env.get(classname).put(node.name,node.typeid);
					objects.insert(node.name,node.typeid);
				}
				else{
					feature_env.get(classname).put(node.name,"Object");
					objects.insert(node.name,"Object");
					reportError(fileName,node.lineNo,"Initializer expression(of type "+node.value.type+") does not subtype LHS type("+node.typeid+")");
				}
			}
			else{
				feature_env.get(classname).put(node.name,"Object");
				objects.insert(node.name,"Object");
				reportError(fileName,node.lineNo,"Specified type "+node.typeid+" does not exist");
			}
		}
		private void visit(AST.expression node) {
			if (node instanceof AST.no_expr) {
				visit((AST.no_expr) node);
			}
			else if (node instanceof AST.bool_const) {
				visit((AST.bool_const) node);
			}
			else if (node instanceof AST.string_const) {
				visit((AST.string_const) node);
			}
			else if (node instanceof AST.int_const) {
				visit((AST.int_const) node);
			}
			else if (node instanceof AST.object) {
				visit((AST.object) node);
			}
			else if (node instanceof AST.comp) {
				visit((AST.comp) node);
			}
			else if (node instanceof AST.eq) {
				visit((AST.eq) node);
			}
			else if (node instanceof AST.leq) {
				visit((AST.leq) node);
			}
			else if (node instanceof AST.lt) {
				visit((AST.lt) node);
			}
			else if (node instanceof AST.neg) {
				visit((AST.neg) node);
			}
			else if (node instanceof AST.divide) {
				visit((AST.divide) node);
			}
			else if (node instanceof AST.mul) {
				visit((AST.mul) node);
			}
			else if (node instanceof AST.sub) {
				visit((AST.sub) node);
			}
			else if (node instanceof AST.plus) {
				visit((AST.plus) node);
			}
			else if (node instanceof AST.isvoid) {
				visit((AST.isvoid) node);
			}
			else if (node instanceof AST.new_) {
				visit((AST.new_) node);
			}
			else if (node instanceof AST.assign) {
				visit((AST.assign) node);
			}
			else if (node instanceof AST.block) {
				visit((AST.block) node);
			}
			else if (node instanceof AST.loop) {
				visit((AST.loop) node);
			}
			else if (node instanceof AST.cond) {
				visit((AST.cond) node);
			}
			else if (node instanceof AST.let) {
				visit((AST.let) node);
			}
			else if (node instanceof AST.dispatch) {
				visit((AST.dispatch) node);
			}
			else if (node instanceof AST.static_dispatch) {
				visit((AST.static_dispatch) node);
			}
			else if (node instanceof AST.typcase) {
				visit((AST.typcase) node);
			}
		}
		
		private void visit(AST.class_ node) {
			feature_env.put(node.name,new HashMap<String,String>());
			objects.enterScope();
			objects.insert("self",node.name);
			for (AST.feature f : node.features) {
				if (f instanceof AST.attr) {
					visit((AST.attr)f,node.name);
				}
				else if (f instanceof AST.method) {
					visit((AST.method)f,node.name);
				}
			}
			objects.exitScope();
		}
		private void visit(AST.program node) {
			for (AST.class_ cl : node.classes) {
				fileName = cl.filename;
				visit(cl);
			}
		}
		
	}

	public Semantic(AST.program program){

		//Write Semantic analyzer code here
		HashMap<String,String> igraph = checkInherit(program);
		if (!igraph.isEmpty()) {
			ASTVisitor v = new ASTVisitor(igraph);
			v.visit(program);
		}
		else { //abort with error due to inheritance issue
			reportError("",program.lineNo,"Error while constructing inheritance hierarchy, terminating compilation");
			return;
		}
	}
}
