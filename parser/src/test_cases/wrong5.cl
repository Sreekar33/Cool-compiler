class Main inherits IO {
    equal(k1 : String,k2 :String) : String {
	if s1.length() = s2.length()
	then "equal"
	else "not equal"
	fi 
    }
            
    s1 : String;
    s2 : String;
    main() : SELF_TYPE {
    {
    	out_string("Enter two strings : ");
        s1 <- in_string();
        s2 <- in_string();                     
	    out_string("The strings are ");
	    out_string(equal(s1,s2));
	    out_string("\n");
	    
 	}
    };
};
