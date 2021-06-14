package ProblemsSolved;

import java.util.*;
import java.text.ParseException;
import java.util.stream.Collectors;

public class FourSeasonHighestAmplitudeOfTemperature {


    private static final String WINTER = "WINTER";
    private static final String AUTUMN = "AUTUMN";
    private static final String SUMMER = "SUMMER";
    private static final String SPRING = "SPRING";
    private static final String COLON_SEPARATOR = ": ";

    public static void main(String[] args) throws ParseException {

        int[] arg2 = {-3, -14, -5, 7, 8, 42, 8, 3};
        int[] arg1 = {2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18};

        System.out.println("+++++++++++ method 1 +++++++++++++");
        methodOne(arg2, arg1);

        System.out.println("+++++++++++ method 2 +++++++++++++");
        methodTwo(arg2, arg1);
    }

    private static void methodOne(int[] arg2, int[] arg1) throws ParseException {
        FourSeasonHighestAmplitudeOfTemperature solution = new FourSeasonHighestAmplitudeOfTemperature();
        System.out.println("Answer for " + arrayToList(arg2) + " is : " + solution.solution(arg2));
        System.out.println("Answer for " + arrayToList(arg1) + " is : " + solution.solution(arg1));
    }

    private static List<Integer> arrayToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static void methodTwo(int[] arg2, int[] arg1) {
        System.out.print("Answer for " + arrayToList(arg2) + " is : ");
        System.out.println(new TemperatureHistory(arg2).getHighestAmplitudeSeason());
        System.out.print("Answer for " + arrayToList(arg1) + " is : ");
        System.out.println(new TemperatureHistory(arg1).getHighestAmplitudeSeason());
    }

    private String solution(int[] arr) throws ParseException {
        List<Integer> list = arrayToList(arr);
        int numberOfDays = list.size() / 4;
        List<Integer> winter = list.subList(0, numberOfDays);
        List<Integer> spring = list.subList(numberOfDays, numberOfDays * 2);
        List<Integer> summer = list.subList(numberOfDays * 2, numberOfDays * 3);
        List<Integer> autumn = list.subList(numberOfDays * 3, numberOfDays * 4);

        System.out.println(WINTER + COLON_SEPARATOR + winter);
        System.out.println(SPRING + COLON_SEPARATOR + spring);
        System.out.println(SUMMER + COLON_SEPARATOR + summer);
        System.out.println(AUTUMN + COLON_SEPARATOR + autumn);

//        TreeMap<Integer, String> seasonAmplitude = new TreeMap<>(Collections.reverseOrder());  //seasonAmplitude.firstEntry().getValue()
        TreeMap<Integer, String> seasonAmplitude = new TreeMap<>();                            //seasonAmplitude.lastEntry().getValue();
        seasonAmplitude.put(getAmplitude(winter), WINTER);
        seasonAmplitude.put(getAmplitude(spring), SPRING);
        seasonAmplitude.put(getAmplitude(summer), SUMMER);
        seasonAmplitude.put(getAmplitude(autumn), AUTUMN);

        return seasonAmplitude.lastEntry().getValue();

    }

    private int getAmplitude(List<Integer> data) {
        return Collections.max(data) - Collections.min(data);

    }

}

class TemperatureHistory {
    private List<Integer> temperatures;
    private Winter winter;
    private Spring spring;
    private Summer summer;
    private Autumn autumn;
    private TreeMap<Integer, Season> seasonAmplitude = new TreeMap<>();

    TemperatureHistory(int[] arr) {
        arrayToList(arr);
        initSeasons(getDaysInASeason());
        mapSeasons();

    }

    private void arrayToList(int[] arr) {
        temperatures = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private void initSeasons(int numberOfDays) {
        winter = new Winter(temperatures, numberOfDays);
        spring = new Spring(temperatures, numberOfDays);
        summer = new Summer(temperatures, numberOfDays);
        autumn = new Autumn(temperatures, numberOfDays);

    }

    private int getDaysInASeason() {
        return temperatures.size() / 4;
    }

    private void mapSeasons() {
        seasonAmplitude.put(winter.getAmplitude(), winter);
        seasonAmplitude.put(spring.getAmplitude(), spring);
        seasonAmplitude.put(summer.getAmplitude(), summer);
        seasonAmplitude.put(autumn.getAmplitude(), autumn);

    }

    String getHighestAmplitudeSeason() {
        return seasonAmplitude.lastEntry().getValue().toString();

    }

    abstract class Season {
        static final String WINTER = "WINTER";
        static final String AUTUMN = "AUTUMN";
        static final String SUMMER = "SUMMER";
        static final String SPRING = "SPRING";
        List<Integer> data;

        Season(List<Integer> dataSet, int numberOfDays, int order) {
            data = dataSet.subList(numberOfDays * (order - 1), numberOfDays * order);
        }

        int getAmplitude() {
            return Collections.max(data) - Collections.min(data);

        }
    }

    class Winter extends Season {
        Winter(List<Integer> dataSet, int numberOfDays) {
            super(dataSet, numberOfDays, 1);
        }

        @Override
        public String toString() {
            return WINTER;
        }
    }

    class Spring extends Season {
        Spring(List<Integer> dataSet, int numberOfDays) {
            super(dataSet, numberOfDays, 2);
        }

        @Override
        public String toString() {
            return SPRING;
        }
    }

    class Summer extends Season {
        Summer(List<Integer> dataSet, int numberOfDays) {
            super(dataSet, numberOfDays, 3);
        }

        @Override
        public String toString() {
            return SUMMER;
        }
    }

    class Autumn extends Season {
        Autumn(List<Integer> dataSet, int numberOfDays) {
            super(dataSet, numberOfDays, 4);
        }

        @Override
        public String toString() {
            return AUTUMN;
        }
    }
}

/* My code -
*  public static void main(String[] args) {

        int[] arg2 = {-3, -14, -5, 7, 8, 42, 8, 3};
        int[] arg1 = {2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18};
        SolutionSample s = new SolutionSample();
        System.out.println(s.someMethod(arg2));
    }

    public String someMethod(int[] args) {
        String[] totalSeasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
        int monthsInSeason = args.length / totalSeasons.length;

        int i = 0;
        List<int[]> arr = new ArrayList<>();
        arr.subList(0,3);
        Map<String, int[]> map = new HashMap<>();
        for (int x = 0; x < totalSeasons.length; x++) {
            int counter = 0;
            int[] sA = new int[monthsInSeason];
            while (counter < monthsInSeason) {
                sA[counter] = args[i];
                i++;
                counter++;
            }
            arr.add(sA);
            map.put(totalSeasons[x], sA);
        }

        Map<Integer, String> map2 = new TreeMap<>();
        map.forEach((key, value) ->
                map2.put(Arrays.stream(value).reduce((acc, n) -> acc > n ? acc : n).getAsInt()
                        - Arrays.stream(value).reduce((acc, n) -> acc < n ? acc : n).getAsInt(), key)
        );

        System.out.println(map2.keySet().stream().reduce((l, k) -> l > k ? l : k).get());

        map2.entrySet().stream().filter(entry ->
                entry.getKey() == Collections.max(map2.keySet()));
        return null;
    }*/
