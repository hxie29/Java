//Testing my hash map
package c27_Hashing;

public class E27L03 {
    public static void main(String[] args) {
        // Create a map
        MyMap<String, Integer> map = new MyHashMap<>(100, 0.75f);
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
//        map.put("Smith", 65);

        System.out.println("Entries in map: " + map);

        System.out.println("The age for " + "Lewis is " + map.get("Lewis"));

        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        System.out.println("Is age 33 in the map? " + map.containsValue(33));

        map.remove("Smith");
        System.out.println("Entries in map: " + map);

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
