export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
cd build/
java MainCalculette > ../mvap_output/perso_test.mvap
cat ../mvap_output/perso_test.mvap

