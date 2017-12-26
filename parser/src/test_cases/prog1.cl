class Main inherits IO {
	arg1 : Int;
	arg2 : Int;
	result : Int;
	main() : Object {
		{
			out_string("Enter 2 integers");
			arg1 <- in_int();
			arg2 <- in_int();
			result <- arg1 + arg2;
			out_int(result);
		}
	};
};
