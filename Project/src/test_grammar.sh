echo "<-----------------ENTER CALCULATOR CODE-------------------->"
echo "<------------------(CTRL+D WHEN DONE)---------------------->"
export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
cd build/
cat ../tests/calculator_test_file.txt | java MainCalculette > ../mvap_output/perso_test.mvap
echo "<------------------SHOWING CALCULATOR CODE----------------->"
echo "<---------------TRANSLATING IT INTO MVAP FILE-------------->"
cat ../mvap_output/perso_test.mvap

