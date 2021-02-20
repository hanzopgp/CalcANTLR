package TP4;

import java.io.*;
import org.antlr.v4.runtime.*;


public class MainCalculette {
    public static void main(String args[]) throws Exception {
        CalculetteLexer lex;
        if (args.length == 0) 
            lex = new CalculetteLexer(CharStreams.fromStream(System.in));
        else 
            lex = new CalculetteLexer(CharStreams.fromFileName(args[0]));
            
        CommonTokenStream tokens = new CommonTokenStream(lex);
        
        CalculetteParser parser = new CalculetteParser(tokens);
        try {
            parser.start();    // start l'axiome de la grammaire 
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
}