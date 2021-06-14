package ProblemsSolved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class HexColor {

    public static void main(String[] args) {
        System.out.printf("Expected: #FF6347 Actual: %s", hexColor(255, 99, 71));
        System.out.printf("Expected: #B8860B Actual: %s", hexColor(184, 134, 11));
        System.out.printf("Expected: #BDB76B Actual: %s", hexColor(189, 183, 107));
        System.out.printf("Expected: #0000CD Actual: %s", hexColor(0, 0, 205));

        System.out.printf("Expected: #3C444C Actual: %s", blend("#000000", "#778899"));
        System.out.printf("Expected: #DCB1D9 Actual: %s", blend("#E6E6FA", "#FF69B4", "#B0C4DE"));

    }

//   Given a list of hex color strings, produce the hex color string you get from averaging their RGB values together. You'll need to round channel values to integers.
    private static String blend(String... colors) {

        int size = colors.length;
        int red = 0;
        int green = 0;
        int blue = 0;

        for (String color : colors) {
            red = red + Integer.parseInt(color.substring(1, 3), 16);
            green = green + Integer.parseInt(color.substring(3, 5), 16);
            blue = blue + Integer.parseInt(color.substring(5, 7), 16);
        }
        return hexColor(red / size, green / size, blue / size);
    }


    // Given three integers between 0 and 255, corresponding to the red, green, and blue channel values of a color, find the hex string for that color.
    private static String hexColor(int r, int g, int b) {
        List<Integer> rgb = new ArrayList<>();

        if (r <= 255 && g <= 255 && b <= 255) {
            rgb.add(r);
            rgb.add(g);
            rgb.add(b);
            return getNumbersOfRGB(rgb);
        } else {
            return null;
        }
    }

    private static String getNumbersOfRGB(List<Integer> rgb) {

        String colorHex = "#";

        for (Integer num : rgb) {
            int rem = num % 16;
            int number = num / 16;
            colorHex = colorHex + getHexDecimal(number) + getHexDecimal(rem);
        }
        return colorHex;

    }

    private static String getHexDecimal(int number) {
        if (number >= 0 && number < 10) {
            return String.valueOf(number);
        }
        if (number == 10) {
            return "A";
        }
        if (number == 11) {
            return "B";
        }
        if (number == 12) {
            return "C";
        }
        if (number == 13) {
            return "D";
        }
        if (number == 14) {
            return "E";
        }
        if (number == 15) {
            return "F";
        }
        return null;

    }
}

