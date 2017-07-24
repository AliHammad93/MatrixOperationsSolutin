/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progressoft.utilities;

/**
 *
 * @author Ali
 */
public class Main implements MatrixOperationsUtility {

    @Override
    public int[][] add(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        int[][] result = new int[a.length][a[0].length];

        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                {
                    for (int j = 0; j < a[i].length; j++) {

                        result[i][j] = a[i][j] + b[i][j];
                    }

                }
            }
            return result;

        }

        throw new IncompatibleArgumentsException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int[][] scalarMultiply(int scalar, int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = a[i][j] * scalar;

            }
        }
        return a;

    }

    @Override
    public int[][] transport(int[][] a) {
        
        int[][] result = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    @Override
    public int[][] multiply(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        if (a[0].length != b.length) {

            throw new IncompatibleArgumentsException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } else {

            int multiply[][] = new int[a.length][b[0].length];
            int sum = 0;
            for (int c = 0; c < a.length; c++) {
                for (int d = 0; d < b[0].length; d++) {
                    for (int k = 0; k < b.length; k++) {
                        sum = sum + a[c][k] * b[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }
            }
            return multiply;

        }
    }

}
