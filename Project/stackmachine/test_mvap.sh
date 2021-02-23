export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
cp ../src/perso_test.mvap .
java MVaPAssembler -d perso_test.mvap
java CBaP -d perso_test.mvap.cbap
