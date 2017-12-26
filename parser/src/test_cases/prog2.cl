class Main inherits IO {
	arg1 : Int;
	main() : Object {
		{
			out_string("Enter an  integer");
			arg1 <- in_int();
			if arg1 - 2*(arg1/2) = 0 then {
				out_string("The number is even!");
			}
			else {
				out_string("The number is odd!");
			}
			fi;
		}
	};
};
