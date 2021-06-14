package ProblemsSolved;

/*
*
* //Complete braces. ALl braces must be closed.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the braces function below.

    static String[] braces(String[] values) {
        return new String[] {};

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(res[i]);

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

*/

import java.io.IOException;
import java.util.*;

public class BracesBalanced {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


//          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        System.out.println("Enter numbers of fields you want to pass: ");
        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        System.out.println(Arrays.toString(res));
        scanner.close();
    }

    static String[] braces(String[] strings) {

        List<String> stringList = new ArrayList<>();
        String[] arr = new String[]{};

        for (String s : strings) {
            BracesBalanced hr = new BracesBalanced();
            if (hr.checkValid(s)) {
                stringList.add("YES");
            }
            else {
                stringList.add("NO");
            }
        }

        return stringList.toArray(arr);

    }

    private boolean checkValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}





