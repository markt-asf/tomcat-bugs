package org.apache.markt;

public class Overflow {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - Integer.MAX_VALUE);
        System.out.println((Integer.MIN_VALUE + 10) - (Integer.MAX_VALUE - 10));
    }
}
