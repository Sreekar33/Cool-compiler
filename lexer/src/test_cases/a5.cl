(* prints the fibonacci numbers *)
class Main{
      main() : Object {
      let n:Int <-(new IO).in_int() in{
          (new IO).out_string("0 1 ");
          let t1:Int<-0 in{
          let t2:Int<-1 in{
          let t3:Int<-0 in{
          let i:Int<-3 in{
            while i<=n loop
            {
              t3 <- t1+t2;
              t1 <- t2;
              t2 <- t3;
              (new IO).out_int(t3);
              (new IO).out_string(" ");
              i <- i+1;
            }
            pool;            
         (* (new IO).out_string("\n");
          };
    };
    };
    };
    }         
   };
};
