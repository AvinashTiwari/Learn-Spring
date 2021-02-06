package maxchar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxCharSol1 {
    public static void main(String[] args) {
        printMaxOccurringChar("Java Concept Of The Day");
    }
    private static void printMaxOccurringChar(String inputString) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] charArray = inputString.replaceAll("\\s+", "").toCharArray();

        for (char c : charArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        System.out.println(charCountMap);
        int maxValueInMap=(Collections.max(charCountMap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }
    }
}
