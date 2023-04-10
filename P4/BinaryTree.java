// Необходимо превратить собранное на семинаре
//  дерево поиска в полноценное левостороннее красно-черное дерево. 
// И реализовать в нем метод добавления новых элементов с балансировкой.

package P4;

import java.nio.channels.ClosedSelectorException;

public class BinaryTree <T extends Comparable<T>>{
    private Node root;

    private class Node {
        private T value;
        private Node  left;
        private Node right;
    }

    public boolean contains(T value){ //метод поиска значений
        Node node = root;
        while (node != null){
            if (node.value.equals(value)){ // если эквивалентны,значит возвращаем true.элемент найден
                return true;
            }
            if (node.value.compareTo(value) > 0){ //эта функция возвращает значение, если оно>0,значит value<чем сама нода 
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return false;
    }

    public void add (T value) { // добавление значения в дерево
        Node node = root;
        Node newNode = new Node();
        newNode.value = value;
        if (root != null) {
            if(node.value.compareTo(value)>0){
                node.left = newNode;
            }
            else {
                node.right = newNode;
            }
        }
        else {
            root = newNode;
        }
    }
    
}
