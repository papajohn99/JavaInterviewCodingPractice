package ProblemsSolved;

import java.util.Arrays;

/**
 * How many Transmitters needs to be placed on house locations based on radius towards right side.
 * <p>
 * For example, if radius is 2 then houses starting from 1 will cover houses number 2 and 3. but will not cover 4 and above.
 * <p>
 * So write a program that will count transmitters needed to cover all of the house locations to the right side direction in the array.
 */
public class PlaceTransmittersOnRangeOfHousesLeftRight {
    public static void main(String args[]) throws Exception {
        PlaceTransmittersOnRangeOfHousesLeftRight s = new PlaceTransmittersOnRangeOfHousesLeftRight();

        int[] houses = new int[]{1, 4, 2, 5, 3};

        int radius = 0;

        radius = 1;
        System.out.println(Arrays.toString(houses));
        int numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 2);

        radius = 2;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 1);


        houses = new int[]

                {
                        7, 2, 4, 6, 5, 9, 12, 11
                }

        ;

        radius = 2;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 2);

        radius = 3;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 2);

        radius = 1;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 3);

        radius = 4;
        numberOfTransmitters = s.findNumberOfTransmitters(houses, radius);
        System.out.println(numberOfTransmitters + " equals " + 1);

    }


    // 1, 4, 2, 5, 3        7, 2, 4, 6, 5, 9, 12, 11
    public int findNumberOfTransmitters(int[] houses, int radius) {

        int transmitter = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < houses.length) {
            transmitter++; // if no houses found on the exact radius then place 1 transmitter to the remaining house.
            j = i + 1;
            while (j < houses.length && j - i <= radius || j - k <= radius) {

                // To count houses on the right side of the middle house.
                if (j - i == radius) {
                    k = j; // K is the house where transmitter will place.
                }

                j++;
            }

            i = j;
        }

        /* Alternate way !
        while (i < houses.length) {
            j = i + 1;
            transmitter++;
            while (j < houses.length && j - i <= radius) {
                if (j - i == radius) {
                    k = j;
                }
                j++;
            }
            while (j < houses.length && j - k <= radius) {
                j++;
            }
            i = j;
        }*/

        return transmitter;
    }

}
