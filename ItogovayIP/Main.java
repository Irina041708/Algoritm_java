package ItogovayIP;

import java.util.Arrays;
import java.util.HashSet;
import org.w3c.dom.Node;

//https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java

public class Main {

    public static void main(String[] args) {
        //Вид печати разный 
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        tree.add(4);
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(8);
       
        tree.printBinaryTree();

        RBBinaryTree<Integer> treeRB = new RBBinaryTree<>();
        
        treeRB.add(4);
        treeRB.add(5);
        treeRB.add(2);
        treeRB.add(6);
        treeRB.add(1);
        treeRB.add(3);
        treeRB.add(8);
        
        treeRB.printRBBinaryTree();
    } 
}
