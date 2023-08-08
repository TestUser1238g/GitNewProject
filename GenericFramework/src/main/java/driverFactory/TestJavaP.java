package driverFactory;

import java.util.ArrayList;

public class TestJavaP {
	
public static void main(String args[]) {
	
	
	String[] strings = { "sandyaswaraj", "a,b,bas,ball,base,cat,swarajd,sandyad,zzzz" };

    String[] words = strings[1].split(",");

    String longestConcatenation = "";
    
    for (String word1 : words) {
        for (String word2 : words) {
        	
            if (strings[0].equals(word1 + word2)) {
                String concatenation = word1 + "," + word2;
                
                if (concatenation.length() > longestConcatenation.length()) {
                	
                	longestConcatenation = concatenation;
                }
                
            }
            
        }
    }
    
    System.out.println("Longest concatenation: " + longestConcatenation);
    
    	
}
}
