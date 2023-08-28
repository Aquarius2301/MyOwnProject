/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readinput;

import java.util.Scanner;

/**
 *
 * @author Aquarius
 */
public class ReadInput {

    public static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer
     *
     * @param mes the message if the user inputs invalid value
     * @return an integer
     */
    public static int readInt(String mes) {
        do {
            try {
                int x = Integer.parseInt(sc.next());
                return x;
            } catch (NumberFormatException e) {
                System.out.print(mes);
            }
        } while (true);
    }

    /**
     * To input an integer is greater than a
     *
     * @param a        an integer
     * @param isEquals true: greater or equals to a, false: greater than a
     * @param mes      the message if the user inputs invalid value
     * @return an integer greater than or equals to a if isEquals = true, an
     *         integer greater than a if isEquals = false
     */
    public static int readIntGreaterThan(int a, boolean isEquals, String mes) {
        do {
            try {
                int x = Integer.parseInt(sc.next());
                if (isEquals && x >= a) {
                    return x;
                } else if (!isEquals && x > a) {
                    return x;
                } else {
                    System.out.print(mes);
                }
            } catch (NumberFormatException e) {
                System.out.print(mes);
            }
        } while (true);
    }

    /**
     * To input an integer is greater than a
     *
     * @param a        an integer
     * @param isEquals true: less or equals to a, false: less than a
     * @param mes      the message if the user inputs invalid value
     * @return an integer less than or equals to a if isEquals = true, an
     *         integer less than a if isEquals = false
     */
    public static int readIntLessThan(int a, boolean isEquals, String mes) {
        do {
            try {
                int x = Integer.parseInt(sc.next());
                if (isEquals && x <= a) {
                    return x;
                } else if (!isEquals && x < a) {
                    return x;
                } else {
                    System.out.print(mes);
                }
            } catch (NumberFormatException e) {
                System.out.print(mes);
            }
        } while (true);
    }

    /**
     * To input an integer from a to b
     *
     * @param a        the min integer
     * @param b        the max integer
     * @param isEquals true: less or equals to a, false: less than a
     * @param mes      the message if the user inputs invalid value
     * @return an integer less than or equals to a if isEquals = true, an
     *         integer less than a if isEquals = false
     */
    public static int readIntFrom(int a, int b, boolean isEqualsA, boolean isEqualsB, String mes) {
        do {
            try {
                int x = Integer.parseInt(sc.next());
                if (isEqualsA && x >= a && isEqualsB && x <= b) {
                    return x;
                } else if (isEqualsA && x >= a && isEqualsB && x < b) {
                    return x;
                } else if (!isEqualsA && x > a && isEqualsB && x <= b) {
                    return x;
                } else if (!isEqualsA && x > a && !isEqualsB && x < b) {
                    return x;
                } else {
                    System.out.print(mes);
                }
            } catch (NumberFormatException e) {
                System.out.print(mes);
            }
        } while (true);
    }

    public static void main(String[] args) {
        String mes = "Error! Please try again: ";
        System.out.print("Read: ");
        readIntLessThan(0, true, mes);
    }

}