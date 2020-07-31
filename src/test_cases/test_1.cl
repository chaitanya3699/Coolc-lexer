(**
* testfile for valid and invalid multi line comments
* in Cool programming language
* This is a valid multi line comment 
* NO ERROR
*)

class Main {
	str : String
	main():IO {{
		new IO.out_string("Hello world!\n");
		(*
			(*
				*Hello world! program
			*)
			*)
		*)	--unspecified *)
		

		str <- "(* This is not a comment *)";
	}};
};


(*
	*nested comment having EOF in between
	(*
		*Reports Error "EOF in comment"