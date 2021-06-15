package SolutionFiles;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionSample {


    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        int result = SolutionSample.getGCD(2, "1A 2F 1C");
        System.out.println("the result is: " + result);
    }

    static int getGCD(int N, String S) {

        int totalSteats = 10;
        int possibleWays = 0;

        List<String> possibleSeatCombo = new ArrayList<>();
        possibleSeatCombo.add("BCDE");
        possibleSeatCombo.add("FGHJ");
        possibleSeatCombo.add("DEFG");

        if (!S.isEmpty()) {
            String[] occupiedSeats = S.split(" ");
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(i, possibleSeatCombo);
            }

            //[1A, 2B]
            String[] seatsBooked = S.split(" ");
            for (String seat : seatsBooked) {
                int rowNum = Integer.parseInt(seat.substring(0, 1)) - 1;
                String seatLetter = seat.substring(1, 2);

                for (int i = 0; i < map.get(rowNum).size(); i++) {

                    map.get(rowNum).remove(validateMapHasLetter(map.get(rowNum), seatLetter));

                }


//                        map.get(rowNum).stream().filter(combos -> !combos.contains(seatLetter)).collect(Collectors.toList()));
            }
            System.out.println(map);
        } else {
            return 2 * N;
        }

        return possibleWays;
    }

    private static Integer validateMapHasLetter(List<String> string, String seatLetter) {
        for (int i = 0; i < string.size(); i++) {
            if (string.get(i).contains(seatLetter)) {
                return i;
            }
        }

        return 0;
    }

    private static int getIndex(List<String> string, String seatsInARow) {


        for (int i = 0; i < string.size(); i++) {
            if (string.get(i).contains(seatsInARow)) {
                return i;
            }
        }
        return 0;
    }
}
