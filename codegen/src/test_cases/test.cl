class Main {
	a : Int <- 10;
	b : Int <- 5;
	c: IO <- new IO;
	main():Object {
		{
		b <- a/b;
		a <- b/a;
		c@IO.out_string(self@Object.type_name());
		c@IO.out_int(a);
		}
	};
};

