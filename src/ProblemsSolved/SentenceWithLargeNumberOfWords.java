package ProblemsSolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceWithLargeNumberOfWords {


    public static void main(String[] args) {

        String s = "We test coders. Give us a try?";

        SentenceWithLargeNumberOfWords solution = new SentenceWithLargeNumberOfWords();
        int x = solution.solution(s);

        System.out.println(x);
    }

    public int solution(String S) {
        //creating new list and spliting the sentences where there is . ? or !
        List<String> sentences = new ArrayList<>(Arrays.asList(S.split("[.?!]", -2)));

        //let's remove all empty sentences
        sentences.removeAll(Arrays.asList("", null));

        //setting counter
        int counter = 0;


        for (String present : sentences) {

            //breaking down sentences after space and adding in to list
            List<String> words = new ArrayList<>(Arrays.asList(present.split("\\s+", 0)));

            //let's remove all empty sentences
            words.removeAll(Arrays.asList("", null));

            if (words.size() > counter) {
                counter = words.size();
            }
        }

        //returning the counter
        return counter;

    }
}
