(*
* testfile for valid and invalid strings
* in Cool programming language
*)

class Main {
    main():IO{{

        --valid string
        "";

        --error "String contains null character"
        "This string has \n \t   \f \b \" \\ null character";

        --another valid string
        "It is also\"a valid string";

        --error "String contains null character" as null comes first, lexing resumes from 21
        "It also has a\
        null   character\\
        and unterminated too"  --unterminated 

        --error "Unterminated string constant" as null comes after this, lexing resumes from 26
        "It also has a\
        null character\\
          and unterminated too" --unterminated

        --if string having multiple null characters, Error "String contains null character", lexing resumes from 33
        "This has\
          multiple\
        null   characters\
        "
    }};
};

--error "String contains null character" as null comes before EOF
" It has null   and file ends after this