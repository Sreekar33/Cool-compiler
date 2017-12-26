
(*claculates the gcd of two numbers*)

class Main inherits IO{
   n1:Int;
   n2;Int;
   main(): SELF_TYPE{
   {
     out_string("enter the numbers");
      n1 <- in_int();
      n2 <- in_int();
      out_int(gcd(n1,n2))
      out_string("\n");
  }
  };
   gcd (a : Int,b : Int): Int{
           if a=b 
              then a
           else if a<b 
                then gcd(a,b-a)
                else gcd(a-b,b)
                fi
                fi
   }; 
    
};
