export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
java org.antlr.v4.Tool Calculette.g4 
javac *.java
