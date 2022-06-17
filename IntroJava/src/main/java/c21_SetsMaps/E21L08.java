package c21_SetsMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class E21L08 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 20);
        hashMap.put("Lewis", 10);
        hashMap.put("Cook", 40);
        System.out.println(hashMap);

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);
        treeMap.forEach((k,v) -> System.out.println(k + ": " + v));

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 20);
        linkedHashMap.put("Lewis", 10);
        linkedHashMap.put("Cook", 40);
        System.out.println(linkedHashMap);
        System.out.println("Age for Lewis is " + linkedHashMap.get("Lewis") );

    }
}
