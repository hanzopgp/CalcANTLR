echo "<------------READING INPUT CALCULATOR LANGUAGE------------->"
export CLASSPATH=".:/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH"
cd build/
cat ../tests/calculator_test_file.txt | java MainCalculette > ../mvap_output/perso_test.mvap
echo "<---------------TRANSLATING IT INTO MVAP FILE-------------->"
echo "<------------------SHOWING CALCULATOR CODE----------------->"
cat ../mvap_output/perso_test.mvap

