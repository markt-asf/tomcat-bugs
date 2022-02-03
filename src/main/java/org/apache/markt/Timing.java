package org.apache.markt;


public class Timing {

    private static int REPEAT = 5;
    private static int LOOP = 1000000;

    public static void main(String[] args) {
        for (int i = 0; i < REPEAT; i++) {
            doTest();
        }
    }

    private static void doTest() {
        doCompare(0, 16);
        doCompare(8, 16);
        doCompare(16, 16);
    }

    private static void doCompare(int same, int length) {
        StringBuilder sb1 = new StringBuilder(length);
        StringBuilder sb2 = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            if (i < same) {
                sb1.append('b');
            } else {
                sb1.append('a');
            }
            sb2.append('b');
        }

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        long start = System.nanoTime();
        boolean result = true;
        for (int i = 0; i < LOOP; i++) {
            result = result & s1.equals(s2);
        }
        long end = System.nanoTime();

        System.out.println("Length [" + length + "], Same [" + same + "] took [" + (end-start) + "] ns");
    }
}
