package com.PiotrKlukowski.Cinema.unitTests.utils;

import com.PiotrKlukowski.Cinema.utils.CollectionsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionsUtilsTest {

    private static final Integer NUMBER_OF_SUB_TESTS_IN_NOT_EMPTY_COLLECTION_TEST = 1000;

    @Test
    public void testEmptyCollection() {
        Set<Integer> testSet = new HashSet<>();
        Assertions.assertNull(CollectionsUtils.getRandomElement(testSet));
    }

    @Test
    public void checkNoCrashesWithCollection() {
        List<Integer> testList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        HashMap<Integer, Integer> histogram = new HashMap<>() {{
            testList.forEach(number -> put(number, 0));
        }};
        IntStream.range(0, NUMBER_OF_SUB_TESTS_IN_NOT_EMPTY_COLLECTION_TEST).forEach(index -> {
            Integer randomElement = CollectionsUtils.getRandomElement(testList);
            histogram.put(randomElement, histogram.get(randomElement) + 1);
        });
        histogram.forEach((element, occurrences) -> Assertions.assertTrue(occurrences > 0));
    }
}
