import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int n = std.nextInt();
        String Tree[][] = new String[n][2];
        String node[] = new String[n];

        for(int i = 0; i < n; i++){
            node[i] = std.next();
            Tree[i][0] = std.next();
            Tree[i][1] = std.next();
        }
        preorder(0, node , Tree);
        System.out.println();
        inorder(0, node , Tree);
        System.out.println();
        postorder(0, node , Tree);

    }
    
    public static void inorder(int x, String node[], String Tree[][]){
        if(!Tree[x][0].equals("."))
            inorder(findIndex(node, Tree[x][0]), node, Tree);
        System.out.print(node[x]);
        if(!Tree[x][1].equals("."))
            inorder(findIndex(node, Tree[x][1]), node, Tree);
    }
    public static void preorder(int x, String node[], String Tree[][]){
        System.out.print(node[x]);
        if(!Tree[x][0].equals("."))
            preorder(findIndex(node, Tree[x][0]), node, Tree);
        if(!Tree[x][1].equals("."))
            preorder(findIndex(node, Tree[x][1]), node, Tree);
    }
    public static void postorder(int x, String node[], String Tree[][]){
        if(!Tree[x][0].equals("."))
            postorder(findIndex(node, Tree[x][0]), node, Tree);
        if(!Tree[x][1].equals("."))
            postorder(findIndex(node, Tree[x][1]), node, Tree);
        System.out.print(node[x]);
    }
    public static int findIndex(String node[], String target) {
        for (int i = 0; i < node.length; i++) {
            if (node[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}