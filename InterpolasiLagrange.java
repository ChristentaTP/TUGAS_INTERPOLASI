/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interpolasilagrange;

/**
 *
 * @author chris
 */
public class InterpolasiLagrange {
    public static double lagrangeInterpolation(double[] x, double[] y, double value) {
        double result = 0.0;
        int n = x.length;
        
        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (value - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};
        double value = 20.0; //ini yang kita isi valuenya
        
        double interpolatedValue = lagrangeInterpolation(x, y, value);
        System.out.println("Interpolated value at " + value + " is: " + interpolatedValue);
    }
}
