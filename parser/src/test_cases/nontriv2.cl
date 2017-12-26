class Main inherits IO {
	result : Int <- 0;
	arg : String;
	tempstr : String;
	counter : Int <- 0;
	len : Int;
	main() : Object {
		{
			out_string("Enter an integer\n");
			arg <- in_string();
			len <- arg.length();
			while (counter < len) loop {
				result <- result*10;
				tempstr <- arg.substr(counter,1);
				if (tempstr = "1") then {
					result <- result+1;
				}
				else if (tempstr = "2") then {
					result <- result+2;
				}
				else if (tempstr = "3") then {
					result <- result+3;
				}
				else if (tempstr = "4") then {
					result <- result+4;
				}
				else if (tempstr = "5") then {
					result <- result+5;
				}
				else if (tempstr = "6") then {
					result <- result+6;
				}
				else if (tempstr = "7") then {
					result <- result+7;
				}
				else if (tempstr = "8") then {
					result <- result+8;
				}
				else if (tempstr = "9") then {
					result <- result+9;
				}
				else {
					0;
				} fi fi fi fi fi fi fi fi fi;
				counter <- counter+1;
			} pool;
			out_int(result*2);
		}
	};
};
