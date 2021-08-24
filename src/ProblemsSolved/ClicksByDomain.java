package ProblemsSolved;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:
 * <p>
 * counts = [ "900,google.com",
 * "60,mail.yahoo.com",
 * "10,mobile.sports.yahoo.com",
 * "40,sports.yahoo.com",
 * "300,yahoo.com",
 * "10,stackoverflow.com",
 * "20,overflow.com",
 * "5,com.com",
 * "2,en.wikipedia.org",
 * "1,m.wikipedia.org",
 * "1,mobile.sports",
 * "1,google.co.uk"]
 * Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)
 * <p>
 * Sample output (in any order/format):
 * <p>
 * calculateClicksByDomain(counts) =>
 * com:                     1345
 * google.com:              900
 * stackoverflow.com:       10
 * overflow.com:            20
 * yahoo.com:               410
 * mail.yahoo.com:          60
 * mobile.sports.yahoo.com: 10
 * sports.yahoo.com:        50
 * com.com:                 5
 * org:                     3
 * wikipedia.org:           3
 * en.wikipedia.org:        2
 * m.wikipedia.org:         1
 * mobile.sports:           1
 * sports:                  1
 * uk:                      1
 * co.uk:                   1
 * google.co.uk:            1
 * n: number of domains in the input
 * (individual domains and subdomains have a constant upper length)
 */
public class ClicksByDomain {

    public static void main(String[] args) {
        String[] counts = {"900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"};

        System.out.println(calculateClicksByDomain(counts));
    }

    public static List<String> calculateClicksByDomain(String[] counts) {

        Map<String, Integer> dict = new HashMap<>();
        for (String cpdomain : counts) {
            String temp[] = cpdomain.split(",");
            String domain[] = temp[1].split("[.]");
            for (int i = 0; i < domain.length; i++) {
                String subdomain = String.join(".", Arrays.copyOfRange(domain, i, domain.length));
                int newCount = dict.getOrDefault(subdomain, 0) + Integer.parseInt(temp[0]);
                dict.put(subdomain, newCount);
            }
        }

        List<String> list = dict.keySet().stream().map(m -> m + ":        " + dict.getOrDefault(m, 0))
                .collect(Collectors.toList());

        return list;

       /* Map<String, Integer> map = new HashMap<>();
        List<String> sList = new ArrayList<>();

        for (int i = 0; i < counts.length; i++) {
            String[] brokenString = counts[i].split(",");
            sList.add(brokenString[1]);
            map.put(brokenString[1], Integer.parseInt(brokenString[0]));
        }


        sList.forEach(l -> {


            List<String> map2 = map.entrySet().stream().filter(m ->
                    m.getKey().contains(l) && !m.getKey().equalsIgnoreCase(l))
                    .collect(Collectors.toList());

        });


        System.out.println(map);*/

    }

}
