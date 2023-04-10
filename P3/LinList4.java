package P3;

// 1.Реализуем метод добавления новых элементов в конец списка и удаление 
// последнего элемента связного списка. 
// 2.Теперь, когда мы понимаем, как можно искать значения внутри связного 
// списка, мы можем сделать методы добавления и удаления элементов в конец 
// нашего односвязного списка.




public class LinList4 {
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

    public void addFirst2(int value) {//пишем функцию вставки в конц связанного списка
        Node carrentNode = new Node();
        carrentNode.value = value;
        if (head == null){
            head = carrentNode; //назначаем  у node  ссылку на следующее значние-это наш head текущий, тоесть вводим вспомогатльную переменную
        }
        else {
            Node last = head; // вводим вспомогательную переменную
            while ( last.next != null){
                    last = last.next;//доходим до элемента, у которого конец нулевой
            }
            last.next = carrentNode;//вставляем в конец связнного списка ноду,которую мы создали
        }  
    }

    public void removeLast2() {
        if (head != null)
        {
            Node node = head;
            while(node.next != null) 
            {
                if(node.next.next == null)
                {
                    node.next = null;
                    return;
                }
            node = node.next;
            }
        }
    }
}
