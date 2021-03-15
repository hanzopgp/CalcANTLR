echo "<-------------------TESTING MVAP CODE---------------------->"
export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
cd ..
cp mvap_output/perso_test.mvap ../stackmachine
cd ../stackmachine
java MVaPAssembler perso_test.mvap
java CBaP -d perso_test.mvap.cbap
