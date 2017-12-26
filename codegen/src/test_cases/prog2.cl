class Main inherits IO {
	arg1:Int;
	main() : Object {
		{
		arg1 <- (new IO)@IO.in_int();
		if arg1-(arg1/2)*2 = 0 then {
			(new IO)@IO.out_string("The number is even!");
		}
		else {
			(new IO)@IO.out_string("The number is odd!");
		}
		fi;
		}
	};
};
