import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


class BinaryTree{
    static class Node{
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public BinaryTree(){
        this.root = null;
    }
    public void insert(int value){
        root = insertRec(root, value);
    }
    private Node insertRec(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value)
            node.left = insertRec(node.left, value);
        else
            node.right = insertRec(node.right, value);
        return node;
    }

    public void postOrderTraversal(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree tree = new BinaryTree();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int value = Integer.parseInt(line);
            tree.insert(value);
        }

        // 후위 순회 결과 출력
        tree.postOrderTraversal();
    }
}
