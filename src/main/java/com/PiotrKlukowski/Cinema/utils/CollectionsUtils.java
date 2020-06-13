package com.PiotrKlukowski.Cinema.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;

public class CollectionsUtils {
    public static <T> T getRandomElement(Collection<T> collection) {
        int size = collection.size();
        if (size == 0) { return null; }
        int index = (int)(Math.random() * size);
        Iterator<T> iterator = collection.iterator();
        IntStream.range(0,index).forEach(number -> iterator.next());
        return iterator.next();
    }
}
