package ProblemsSolved;

public class BinaySearchTreeConcepts {

    public static void main(String[] args) {
        BinaySearchTreeConcepts st = new BinaySearchTreeConcepts();

        Node rootNode = new Node(25,
                new Node(12, new Node(4, null, null), new Node(15, null, null)),
                new Node(35, new Node(30, null, null), new Node(40, null, null)));

        Node result = st.searchBinaryTree(rootNode, 15);

        st.levelTraverse(rootNode);

        st.InsertBinaryTree(rootNode, 50);

    }

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

    // Create BST Left and Right
    public Node createBinaryTree(int[] arr) {
        Node finalNode = new Node();

        if (arr.length > 0) {

            for (int i = 0; i < arr.length; i++) {

                if (i == 0) {
                    finalNode = new Node(arr[i], null, null);
                } else {
                    binaryTree(finalNode, arr[i]);
                }

            }
        }

        return finalNode;
    }

    private void binaryTree(Node node, int nextNum) {

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
    }

}

class Node {
    int info;
    Node left;
    Node right;

    public Node() {

    }

    Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
