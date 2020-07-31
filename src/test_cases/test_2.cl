(*
* testfile for valid and invalid single line comments and invalid characters
* Along with some simple errors
* in Cool programming language
*)

claSs MAin { --the keywords except true and false are case insensitive.
    flag : Bool
    main():IO {{
        --This is a valid comment

        flag <- True; --here True is identified as typeID rather than bool_const (the keywords true and false are case sensitive).

        -This is not a valid comment

        ! \ --error tokens

    }};
};
--This is also a valid comment even if it has EOF.