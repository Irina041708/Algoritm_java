// Необходимо превратить собранное на семинаре
//  дерево поиска в полноценное левостороннее красно-черное дерево. 
// И реализовать в нем метод добавления новых элементов с балансировкой.
//https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java

package ItogovayIP;

public class RBBinaryTree<V extends Comparable<V>> {
   	
	private Node root; // рутовая нода (элемент,с которого начинаем работу)

    public boolean add (V value){
        if (root != null) {
            boolean result = addNode (root, value);
            root = rebalance (root);
            root.color = Color.BLACK;
            return result;
        }
        else {
            root = new Node ();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    // печать дерева
    public void printRBBinaryTree() {
        if (root != null) {
            root.printNode(1, "Root");
        }
    }

    private boolean addNode (Node node, V value) {
        if (node.value == value) {
            return false; // значит создать новую ноду нельзя, так как уже есть у ноды , код нашли , значение
        }
        else {
            if (node.value.compareTo (value) > 0) { //если значение ноды больше чем искомое значение
                if (node.left != null) {  //при  этом левый рбеной существует, запускаем реурсию по созданию ноды там
                    boolean result = addNode( node.left, value);
                    node.left = rebalance (node.left);
                    return result;
                }
                else{ // если левая нода не сущствут,нашли подходящее место для подставновки нашего значения,генерируем ноду 
                    node.left = new Node();
                    node.left.color = Color.RED; // все ноды при создании всгда получают красный цвет
                    node.left.value = value;
                    return true;
                }
            }
            else {
                if (node.right != null) {
                    boolean result = addNode (node.right, value);
                    node.right = rebalance (node.right);
                    return result;
                }
                else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }
    private Node rebalance (Node node){
        Node result = node;
        boolean neeRebalance;
        do {
            neeRebalance = false;
            if (result.right != null && result.right.color == Color.RED && 
                    (result.left == null || result.left.color == Color.BLACK)) {
                neeRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && 
                    result.left.left != null && result.left.left.color == Color.RED) {
                neeRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.right != null &&
                    result.right.color == Color.RED) {
                neeRebalance = true;
                colorSwap(result);
            }
        }
        while (neeRebalance);
        return result;
    }

    private Node rightSwap(Node node) { //правосторонний перевод
        Node rightChild = node.right;
        Node betweenChild = rightChild.right;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }    

    private Node leftSwap(Node node) { //левосторонний перевод
        Node leftChild = node.left;//берем левого ребенка и выделяем как отдельную переменную для удобства
        Node betweenChild = leftChild.right;//промжуточный элемент,который будет менять своего родителя
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED; 
        return leftChild;
    }   

    private void colorSwap (Node node) { // ребалансировка смены цвета,только тогда,когда у ноды два красных ребнка
        node.right.color = Color.BLACK;//присваивам левму и правму ребенку чрный цвета
        node.left.color = Color.BLACK;
        node.color = Color.RED;  // сама нода становится красной
    }

    private class Node {
        private V value;//значение,которое храним в нашем узле
        private Color color;//еще один признак узла, это его цвет,кот заводим благодаря enum (смотри  ниже)
        private Node left; // его левый ребенок
        private Node right; // его правый ребенок
    

        // печать Node о самой себе информацию
        public void printNode(int level, String typeBranch) {
            String text = typeBranch + " Value = " + value.toString() + " Color = " + color.toString();
            int padCount = level;
            if (level > 1) {
                padCount = level + 5; // уровень отступа для визуализации ветвей
            }
            text = padLeft(text, padCount);
            System.out.println(text);

            printChild(level + 1); // уровень дерева
        }
        
        // печать информация о детях + информация какая ветка
        public void printChild(int level) {
            if (right != null) {
                right.printNode(level, "Right");
            }
            if (left != null) {
                left.printNode(level, "Left");
            }
        }

        // отступы слева
        public static String padLeft(String s, int n) {
            n = n + s.length();
            return String.format("%" + n + "s", s);
        }
    }

    private enum Color {
        RED, BLACK
    }
}


