/**
 * Program that calculates an electricity bill based on:
 * units consumed, payment delay penalty, and possible discount.
 */
package com.crashcourse.tasks;

import java.util.Scanner;

public class ElectricityBill {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter units: ");
        int units = input.nextInt();
        System.out.print("Enter payment delay: ");
        int delay = input.nextInt();
        double bill = calculateBill(units, delay);
        System.out.println("Total bill: " + bill);
    }

    public static double calculateBill(int units, int delay) {
        double total;
        if (units <= 100) {
            total = units * 5;
        } else if (units <= 300) {
            total = 100 * 5 + (units - 100) * 8;
        } else {
            total = 100 * 5 + 200 * 8 + (units - 300) * 12;
        }

        if (delay > 10) {
            total *= 1.2;
        } else if (delay > 5) {
            total *= 1.1;
        } else if (delay > 0) {
            total *= 1.05;
        }

        if (total > 5000) {
            total -= 500;
        }
        return total;
    }

}
