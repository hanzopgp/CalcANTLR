echo "<---------------BUILDING UTIL JAVA FILES------------------->"
cp antlr_output/*.java util/
javac -d build/ util/*.java
rm util/Calculette*