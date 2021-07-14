package ProblemsSolved;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class CustomComparator {
    public static void main(String[] args) {

        CustomComparator st = new CustomComparator();

        TreeSet ss = new TreeSet(new MyComp());
        ss.add(new Book(5, "someName1"));
        ss.add(new Book(15, "someName2"));
        ss.add(new Book(10, "someName3"));


        for (Object b : ss) {
            Book x = (Book) b;
            System.out.println(x.getPrice());
        }

        Queue q = new PriorityQueue();

    }
}

class MyComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;

        if (b1.getPrice() == b2.getPrice()) {
            return 0;
        }

        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    }
}


class Book {
    private int price;
    private String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}