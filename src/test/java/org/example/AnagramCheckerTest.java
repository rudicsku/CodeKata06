package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramCheckerTest {

    private final AnagramChecker anagramChecker = new AnagramChecker();

    private final List<String> stringList = ReadFromFile.readFromFile("/Users/HU900849/Desktop/CodeKata/CodeKata-06/src/main/resources/wordlist.txt");

    @Test
    void isAnagramTest() {
        //Arrange
        String str1 = "abcd";
        String str2 = "bcad";

        //Act
        boolean actualBoolean = anagramChecker.isAnagram(str1, str2);

        //Assert
        assertTrue(actualBoolean);
    }

    @RepeatedTest(10)
    @Test
    void printAnagramsTest() {
        //Arrange
        Random random = new Random();

        //Act
        List<List<String>> result = anagramChecker.printAnagrams(stringList);
        int randomSize = random.nextInt(result.size());


        //Assert
        List<String> randomList = result.get(randomSize);
        int randomElement1 = random.nextInt(randomList.size());
        int randomElement2 = random.nextInt(randomList.size());

        System.out.println(randomList.get(randomElement1));
        System.out.println(randomList.get(randomElement2));

        assertTrue(anagramChecker.isAnagram(randomList.get(randomElement1), randomList.get(randomElement2)));
    }
}