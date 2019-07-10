package com.newcode.soluction;

import java.util.Scanner;

public class numbermood {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();

        }
        for (int i = 0; i < n; i++){
            int shi = array[i] % 10;
            int ge = array[i] / 10;
            int shiResult = array[i] / shi;
            int geResult = array[i] / ge;
            if (shiResult * shi == array[i]) {
                if (geResult * ge == array[i]) {
                    System.out.println('G');
                } else {
                    System.out.println('H');
                }
            } else {
                if (geResult * ge == array[i]) {
                    System.out.println('H');
                } else {
                    System.out.println('S');
                }
            }
        }

    }
}
