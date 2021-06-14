package ProblemsSolved;

/*
 * Complete the 'maxDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

       /*   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int aCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

             bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class MaximumDifference {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(1);

        int result = MaximumDifference.maxDifference(list);
        System.out.println(result);

    }


    public static int maxDifference(List<Integer> list) {
        // Write your code here
        if (!list.isEmpty()) {
            Integer[] array = new Integer[] {};
            array = list.toArray(array);

            int min, diff = -1;
            if (array.length < 0) {
                return -1;
            }
            min = array[0];
            for (int i = 1; i < array.length; i++) {
                diff = Math.max(diff, array[i] - min);
                min = Math.min(min, array[i]);
            }
            return diff;
        } else {
            return 0;
        }

    }


}