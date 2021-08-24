package SolutionFiles;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here*/
        List<Integer> li = new ArrayList<>();
        li.add(8);
        li.add(3);
        li.add(1);
        li.add(6);
        li.add(4);
        li.add(7);
        li.add(10);
        li.add(14);
        li.add(13);
        System.out.println(createTree(li));
    }

    public static String createTree(List<Integer> values) {
        Tree tree = new Tree();
        values.forEach(value -> tree.add(value));
        return tree.traverseInOrderFromRoot();
    }

    public static class Tree {
        Node root;

        public String traverseInOrderFromRoot() {
            return traverseInOrder(root);
        }

        public String traverseInOrder(Node node) {
            String traverseInOrder = "";
            if (node != null) {
                traverseInOrder += traverseInOrder(node.left);
                traverseInOrder += visit(node.value);
                traverseInOrder += traverseInOrder(node.right);
            }
            return traverseInOrder;
        }

        private String visit(int value) {
            return " " + value;
        }


        public void add(int value) {
            if (root != null) {
                addNode(root, value);
            } else {
                root = new Node(value, null, null);
            }
        }

        public void addNode(Node root, int value) {
            if (root != null) {

                if (value < root.getValue()) {
                    addNode(root.left, value);
                    if (root.left == null) {
                        root.setLeft(new Node(value, null, null));
                    }

                }

                if (value > root.getValue()) {
                    addNode(root.right, value);
                    if (root.right == null) {
                        root.setRight(new Node(value, null, null));
                    }
                }
            }
        }

    }

    public static class Node {
        private int value;
        private Node left, right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
   /* public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3};
        int[][] y = new int[][]{{}, {2, 3}};

        *//*System.out.println(calculateClicksByDomain(x));
        Map<Key, String> t = new HashMap<>();
        t.put(new Key("abc"),"ABC");
        System.out.println(t.get(new Key("abc")));*//*
        List<Long> l = new ArrayList<>();
        l.add(1L);
        l.add(2L);

        computeFactorialSum(l);

    }
*/
  /*  public static long computeFactorialSum(List<Long> inputs) {
        long result = inputs.parallelStream().mapToLong(n -> computeFactorial((long) n)).sum();
        for (int i = 0; i < inputs.size(); i++) {
            result += computeFactorial((long) i);
        }
        return result;

    }

    public static Long computeFactorial(Long num) {
        Long factorial = 1l;
        for (int i = 1; i <= Math.abs(num); i++) {
            factorial *= i;
        }

        return factorial;
    }*/

   /*

    public static List<String> calculateClicksByDomain(int[] counts) {

        return null;
    }

    private static class Key {
        String k;
        public Key(String abc) {
            this.k = abc;
        }
    }*/
