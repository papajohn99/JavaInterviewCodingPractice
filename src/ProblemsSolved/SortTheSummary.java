package ProblemsSolved;

import java.util.*;

public class SortTheSummary {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(3);
        l.add(1);
        l.add(2);
        l.add(1);
        l.add(0);
        l.add(0);
        System.out.println(some(l));
    }

    public static List<List<Integer>> some(List<Integer> list) {

        // ascending by keys
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer i : list) {
            if (!map.containsKey(i)) {
                int count = 1;
                map.put(i, count);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        List<List<Integer>> tl = new ArrayList<>();

        map.forEach((key, value) -> {
            List<Integer> nl = new ArrayList<>();
            nl.add(key);
            nl.add(value);
            tl.add(nl);
        });

        //Descending by values.
        tl.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1).intValue() == o2.get(1).intValue()) {
                    return 0;
                }

                if (o1.get(1).intValue() < o2.get(1).intValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return tl;

    }
}
