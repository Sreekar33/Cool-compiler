(* program to find out the given year is leap year or not*)
class Main inherits A2I {

     main() : Object {
      let y:Int <-a2i((new IO).in_string()) in
        if (y-(y/400)*400)=0 then 
           (new IO).out_string("This is leap year\n")
           else  
                if (y-(y/100)*100)=0 then
                  (new IO).out_string("This is not a leap year\n")
                else 
                  if (y-(y/4)*4)=0 then
                  (new IO).out_string("This is leap year\n")	
                   fi
                  else
                   (new IO).out_string("This is not a leap year\n")
                  
                fi
              fi
   
	};
};
