class Main inherits IO {
	arg1 : Int;
	arg2 : Int;
	result : Int;
	main() : Object {
		{
			(new IO)@IO.out_string("Enter 2 integers");
			arg1 <- (new IO)@IO.in_int();
			arg2 <- (new IO)@IO.in_int();
			result <- arg1 + arg2;
			(new IO)@IO.out_int(result);
		}
	};
};
