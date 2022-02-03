package org.apache.markt;

import java.security.Security;
import java.util.Set;

public class SupportedSecurityAlgorithms {

    public static void main(String[] args) {
        Set<String> algorithmNames = Security.getAlgorithms("SecureRandom");
        for (String algorithmName : algorithmNames) {
            System.out.println(algorithmName);
        }
    }
}
