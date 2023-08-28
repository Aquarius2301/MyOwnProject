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
     * @param isEquals true: greater than or equals to a, false: greater than a
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
     * @param isEquals true: less than or equals to a, false: less than a
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
     * @param a         the min integer
     * @param b         the max integer
     * @param isEqualsA true: greater than or equals to a, false: greater than a
     * @param isEquals  true: less than or equals to b, false: less than b
     * @param mes       the message if the user inputs invalid value
     * @return an integer that statisfied with the condition
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

    /**
     * To input a string
     * 
     * @param acceptEmpty accept an empty string (blank)
     * @param mes         the message if the user inputs invalid value
     * @return a string (if there are some spaces at the beginning or the end, there will be removed automatically)
     */
    public static String readString(boolean acceptEmpty, String mes) {
        do {
            String s = sc.nextLine().trim();
            if (!acceptEmpty && s.equals("")) {
                System.out.print(mes);
            } else
                return s;
        } while (true);
    }

    /**
     * To input a string with length
     * 
     * @param len the length of the string
     * @param mes the message if the user inputs invalid value
     * @return a string with the length = len (Not count the space at the beginning and the end)
     * @throws Exception if len <= 0
     */
    public static String readStringLength(int len, String mes) throws Exception {
        if (len > 0) {
            throw new Exception("The length of the string must be greater than 0");
        }
        do {
            String s = readString(false, mes);
            if (s.length() != len) {
                System.out.print(mes);
            } else
                return s;
        } while (true);
    }

    public static void main(String[] args) {
        String mes = "Error! Please try again: ";
        System.out.print("Read: ");
        readString(true, mes);
    }

}
