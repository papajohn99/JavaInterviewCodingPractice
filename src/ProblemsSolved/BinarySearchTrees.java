package ProblemsSolved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class BinarySearchTrees {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY a as parameter.

     https://stackoverflow.com/questions/26173808/checking-if-given-preorder-traversal-is-valid-bst

     */

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    String result = BinarySearchTrees.isValid(a);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }


        public static String isValid(List<Integer> arr) {
            if ("true" == String.valueOf(checkTree(arr))) {
                return "YES";
            } else {
                return "NO";
            }
        }

        private static boolean checkTree(List<Integer> arr) {
            if (arr.size() == 1) {
                return true;
            }

            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();

            Integer root = arr.get(0);
            int idx = 1;

            // adding left subtree nodes
            while (arr.get(idx) < root) {
                left.add(arr.get(idx++));

                if (idx >= arr.size())
                    break;
            }

            // adding right subtree nodes
            if (!(idx >= arr.size()))
                while (arr.get(idx) > root) {
                    right.add(arr.get(idx++));

                    if (idx >= arr.size())
                        break;
                }

            if (left.size() + right.size() == arr.size() - 1) {
                if (left.size() == 0) {
                    return true && checkTree(right);
                } else if (right.size() == 0) {
                    return true && checkTree(left);
                } else {
                    return checkTree(left) && checkTree(right);
                }
            } else {
                return false;
            }

        }
    }
