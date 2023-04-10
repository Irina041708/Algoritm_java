package ItogovayIP;

import java.util.Stack;

public class BinaryTree<V extends Comparable<V>> {
    private Node root; // рутовая нода (элемент,с которого начинаем работу)
	public char[] node;

    public BinaryTree() { // Пустое дерево
        root = null;
    }
    
    public Integer add (V value){
        if (root != null) {
            Integer result = addNode (root, value);
            root = rebalance (root);
            root.color = Color.BLACK;
            return result;
        }
        else {
            root = new Node ();
            root.color = Color.BLACK;
            root.value = value;
            return (Integer) value;
        }
    }

    private Integer addNode (Node node, V value) {
        if (node.value == value) {
            return (Integer) value; // значит создать новую ноду нельзя, так как уже есть у ноды , код нашли , значение
        }
        else {
            if (node.value.compareTo (value) > 0) { //если значение ноды больше чем искомое значение
                if (node.left != null) {  //при  этом левый рбеной существует, запускаем реурсию по созданию ноды там
                    Integer result = addNode( node.left, value);
                    node.left = rebalance (node.left);
                    return result;
                }
                else{ // если левая нода не сущствут,нашли подходящее место для подставновки нашего значения,генерируем ноду 
                    node.left = new Node();
                    node.left.color = Color.RED; // все ноды при создании всгда получают красный цвет
                    node.left.value = value;
                    return (Integer) value;
                }
            }
            else {
                if (node.right != null) {
                    Integer result = addNode (node.right, value);
                    node.right = rebalance (node.right);
                    return result;
                }
                else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return (Integer) value;
                }
            }
        }
    }
    private Node rebalance (Node node){
        Node result = node;
        boolean neeRebalance;
        do {
            neeRebalance = false;
            if (result.right != null && result.right.color == Color.RED && (result.left == null || result.left.color == Color.BLACK)) {
                neeRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.left.left != null && result.left.left.color == Color.RED) {
                neeRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.right != null && result.right.color == Color.RED) {
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

        public V getValue() {
            return this.value;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }
    }

    private enum Color {
        RED, BLACK
    }

	public static char[] Node(BinaryTree<Integer> tree) {
		return null;
	}

    public void printBinaryTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;
 
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeft()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
 
}


