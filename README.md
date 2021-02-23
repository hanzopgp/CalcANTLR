# CalcANTLR

## Presentation

>This is a calculator language compiler done with ANTLR and a stack machine.

## How does it work

>I'm using ANTLR to generate a java lexer and parser with a grammar file. The "calculator language" is made of numbers, operators, spaces, brackets... The purpose of the grammar I've built is to translate the calculator language into stack machine language. We can then run this stack machine language (which looks like assembly but without register) using the stack machine in src/stackmachine folder.

## Commands

### General commands :

- Export classpath :
>export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
- Use ANTRL to generate lexer and parser java files :
>java org.antlr.v4.Tool <your_grammar>.g4 
- Build all the java files :
>javac \*.java 
- Run java program if you use a main instead of TestRig or grun :
> java <your_main_class>
- Test your grammar quickly : 
>java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule>
- Test it and show tree :
>java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule> -gui
- Test it and show tokens :
>java org.antlr.v4.runtime.misc.TestRig <your_grammar> "tokens" -tokens
- Test the grammar and put the output in a file :
>java org.antlr.v4.runtime.misc.TestRig <your_grammar> <start_rule> > <file_name>.mvap
- Signal you are done writing your test :
>CTRL+D

### Stack machine commands :

- Build stack machine code :
> java MVAPAssembler -d <your_stackmachine_file>.mvap
- Run stack machine code :  
> java CBaP <your_stackmachine_file>.mvap.cbap

### Scripts :

If you want to easily test, go into Project/src and use the 2 first scripts.
Then go in Project/stackmachine and use the test_mvap.sh script.

- Build new grammar :
> bash build_grammar.sh
- Run a test, display the result and put the output in a mvap file :
> bash test_grammar.sh
- Run .mvap file :
> bash test_mvap.sh