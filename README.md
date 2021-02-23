# CalcANTLR

## Presentation

>This is a calculator language compiler done with ANTLR for my Language Theory / Compiler classes.

## How does it work

>I'm using ANTLR to generate a java lexer and parser with a grammar file. The "calculator language" is made of numbers, operators, spaces, brackets... The purpose of the grammar I've built is to translate the calculator language into stack machine. We can then run this stack machine language (which looks like assembly but without register).

## Commands

### General commands :

- Export classpath to make sure you run everything on same version :
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

### Stack machine commands :

