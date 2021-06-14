package ProblemsSolved;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;


class AnagramDifference {

    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = Result.getMinimumDifference(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/

        List<String> a = new ArrayList<>();

        a.add("5");
        a.add("a");
        a.add("jk");
        a.add("abb");
        a.add("mn");
        a.add("abc");

        List<String> b = new ArrayList<>();
        b.add("5");
        b.add("bb");
        b.add("kj");
        b.add("bbc");
        b.add("op");
        b.add("def");

        List<Integer> result = getMinimumDifference(a, b);


        result.stream()
                .map(Object::toString)
                .collect(joining("\n"));

    }

    public static List<Integer> getMinimumDifference(List<String> list1, List<String> list2) {

        List<Integer> result = new ArrayList<>();

        for (int c = 0; c < list1.size(); c++) {
            String s1 = list1.get(c);
            String s2 = list2.get(c);
            // store the count of character
            int count = 0;
            int char_count[] = new int[26];

            // iterate though the first String and update
            // count
            for (int i = 0; i < s1.length(); i++)
                char_count[s1.charAt(i) - 'a']++;

            // iterate through the second string
            // update char_count.
            // if character is not found in char_count
            // then increase count
            for (int i = 0; i < s2.length(); i++)
                if (char_count[s2.charAt(i) - 'a']-- <= 0)
                    count++;

            result.add(count);
        }
        return result;
    }

}
