import java.util.Scanner;

public class BOJ1068{
    public static void main(String arg[]){
        Scanner std = new Scanner(System.in);
        int i = std.nextInt();
        int Tree[] = new int[i];
        for(int a = 0; a < i; a++){
            Tree[a]= std.nextInt();
        }
        int delete = std.nextInt();
        Delete(Tree,delete);
        System.out.println(Tree(Tree));
    }
    public static void Delete(int Tree[],int delete){
        for(int i = 0; i < Tree.length; i++){
            if(delete == Tree[i]){
                Tree[i] = -2;
                Delete(Tree,i);
            }
        }
        Tree[delete] = -2;
    }
    public static int Tree(int Tree[]){
        int ref = Tree.length;
        if(Tree.length == 2)
            return 1;
        else if(Tree.length == 1)
            return 0;

        for(int i = 0; i < Tree.length; i++)
            for(int j = 0; j < Tree.length; j++)
                if(i == Tree[j] || Tree[i] == -2){
                    ref--;
                    j = Tree.length;
                }
        
        return ref;
    }
}
