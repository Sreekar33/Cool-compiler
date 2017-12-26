class Animal {
	noise() : String {
		{
			abort();
			"Type check";
		}
	};
};
class Cat inherits Animal {
	noise() : String {
		{
			"Purr!";
		}
	};
};
class Dog inherits Animal {
	noise() : String {
		{
			"Woof!";
		}
	};
};
class Main inherits IO {
	arg1 : Int;
	result : Animal;
	main() : Object {
		{
			out_string("Enter an  integer");
			arg1 <- in_int();
			if 0 < arg1 then {
				result <- new Cat;
			}
			else {
				result <- new Dog;
			}
			fi;
			case result of
				animcat : Cat => out_string("We have a cat\n");
				animdog : Dog => out_string("We have a dog\n");
			esac;
			out_string(result.noise());
		}
	};
};
