export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
bash reset.sh
bash build_grammar.sh
bash build_util.sh
bash test_grammar.sh
