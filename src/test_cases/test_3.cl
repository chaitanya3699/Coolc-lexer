(*
* testfile for valid and invalid strings
* in Cool programming language
*)

class Main {
    main():IO{{
        --valid string
        "A valid string constant";

        --unterminated string
        "This is an invalid string\";

        --another valid string
        "(* This is not a comment *)"

        --unterminated string, lexing resumes from line 19
        "\"

        --no error
        "\a\c\d\e\g\h\i\j\k\l\m\o\p\q\r\s\u\v\w\x\y\z\1\2\3\4\5\6\7\8\9\0\-\=\+\_\)\(\*\&\^\%\$\#\@\`\~\)\:\;\'\{\}\[\]\,\.\<\>\/\?"

        --no error
        "string having\
        multiple escaped\
        newlines\
        "

        --unterminated string, lexing resumes from line 31
        "string having
        unescaped
        newlines
        "  --unterminated string, lexing resumes from line 34

        --unterminated string (line 38), lexing resumes from line 39
        "string having\\\"\
        multiple\\\\\
        backslashes\\
    }};
};

--EOF in string
"