class Main inherits IO {
	arg : Int;
	divisor : Int <- 2;
	flag : Bool <- true;
	next : Bool <- true;
	main() : Object {
		{
			out_string("Enter an integer");
			arg <- in_int();
			if ((arg/2) < divisor) then {
				next <- false;
			}
			else {
				0;
			} fi;
			while (next = true) loop {
				if (arg = (arg/divisor)*divisor) then {
					flag <- false;
				}
				else {
					0;
				} fi;
				if ((arg/2) < divisor) then {
					next <- false;
				}
				else {
					0;
				} fi;
				divisor <- divisor+1;
			} pool;
			if (flag=true) then {
				out_string("Is a prime");
			}
			else {
				out_string("Is composite");
			} fi;
		}
	};
};
