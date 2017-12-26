(* program to test wheather a number is prime or not *)
class Main inherits A2I{
      main() : Object {
      let n:Int <-a2i((new IO).in_string()) in{
          let flag:Int <-0 in{
              let i:Int<-2 in{
                 while i<=(n/2)
                 {
                   if (n-((n/i)*i)) = 0 then flag<-1 
                   else if (n-((n/i)*i)) = 0 then i<-i 
                   else i<-i
                   fi
                   i <- i+1;
                 }
                 pool;
               };
              if flag = 0 then 
                  (new IO).out_string("this is a prime number\n")
                  else
                  (new IO).out_string("this is not a prime number\n")
                  fi;
          };
    }  
   };
};
