/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polinomnewton;

/**
 *
 * @author chris
 */
public class PolinomNewton {

    public static double[][] dividedDifferences(double[] x, double[] y) {
        int n = x.length;
        double[][] table = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            table[i][0] = y[i];
        }
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                table[i][j] = (table[i+1][j-1] - table[i][j-1]) / (x[i+j] - x[i]);
            }
        }
        
        return table;
    }

    public static double newtonInterpolation(double[] x, double[] y, double value) {
        double[][] table = dividedDifferences(x, y);
        double result = table[0][0];
        double term = 1.0;
        
        for (int i = 1; i < x.length; i++) {
            term *= (value - x[i-1]);
            result += table[0][i] * term;
        }
        
        return result;
    }

    public static void main(String[] args) {
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};
        double value = 12.0; // Isi value disini
        
        double interpolatedValue = newtonInterpolation(x, y, value);
        System.out.println("Interpolated value at " + value + " is: " + interpolatedValue);
    }
}