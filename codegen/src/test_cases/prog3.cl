class Main inherits IO {
	arg1 : Int;
	result : Int <- 1;
	main() : Object {
		{
			(new IO)@IO.out_string("Enter an  integer");
			arg1 <- (new IO)@IO.in_int();
			while 0 < arg1 loop {
				result <- result*arg1;
				arg1 <- arg1-1;
			} pool;
			(new IO)@IO.out_int(result);
		}
	};
};
