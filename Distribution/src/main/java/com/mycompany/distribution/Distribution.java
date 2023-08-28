/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.distribution;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.TDistribution;

/**
 *
 * @author khang
 */
public class Distribution {

    public static double getZScore(double alpha) {
        NormalDistribution normalDistribution = new NormalDistribution();
        return normalDistribution.inverseCumulativeProbability(1 - alpha);
    }

    public static double getTScore(int degreesOfFreedom, double alpha) {
        TDistribution tDistribution = new TDistribution(degreesOfFreedom);
        return tDistribution.inverseCumulativeProbability(1 - alpha);
    }

    public static double getZUpper(double mean, double stdev, double alpha, int n) {
        return mean + (getZScore(alpha) * stdev / Math.sqrt(n));
    }

    public static double getZLower(double mean, double stdev, double alpha, int n) {
        return mean - (getZScore(alpha) * stdev / Math.sqrt(n));
    }

    public static double getTUpper(double mean, double stdev, double alpha, int n) {
        return mean + (getTScore((n - 1), alpha) * stdev / Math.sqrt(n));
    }

    public static double getTLower(double mean, double stdev, double alpha, int n) {
        return mean - (getTScore(n - 1, alpha) * stdev / Math.sqrt(n));
    }
}
