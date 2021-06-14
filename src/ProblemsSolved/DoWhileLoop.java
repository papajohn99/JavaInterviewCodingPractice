package ProblemsSolved;

public class DoWhileLoop {


    public static void main(String[] args) {

        int x = 2437;
        int y = 875;


        do {
            if (x > y) {
                x = x - y;
            }
            if (x < y) {
                y = y - x;
            }
            if (x == y) {
                break;
            }
        } while (x != y);

        System.out.println(x);
        System.out.println(y);
    }


}
