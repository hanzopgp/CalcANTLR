# CalcANTLR

## Table of contents

1. [Presentation](#presentation)
2. [How does it work](#how-does-it-work)
3. [Commands](#commands)
4. [Links](#links)

## Presentation

>This is a calculator language compiler done with ANTLR and a stack machine.

## Details

### ToDo

- General tests
- Add features

### Doing

### Done

- ANTLR basic use
- Basic calcul grammar
- Calcul priority / Negative numbers
- Parenthesis
- Integur variables
- Write / Read
- While loop
- Blocks (sequence of instructions)
- If statement
- Relational operators
- Else statement
- Logical operators
- For loop
- Repeat until loop
- Syntaxic analysis of functions
- Float numbers

## How does it work

>I'm using ANTLR to generate a java lexer and parser with a grammar file. The "calculator language" is made of numbers, operators, spaces, brackets... The purpose of the grammar I've built is to translate the calculator language into stack machine language. We can then run this stack machine language (which looks like assembly but without register) using the stack machine in src/stackmachine folder.

## Commands

### General commands :

- Export classpath :
`export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"`
- Use ANTRL to generate lexer and parser java files :
`java org.antlr.v4.Tool <your_grammar>.g4`
- Build all the java files :
`javac \*.java` 
- Run java program if you use a main instead of TestRig or grun :
`java <your_main_class>`
- Test your grammar quickly : 
`java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule>`
- Test it and show tree :
`java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule> -gui`
- Test it and show tokens :
`java org.antlr.v4.runtime.misc.TestRig <your_grammar> "tokens" -tokens`
- Test the grammar and put the output in a file :
`java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule> > <file_name>.mvap`
- Signal you are done writing your test :
`CTRL+D`
- Show binary code :
`od -t x4 --endian=big <file>.mvap.cbap`
`od -t d4 --endian=big <file>.mvap.cbap`

### Stack machine commands :

- Build stack machine code :
`java MVAPAssembler -d <your_stackmachine_file>.mvap`
- Run stack machine code :
`java CBaP <your_stackmachine_file>.mvap.cbap`

### Scripts :

- Does everything in one script : (the input file is in tests folder)
`bash do_all.sh`
- Does basicaly everything from building to test :
`bash build_all_and_test.sh`
- Reset everything :
`bash reset.sh`
- Build new grammar :
`bash build_grammar.sh`
- Build all util java files :
`bash build_util.sh`
- Run a test file, display the result and put the output in a mvap file : (the test file is in tests folder)
`bash test_grammar.sh`
- Run .mvap file :
`bash test_mvap.sh`

## Links

-  [Wikipedia language theory](https://en.wikipedia.org/wiki/Theory_of_language#:~:text=Theory%20of%20language%20is%20a,linguistics%20and%20philosophy%20of%20language.&text=Even%20though%20much%20of%20the,the%20researcher's%20opinion%20of%20language)
-  [Wikipedia stack machine](https://en.wikipedia.org/wiki/Stack_machine)
-  [Wikipedia compiler](https://en.wikipedia.org/wiki/Compiler)
-  [ANTLR](https://www.antlr.org/)
