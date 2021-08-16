package ProblemsSolved;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class RequestResponseAPI {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) throws Exception {

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            //GET
            Map<String, String> params = new HashMap<>();
            params.put("number", "someName");

            String url = "https://datausa.io/api/data?drilldowns=" + "Nation" + "&measures=" + "Population";
            HttpGet request = new HttpGet(url);

            Example response1 = client.execute(request, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), Example.class));

           /* Json node to pojo

           JsonNode response2 = client.execute(request, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), JsonNode.class));

            Example e1 = new ObjectMapper().treeToValue(response2, Example.class);

            Example e2 = new ObjectMapper().readValue(response2.toPrettyString(), Example.class);*/


            // Sort by ascending Years.
            RequestResponseAPI.quickSort(response1.data, 0, response1.data.length - 1);

            //Filter Array wether data is greater.
            Nations[] response2 = Arrays.stream(response1.data).filter(d -> d.getiDYear() >= 2015).toArray(Nations[]::new);

            //find Maximum number
            Nations maxObj = Arrays.stream(response1.data).reduce((acc, n) -> acc.getiDYear() > n.getiDYear() ? acc : n).get();

            //Search - 2015 Bonus
//           Arrays.sort(response1.data, new MyCustomCompare());
            int foundAtIndex = RequestResponseAPI.binarySerach(response1.data, 2015);


            //POST
            HttpPost postRequest = new HttpPost("http://localhost:8081/updateHubSpot");

            postRequest.addHeader("Content-Type", "application/json");
            postRequest.addHeader("name", "blah");

            String json = new Gson().toJson(response1);
            StringEntity entity = new StringEntity(json);
            postRequest.setEntity(entity);

            JsonNode responses = client.execute(postRequest, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), JsonNode.class));

            System.out.println(responses);
        }

    }

    private static int binarySerach(Nations[] data, int year) {
        if (data.length > 0) {

            int left = 0;
            int right = data.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (data[mid].getiDYear() == year) {
                    return mid;
                }

                if (year < data[mid].getiDYear()) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private static void quickSort(Nations[] data, int lb, int rb) {
        if (lb < rb) {
            int loc = partiton(data, lb, rb);
            quickSort(data, lb, loc - 1);
            quickSort(data, loc + 1, rb);
        }
    }

    private static int partiton(Nations[] data, int lb, int rb) {

        int pivot = lb;
        int left = lb;
        int right = rb;

        while (left < right) {
            while (left <= right && data[left].getiDYear() <= data[pivot].getiDYear()) {
                left++;
            }
            while (right >= left && data[right].getiDYear() > data[pivot].getiDYear()) {
                right--;
            }
            if (left < right) {
                RequestResponseAPI.swap(data, left, right);
            }
        }
        RequestResponseAPI.swap(data, pivot, right);
        return right;
    }

    public static void swap(Nations[] data, int n1, int n2) {
        Nations tempObj = data[n1];
        data[n1] = data[n2];
        data[n2] = tempObj;

    }

    private static class MyCustomCompare implements Comparator {

        @Override
        public int compare(Object newNum, Object oldNum) {
            Nations n1 = (Nations) newNum;
            Nations n2 = (Nations) oldNum;

            if (n1.getiDYear() == n2.getiDYear()) {
                return 0;
            }

            if (n1.getiDYear() > n2.getiDYear()) {
                return 1;
            } else {
                return -1;
            }

        }
    }
}

class Example {

   /* @JsonProperty("data")
    List<Nations> data;
    @JsonProperty("source")
    List<Object> source;*/

    @JsonProperty("data")
    Nations[] data;
    @JsonProperty("source")
    Object[] source;

}

class Nations {

    @JsonProperty("ID Nation")
    private String iDNation;
    @JsonProperty("Nation")
    private String nation;
    @JsonProperty("ID Year")
    private Integer iDYear;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Population")
    private Integer population;
    @JsonProperty("Slug Nation")
    private String slugNation;

    public String getiDNation() {
        return iDNation;
    }

    public void setiDNation(String iDNation) {
        this.iDNation = iDNation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getiDYear() {
        return iDYear;
    }

    public void setiDYear(Integer iDYear) {
        this.iDYear = iDYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getSlugNation() {
        return slugNation;
    }

    public void setSlugNation(String slugNation) {
        this.slugNation = slugNation;
    }
}

class Student {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;

    public Student(int i, String name, int i1) {
        this.id = i;
        this.name = name;
        this.age = i1;
    }
}



     /*
     import sun.net.www.http.HttpClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

     // Create a neat value object to hold the URL
        URL url = new URL("http://localhost:8081/getJsonDataWithNumber?number=someName");

        // Open a connection(?) on the URL(?) and cast the response(??)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

        // This line makes the request
        InputStream responseStream = connection.getInputStream();

        JsonNode x = new ObjectMapper().readTree(responseStream);*/


      /*  URL yahoo = new URL("http://localhost:8081/updateHubSpot");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();*/

/*
        try {

            URL urls = new URL("https://gorest.co.in/public/v1/users");
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader ins = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(ins);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }*/