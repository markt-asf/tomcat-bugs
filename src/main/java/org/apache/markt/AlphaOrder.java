package org.apache.markt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaOrder {

    /*
     * Confirm Java's view on alphabetical order
     */
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("t-10");
        l.add("t--8");

        Collections.sort(l);

        for (String s : l) {
            System.out.println(s);
        }
    }
}
