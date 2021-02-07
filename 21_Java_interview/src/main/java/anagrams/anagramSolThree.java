package anagrams;

import static anagrams.anagramSolTwo.isAnagramMultiset;

public class anagramSolThree {
    public static void main(String[] args) {
        System.out.println(isLetterBasedAnagramMultiset("Hello", "elloH"));
    }

    static String preprocess(String source) {
        return source.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

   static boolean isLetterBasedAnagramMultiset(String string1, String string2) {
        return isAnagramMultiset(preprocess(string1), preprocess(string2));
    }
}
