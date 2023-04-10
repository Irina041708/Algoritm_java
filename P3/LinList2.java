package P3;

// 1.Реализуем метод добавления новых элементов в начало списка и удаление 
// первого элемента связного списка. 
// 2.Односвязный список всегда имеет ссылку на первый элемент 
// последовательности, потому именно с реализации методов для первого 
// элемента последовательности стоит начать


public class LinList2 {
    private Node head;//ссылка на самый первый элемент связанного списка

    private class Node {
        private int value;//значние, которое мы кладем в текущую node
        private Node next;//ссылка на следующий элемент
        
    }

    public void addFirst(int value) {//пишем функцию вставки вначало
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head; //назначаем  у node  ссылку на следующее значние-это наш head текущий
        }
        head = node; //указатель на head отдам уже добавленной вначало связанного списка node 
    }

    public void removeFirst(int value) {//пишем функцию удаления первого элемента связнного списка
        Node node = new Node();
        node.value = value;
        if (head != null){
            head = head.next; 
        }
    }

}
