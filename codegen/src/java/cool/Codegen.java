package cool;
import java.io.PrintWriter;
import java.util.*;
import java.nio.charset.*;
public class Codegen{
	private int nextreg;
	HashMap<String,Integer> Strconst_map = new HashMap<String,Integer>();
	HashMap<String,Integer> register_map = new HashMap<String,Integer>();
	HashMap<String,Integer> member_back_ptr_map = new HashMap<String,Integer>();
	HashMap<String,String> local_type_map = new HashMap<String,String>();
	HashMap<String,HashMap<String,Integer>> member_offsets = new HashMap<String,HashMap<String,Integer>>();
	private Integer nextstrconst=new Integer(1);
	private int loopid=0;
	String mangle_method(String classname, String methodname) {
		return "m_"+Integer.toString(classname.length())+"_"+classname+"_"+Integer.toString(methodname.length())+"_"+methodname;
	}
	int visit(AST.bool_const node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int size_Bool_in_ptr=nextreg;
		code.append("%");
		code.append(size_Bool_in_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
		++nextreg;
		int size_Bool=nextreg;
		code.append("%");
		code.append(size_Bool);
		code.append(" = ptrtoint %struct.Bool* %");
		code.append(size_Bool_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Bool);
		code.append(")\n");
		++nextreg;
		int result_Bool_ptr=nextreg;
		code.append("%");
		code.append(result_Bool_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Bool*\n");
		++nextreg;
		int inner_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(inner_bool_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
		code.append(result_Bool_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i1 ");
		if (node.value) {
			code.append("true, ");
		}
		else {
			code.append("false, ");
		}
		code.append("i1* %");
		code.append(inner_bool_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Bool* %");
		code.append(result_Bool_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_Bool_ptr;
	}
	int visit(AST.string_const node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int size_String_in_ptr=nextreg;
		code.append("%");
		code.append(size_String_in_ptr);
		code.append(" = getelementptr %struct.String, %struct.String* null, i32 1\n");
		++nextreg;
		int size_String=nextreg;
		code.append("%");
		code.append(size_String);
		code.append(" = ptrtoint %struct.String* %");
		code.append(size_String_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_String);
		code.append(")\n");
		++nextreg;
		int result_String_ptr=nextreg;
		code.append("%");
		code.append(result_String_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.String*\n");
		++nextreg;
		int inner_string_ptr_offset_ptr=nextreg;
		code.append("%");
		code.append(inner_string_ptr_offset_ptr);
		code.append(" = getelementptr inbounds %struct.String, %struct.String* %");
		code.append(result_String_ptr);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int const_string_ptr=nextreg;
		code.append("%");
		code.append(const_string_ptr);
		code.append(" = bitcast [");
		int strLen=node.value.length()+1;
		code.append(strLen);
		code.append(" x i8]* @.str.");
		code.append(Strconst_map.get(node.value+"\0").toString());
		code.append(" to i8*\n");
		code.append("store i8* %");
		code.append(const_string_ptr);
		code.append(", i8** %");
		code.append(inner_string_ptr_offset_ptr);
		code.append("\n");
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.String* %");
		code.append(result_String_ptr);
		code.append(" to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [7 x i8]* @.str.9 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_String_ptr;
	}
	int visit(AST.int_const node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_Int_ptr=nextreg;
		code.append("%");
		code.append(result_Int_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int inner_int_offset_ptr=nextreg;
		code.append("%");
		code.append(inner_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_Int_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 ");
		code.append(Integer.toString(node.value));
		code.append(", i32* %");
		code.append(inner_int_offset_ptr);
		code.append("\n");
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_Int_ptr);
		code.append(" to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_Int_ptr;
	}
	int visit(AST.object node, String classname, ClassTable structures, PrintWriter out){
		return register_map.get(node.name);
	}
	int visit(AST.comp node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int size_Bool_in_ptr=nextreg;
		code.append("%");
		code.append(size_Bool_in_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
		++nextreg;
		int size_Bool=nextreg;
		code.append("%");
		code.append(size_Bool);
		code.append(" = ptrtoint %struct.Bool* %");
		code.append(size_Bool_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Bool);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Bool*\n");
		++nextreg;
		int op_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(op_bool_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op_bool=nextreg;
		code.append("%");
		code.append(op_bool);
		code.append(" = load i1, i1* %");
		code.append(op_bool_offset_ptr);
		code.append("\n");
		++nextreg;
		int result_bool=nextreg;
		code.append("%");
		code.append(result_bool);
		code.append(" = sub i1 1, %");
		code.append(op_bool);
		code.append("\n");
		++nextreg;
		int result_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(result_bool_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i1 %");
		code.append(result_bool);
		code.append(", i1* %");
		code.append(result_bool_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Bool* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.eq node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		if(node.e1.type.equals(node.e2.type)){
			if(node.e1.type.equals("Int")){
				int op1_int_ptr=nextreg;
				code.append("%");
				code.append(op1_int_ptr);
				code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
				code.append(r1);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op1_int=nextreg;
				code.append("%");
				code.append(op1_int);
				code.append(" = load i32, i32* %");
				code.append(op1_int_ptr);
				code.append("\n");
				++nextreg;
				int op2_int_ptr=nextreg;
				code.append("%");
				code.append(op2_int_ptr);
				code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
				code.append(r2);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op2_int=nextreg;
				code.append("%");
				code.append(op2_int);
				code.append(" = load i32, i32* %");
				code.append(op2_int_ptr);
				code.append("\n");
				++nextreg;
				int compare_reg = nextreg;
				code.append("%");
				code.append(compare_reg);
				code.append(" = icmp eq i32 %");
				code.append(op1_int);
				code.append(", %");
				code.append(op2_int);
				code.append("\n");
				++nextreg;
				int size_Bool_in_ptr=nextreg;
				code.append("%");
				code.append(size_Bool_in_ptr);
				code.append(" = getelementptr %struct.Bool,%struct.Bool* null, i32 1\n");
				++nextreg;
				int size_Bool=nextreg;
				code.append("%");
				code.append(size_Bool);
				code.append(" = ptrtoint %struct.Bool* %");
				code.append(size_Bool_in_ptr);
				code.append(" to i32\n");
				++nextreg;
				int result_mem_ptr=nextreg;
				code.append("%");
				code.append(result_mem_ptr);
				code.append(" = call i8* @malloc(i32 %");
				code.append(size_Bool);
				code.append(")\n");
				++nextreg;
				int result_ptr=nextreg;
				code.append("%");
				code.append(result_ptr);
				code.append(" = bitcast i8* %");
				code.append(result_mem_ptr);
				code.append(" to %struct.Bool*\n");
				++nextreg;
				int result_bool_offset_ptr=nextreg;
				code.append("%");
				code.append(result_bool_offset_ptr);
				code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
				code.append(result_ptr);
				code.append(", i32 0, i32 1\n");
				code.append("store i1 %");
				code.append(compare_reg);
				code.append(", i1* %");
				code.append(result_bool_offset_ptr);
				code.append("\n");
				++nextreg;
				int cast_to_obj_ptr=nextreg;
				code.append("%");
				code.append(cast_to_obj_ptr);
				code.append(" = bitcast %struct.Bool* %");
				code.append(result_ptr);
				code.append("to %struct.Object*\n");
				++nextreg;
				int find_obj_str_ptr=nextreg;
				code.append("%");
				code.append(find_obj_str_ptr);
				code.append(" = getelementptr %struct.Object, %struct.Object* %");
				code.append(cast_to_obj_ptr);
				code.append(",i32 0, i32 0");
				++nextreg;
				int type_str_ptr=nextreg;
				code.append("%");
				code.append(type_str_ptr);
				code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
				code.append("store i8* %");
				code.append(type_str_ptr);
				code.append(", i8** %");
				code.append(find_obj_str_ptr);
				++nextreg;
				out.println(code.toString());
				return result_ptr;
			}
			else if(node.e1.type.equals("Bool")){
				int op1_int_ptr=nextreg;
				code.append("%");
				code.append(op1_int_ptr);
				code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
				code.append(r1);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op1_int=nextreg;
				code.append("%");
				code.append(op1_int);
				code.append(" = load i1, i1* %");
				code.append(op1_int_ptr);
				code.append("\n");
				++nextreg;
				int op2_int_ptr=nextreg;
				code.append("%");
				code.append(op2_int_ptr);
				code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
				code.append(r2);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op2_int=nextreg;
				code.append("%");
				code.append(op2_int);
				code.append(" = load i1, i1* %");
				code.append(op2_int_ptr);
				code.append("\n");
				++nextreg;
				int compare_reg = nextreg;
				code.append("%");
				code.append(compare_reg);
				code.append(" = icmp eq i1 %");
				code.append(op1_int);
				code.append(", %");
				code.append(op2_int);
				code.append("\n");
				++nextreg;
				int size_Bool_in_ptr=nextreg;
				code.append("%");
				code.append(size_Bool_in_ptr);
				code.append(" = getelementptr %struct.Bool,%struct.Bool* null, i32 1\n");
				++nextreg;
				int size_Bool=nextreg;
				code.append("%");
				code.append(size_Bool);
				code.append(" = ptrtoint %struct.Bool* %");
				code.append(size_Bool_in_ptr);
				code.append(" to i32\n");
				++nextreg;
				int result_mem_ptr=nextreg;
				code.append("%");
				code.append(result_mem_ptr);
				code.append(" = call i8* @malloc(i32 %");
				code.append(size_Bool);
				code.append(")\n");
				++nextreg;
				int result_ptr=nextreg;
				code.append("%");
				code.append(result_ptr);
				code.append(" = bitcast i8* %");
				code.append(result_mem_ptr);
				code.append(" to %struct.Bool*\n");
				++nextreg;
				int result_bool_offset_ptr=nextreg;
				code.append("%");
				code.append(result_bool_offset_ptr);
				code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
				code.append(result_ptr);
				code.append(", i32 0, i32 1\n");
				code.append("store i1 %");
				code.append(compare_reg);
				code.append(", i1* %");
				code.append(result_bool_offset_ptr);
				code.append("\n");
				++nextreg;
				int cast_to_obj_ptr=nextreg;
				code.append("%");
				code.append(cast_to_obj_ptr);
				code.append(" = bitcast %struct.Bool* %");
				code.append(result_ptr);
				code.append("to %struct.Object*\n");
				++nextreg;
				int find_obj_str_ptr=nextreg;
				code.append("%");
				code.append(find_obj_str_ptr);
				code.append(" = getelementptr %struct.Object, %struct.Object* %");
				code.append(cast_to_obj_ptr);
				code.append(",i32 0, i32 0");
				++nextreg;
				int type_str_ptr=nextreg;
				code.append("%");
				code.append(type_str_ptr);
				code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
				code.append("store i8* %");
				code.append(type_str_ptr);
				code.append(", i8** %");
				code.append(find_obj_str_ptr);
				++nextreg;
				out.println(code.toString());
				return result_ptr;
			}
			else if(node.e1.type.equals("String")){
				int op1_int_ptr=nextreg;
				code.append("%");
				code.append(op1_int_ptr);
				code.append(" = getelementptr inbounds %struct.String, %struct.String* %");
				code.append(r1);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op1_int=nextreg;
				code.append("%");
				code.append(op1_int);
				code.append(" = load i8*, i8** %");
				code.append(op1_int_ptr);
				code.append("\n");
				++nextreg;
				int op2_int_ptr=nextreg;
				code.append("%");
				code.append(op2_int_ptr);
				code.append(" = getelementptr inbounds %struct.String, %struct.String* %");
				code.append(r2);
				code.append(", i32 0, i32 1\n");
				++nextreg;
				int op2_int=nextreg;
				code.append("%");
				code.append(op2_int);
				code.append(" = load i8*, i8** %");
				code.append(op2_int_ptr);
				code.append("\n");
				++nextreg;
				int str_compare_reg = nextreg;
				code.append("%");
				code.append(str_compare_reg);
				code.append(" = call i32 @strcmp(i8* %");
				code.append(op1_int);
				code.append(",i8* %");
				code.append(op2_int);
				code.append(")\n");
				++nextreg;
				int compare_reg = nextreg;
				code.append("%");
				code.append(compare_reg);
				code.append(" = icmp eq i32 %");
				code.append(str_compare_reg);
				code.append(", 0\n");
				++nextreg;
				int size_Bool_in_ptr=nextreg;
				code.append("%");
				code.append(size_Bool_in_ptr);
				code.append(" = getelementptr %struct.Bool,%struct.Bool* null, i32 1\n");
				++nextreg;
				int size_Bool=nextreg;
				code.append("%");
				code.append(size_Bool);
				code.append(" = ptrtoint %struct.Bool* %");
				code.append(size_Bool_in_ptr);
				code.append(" to i32\n");
				++nextreg;
				int result_mem_ptr=nextreg;
				code.append("%");
				code.append(result_mem_ptr);
				code.append(" = call i8* @malloc(i32 %");
				code.append(size_Bool);
				code.append(")\n");
				++nextreg;
				int result_ptr=nextreg;
				code.append("%");
				code.append(result_ptr);
				code.append(" = bitcast i8* %");
				code.append(result_mem_ptr);
				code.append(" to %struct.Bool*\n");
				++nextreg;
				int result_bool_offset_ptr=nextreg;
				code.append("%");
				code.append(result_bool_offset_ptr);
				code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
				code.append(result_ptr);
				code.append(", i32 0, i32 1\n");
				code.append("store i1 %");
				code.append(compare_reg);
				code.append(", i1* %");
				code.append(result_bool_offset_ptr);
				code.append("\n");
				++nextreg;
				int cast_to_obj_ptr=nextreg;
				code.append("%");
				code.append(cast_to_obj_ptr);
				code.append(" = bitcast %struct.Bool* %");
				code.append(result_ptr);
				code.append("to %struct.Object*\n");
				++nextreg;
				int find_obj_str_ptr=nextreg;
				code.append("%");
				code.append(find_obj_str_ptr);
				code.append(" = getelementptr %struct.Object, %struct.Object* %");
				code.append(cast_to_obj_ptr);
				code.append(",i32 0, i32 0");
				++nextreg;
				int type_str_ptr=nextreg;
				code.append("%");
				code.append(type_str_ptr);
				code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
				code.append("store i8* %");
				code.append(type_str_ptr);
				code.append(", i8** %");
				code.append(find_obj_str_ptr);
				++nextreg;
				out.println(code.toString());
				return result_ptr;
			}
			else{
				int op1_reg = nextreg;
				code.append("%");
				code.append(op1_reg);
				code.append(" = bitcast %struct.");
				code.append(node.e1.type);
				code.append("* %");
				code.append(r1);
				code.append(" to i8*\n");
				++nextreg;
				int op2_reg = nextreg;
				code.append("%");
				code.append(op2_reg);
				code.append(" = bitcast %struct.");
				code.append(node.e2.type);
				code.append("* %");
				code.append(r2);
				code.append(" to i8*\n");
				++nextreg;
				int compare_reg=nextreg;
				code.append("%");
				code.append(compare_reg);
				code.append(" = icmp eq i8* %");
				code.append(op1_reg);
				code.append(", %");
				code.append(op2_reg);
				code.append("\n");
				++nextreg;
				int size_Bool_in_ptr=nextreg;
				code.append("%");
				code.append(size_Bool_in_ptr);
				code.append(" = getelementptr %struct.Bool,%struct.Bool* null, i32 1\n");
				++nextreg;
				int size_Bool=nextreg;
				code.append("%");
				code.append(size_Bool);
				code.append(" = ptrtoint %struct.Bool* %");
				code.append(size_Bool_in_ptr);
				code.append(" to i32\n");
				++nextreg;
				int result_mem_ptr=nextreg;
				code.append("%");
				code.append(result_mem_ptr);
				code.append(" = call i8* @malloc(i32 %");
				code.append(size_Bool);
				code.append(")\n");
				++nextreg;
				int result_ptr=nextreg;
				code.append("%");
				code.append(result_ptr);
				code.append(" = bitcast i8* %");
				code.append(result_mem_ptr);
				code.append(" to %struct.Bool*\n");
				++nextreg;
				int result_bool_offset_ptr=nextreg;
				code.append("%");
				code.append(result_bool_offset_ptr);
				code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
				code.append(result_ptr);
				code.append(", i32 0, i32 1\n");
				code.append("store i1 %");
				code.append(compare_reg);
				code.append(", i1* %");
				code.append(result_bool_offset_ptr);
				code.append("\n");
				++nextreg;
				int cast_to_obj_ptr=nextreg;
				code.append("%");
				code.append(cast_to_obj_ptr);
				code.append(" = bitcast %struct.Bool* %");
				code.append(result_ptr);
				code.append("to %struct.Object*\n");
				++nextreg;
				int find_obj_str_ptr=nextreg;
				code.append("%");
				code.append(find_obj_str_ptr);
				code.append(" = getelementptr %struct.Object, %struct.Object* %");
				code.append(cast_to_obj_ptr);
				code.append(",i32 0, i32 0");
				++nextreg;
				int type_str_ptr=nextreg;
				code.append("%");
				code.append(type_str_ptr);
				code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
				code.append("store i8* %");
				code.append(type_str_ptr);
				code.append(", i8** %");
				code.append(find_obj_str_ptr);
				++nextreg;
				out.println(code.toString());
				return result_ptr;
			}
		}
		else{
			int op1_reg = nextreg;
			code.append("%");
			code.append(op1_reg);
			code.append(" = bitcast %struct.");
			code.append(node.e1.type);
			code.append("* %");
			code.append(r1);
			code.append(" to i8*\n");
			++nextreg;
			int op2_reg = nextreg;
			code.append("%");
			code.append(op2_reg);
			code.append(" = bitcast %struct.");
			code.append(node.e2.type);
			code.append("* %");
			code.append(r2);
			code.append(" to i8*\n");
			++nextreg;
			int compare_reg=nextreg;
			code.append("%");
			code.append(compare_reg);
			code.append(" = icmp eq i8* %");
			code.append(op1_reg);
			code.append(", %");
			code.append(op2_reg);
			code.append("\n");
			++nextreg;
			int size_Bool_in_ptr=nextreg;
			code.append("%");
			code.append(size_Bool_in_ptr);
			code.append(" = getelementptr %struct.Bool,%struct.Bool* null, i32 1\n");
			++nextreg;
			int size_Bool=nextreg;
			code.append("%");
			code.append(size_Bool);
			code.append(" = ptrtoint %struct.Bool* %");
			code.append(size_Bool_in_ptr);
			code.append(" to i32\n");
			++nextreg;
			int result_mem_ptr=nextreg;
			code.append("%");
			code.append(result_mem_ptr);
			code.append(" = call i8* @malloc(i32 %");
			code.append(size_Bool);
			code.append(")\n");
			++nextreg;
			int result_ptr=nextreg;
			code.append("%");
			code.append(result_ptr);
			code.append(" = bitcast i8* %");
			code.append(result_mem_ptr);
			code.append(" to %struct.Bool*\n");
			++nextreg;
			int result_bool_offset_ptr=nextreg;
			code.append("%");
			code.append(result_bool_offset_ptr);
			code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
			code.append(result_ptr);
			code.append(", i32 0, i32 1\n");
			code.append("store i1 %");
			code.append(compare_reg);
			code.append(", i1* %");
			code.append(result_bool_offset_ptr);
			code.append("\n");
			++nextreg;
			int cast_to_obj_ptr=nextreg;
			code.append("%");
			code.append(cast_to_obj_ptr);
			code.append(" = bitcast %struct.Bool* %");
			code.append(result_ptr);
			code.append("to %struct.Object*\n");
			++nextreg;
			int find_obj_str_ptr=nextreg;
			code.append("%");
			code.append(find_obj_str_ptr);
			code.append(" = getelementptr %struct.Object, %struct.Object* %");
			code.append(cast_to_obj_ptr);
			code.append(",i32 0, i32 0");
			++nextreg;
			int type_str_ptr=nextreg;
			code.append("%");
			code.append(type_str_ptr);
			code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
			code.append("store i8* %");
			code.append(type_str_ptr);
			code.append(", i8** %");
			code.append(find_obj_str_ptr);
			++nextreg;
			out.println(code.toString());
			return result_ptr;
		} 
	}
	int visit(AST.leq node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Bool_in_ptr=nextreg;
		code.append("%");
		code.append(size_Bool_in_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
		++nextreg;
		int size_Bool=nextreg;
		code.append("%");
		code.append(size_Bool);
		code.append(" = ptrtoint %struct.Bool* %");
		code.append(size_Bool_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Bool);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Bool*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int result_bool=nextreg;
		code.append("%");
		code.append(result_bool);
		code.append(" = icmp sle i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(result_bool_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i1 %");
		code.append(result_bool);
		code.append(", i1* %");
		code.append(result_bool_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Bool* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.lt node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Bool_in_ptr=nextreg;
		code.append("%");
		code.append(size_Bool_in_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
		++nextreg;
		int size_Bool=nextreg;
		code.append("%");
		code.append(size_Bool);
		code.append(" = ptrtoint %struct.Bool* %");
		code.append(size_Bool_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Bool);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Bool*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int result_bool=nextreg;
		code.append("%");
		code.append(result_bool);
		code.append(" = icmp slt i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(result_bool_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Bool, %struct.Bool* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i1 %");
		code.append(result_bool);
		code.append(", i1* %");
		code.append(result_bool_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Bool* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.neg node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int op_int_offset_ptr=nextreg;
		code.append("%");
		code.append(op_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op_int=nextreg;
		code.append("%");
		code.append(op_int);
		code.append(" = load i32, i32* %");
		code.append(op_int_offset_ptr);
		code.append("\n");
		++nextreg;
		int result_int=nextreg;
		code.append("%");
		code.append(result_int);
		code.append(" = sub nsw i32 0, %");
		code.append(op_int);
		code.append("\n");
		++nextreg;
		int result_int_offset_ptr=nextreg;
		code.append("%");
		code.append(result_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 %");
		code.append(result_int);
		code.append(", i32* %");
		code.append(result_int_offset_ptr);
		code.append("\n");
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.divide node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int compare_reg = nextreg;
		++nextreg;
		code.append("%");
		code.append(compare_reg);
		code.append(" = icmp eq i32 %");
		code.append(op2_int);
		code.append(",0\n");
		code.append("br i1 %");
		code.append(compare_reg);
		code.append(", label %div");code.append(compare_reg);code.append(".end, label %div");code.append(compare_reg);code.append(".then\n");
		int err_reg = nextreg;
		++nextreg;
		code.append("div");code.append(compare_reg);code.append(".end: \n");
		code.append("%");
		code.append(err_reg);
		code.append(" = bitcast [22 x i8]* @.str.4 to i8*\n");
		int pcall_reg=nextreg;
		++nextreg;
		code.append("%");
		code.append(pcall_reg);
		code.append(" = call i32 (i8*, ...) @printf(i8* %");
		code.append(err_reg);
		code.append(")\n");
		int call_reg = nextreg;
		code.append("%");
		code.append(call_reg);
		code.append(" = call %struct.Object* (%struct.Object*) @m_6_Object_5_abort(%struct.Object* null)\n");
		code.append("br label %div");
		code.append(compare_reg);
		code.append(".then\n");
		code.append("div");
		code.append(compare_reg);
		code.append(".then: \n");
		++nextreg;
		int result_int=nextreg;
		code.append("%");
		code.append(result_int);
		code.append(" = sdiv i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_int_offset_ptr=nextreg;
		code.append("%");
		code.append(result_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 %");
		code.append(result_int);
		code.append(", i32* %");
		code.append(result_int_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.mul node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int result_int=nextreg;
		code.append("%");
		code.append(result_int);
		code.append(" = mul nsw i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_int_offset_ptr=nextreg;
		code.append("%");
		code.append(result_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 %");
		code.append(result_int);
		code.append(", i32* %");
		code.append(result_int_offset_ptr);
		code.append("\n");
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.sub node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int result_int=nextreg;
		code.append("%");
		code.append(result_int);
		code.append(" = sub nsw i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_int_offset_ptr=nextreg;
		code.append("%");
		code.append(result_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 %");
		code.append(result_int);
		code.append(", i32* %");
		code.append(result_int_offset_ptr);
		code.append("\n");
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.plus node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int r1=visit(node.e1,classname,structures,out);
		int r2=visit(node.e2,classname,structures,out);
		int size_Int_in_ptr=nextreg;
		code.append("%");
		code.append(size_Int_in_ptr);
		code.append(" = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
		++nextreg;
		int size_Int=nextreg;
		code.append("%");
		code.append(size_Int);
		code.append(" = ptrtoint %struct.Int* %");
		code.append(size_Int_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Int);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Int*\n");
		++nextreg;
		int op1_int_ptr=nextreg;
		code.append("%");
		code.append(op1_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r1);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op1_int=nextreg;
		code.append("%");
		code.append(op1_int);
		code.append(" = load i32, i32* %");
		code.append(op1_int_ptr);
		code.append("\n");
		++nextreg;
		int op2_int_ptr=nextreg;
		code.append("%");
		code.append(op2_int_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(r2);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int op2_int=nextreg;
		code.append("%");
		code.append(op2_int);
		code.append(" = load i32, i32* %");
		code.append(op2_int_ptr);
		code.append("\n");
		++nextreg;
		int result_int=nextreg;
		code.append("%");
		code.append(result_int);
		code.append(" = add nsw i32 %");
		code.append(op1_int);
		code.append(", %");
		code.append(op2_int);
		code.append("\n");
		++nextreg;
		int result_int_offset_ptr=nextreg;
		code.append("%");
		code.append(result_int_offset_ptr);
		code.append(" = getelementptr inbounds %struct.Int, %struct.Int* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		code.append("store i32 %");
		code.append(result_int);
		code.append(", i32* %");
		code.append(result_int_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Int* %");
		code.append(result_ptr);
		code.append("to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [4 x i8]* @.str.7 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.isvoid node, String classname, ClassTable structures, PrintWriter out){
		int resultreg=visit(node.e1,classname,structures,out);
		int size_Bool_in_ptr=nextreg;
		StringBuilder code = new StringBuilder();
		code.append("%");
		code.append(size_Bool_in_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
		++nextreg;
		int size_Bool=nextreg;
		code.append("%");
		code.append(size_Bool);
		code.append(" = ptrtoint %struct.Bool* %");
		code.append(size_Bool_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Bool);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Bool*\n");
		++nextreg;
		int result_bool_offset_ptr=nextreg;
		code.append("%");
		code.append(result_bool_offset_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int result_bool=nextreg;
		code.append("%");
		code.append(result_bool);
		code.append(" = icmp eq %struct.");
		code.append(node.e1.type);
		code.append("* %");
		code.append(resultreg);
		code.append(", null\n");
		code.append("store i1 %");
		code.append(result_bool);
		code.append(", i1* %");
		code.append(result_bool_offset_ptr);
		++nextreg;
		int cast_to_obj_ptr=nextreg;
		code.append("%");
		code.append(cast_to_obj_ptr);
		code.append(" = bitcast %struct.Bool* %");
		code.append(result_ptr);
		code.append(" to %struct.Object*\n");
		++nextreg;
		int find_obj_str_ptr=nextreg;
		code.append("%");
		code.append(find_obj_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(cast_to_obj_ptr);
		code.append(",i32 0, i32 0\n");
		++nextreg;
		int type_str_ptr=nextreg;
		code.append("%");
		code.append(type_str_ptr);
		code.append(" = bitcast [5 x i8]* @.str.8 to i8*\n");
		code.append("store i8* %");
		code.append(type_str_ptr);
		code.append(", i8** %");
		code.append(find_obj_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.new_ node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code=new StringBuilder();
		int size_Type_in_ptr=nextreg;
		code.append("%");
		code.append(size_Type_in_ptr);
		code.append(" = getelementptr %struct.");
		code.append(node.typeid);
		code.append(", %struct.");
		code.append(node.typeid);
		code.append("* null, i32 1\n");
		++nextreg;
		int size_Type=nextreg;
		code.append("%");
		code.append(size_Type);
		code.append(" = ptrtoint %struct.");
		code.append(node.typeid);
		code.append("* %");
		code.append(size_Type_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Type);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = call %struct.");
		code.append(node.typeid);
		code.append("* @");
		code.append(mangle_method(node.typeid,"Build"));
		code.append("(i8* %");
		code.append(result_mem_ptr);
		code.append(")");
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.assign node, String classname, ClassTable structures, PrintWriter out){
		int resultreg=visit(node.e1,classname,structures,out);
		StringBuilder commoncode = new StringBuilder();
		int dest_ptr=nextreg;
		commoncode.append("%");
		commoncode.append(dest_ptr);
		commoncode.append(" = bitcast %struct.");
		commoncode.append(node.e1.type);
		commoncode.append("* %");
		commoncode.append(resultreg);
		commoncode.append("to %struct.");
		commoncode.append(local_type_map.get(node.name));
		commoncode.append("*");
		++nextreg;
		out.println(commoncode.toString());
		register_map.put(node.name,new Integer(dest_ptr));
		if (member_back_ptr_map.containsKey(node.name)) { //is a data member, need to write back
			StringBuilder code = new StringBuilder();
			code.append("store %struct.");
			code.append(local_type_map.get(node.name));
			code.append("* %");
			code.append(dest_ptr);
			code.append(", %struct.");
			code.append(local_type_map.get(node.name));
			code.append("** %");
			code.append(member_back_ptr_map.get(node.name));
			out.println(code.toString());
		}
		return resultreg;
	}
	int visit(AST.block node, String classname, ClassTable structures, PrintWriter out){
		int ret=0;
		for (AST.expression e1 : node.l1) {
			ret=visit(e1,classname,structures,out);
		}
		return ret;
	}
	int visit(AST.loop node, String classname, ClassTable structures, PrintWriter out){
		StringBuilder code = new StringBuilder();
		int myloopid=loopid;
		++loopid;
		code.append("br label %loop");
		code.append(myloopid);
		code.append(".entry\n");
		code.append("loop");
		code.append(myloopid);
		code.append(".entry:\n");
		code.append("br label %loop");
		code.append(myloopid);
		code.append(".cond\n");
		code.append("loop");
		code.append(myloopid);
		code.append(".cond:");
		for (String name : register_map.keySet()) {
			int newregno=nextreg;
			code.append("\n%");
			code.append(newregno);
			code.append(" = phi %struct.");
			code.append(local_type_map.get(name));
			code.append("* [%");
			code.append(register_map.get(name).toString());
			code.append(", %loop");
			code.append(myloopid);
			code.append(".entry ], [%");
			code.append(name);
			code.append(".");
			code.append(myloopid);
			code.append(", %loop");
			code.append(myloopid);
			code.append(".bodyend ]");
			register_map.put(name,new Integer(newregno));
			++nextreg;
		}
		HashMap<String,Integer> tempregmap=new HashMap<String,Integer>(register_map);
		out.println(code.toString());
		int predresultreg=visit(node.predicate,classname,structures,out);
		int result_bool_ptr=nextreg;
		code.setLength(0);
		code.append("%");
		code.append(result_bool_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
		code.append(predresultreg);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int result_bool=nextreg;
		code.append("%");
		code.append(result_bool);
		code.append(" = load i1, i1* %");
		code.append(result_bool_ptr);
		code.append("\n");
		code.append("br i1 %");
		code.append(result_bool);
		code.append(", label %loop");
		code.append(myloopid);
		code.append(".body, label %loop");
		code.append(myloopid);
		code.append(".exit\n");
		code.append("loop");
		code.append(myloopid);
		code.append(".body:");
		out.println(code.toString());
		++nextreg;
		int bodyresultreg=visit(node.body,classname,structures,out);
		code.setLength(0);
		code.append("br label %loop");
		code.append(myloopid);
		code.append(".prebodyend\n");
		code.append("loop");
		code.append(myloopid);code.append(".prebodyend:\n");
		code.append("br label %loop");
		code.append(myloopid);
		code.append(".bodyend\n");
		code.append("loop");
		code.append(myloopid);
		code.append(".bodyend:\n");
		for (String name : register_map.keySet()) {
			code.append("%");
			code.append(name);
			code.append(".");
			code.append(myloopid);
			code.append(" = phi %struct.");
			code.append(local_type_map.get(name));
			code.append("* [%");
			code.append(register_map.get(name).toString());
			code.append(", %loop");
			code.append(myloopid);
			code.append(".prebodyend ]\n");
		}
		code.append("br label %loop");
		code.append(myloopid);
		code.append(".cond\n");
		code.append("loop");
		code.append(myloopid);
		code.append(".exit:\n");
		register_map = tempregmap;
		int size_Object_in_ptr=nextreg;
		code.append("%");
		code.append(size_Object_in_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* null, i32 1\n");
		++nextreg;
		int size_Object=nextreg;
		code.append("%");
		code.append(size_Object);
		code.append(" = ptrtoint %struct.Object* %");
		code.append(size_Object_in_ptr);
		code.append(" to i32\n");
		++nextreg;
		int result_mem_ptr=nextreg;
		code.append("%");
		code.append(result_mem_ptr);
		code.append(" = call i8* @malloc(i32 %");
		code.append(size_Object);
		code.append(")\n");
		++nextreg;
		int result_ptr=nextreg;
		code.append("%");
		code.append(result_ptr);
		code.append(" = bitcast i8* %");
		code.append(result_mem_ptr);
		code.append(" to %struct.Object*\n");
		//out.println(code.toString());
		++nextreg;
		int inner_str_ptr=nextreg;
		code.append("%");
		code.append(inner_str_ptr);
		code.append(" = getelementptr %struct.Object, %struct.Object* %");
		code.append(result_ptr);
		code.append(", i32 0, i32 0\n");
		++nextreg;
		int str_const_ptr=nextreg;
		code.append("%");
		code.append(str_const_ptr);
		code.append(" = bitcast [7 x i8]* @.str.3 to i8*\n");
		code.append("store i8* %");
		code.append(str_const_ptr);
		code.append(", i8** %");
		code.append(inner_str_ptr);
		++nextreg;
		out.println(code.toString());
		return result_ptr;
	}
	int visit(AST.cond node, String classname, ClassTable structures, PrintWriter out){
		int resultreg=visit(node.predicate,classname,structures,out);
		StringBuilder code = new StringBuilder();
		int Bool_value_ptr=nextreg;
		code.append("%");
		code.append(Bool_value_ptr);
		code.append(" = getelementptr %struct.Bool, %struct.Bool* %");
		code.append(resultreg);
		code.append(", i32 0, i32 1\n");
		++nextreg;
		int Bool_value=nextreg;
		code.append("%");
		code.append(Bool_value);
		code.append(" = load i1, i1* %");
		code.append(Bool_value_ptr);
		code.append("\n");
		code.append("br i1 %");
		code.append(Bool_value);
		code.append(", label %if");
		code.append(resultreg);
		code.append(".body, label %else");
		code.append(resultreg);
		code.append(".body\n");
		code.append("if");
		code.append(resultreg);
		code.append(".body:");
		++nextreg;
		out.println(code.toString());
		HashMap<String,Integer> precondmap = new HashMap<String,Integer>(register_map);
		int ifresultreg=visit(node.ifbody,classname,structures,out);
		int realifresultreg=nextreg;
		code.setLength(0);
		code.append("%");
		code.append(realifresultreg);
		code.append(" = bitcast %struct.");
		code.append(node.ifbody.type);
		code.append("* %");
		code.append(ifresultreg);
		code.append(" to %struct.");
		code.append(node.type);
		code.append("*");
		out.println(code.toString());
		++nextreg;
		HashMap<String,Integer> postifmap = new HashMap<String,Integer>(register_map);
		code.setLength(0);
		code.append("br label %if");
		code.append(resultreg);
		code.append(".bodyexit\n");
		code.append("if");
		code.append(resultreg);
		code.append(".bodyexit:\n");
		code.append("br label %if");
		code.append(resultreg);
		code.append(".end\n");
		code.append("else");
		code.append(resultreg);
		code.append(".body:");
		out.println(code.toString());
		register_map=precondmap;
		int elseresultreg=visit(node.elsebody,classname,structures,out);
		int realelseresultreg=nextreg;
		code.setLength(0);
		code.append("%");
		code.append(realelseresultreg);
		code.append(" = bitcast %struct.");
		code.append(node.elsebody.type);
		code.append("* %");
		code.append(elseresultreg);
		code.append(" to %struct.");
		code.append(node.type);
		code.append("*");
		out.println(code.toString());++nextreg;
		HashMap<String,Integer> postelsemap = new HashMap<String,Integer>(register_map);
		code.setLength(0);
		code.append("br label %else");
		code.append(resultreg);
		code.append(".bodyexit\n");
		code.append("else");
		code.append(resultreg);
		code.append(".bodyexit:\n");
		code.append("br label %if");
		code.append(resultreg);
		code.append(".end\n");
		code.append("if");
		code.append(resultreg);
		code.append(".end:\n");
		int finalresultreg=nextreg;
		code.append("%");
		code.append(finalresultreg);
		code.append(" = phi %struct.");
		code.append(node.type);
		code.append("* [%");
		code.append(realifresultreg);
		code.append(", %if");
		code.append(resultreg);
		code.append(".bodyexit ], [%");
		code.append(realelseresultreg);
		code.append(", %else");
		code.append(resultreg);
		code.append(".bodyexit ]");
		++nextreg;
		for (String name : register_map.keySet()) {
			Integer postifreg = postifmap.get(name);
			Integer postelsereg = postelsemap.get(name);
			if (!postifreg.equals(postelsereg)) {
				int newreg = nextreg;
				code.append("\n%");
				code.append(newreg);
				code.append(" = phi %struct.");
				code.append(local_type_map.get(name));
				code.append("* [%");
				code.append(postifreg.toString());
				code.append(", %if");
				code.append(resultreg);
				code.append(".bodyexit ], [%");
				code.append(postelsereg.toString());
				code.append(", %else");
				code.append(resultreg);
				code.append(".bodyexit ]");
				register_map.put(name,new Integer(newreg));
				++nextreg;
			}
		}
		out.println(code.toString());
		return finalresultreg;
	}
	int visit(AST.static_dispatch node, String classname, ClassTable structures, PrintWriter out){
		int reg_caller=visit(node.caller,classname,structures,out);
		ArrayList<Integer> reg_actuals = new ArrayList<Integer>();
		StringBuilder code=new StringBuilder();
		int fcounter=0;
		for (AST.expression e: node.actuals) {
			int canon_reg_actual=visit(e,classname,structures,out);
			int new_reg_actual=nextreg;
			code.append("%");
			code.append(new_reg_actual);
			code.append(" = bitcast %struct.");
			code.append(e.type);
			code.append("* %");
			code.append(canon_reg_actual);
			code.append(" to %struct.");
			code.append(structures.getClassPlus(node.typeid).mlist.get(node.name).formals.get(fcounter).typeid);
			code.append("*"); 
			out.println(code.toString());
			code.setLength(0);
			reg_actuals.add(new Integer(new_reg_actual));
			++fcounter;
			++nextreg;
		}
		int cast_reg_caller=nextreg;
		code.append("%");
		code.append(cast_reg_caller);
		code.append(" = bitcast %struct.");
		code.append(node.caller.type);
		code.append("* %");
		code.append(reg_caller);
		code.append(" to %struct.");
		code.append(node.typeid);
		code.append("*\n");
		++nextreg;
		int check_void=nextreg;
		code.append("%"); //check for void
		code.append(check_void);
		code.append(" = icmp eq %struct.");
		code.append(node.typeid);
		code.append("* %");
		code.append(cast_reg_caller);
		code.append(", null\n");
		code.append("br i1 %");
		code.append(check_void);
		code.append(", label %static");
		code.append(check_void);
		code.append("term, label %static");
		code.append(check_void);
		code.append("cont\n");
		code.append("static");
		code.append(check_void);
		code.append("term:\n");
		++nextreg;
		int irrelevantreg1=nextreg;
		code.append("%");
		code.append(irrelevantreg1);
		code.append(" = bitcast [25 x i8]* @.str.6 to i8*\n");
		++nextreg;
		int irrelevantreg2=nextreg;
		code.append("%");
		code.append(irrelevantreg2);
		code.append(" = call i32(i8*,...) @printf(i8* %");
		code.append(irrelevantreg1);
		code.append(")\n");
		code.append("call void @exit(i32 0)\n");
		code.append("br label %static");
		code.append(check_void);
		code.append("cont\n");
		code.append("static");
		code.append(check_void);
		code.append("cont:\n");
		++nextreg;
		int returnreg=nextreg;
		code.append("%");
		code.append(returnreg);
		code.append(" = call %struct.");
		code.append(node.type);
		code.append("* (%struct.");
		code.append(node.typeid);
		code.append("*");
		fcounter=0;
		for (AST.expression e : node.actuals) {
			code.append(", ");
			code.append("%struct.");
			code.append(structures.getClassPlus(node.typeid).mlist.get(node.name).formals.get(fcounter).typeid);
			++fcounter;
			//code.append(e.type);
			code.append("*");
		}
		code.append(") @");
		code.append(mangle_method(node.typeid,node.name));
		code.append("(");
		code.append("%struct.");
		code.append(node.typeid);
		code.append("* %");
		code.append(cast_reg_caller);
		int index=0;
		for (AST.expression e : node.actuals) {
			code.append(", ");
			code.append("%struct.");
			code.append(structures.getClassPlus(node.typeid).mlist.get(node.name).formals.get(index).typeid);
			//code.append(e.type);
			code.append("* %");
			code.append(reg_actuals.get(index));
			++index;
		}
		code.append(")");
		++nextreg;
		out.println(code.toString());
		return returnreg;
	}
	
	int visit(AST.expression node, String classname, ClassTable structures, PrintWriter out) {
		if (node instanceof AST.bool_const) {
			return visit((AST.bool_const) node,classname,structures,out);
		}
		else if (node instanceof AST.string_const) {
			return visit((AST.string_const) node,classname,structures,out);
		}
		else if (node instanceof AST.int_const) {
			return visit((AST.int_const) node,classname,structures,out);
		}
		else if (node instanceof AST.object) {
			return visit((AST.object) node,classname,structures,out);
		}
		else if (node instanceof AST.comp) {
			return visit((AST.comp) node,classname,structures,out);
		}
		else if (node instanceof AST.eq) {
			return visit((AST.eq) node,classname,structures,out);
		}
		else if (node instanceof AST.leq) {
			return visit((AST.leq) node,classname,structures,out);
		}
		else if (node instanceof AST.lt) {
			return visit((AST.lt) node,classname,structures,out);
		}
		else if (node instanceof AST.neg) {
			return visit((AST.neg) node,classname,structures,out);
		}
		else if (node instanceof AST.divide) {
			return visit((AST.divide) node,classname,structures,out);
		}
		else if (node instanceof AST.mul) {
			return visit((AST.mul) node,classname,structures,out);
		}
		else if (node instanceof AST.sub) {
			return visit((AST.sub) node,classname,structures,out);
		}
		else if (node instanceof AST.plus) {
			return visit((AST.plus) node,classname,structures,out);
		}
		else if (node instanceof AST.isvoid) {
			return visit((AST.isvoid) node,classname,structures,out);
		}
		else if (node instanceof AST.new_) {
			return visit((AST.new_) node,classname,structures,out);
		}
		else if (node instanceof AST.assign) {
			return visit((AST.assign) node,classname,structures,out);
		}
		else if (node instanceof AST.block) {
			return visit((AST.block) node,classname,structures,out);
		}
		else if (node instanceof AST.loop) {
			return visit((AST.loop) node,classname,structures,out);
		}
		else if (node instanceof AST.cond) {
			return visit((AST.cond) node,classname,structures,out);
		}
		else if (node instanceof AST.static_dispatch) {
			return visit((AST.static_dispatch) node,classname,structures,out);
		}
		else {
			return 0;
		}
	}
	void visit(AST.method node,String classname, ClassTable structures, PrintWriter out) {
		StringBuilder code=new StringBuilder();
		register_map.clear();
		local_type_map.clear();
		member_back_ptr_map.clear();
		loopid=0;
		code.append("define %struct.");
		code.append(node.typeid);
		code.append("* @");
		String mangled=mangle_method(classname,node.name);
		code.append(mangled);
		code.append("(%struct.");
		code.append(classname);
		code.append("* %self");
		Integer argreg=new Integer(1);
		register_map.put("self",argreg);
		local_type_map.put("self",classname);
		++argreg;
		for (AST.formal f : node.formals)  {
			code.append(", %struct.");
			code.append(f.typeid);
			code.append("* %");
			code.append(f.name);
			register_map.put(f.name,argreg);
			local_type_map.put(f.name,f.typeid);
			++argreg;
		}
		code.append(") {");
		out.println(code.toString());
		nextreg=new Integer(1);
		code.setLength(0);
		code.append("%self.addr = alloca %struct.");
		code.append(classname);
		code.append("*, align 8");
		out.println(code.toString());
		code.setLength(0);
		code.append("store %struct.");
		code.append(classname);
		code.append("* %self, %struct.");
		code.append(classname);
		code.append("** %self.addr, align 8");
		out.println(code.toString());
		code.setLength(0);
		int argptr=nextreg;
		++nextreg;
		code.append("%");
		code.append(argptr);
		code.append(" = load %struct.");
		code.append(classname);
		code.append("*, %struct.");
		code.append(classname);
		code.append("** %self.addr, align 8");
		out.println(code.toString());
		for (AST.formal f : node.formals) {
			code.setLength(0);
			code.append("%");
			code.append(f.name);
			code.append(".addr = alloca %struct.");
			code.append(f.typeid);
			code.append("*, align 8");
			out.println(code.toString());
			code.setLength(0);
			code.append("store %struct.");
			code.append(f.typeid);
			code.append("* %");
			code.append(f.name);
			code.append(", %struct.");
			code.append(f.typeid);
			code.append("** %");
			code.append(f.name);
			code.append(".addr, align 8");
			out.println(code.toString());
			code.setLength(0);
			int nonselfargptr=nextreg;
			++nextreg;
			code.append("%");
			code.append(nonselfargptr);
			code.append(" = load %struct.");
			code.append(f.typeid);
			code.append("*, %struct.");
			code.append(f.typeid);
			code.append("** %");
			code.append(f.name);
			code.append(".addr, align 8");
			out.println(code.toString());
		}
		for (String dataname : member_offsets.get(classname).keySet()) {
			int dataregptr = nextreg;
			code.setLength(0);
			code.append("%");
			code.append(dataregptr);
			code.append(" = getelementptr %struct.");
			code.append(classname);
			code.append(", %struct.");
			code.append(classname);
			code.append("* %1, i32 0, i32 ");
			code.append(member_offsets.get(classname).get(dataname));
			member_back_ptr_map.put(dataname,new Integer(dataregptr));
			++nextreg;
			out.println(code.toString());
		}
		ClassPlus self_data = structures.getClassPlus(classname);
		for (String dataname : member_offsets.get(classname).keySet()) {
			int datareg = nextreg;
			code.setLength(0);
			code.append("%");
			code.append(datareg);
			code.append(" = load %struct.");
			code.append(self_data.alist.get(dataname).typeid);
			code.append("*, %struct.");
			code.append(self_data.alist.get(dataname).typeid);
			code.append("** %");
			code.append(member_back_ptr_map.get(dataname));
			++nextreg;
			out.println(code.toString());
			register_map.put(dataname,datareg);
			local_type_map.put(dataname,self_data.alist.get(dataname).typeid);
		}
		if (node.body instanceof AST.no_expr) { //empty body, delegate to parent's implementation
			code.setLength(0);
			String parentname=structures.getClassPlus(classname).parent;
			int parentptrreg=nextreg;
			code.append("%");
			code.append(parentptrreg);
			code.append(" = bitcast %struct.");
			code.append(classname);
			code.append("* %1 to %struct.");
			code.append(parentname);
			code.append("*\n");
			++nextreg;
			int resultreg = nextreg;
			code.append("%");
			code.append(resultreg);
			code.append(" = call %struct.");
			code.append(node.typeid);
			code.append("* @");
			code.append(mangle_method(parentname,node.name));
			code.append("(%struct.");
			code.append(parentname);
			code.append("* %");
			code.append(parentptrreg);
			int fcounter=2;
			for (AST.formal f : node.formals) {
				code.append(", %struct.");
				code.append(f.typeid);
				code.append("* %");
				code.append(f.name);
			}
			code.append(")\n");
			code.append("ret %struct.");
			code.append(node.typeid);
			code.append("* %");
			code.append(resultreg);
			code.append("\n}");
			++nextreg;
		}
		else {
			int resultreg=visit(node.body,classname,structures,out);
			int realresultreg=nextreg;
			code.setLength(0);
			code.append("%");
			code.append(realresultreg);
			code.append(" = bitcast %struct.");
			code.append(node.body.type);
			code.append("* %");
			code.append(resultreg);
			code.append(" to %struct.");
			code.append(node.typeid);
			code.append("*\n");
			code.append("ret %struct.");
			code.append(node.typeid);
			code.append("* %");
			code.append(realresultreg);
			code.append("\n}");
			++nextreg;
		}
		out.println(code.toString());
	}
	void visit(AST.class_ node, ClassTable structures, PrintWriter out) {
		ClassPlus entries=structures.getClassPlus(node.name);
		HashMap<String,Integer> register_map_master=new HashMap<String,Integer>();
		{ //code for build for this class
			StringBuilder code = new StringBuilder();
			code.append("define %struct.");
			code.append(node.name);
			code.append("* @");
			code.append(mangle_method(node.name,"Build"));
			code.append("(i8* %memory) {\n");
			code.append("%parent_ptr = call %struct.");
			code.append(node.parent);
			code.append("* @");
			code.append(mangle_method(node.parent,"Build"));
			code.append("(i8* %memory)\n");
			code.append("%object_ptr = bitcast %struct.");
			code.append(node.parent);
			code.append("* %parent_ptr to %struct.Object*\n");
			code.append("%inner_str_ptr = getelementptr %struct.Object, %struct.Object* %object_ptr, i32 0, i32 0\n");
			code.append("%str_ptr = bitcast [");
			code.append(node.name.length()+1);
			code.append(" x i8]* @.str.");
			code.append(Strconst_map.get(node.name+"\0").toString());
			code.append(" to i8*\n");
			code.append("store i8* %str_ptr, i8** %inner_str_ptr");
			code.append("%obj_ptr = bitcast i8* %memory to %struct.");
			code.append(node.name);
			code.append("*");
			out.println(code.toString());
			nextreg=new Integer(1);
			HashMap<String,Integer> these_offsets = member_offsets.get(node.name);
			for (String dataname : entries.alist.keySet()) {
				AST.attr attribute = entries.alist.get(dataname);
				if (attribute.value instanceof AST.no_expr) {
					if (attribute.typeid.equals("Int")) {
						code.setLength(0);
						code.append("%");
						code.append(attribute.name);
						code.append(" = getelementptr %struct.");
						code.append(node.name);
						code.append(", %struct.");
						code.append(node.name);
						code.append("* %obj_ptr, i32 0, i32 ");
						code.append(these_offsets.get(attribute.name));
						code.append("\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size_ptr = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size = ptrtoint %struct.Int* %");
						code.append(attribute.name);
						code.append(".size_ptr to i32\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".mem_ptr = call i8* @malloc(i32 %");
						code.append(attribute.name);
						code.append(".size)\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".ptr = call %struct.Int* @");
						code.append(mangle_method("Int","Build"));
						code.append("(i8* %");
						code.append(attribute.name);
						code.append(".mem_ptr)\n");
						code.append("store %struct.Int* %");
						code.append(attribute.name);
						code.append(".ptr, %struct.Int** %");
						code.append(attribute.name);
						out.println(code.toString());
					}
					else if (attribute.typeid.equals("String")) {
						code.setLength(0);
						code.append("%");
						code.append(attribute.name);
						code.append(" = getelementptr %struct.");
						code.append(node.name);
						code.append(", %struct.");
						code.append(node.name);
						code.append("* %obj_ptr, i32 0, i32 ");
						code.append(these_offsets.get(attribute.name));
						code.append("\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size_ptr = getelementptr %struct.String, %struct.String* null, i32 1\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size = ptrtoint %struct.String* %");
						code.append(attribute.name);
						code.append(".size_ptr to i32\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".mem_ptr = call i8* @malloc(i32 %");
						code.append(attribute.name);
						code.append(".size)\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".ptr = call %struct.String* @");
						code.append(mangle_method("String","Build"));
						code.append("(i8* %");
						code.append(attribute.name);
						code.append(".mem_ptr)\n");
						code.append("store %struct.String* %");
						code.append(attribute.name);
						code.append(".ptr, %struct.String** %");
						code.append(attribute.name);
						out.println(code.toString());
					}
					else if (attribute.typeid.equals("Bool")) {
						code.setLength(0);
						code.append("%");
						code.append(attribute.name);
						code.append(" = getelementptr %struct.");
						code.append(node.name);
						code.append(", %struct.");
						code.append(node.name);
						code.append("* %obj_ptr, i32 0, i32 ");
						code.append(these_offsets.get(attribute.name));
						code.append("\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size_ptr = getelementptr %struct.Bool, %struct.Bool* null, i32 1\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".size = ptrtoint %struct.Bool* %");
						code.append(attribute.name);
						code.append(".size_ptr to i32\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".mem_ptr = call i8* @malloc(i32 %");
						code.append(attribute.name);
						code.append(".size)\n");
						code.append("%");
						code.append(attribute.name);
						code.append(".ptr = call %struct.Bool* @");
						code.append(mangle_method("Bool","Build"));
						code.append("(i8* %");
						code.append(attribute.name);
						code.append(".mem_ptr)\n");
						code.append("store %struct.Bool* %");
						code.append(attribute.name);
						code.append(".ptr, %struct.Bool** %");
						code.append(attribute.name);
						out.println(code.toString());
					}
					else {
						code.setLength(0);
						code.append("%");
						code.append(attribute.name);
						code.append(" = getelementptr %struct.");
						code.append(node.name);
						code.append(", %struct.");
						code.append(node.name);
						code.append("* %obj_ptr, i32  0, i32 ");
						code.append(these_offsets.get(attribute.name));
						code.append("\n");
						code.append("store %struct.");
						code.append(attribute.typeid);
						code.append("* null, %struct.");
						code.append(attribute.typeid);
						code.append("** %");
						code.append(attribute.name);
						out.println(code.toString());
					}
				}
				else {
					int resultreg=visit(attribute.value,node.name,structures,out);
					code.setLength(0);
					code.append("%");
					code.append(attribute.name);
					code.append(" = getelementptr %struct.");
					code.append(node.name);
					code.append(", %struct.");
					code.append(node.name);
					code.append("* %obj_ptr, i32 0, i32 ");
					code.append(these_offsets.get(attribute.name));
					code.append("store %struct.");
					code.append(attribute.typeid);
					code.append("* %");
					code.append(resultreg);
					code.append(", %struct.");
					code.append(attribute.typeid);
					code.append("** %");
					code.append(attribute.name);
					out.println(code.toString());
				}
			}
			code.setLength(0);
			code.append("ret %struct.");
			code.append(node.name);
			code.append("* %obj_ptr\n");
			code.append("}");
			out.println(code.toString());
		}
		for (Map.Entry<String,AST.method> entry : entries.mlist.entrySet()) {
			HashMap<String,Integer> register_map= new HashMap<String,Integer>();
			register_map.putAll(register_map_master);
			visit(entry.getValue(),node.name,structures,out);
		}
	}
	
	void search_string(AST.bool_const node){}
	void search_string(AST.string_const node){
		Strconst_map.put(node.value+"\0",nextstrconst);
		nextstrconst=new Integer(nextstrconst+1);	
	}
	void search_string(AST.int_const node){}
	void search_string(AST.object node){}
	void search_string(AST.comp node){
		search_string(node.e1);
	}
	void search_string(AST.eq node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.leq node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.lt node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.neg node){
		search_string(node.e1);
	}
	void search_string(AST.divide node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.mul node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.sub node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.plus node){
		search_string(node.e1);
		search_string(node.e2);
	}
	void search_string(AST.isvoid node){
		search_string(node.e1);
	}
	void search_string(AST.new_ node){}
	void search_string(AST.assign node){
		search_string(node.e1);
	}
	void search_string(AST.block node){
		for(AST.expression e : node.l1){
			search_string(e);
		}
	}
	void search_string(AST.loop node){
		search_string(node.predicate);
		search_string(node.body);
	}
	void search_string(AST.cond node){
		search_string(node.predicate);
		search_string(node.ifbody);
		search_string(node.elsebody);
	}
	void search_string(AST.static_dispatch node){
		search_string(node.caller);
		for(AST.expression e : node.actuals){
			search_string(e);
		}
	}
	void search_string(AST.expression node) {
		if (node instanceof AST.bool_const) {
			 search_string((AST.bool_const) node);
		}
		else if (node instanceof AST.string_const) {
			 search_string((AST.string_const) node);
		}
		else if (node instanceof AST.int_const) {
			 search_string((AST.int_const) node);
		}
		else if (node instanceof AST.object) {
			 search_string((AST.object) node);
		}
		else if (node instanceof AST.comp) {
			 search_string((AST.comp) node);
		}
		else if (node instanceof AST.eq) {
			 search_string((AST.eq) node);
		}
		else if (node instanceof AST.leq) {
			 search_string((AST.leq) node);
		}
		else if (node instanceof AST.lt) {
			 search_string((AST.lt) node);
		}
		else if (node instanceof AST.neg) {
			 search_string((AST.neg) node);
		}
		else if (node instanceof AST.divide) {
			 search_string((AST.divide) node);
		}
		else if (node instanceof AST.mul) {
			 search_string((AST.mul) node);
		}
		else if (node instanceof AST.sub) {
			 search_string((AST.sub) node);
		}
		else if (node instanceof AST.plus) {
			 search_string((AST.plus) node);
		}
		else if (node instanceof AST.isvoid) {
			 search_string((AST.isvoid) node);
		}
		else if (node instanceof AST.new_) {
			 search_string((AST.new_) node);
		}
		else if (node instanceof AST.assign) {
			 search_string((AST.assign) node);
		}
		else if (node instanceof AST.block) {
			 search_string((AST.block) node);
		}
		else if (node instanceof AST.loop) {
			 search_string((AST.loop) node);
		}
		else if (node instanceof AST.cond) {
			 search_string((AST.cond) node);
		}
		else if (node instanceof AST.static_dispatch) {
			 search_string((AST.static_dispatch) node);
		}
	}
	void search_string(AST.method node) {
		search_string(node.body);
	}
	void search_string(AST.attr node) {
		search_string(node.value);
	}
	void search_string(AST.feature node) {
		if (node instanceof AST.method) {
			search_string((AST.method)node);
		}
		else if (node instanceof AST.attr) {
			search_string((AST.attr)node);
		}
	}
	void search_string(AST.class_ node){
		for (AST.feature f : node.features) {
			search_string(f);
		}
	}
	public Codegen(AST.program program, Semantic semantic, PrintWriter out){
		//Write Code generator code here
		out.println("declare i8* @malloc(i32)");
		out.println("declare i32 @__isoc99_scanf(i8*, ...)	");
		out.println("declare i32 @printf(i8*, ...)");
		out.println("declare void @exit(i32)");
		out.println("declare i32 @strcmp(i8*, i8*)");
		out.println("@.str.1 = private unnamed_addr constant [3 x i8] c\"%d\\00\", align 1");
		out.println("@.str.2 = private unnamed_addr constant [3 x i8] c\"%s\\00\", align 1");
		out.println("@.str.3 = private unnamed_addr constant [7 x i8] c\"Object\\00\", align 1");
		out.println("@.str.4 = private unnamed_addr constant [22 x i8] c\"Divide by zero error\n\\00\", align 1");
		out.println("@.str.5 = private unnamed_addr constant [35 x i8] c\"Substring reference out of bounds\n\\00\", align 1");
		out.println("@.str.6 = private unnamed_addr constant [25 x i8] c\"Static dispatch on void\n\\00\", align 1");
		out.println("@.str.7 = private unnamed_addr constant [4 x i8] c\"Int\\00\", align 1");
		out.println("@.str.8 = private unnamed_addr constant [5 x i8] c\"Bool\\00\", align 1");
		out.println("@.str.9 = private unnamed_addr constant [7 x i8] c\"String\\00\", align 1");
		out.println("@.str.10 = private unnamed_addr constant [3 x i8] c\"IO\\00\", align 1");
		nextstrconst = new Integer(nextstrconst+10);
		for (AST.class_ c : program.classes) {
			StringBuilder code=new StringBuilder();
			String cname=c.name;
			int reallen=cname.length()+1;
			Strconst_map.put(cname+"\0",nextstrconst);
			nextstrconst = new Integer(nextstrconst+1);
		}
		for(AST.class_ c: program.classes){
			search_string(c);
		}
		for(Map.Entry<String,Integer> entry : Strconst_map.entrySet()){
			StringBuilder code=new StringBuilder();
			code.append("@.str.");
			code.append(entry.getValue().toString());
			code.append(" =  private unnamed_addr constant [");
			code.append(entry.getKey().length());
			code.append(" x i8] c\"");
			String s=entry.getKey();
			byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(String.format("\\%02X", b));
			}
			code.append(sb.toString());
			code.append("\", align 1");
			out.println(code.toString());
		}
		
		String mainRetType=null;
		{ //generate built-in type definitions
			out.println("%struct.Object = type {i8*}");
			out.println("%struct.Int = type {%struct.Object, i32}");
			out.println("%struct.Bool = type {%struct.Object, i1}");
			out.println("%struct.String = type {%struct.Object, i8*}");
			out.println("%struct.IO = type {%struct.Object}");
		}
		{ //generate code for Object
			StringBuilder code = new StringBuilder();
			{ //generate code for build
				code.append("define %struct.Object* @m_6_Object_5_Build(i8* %memory) {\n");
				code.append("%1 = bitcast i8* %memory to %struct.Object*\n");
				code.append("%2 = getelementptr %struct.Object, %struct.Object* %1, i32 0, i32 0\n");
				code.append("%3 = bitcast [7 x i8]* @.str.3 to i8*\n");
				code.append("store i8* %3, i8** %2\n");
				code.append("ret %struct.Object* %1\n");
				code.append("}\n");
			}
			{ //generate code for type_name
				code.append("define %struct.String* @m_6_Object_9_type_name(%struct.Object* %self) {\n");
				code.append("%self.addr = alloca %struct.Object*, align 8\n");
				code.append("store %struct.Object* %self, %struct.Object** %self.addr, align 8\n");
				code.append("%1 = load %struct.Object*, %struct.Object** %self.addr, align 8\n");
				code.append("%2 = getelementptr %struct.String, %struct.String* null, i32 1\n");
				code.append("%3 = ptrtoint %struct.String* %2 to i32\n");
				code.append("%4 = call i8* @malloc(i32 %3)\n");
				code.append("%5 = bitcast i8* %4 to %struct.String*\n");
				code.append("%6 = getelementptr %struct.Object, %struct.Object* %1, i32 0, i32 0\n");
				code.append("%7 = load i8*,i8** %6\n");
				code.append("%8 = getelementptr %struct.String, %struct.String* %5, i32 0, i32 1\n");
				//code.append("%6 = bitcast [7 x i8]* @.str.3 to i8*\n");
				//code.append("%7 = getelementptr %struct.String, %struct.String* %5, i32 0, i32 1\n");
				code.append("store i8* %7, i8** %8\n");
				code.append("%9 = bitcast %struct.String* %5 to %struct.Object*\n");
				code.append("%10 = getelementptr %struct.Object, %struct.Object* %9, i32 0, i32 0\n");
				code.append("%11 = bitcast [7 x i8]* @.str.9 to i8*\n");
				code.append("store i8* %11, i8** %10\n");
				code.append("ret %struct.String* %5\n");
				code.append("}\n");
			}
			{ //generate code for abort
				code.append("define %struct.Object* @m_6_Object_5_abort(%struct.Object* %self) {\n");
				code.append("call void @exit(i32 0)\n");
				code.append("ret %struct.Object* %self\n");
				code.append("}\n");
			}
			out.println(code.toString());
		}
		{ //generate code for Int
			StringBuilder code = new StringBuilder();
			{ //generate code for build
				code.append("define %struct.Int* @m_3_Int_5_Build(i8* %memory) {\n");
				code.append("%call = call %struct.Object* @m_6_Object_5_Build(i8* %memory)\n");
				code.append("%inner_str_ptr = getelementptr %struct.Object, %struct.Object* %call, i32 0, i32 0\n");
				code.append("%string_ptr = bitcast [4 x i8]* @.str.7 to i8*");
				code.append("store i8* %string_ptr,i8** %inner_str_ptr");
				code.append("%1 = bitcast i8* %memory to %struct.Int*\n");
				code.append("%2 = getelementptr %struct.Int, %struct.Int* %1, i32 0, i32 1\n");
				code.append("store i32 0, i32* %2");
				code.append("ret %struct.Int* %1\n");
				code.append("}");
			}
			{ //generate code for abort
				code.append("define %struct.Object* @m_3_Int_5_abort(%struct.Int* %self) {\n");
				code.append("%self.addr = alloca %struct.Int*, align 8\n");
				code.append("store %struct.Int* %self, %struct.Int** %self.addr, align 8\n");
				code.append("%1 = load %struct.Int*, %struct.Int** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.Int* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.Object* @m_6_Object_5_abort(%struct.Object* %2)\n");
				code.append("ret %struct.Object* %3\n");
				code.append("}");
			}
			{//generate code for type_name
				code.append("define %struct.String* @m_3_Int_9_type_name(%struct.Int* %self) {\n");
				code.append("%self.addr = alloca %struct.Int*, align 8\n");
				code.append("store %struct.Int* %self, %struct.Int** %self.addr, align 8\n");
				code.append("%1 = load %struct.Int*, %struct.Int** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.Int* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.String* @m_6_Object_9_type_name(%struct.Object* %2)\n");
				code.append("ret %struct.String* %3\n");
				code.append("}");

			}
			
			out.println(code.toString());
		}
		{ //generate code for Bool
			StringBuilder code = new StringBuilder();
			{ //generate code for build
				code.append("define %struct.Bool* @m_4_Bool_5_Build(i8* %memory) {\n");
				code.append("%call = call %struct.Object* @m_6_Object_5_Build(i8* %memory)\n");
				code.append("%inner_str_ptr = getelementptr %struct.Object, %struct.Object* %call, i32 0, i32 0\n");
				code.append("%string_ptr = bitcast [5 x i8]* @.str.8 to i8*");
				code.append("store i8* %string_ptr,i8** %inner_str_ptr");
				code.append("%1 = bitcast i8* %memory to %struct.Bool*\n");
				code.append("%2 = getelementptr %struct.Bool, %struct.Bool* %1, i32 0, i32 1\n");
				code.append("store i1 0, i1* %2");
				code.append("ret %struct.Bool* %1\n");
				code.append("}");
			}
			{ //generate code for abort
				code.append("define %struct.Object* @m_4_Bool_5_abort(%struct.Bool* %self) {\n");
				code.append("%self.addr = alloca %struct.Bool*, align 8\n");
				code.append("store %struct.Bool* %self, %struct.Bool** %self.addr, align 8\n");
				code.append("%1 = load %struct.Bool*, %struct.Bool** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.Bool* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.Object* @m_6_Object_5_abort(%struct.Object* %2)\n");
				code.append("ret %struct.Object* %3\n");
				code.append("}");
			}
			{//generate code for type_name
				code.append("define %struct.String* @m_4_Bool_9_type_name(%struct.Bool* %self) {\n");
				code.append("%self.addr = alloca %struct.Bool*, align 8\n");
				code.append("store %struct.Bool* %self, %struct.Bool** %self.addr, align 8\n");
				code.append("%1 = load %struct.Bool*, %struct.Bool** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.Bool* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.String* @m_6_Object_9_type_name(%struct.Object* %2)\n");
				code.append("ret %struct.String* %3\n");
				code.append("}");
			}
			out.println(code.toString());
		}
		{ //generate code for String
			StringBuilder code = new StringBuilder();
			{ //generate code for build
				code.append("define %struct.String* @m_6_String_5_Build(i8* %memory) {\n");
				code.append("%call = call %struct.Object* @m_6_Object_5_Build(i8* %memory)\n");
				code.append("%inner_str_ptr = getelementptr %struct.Object, %struct.Object* %call, i32 0, i32 0\n");
				code.append("%string_ptr = bitcast [7 x i8]* @.str.9 to i8*");
				code.append("store i8* %string_ptr,i8** %inner_str_ptr");
				code.append("%1 = bitcast i8* %memory to %struct.String*\n");
				code.append("%2 = getelementptr %struct.String, %struct.String* %1, i32 0, i32 1\n");
				code.append("%3 = call i8* @malloc(i32 1)\n");
				code.append("store i8 0, i8* %3\n");
				code.append("store i8* %3, i8** %2");
				code.append("ret %struct.String* %1\n");
				code.append("}\n");
			}
			{ //generate code for abort
				code.append("define %struct.Object* @m_6_String_5_abort(%struct.String* %self) {\n");
				code.append("%self.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %self, %struct.String** %self.addr, align 8\n");
				code.append("%1 = load %struct.String*, %struct.String** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.String* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.Object* @m_6_Object_5_abort(%struct.Object* %2)\n");
				code.append("ret %struct.Object* %3\n");
				code.append("}");
			}
			{//generate code for type_name
				code.append("define %struct.String* @m_6_String_9_type_name(%struct.String* %self) {\n");
				code.append("%self.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %self, %struct.String** %self.addr, align 8\n");
				code.append("%1 = load %struct.String*, %struct.String** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.String* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.String* @m_6_Object_9_type_name(%struct.Object* %2)\n");
				code.append("ret %struct.String* %3\n");
				code.append("}\n");
			}
			{//generate code for length
				code.append("define %struct.Int* @m_6_String_6_length(%struct.String* %self) {\n");
				code.append("%self.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %self, %struct.String** %self.addr, align 8\n");
				code.append("%1 = load %struct.String*, %struct.String** %self.addr, align 8\n");
				code.append("%2 = getelementptr %struct.String, %struct.String* %1, i32 0, i32 1\n");
				code.append("%3 = load i8*, i8** %2\n");
				code.append("%lencount = alloca i32, align 4\n");
				code.append("store i32 0, i32* %lencount\n");
				code.append("br label %loop.cond\n");
				code.append("loop.cond:\n");
				code.append("%4 = load i32, i32* %lencount\n");
				code.append("%5 = getelementptr i8, i8* %3, i32 %4\n");
				code.append("%6 = load i8, i8* %5\n");
				code.append("%7 = icmp eq i8 0, %6\n");
				code.append("br i1 %7, label %loop.end , label %loop.body\n");
				code.append("loop.body:\n");
				code.append("%8 = load i32, i32* %lencount\n");
				code.append("%9 = add nsw i32 %8, 1\n");
				code.append("store i32 %9, i32* %lencount\n");
				code.append("br label %loop.cond\n");
				code.append("loop.end:\n");
				code.append("%10 = load i32, i32* %lencount\n");
				code.append("%11 = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
				code.append("%12 = ptrtoint %struct.Int* %11 to i32\n");
				code.append("%13 = call i8* @malloc(i32 %12)\n");
				code.append("%14 = bitcast i8* %13 to %struct.Int*\n");
				code.append("%15 = getelementptr %struct.Int, %struct.Int* %14, i32 0, i32 1\n");
				code.append("store i32 %10, i32* %15\n");
				code.append("%16 = bitcast %struct.Int* %14 to %struct.Object*\n");
				code.append("%17 = getelementptr %struct.Object, %struct.Object* %16, i32 0, i32 0\n");
				code.append("%18 = bitcast [4 x i8]* @.str.7 to i8*\n");
				code.append("store i8* %18, i8** %17\n");
				code.append("ret %struct.Int* %14\n");
				code.append("}\n");
			}
			{ //generate code for concat
				code.append("define %struct.String* @m_6_String_6_concat(%struct.String* %self, %struct.String* %s) {\n");
				code.append("%self.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %self, %struct.String** %self.addr, align 8\n");
				code.append("%1 = load %struct.String*, %struct.String** %self.addr, align 8\n");
				code.append("%s.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %s, %struct.String** %s.addr, align 8\n");
				code.append("%2 = load %struct.String*, %struct.String** %s.addr, align 8\n");
				code.append("%3 = call %struct.Int* (%struct.String*) @m_6_String_6_length(%struct.String* %1)\n");
				code.append("%4 = call %struct.Int* (%struct.String*) @m_6_String_6_length(%struct.String* %2)\n");
				code.append("%5 = getelementptr %struct.Int, %struct.Int* %3, i32 0, i32 1\n");
				code.append("%6 = getelementptr %struct.Int, %struct.Int* %4, i32 0, i32 1\n");
				code.append("%7 = load i32, i32* %5\n");
				code.append("%8 = load i32, i32* %6\n");
				code.append("%9 = add nsw i32 %7, %8\n");
				code.append("%10 = add nsw i32 %9, 1\n");
				code.append("%11 = call i8* @malloc(i32 %10)\n");
				code.append("%12 = getelementptr %struct.String, %struct.String* null,i32 1\n");
				code.append("%13 = ptrtoint %struct.String* %12 to i32\n");
				code.append("%14 = call i8* @malloc(i32 %13)\n");
				code.append("%truestring = bitcast i8* %14 to %struct.String*\n");
				code.append("%15 = getelementptr %struct.String , %struct.String* %truestring,i32 0,i32 1\n");
				code.append("store i8* %11, i8** %15\n");
				code.append("%16 = getelementptr %struct.String , %struct.String* %1,i32 0,i32 1\n");
				code.append("%strstart1ptr = load i8*, i8** %16\n");
				code.append("%17 = getelementptr %struct.String , %struct.String* %2,i32 0,i32 1\n");
				code.append("%strstart2ptr = load i8*, i8** %17\n");
				code.append("%i = alloca i32,align 4\n");
				code.append("store i32 0, i32* %i, align 4\n");
				code.append("br label %for.cond\n");
				code.append("for.cond: \n");
				code.append("%len = load i32, i32* %i, align 4\n");
				code.append("%cmp = icmp slt i32 %len, %7\n");
				code.append("br i1 %cmp, label %for.body, label %for.end\n");
				code.append("for.body: \n");
				code.append("%len1 = load i32, i32* %i, align 4\n");
				code.append("%char = getelementptr i8, i8* %strstart1ptr,i32 %len1\n");
				code.append("%18 = load i8 , i8* %char\n");
				code.append("%19 = getelementptr i8,i8* %11,i32 %len1\n");
				code.append("store i8 %18,i8* %19\n");
				code.append("br label %for.inc\n");
				code.append("for.inc: \n");
				code.append("%20 = load i32,i32* %i,align 4\n");
				code.append("%inc = add nsw i32 %20, 1\n");
				code.append("store i32 %inc, i32* %i, align 4\n");
				code.append("br label %for.cond\n");
				code.append("for.end:\n");
				code.append("%j = alloca i32,align 4\n");
				code.append("store i32 0, i32* %j, align 4\n");
				code.append("br label %for1.cond\n");
				code.append("for1.cond: \n");
				code.append("%len2 = load i32, i32* %j, align 4\n");
				code.append("%cmp1 = icmp slt i32 %len2, %8\n");
				code.append("br i1 %cmp1, label %for1.body, label %for1.end\n");
				code.append("for1.body: \n");
				code.append("%l1 = load i32, i32* %i, align 4\n");
				code.append("%l2 = load i32, i32* %j, align 4\n");
				code.append("%char1 = getelementptr i8, i8* %strstart2ptr,i32 %l2\n");
				code.append("%21 = load i8 , i8* %char1\n");
				code.append("%22 = getelementptr i8,i8* %11,i32 %l1\n");
				code.append("store i8 %21,i8* %22\n");
				code.append("br label %for1.inc\n");
				code.append("for1.inc: \n");
				code.append("%23 = load i32,i32* %i,align 4\n");
				code.append("%inc1 = add nsw i32 %23, 1\n");
				code.append("store i32 %inc1, i32* %i, align 4\n");
				code.append("%24 = load i32,i32* %j,align 4\n");
				code.append("%inc2 = add nsw i32 %24, 1\n");
				code.append("store i32 %inc2, i32* %j, align 4\n");
				code.append("br label %for1.cond\n");
				code.append("for1.end:\n");
				code.append("%25 = load i32, i32* %i, align 4\n");
				code.append("%26 = getelementptr i8,i8* %11,i32 %25\n");
				code.append("store i8 0,i8* %26\n");
				code.append("%27 = bitcast %struct.String* %truestring to %struct.Object*\n");
				code.append("%28 = getelementptr %struct.Object, %struct.Object* %27, i32 0, i32 0\n");
				code.append("%29 = bitcast [7 x i8]* @.str.9 to i8*\n");
				code.append("store i8* %29, i8** %28\n");
				code.append("ret %struct.String* %truestring\n");
				code.append("}\n");
				
			}
			{ //generate code for substr
				code.append("define %struct.String* @m_6_String_6_substr(%struct.String* %self, %struct.Int* %i, %struct.Int* %l) {");
				code.append("%self.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %self, %struct.String** %self.addr, align 8\n");
				code.append("%1 = load %struct.String*, %struct.String** %self.addr, align 8\n");
				code.append("%i.addr = alloca %struct.Int*, align 8\n");
				code.append("store %struct.Int* %i, %struct.Int** %i.addr, align 8\n");
				code.append("%2 = load %struct.Int*, %struct.Int** %i.addr, align 8\n");
				code.append("%l.addr = alloca %struct.Int*, align 8\n");
				code.append("store %struct.Int* %l, %struct.Int** %l.addr, align 8\n");
				code.append("%3 = load %struct.Int*, %struct.Int** %l.addr, align 8\n");
				code.append("%4 = getelementptr %struct.Int, %struct.Int* %2, i32 0, i32 1\n");
				code.append("%start_idx = load i32, i32* %4\n");
				code.append("%5 = getelementptr %struct.Int, %struct.Int* %3, i32 0, i32 1\n");
				code.append("%length = load i32, i32* %5\n");
				code.append("%src_length_Int = call %struct.Int* @m_6_String_6_length(%struct.String* %1)\n");
				code.append("%src_length_ptr = getelementptr %struct.Int, %struct.Int* %src_length_Int, i32 0, i32 1 \n");
				code.append("%src_length = load i32, i32* %src_length_ptr\n");
				code.append("br label %check1.cond\n");
				code.append("check1.cond:\n");
				code.append("%cmpstart = icmp slt i32 %start_idx, %src_length\n");
				code.append("br i1 %cmpstart, label %check2.cond, label %term.block\n");
				code.append("term.block:\n");
				code.append("%temp = bitcast [35 x i8]* @.str.5 to i8*\n");
				code.append("%eat = call i32 (i8*, ...) @printf(i8* %temp)\n");
				code.append("%call = call %struct.Object* (%struct.Object*) @m_6_Object_5_abort(%struct.Object* null)\n");
				code.append("br label %check.end\n");
				code.append("check2.cond:\n");
				code.append("%finalplusone = add nsw i32 %start_idx, %length\n");
				code.append("%cmpend = icmp sle i32 %finalplusone, %src_length\n");
				code.append("br i1 %cmpend, label %check.end, label %term.block\n");
				code.append("check.end:");
				code.append("%6 = getelementptr %struct.String, %struct.String* null, i32 1\n");
				code.append("%7 = ptrtoint %struct.String* %6 to i32\n");
				code.append("%8 = call i8* @malloc(i32 %7)\n");
				code.append("%9 = bitcast i8* %8 to %struct.String*\n");
				code.append("%10 = add nsw i32 1, %length\n");
				code.append("%11 = call i8* @malloc(i32 %10)\n");
				code.append("%12 = getelementptr %struct.String, %struct.String* %9, i32 0, i32 1\n");
				code.append("store i8* %11, i8** %12\n");
				code.append("%iter = alloca i32, align 4\n");
				code.append("store i32 0,i32* %iter\n");
				code.append("%src_buffer_ptr_ptr = getelementptr %struct.String, %struct.String* %1, i32 0, i32 1\n");
				code.append("%src_buffer_ptr = load i8*, i8** %src_buffer_ptr_ptr\n");
				code.append("br label %loop.cond\n");
				code.append("loop.cond:\n");
				code.append("%13 = load i32, i32* %iter\n");
				code.append("%14 = icmp slt i32 %13, %length\n");
				code.append("br i1 %14,label %loop.body, label %loop.end\n");
				code.append("loop.body:\n");
				code.append("%15 = load i32, i32* %iter\n");
				code.append("%16 = getelementptr i8, i8* %11, i32 %15\n");
				code.append("%17 = add nsw i32 %15,%start_idx\n");
				code.append("%18 = getelementptr i8, i8* %src_buffer_ptr,i32 %17\n");
				code.append("%19 = load i8, i8* %18\n");
				code.append("%20 = add nsw i32 1, %15\n");
				code.append("store i32 %20, i32* %iter\n");
				code.append("store i8 %19, i8* %16\n");
				code.append("br label %loop.cond\n");
				code.append("loop.end:\n");
				code.append("%21 = load i32, i32* %iter\n");
				code.append("%22 = getelementptr i8, i8* %11, i32 %21\n");
				code.append("store i8 0,i8* %22\n");
				code.append("%23 = bitcast %struct.String* %9 to %struct.Object*\n");
				code.append("%24 = getelementptr %struct.Object, %struct.Object* %23, i32 0, i32 0\n");
				code.append("%25 = bitcast [7 x i8]* @.str.9 to i8*\n");
				code.append("store i8* %25, i8** %24\n");
				code.append("ret %struct.String* %9\n");
				code.append("}");
			}
			out.println(code.toString());
		}
		{ //generate code for IO
			StringBuilder code = new StringBuilder();
			{ //generate code for build
				code.append("define %struct.IO* @m_2_IO_5_Build(i8* %memory) {\n");
				code.append("%call = call %struct.Object* @m_6_Object_5_Build(i8* %memory)\n");
				code.append("%inner_str_ptr = getelementptr %struct.Object, %struct.Object* %call, i32 0, i32 0\n");
				code.append("%string_ptr = bitcast [3 x i8]* @.str.10 to i8*");
				code.append("store i8* %string_ptr,i8** %inner_str_ptr");
				code.append("%1 = bitcast i8* %memory to %struct.IO*\n");
				code.append("ret %struct.IO* %1\n");
				code.append("}\n");
			}
			{//generate code for type_check
				code.append("define %struct.String* @m_2_IO_9_type_name(%struct.IO* %self) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.IO* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.String* @m_6_Object_9_type_name(%struct.Object* %2)\n");
				code.append("ret %struct.String* %3\n");
				code.append("}");

			}
			{ //generate code for abort
				code.append("define %struct.Object* @m_2_IO_5_abort(%struct.IO* %self) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%2 = bitcast %struct.IO* %1 to %struct.Object*\n");
				code.append("%3 = call %struct.Object* @m_6_Object_5_abort(%struct.Object* %2)\n");
				code.append("ret %struct.Object* %3\n");
				code.append("}");
			}
			{ //generate code for out_string
				code.append("define %struct.IO* @m_2_IO_10_out_string(%struct.IO* %self, %struct.String* %x) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%x.addr = alloca %struct.String*, align 8\n");
				code.append("store %struct.String* %x, %struct.String** %x.addr, align 8\n");
				code.append("%2 = load %struct.String*, %struct.String** %x.addr, align 8\n");
				code.append("%3 = getelementptr inbounds %struct.String, %struct.String* %2, i32 0, i32 1\n");
				code.append("%4 = load i8*, i8** %3\n");
				code.append("%5 = bitcast [3 x i8]* @.str.2 to i8*\n");
				code.append("call i32 (i8*, ...) @printf(i8* %5, i8* %4)\n");
				code.append("ret %struct.IO* %1\n");
				code.append("}\n");
			}
			{ //generate code for out_int
				code.append("define %struct.IO* @m_2_IO_7_out_int(%struct.IO* %self, %struct.Int* %x) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%x.addr = alloca %struct.Int*, align 8\n");
				code.append("store %struct.Int* %x, %struct.Int** %x.addr, align 8\n");
				code.append("%2 = load %struct.Int*, %struct.Int** %x.addr, align 8");
				code.append("%3 = getelementptr inbounds %struct.Int, %struct.Int* %2, i32 0, i32 1\n");
				code.append("%4 = load i32, i32* %3\n");
				code.append("%5 = bitcast [3 x i8]* @.str.1 to i8*\n");
				code.append("call i32 (i8*, ...) @printf(i8* %5, i32 %4)\n");
				code.append("ret %struct.IO* %1\n");
				code.append("}\n");				
			}
			{ //generate code for in_int
				code.append("define %struct.Int* @m_2_IO_6_in_int(%struct.IO* %self) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%2 = getelementptr %struct.Int, %struct.Int* null, i32 1\n");
				code.append("%3 = ptrtoint %struct.Int* %2 to i32\n");
				code.append("%4 = call i8* @malloc(i32 %3)\n");
				code.append("%5 = bitcast i8* %4 to %struct.Int*\n");
				code.append("%6 = getelementptr inbounds %struct.Int, %struct.Int* %5, i32 0, i32 1\n");
				code.append("%7 = bitcast [3 x i8]* @.str.1 to i8*\n");
				code.append("call i32 (i8*,...) @__isoc99_scanf(i8* %7, i32* %6)\n");
				code.append("%9 = bitcast %struct.Int* %5 to %struct.Object*\n");
				code.append("%10 = getelementptr %struct.Object, %struct.Object* %9, i32 0, i32 0\n");
				code.append("%11 = bitcast [4 x i8]* @.str.7 to i8*\n");
				code.append("store i8* %11, i8** %10\n");
				code.append("ret %struct.Int* %5\n");
				code.append("}\n");
			}
			{ //generate code for in_string
				code.append("define %struct.String* @m_2_IO_9_in_string(%struct.IO* %self) {\n");
				code.append("%self.addr = alloca %struct.IO*, align 8\n");
				code.append("store %struct.IO* %self, %struct.IO** %self.addr, align 8\n");
				code.append("%1 = load %struct.IO*, %struct.IO** %self.addr, align 8\n");
				code.append("%2 = getelementptr %struct.String, %struct.String* null, i32 1\n");
				code.append("%3 = ptrtoint %struct.String* %2 to i32\n");
				code.append("%4 = call i8* @malloc(i32 %3)\n");
				code.append("%5 = bitcast i8* %4 to %struct.String*\n");
				code.append("%6 = getelementptr inbounds %struct.String, %struct.String* %5, i32 0, i32 1\n");
				code.append("%7 = call i8* @malloc(i32 1024)\n");
				code.append("%8 = bitcast [3 x i8]* @.str.2 to i8*\n");
				code.append("call i32 (i8*,...) @__isoc99_scanf(i8* %8,i8* %7)\n");
				code.append("store i8* %7, i8** %6\n");
				code.append("%10 = bitcast %struct.String* %5 to %struct.Object*\n");
				code.append("%11 = getelementptr %struct.Object, %struct.Object* %10, i32 0, i32 0\n");
				code.append("%12 = bitcast [7 x i8]* @.str.9 to i8*\n");
				code.append("store i8* %12, i8** %11\n");
				code.append("ret %struct.String* %5\n");
				code.append("}\n");
			}
			out.println(code.toString());
		}
		for (AST.class_ c : program.classes) {
			StringBuilder code=new StringBuilder();
			ClassPlus entries=semantic.classTable.getClassPlus(c.name);
			code.append("%struct.");
			code.append(c.name);
			code.append(" = type {%struct.");
			code.append(c.parent);
			int counter=1;
			HashMap<String,Integer> these_offsets=new HashMap<String,Integer>();
			for (Map.Entry<String,AST.attr> entry : entries.alist.entrySet()) {
				if (semantic.classTable.getClassPlus(c.parent).alist.get(entry.getKey())==null) {
					code.append(", %struct.");
					code.append(entry.getValue().typeid);
					code.append("*");
					these_offsets.put(entry.getKey(),new Integer(counter));
					++counter;
				}
			}
			member_offsets.put(c.name,these_offsets);
			code.append("}");
			if (c.name.equals("Main")) {
				mainRetType=entries.mlist.get("main").typeid;
			}
			out.println(code.toString());
		}
		for (AST.class_ c : program.classes) {
			visit(c,semantic.classTable,out);
		}
		//codegen for true main
		{
			StringBuilder code = new StringBuilder();
			code.append("define i32 @main() {\n");
			nextreg=1;
			int size_Main_in_ptr=nextreg;
			code.append("%");
			code.append(size_Main_in_ptr);
			code.append(" = getelementptr %struct.Main, %struct.Main* null, i32 1\n");
			++nextreg;
			int size_Main=nextreg;
			code.append("%");
			code.append(size_Main);
			code.append(" = ptrtoint %struct.Main* %");
			code.append(size_Main_in_ptr);
			code.append(" to i32\n");
			++nextreg;
			int main_mem_ptr=nextreg;
			code.append("%");
			code.append(main_mem_ptr);
			code.append(" = call i8* @malloc(i32 %");
			code.append(size_Main);
			code.append(")\n");
			++nextreg;
			int main_ptr=nextreg;
			code.append("%");
			code.append(main_ptr);
			code.append(" = call %struct.Main* @m_4_Main_5_Build(i8* %");
			code.append(main_mem_ptr);
			code.append(")\n");
			code.append("call %struct.");
			code.append(mainRetType);
			code.append("* @m_4_Main_4_main(%struct.Main* %");
			code.append(main_ptr);
			code.append(")\n");
			++nextreg;
			code.append("ret i32 0\n}");
			out.println(code.toString());
		}
	}
}
