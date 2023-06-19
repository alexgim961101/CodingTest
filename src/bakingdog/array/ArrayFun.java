package bakingdog.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 자바 배열 함수 정리
 * 1). Array.asList(array);
 * 2). toString(array);
 * 3). Arrays.sort(array);
 * 4). Arrays.copyOf(array)
 * */
public class ArrayFun {
    public static void main(String[] args) {
        // 1. asList(array);
        String[] strArr = {"alexgim", "apple", "acv", "scv", "bbb"};
        List<String> strList = Arrays.asList(strArr);
        System.out.println(strList.toString());

        System.out.println("==============================================");

        // 2. Arrays.toString(array)
        String string = Arrays.toString(strArr);
        System.out.println(string);

        System.out.println("==============================================");

        // 3. Arrays.sort(array, Comparator)
        Arrays.sort(strArr);
        Arrays.sort(strArr, Collections.reverseOrder());

        System.out.println("==============================================");

        // 4. Arrays.copyOf()
        String[] strings = Arrays.copyOf(strArr, 2);
        for(String str : strings) {
            System.out.println(str);
        }
    }

    static class Car implements Comparable<Car>{
        String name;
        int price;

        @Override
        public int compareTo(Car o) {
            return this.price - o.price;
        }
    }
}
