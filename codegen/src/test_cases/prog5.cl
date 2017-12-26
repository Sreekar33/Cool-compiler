class CanFail {
	init(arg : Int) : Int {
			if arg - 3*(arg/3) = 0 then {
				5;
			}
			else {
				6;
			}
			fi
	};
};
class Main inherits IO {
	arg1 : Int;
	trial : Object;
	main() : Object {
		{
			arg1 <- (new IO)@IO.in_int();
			trial <- (new CanFail)@CanFail.init(arg1);
		}
	};
};
