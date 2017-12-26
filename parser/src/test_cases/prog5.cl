class CanFail {
	init(arg : Int) : Object {
		{
			if arg - 3*(arg/3) = 0 then {
				self;
			}
			else {
				while 1 < 0 loop {
					0;
				}
				pool;
			}
			fi;
		}
	};
};
class Main inherits IO {
	arg1 : Int;
	trial : Object;
	main() : Object {
		{
			out_string("Enter an  integer");
			arg1 <- in_int();
			trial <- (new CanFail).init(arg1);
			if isvoid trial then {
				out_string("Could not create object\n");
			}
			else {
				out_string("Created object!\n");
			}
			fi;
		}
	};
};
