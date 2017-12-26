class Main inherits IO {
	arg1 : Int;
	result : Int <- 1;
	main() : Object {
		{
			out_string("Enter an  integer");
			arg1 <- in_int();
			while 0 < arg1 loop {
				result <- result*arg1;
				arg1 <- arg1-1;
			} pool;
			out_int(result);
		}
	};
};
