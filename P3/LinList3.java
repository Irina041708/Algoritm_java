package P3;

// 1.Реализуем метод поиска элемента в односвязном списке для проверки 
// наличия элемента внутри списка. 
// 2.Для корректной работы со связным список необходимо понимать, как именно 
// можно обходить все значения внутри связного списка. 
// 3.Для нашего примера проще всего будет написать метод поиска значения в 
// связном списке и возвращения из метода информации о наличии искомого 
// внутри списка.



public class LinList3 {
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

    public boolean find(int value){
        Node carrentNode = head;
        while (carrentNode != null){
            if (carrentNode.value == value) return true; {
                carrentNode = carrentNode.next;
            }
        }
        return false;
    }

}
