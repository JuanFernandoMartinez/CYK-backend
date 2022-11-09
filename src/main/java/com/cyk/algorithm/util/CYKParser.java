package com.cyk.algorithm.util;

public class CYKParser {
    public String[][] grammarParser(String g){
        System.out.println(g);
        String[] firstSplit;
        String[] secondSplit;
        String[] grammar = g.split("\n");
        int col = 0;

        String[][] matrix;

        for (String s : grammar) {

            firstSplit = s.split(":");
            secondSplit = firstSplit[1].split("\\|");
            col = secondSplit.length + 1;

        }

        matrix = new String[grammar.length][col];

        for (int i = 0; i < grammar.length; i++) {

            firstSplit = grammar[i].split(":");
            secondSplit = firstSplit[1].split("\\|");


            for(int n = 0; n < secondSplit.length+1;n++) {
                if(n == 0) {
                    matrix[i][n] = firstSplit[n];
                }else {
                    matrix[i][n] = secondSplit[n-1];
                }
            }



        }
        return matrix;


    }
}
