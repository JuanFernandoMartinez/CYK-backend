package com.cyk.algorithm.model;

public class CYK {
    /**
     * Se declara las variables: tamaï¿½o = np, gramatica = grammer[][] y cadena que se recibe el lenguaje =str.
     */
    private int np = 0;
    private String[][] grammer;
    private String str;

    /**
     *
     * @param grammer grammar to be tested
     * @param str string to test
     */
    public CYK(String[][] grammer, String str) {
        this.grammer = grammer;
        this.str = str;
    }


    /**
     * @param a
     * @param b
     * @return
     */
    public String combinacion(String a, String b){
        String to_ret = "", temp = "";

        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){

                temp = "";
                temp += a.charAt(i) + "" +  b.charAt(j);
                to_ret += verificacion(temp);
            }
        }
        return to_ret;
    }

    /**
     * 				para poder hacer la verificaciï¿½n con la cadena Ademas de esto
     * 				arroja la respuesta que se necesita para los llamados.
     *
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public String fillMatrixAndAnswer() throws ArrayIndexOutOfBoundsException {
        String r;
        String st;
        String  start = "S";
        int count = 0;
        np = grammer.length;
        String respuesta = "";
        String matrizDeRespuestas[][] = new String[10][10];


        for(int i = 0; i < str.length(); i++){
            r = "";
            st = "" + str.charAt(i);
            System.out.println(st);

            for(int j = 0; j < np; j++){
                for(count = 1; count < grammer[j].length; count++){
                    if(grammer[j][count].equals(st)){
                        r += grammer[j][0];
                    }
                }
            }
            matrizDeRespuestas[i][i] = r;
        }

        //Esta parte del codigo se encarga del llenado de la matriz
        for(int i = 1; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                r = "";
                for(int k = j - i; k < j; k++){
                    r += combinacion(matrizDeRespuestas[j - i][k], matrizDeRespuestas[k + 1][j]);
                }
                matrizDeRespuestas[j - i][j] = r;
            }
        }

        //La ï¿½ltima columna de la primera fila debe tener el sï¿½mbolo de inicio, para asi poder verificarlo
        if(matrizDeRespuestas[0][str.length() - 1].indexOf(start) >= 0){
            respuesta = "Generates";
        }
        else{
            respuesta = "doesn't generate";
        }
        return respuesta;
    }

    //

    /**
     * @param a
     * @return
     */
    public String verificacion(String a){
        String to_ret = "";
        int count = 0;
        for(int i = 0; i < np; i++) {
            for(count = 0; count < grammer[i].length ; count++){
                if(grammer[i][count].equals(a)){
                    to_ret += grammer[i][0];
                }
            }
        }
        return to_ret;
    }

    /**
     *
     * @return
     */
    public int getNp() {
        return np;
    }

    /**
     *
     * @param np
     */
    public void setNp(int np) {
        this.np = np;
    }

    /**
     *
     * @return
     */
    public String[][] getGrammer() {
        return grammer;
    }

    /**
     *
     * @param grammer
     */
    public void setGrammer(String[][] grammer) {
        this.grammer = grammer;
    }

    /**
     *
     * @return
     */
    public String getStr() {
        return str;
    }

    /**
     *
     * @param str
     */
    public void setStr(String str) {
        this.str = str;
    }



}

