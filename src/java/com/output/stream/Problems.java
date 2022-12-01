package com.output.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problems {

    public static void main(String[] args) {
        Stream<double[]> HackValue = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a,10)
                .mapToObj(
                        b -> new double[] {a,b, Math.sqrt(a*a + b*b)})
                .filter(t -> t[2] % 1 == 0));
        HackValue.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


        List<String> languages = Arrays.asList("John", "ben", "bob", "mike", "john");
        Map<String, Integer> languagesLength = languages.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(languagesLength);
    }
}
