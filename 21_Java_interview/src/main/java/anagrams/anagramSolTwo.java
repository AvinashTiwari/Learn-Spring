package anagrams;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class anagramSolTwo {

    public static void main(String[] args) {
        System.out.println(isAnagramMultiset("hello", "ellho"));
    }

    static  boolean isAnagramMultiset(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        for (int i = 0; i < string1.length(); i++) {
            multiset1.add(string1.charAt(i));
            multiset2.add(string2.charAt(i));
        }
        return multiset1.equals(multiset2);
    }
}
