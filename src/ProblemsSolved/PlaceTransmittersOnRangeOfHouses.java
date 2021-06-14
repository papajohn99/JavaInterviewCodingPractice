package ProblemsSolved;

import java.util.Arrays;

/**
 * How many Transmitters needs to be placed on house locations based on radius towards right side.
 * <p>
 * For example, if radius is 2 then houses starting from 1 will cover houses number 2 and 3. but will not cover 4 and above.
 * <p>
 * So write a program that will count transmitters needed to cover all of the house locations to the right side direction in the array.
 */
public class PlaceTransmittersOnRangeOfHouses {
    public static void main(String args[]) throws Exception {
        PlaceTransmittersOnRangeOfHouses s = new PlaceTransmittersOnRangeOfHouses();

        int[] houses = new int[]{1, 4, 2, 5, 3};

        int radius = 0;

        radius = 1;
        System.out.println(Arrays.toString(houses));
        int numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 3);

        radius = 2;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 2);


        houses = new int[]{7, 2, 4, 6, 5, 9, 12, 11};

        radius = 2;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 3);

        radius = 3;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 2);

    }

    // 2 5 7 15 16
    public int findNumberOfTransmitters(int[] houses, int radius) {

        int transmitter = 0;
        int i = 0;

        while (i < houses.length) {
            // putting transmitter on house.
            transmitter++;
            int j = i + 1;
            while (j < houses.length && j - i <= radius) {
                j++;
            }
            i = j;
        }
        return transmitter;
    }
}