package com.mycompany.distribution;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Aquarius
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getInt(int a, int b) {
        do {
            try {
                int x = Integer.parseInt(sc.next());
                if (a <= x && x <= b) {
                    return x;
                } else {
                    System.out.print("Invalid number! Please try again: ");
                }
            } catch (Exception e) {
            }
        } while (true);
    }
}
