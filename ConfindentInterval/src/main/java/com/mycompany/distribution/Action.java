package com.mycompany.distribution;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Aquarius
 */
public class Action {

    private int n;
    private double mean, var, stdev, CI, alpha;

    File file = new File("input.txt");

    public Action() {
    }

    public void menu() throws IOException {
        createFile(file);
        System.out.println("\nFind Confident Interval");
        System.out.println("1. Population");
        System.out.println("2. Sample");
        int choose1 = Validation.getInt(1, 2);

        if (choose1 == 1) {
            System.out.println("\nChoose an option");
            System.out.println("1. Value of elements known");
            System.out.println("2. Mean, Variance,... known");
            int choose2 = Validation.getInt(1, 2);
            if (choose2 == 1) {
                readFileOption1(true);
            } else {
                readFileOption2();
            }
            printOut1(n, mean, var, stdev, CI);
        } else {
            System.out.println("\nChoose an option");
            System.out.println("1. Value of elements known");
            System.out.println("2. Mean, Variance,... known");
            int choose2 = Validation.getInt(1, 2);
            if (choose2 == 1) {
                readFileOption1(false);
            } else {
                readFileOption2();
            }
            printOut2(n, mean, var, stdev, CI);
        }
    }

    private void createFile(File file) {
        try {
            if (!file.exists()) {
                System.out.println("File input.txt is not existed! Creating new one...");
                file.createNewFile();
                System.out.println("Done!");
            }
        } catch (Exception e) {
            System.out.println("There are some error!");
        }
    }

    private void readFileOption1(boolean ok) throws IOException {
        Scanner sc = new Scanner(file);
        n = Integer.parseInt(sc.next());
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(sc.next());
        }
        mean = findMean(a);
        var = findVariance(a, mean, ok);
        stdev = Math.sqrt(var);
        CI = Double.parseDouble(sc.next());
        alpha = 1 - (CI / 100);
    }

    private void readFileOption2() throws IOException {
        Scanner sc = new Scanner(file);
        n = Integer.parseInt(sc.next());
        mean = Double.parseDouble(sc.next());
        var = Double.parseDouble(sc.next());
        stdev = Math.sqrt(var);
        CI = Double.parseDouble(sc.next());
        alpha = 1 - (CI / 100);
    }

    private void printOut1(int n, double mean, double var, double stdev, double CI) {
        System.out.println("--- Result ---");
        System.out.println("Number of element(s): " + n);
        System.out.println("Population mean: " + mean);
        System.out.println("Population variance: " + var);
        System.out.println("Population standard deviation: " + stdev);
        System.out.println("Confident Interval: " + CI + "%");
        System.out.println("Lower Bound: " + Distribution.getZLower(mean, stdev, alpha / 2, n));
        System.out.println("Upper Bound: " + Distribution.getZUpper(mean, stdev, alpha / 2, n));

    }

    private void printOut2(int n, double mean, double var, double stdev, double CI) {
        System.out.println("--- Result ---");
        System.out.println("Number of element(s): " + n);
        System.out.println("Sample mean: " + mean);
        System.out.println("Sample variance: " + var);
        System.out.println("Sample standard deviation: " + stdev);
        System.out.println("Confident Interval: " + CI + "%");
        System.out.println("Lower Bound: " + Distribution.getTLower(mean, stdev, alpha / 2, n));
        System.out.println("Upper Bound: " + Distribution.getTUpper(mean, stdev, alpha / 2, n));

    }

    private double findMean(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    private double findVariance(double[] a, double mean, boolean ok) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - mean) * (a[i] - mean);
        }
        return ok ? (sum / a.length) : (sum / (a.length - 1));
    }
}
