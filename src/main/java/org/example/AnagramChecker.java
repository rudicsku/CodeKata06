package org.example;

import java.util.*;

public class AnagramChecker {

    public boolean isAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    public List<List<String>> printAnagrams(List<String> list) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            // convert to char array, sort and then re-convert to string
            String word = list.get(i);
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            // calculate hashcode of string after sorting
            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                // Adding a word for a specific hashcode
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        // Print all the values where size > 1. If we want to print non-anagrams, change to size = 1
        /*for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1) {
                System.out.print(values);
            }
        }*/

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : map.entrySet()) {
            if (entrySet.getValue().size() > 1) {
                List<String> temp = new ArrayList<>();
                temp.add(entrySet.getKey());
                temp.addAll(entrySet.getValue());
                result.add(temp);
            }
        }
        return result;
    }

}


