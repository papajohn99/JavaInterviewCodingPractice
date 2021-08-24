package ProblemsSolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaySearchTreeConcepts {

    public static void main(String[] args) {
        BinaySearchTreeConcepts st = new BinaySearchTreeConcepts();

        Node rootNode = new Node(25,
                new Node(12, new Node(4, null, null), new Node(15, null, null)),
                new Node(35, new Node(30, null, null), new Node(40, null, null)));

        Node result = st.searchBinaryTree(rootNode, 15);

        st.levelTraverse(rootNode);

        st.InsertBinaryTree(rootNode, 50);

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

        int[] n = li.stream().mapToInt(l -> l).toArray();
        Node createdBiTree = st.createBinaryTree(n);
        System.out.println("unsorted Array: " + Arrays.toString(n));
        System.out.println("preOrder Traverse: " + preOrderTraverse(createdBiTree));
        System.out.println("inOrder Traverse: " + inOrderTraverse(createdBiTree));
        System.out.println("postOrder Traverse: " + postOrderTraverse(createdBiTree));
    }


    // Create BST Left and Right. Sorted/unsorted Array.
    public Node createBinaryTree(int[] arr) {
        Node finalNode = null;

        for (int a : arr) {
            if (finalNode != null) {
                InsertBinaryTree(finalNode, a);
            } else {
                finalNode = new Node(a, null, null);
            }
        }

        return finalNode;
    }

    // Insert element in BST.
    public void InsertBinaryTree(Node node, int nextNum) {

        if (node != null) {
            if (nextNum > node.info) {
                InsertBinaryTree(node.right, nextNum);
                if (node.right == null) {
                    node.right = new Node(nextNum, null, null);
                }
            } else {
                InsertBinaryTree(node.left, nextNum);
                if (node.left == null) {
                    node.left = new Node(nextNum, null, null);
                }
            }
        }
    }

    //Left - Node - right
    public static String preOrderTraverse(Node node) {
        String result = "";
        if (node != null) {
            result += preOrderTraverse(node.left);
            result += " " + node.info;
            result += preOrderTraverse(node.right);

        }
        return result;
    }

    //root Node - left - right
    public static String inOrderTraverse(Node node) {
        String result = "";
        if (node != null) {
            result += " " + node.info;
            result += preOrderTraverse(node.left);
            result += preOrderTraverse(node.right);
        }
        return result;
    }

    //left - right - root Node
    public static String postOrderTraverse(Node node) {
        String result = "";
        if (node != null) {
            result += preOrderTraverse(node.left);
            result += preOrderTraverse(node.right);
            result += " " + node.info;
        }
        return result;
    }

    // Traverse Binary tree by level
    public void levelTraverse(Node node) {

        if (node != null) {

            if (node.left != null) {
                System.out.println(node.left.info);
            }

            if (node.right != null) {
                System.out.println(node.right.info);
            }

            levelTraverse(node.left);
            levelTraverse(node.right);

        }
    }


    //Search BST
    public Node searchBinaryTree(Node node, int num) {
        if (node != null) {
            if (num == node.info) {
                return node;
            }

            if (num < node.info) {
                return searchBinaryTree(node.left, num);
            } else if (num > node.info) {
                return searchBinaryTree(node.right, num);
            }
        }
        return null;
    }




    /*private void binaryTree(Node node, int nextNum) {

        if (node != null) {
            if (nextNum > node.info) {
                binaryTree(node.right, nextNum);
                node.right = new Node(nextNum, null, null);
            }
            if (nextNum < node.info) {
                binaryTree(node.left, nextNum);
                node.left = new Node(nextNum, null, null);
            }
        }
    }*/

}

class Node {
    int info;
    Node left;
    Node right;

    Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
