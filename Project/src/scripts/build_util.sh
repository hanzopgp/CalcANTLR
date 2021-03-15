echo "<---------------BUILDING UTIL JAVA FILES------------------->"
cd ..
cp antlr_output/*.java util/
javac -d build/ util/*.java
rm util/Calculette*
