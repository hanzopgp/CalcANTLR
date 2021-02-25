export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
java org.antlr.v4.Tool -o antlr_output/ Calculette.g4
javac -d build/ antlr_output/*.java

