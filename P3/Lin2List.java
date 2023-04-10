package P3;

public class Lin2List {
    private Node head;//ссылка на самый первый элемент связанного списка
    private Node tail;

    public void print() {
        Node node = head;
        while(node != null)
        {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println(tail.value);
    }

    private class Node {
        private int value;//значние, которое мы кладем в текущую node
        private Node next;//ссылка на следующий элемент
        private Node previous;//ссылка на спредыдущий элемент
        
    }

    public void addFirst(int value) {//пишем функцию вставки вначало
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head; //назначаем  у node  ссылку на следующее значние-это наш head текущий
            head.previous = node;
        }
        else {
            tail = null; 
            head = null;
        }
        head = node; //указатель на head отдам уже добавленной вначало связанного списка node 
    }

    public void removeFirst(int value) {//пишем функцию удаления первого элемента связнного списка
        Node node = new Node();
        node.value = value;
        if (head != null && head.next != null){
            head.next.previous = null;
            head = head.next; 
        }
        else {
            tail = null;
            head = null;

        }
    }

    public boolean find(int value){
        Node carrentNode = head;
        while (carrentNode != null){
            if (carrentNode.value == value) return true; {
                carrentNode = carrentNode.next;
            }
        }
        return false;
    }

    public void addLast(int value) {//пишем функцию вставки в конц связанного списка
        Node carrentNode = new Node();
        carrentNode.value = value;
        if (tail != null){
            carrentNode.previous = tail;
            tail.next = carrentNode;
        }
        else {
            head = carrentNode;
        }
        tail = carrentNode;
    }

    public void removeLast() {
        if (tail == null && tail.previous != null)
        {
            tail.previous.next = null;
            tail = tail.previous; 
        }
        else {
            head = null;
            tail = null;
        }
    }
}
