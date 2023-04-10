package P3;

// 1.Реализуем метод добавления новых элементов в конец списка и удаление 
// последнего элемента связного списка. 
// 2.Теперь, когда мы понимаем, как можно искать значения внутри связного 
// списка, мы можем сделать методы добавления и удаления элементов в конец 
// нашего односвязного списка.




public class Main {
    public static void main(String[] args) {
    // LinList list = new LinList();
    // list.addFirst(1);
    // list.addLast(2);
    // list.addFirst(3);
    // list.removeLast();
    // list.removeFirst(1);
    // list.removeLast();
    // list.print();


    Lin2List list = new Lin2List();
    list.addFirst(1);
    list.addLast(2);
    list.addFirst(3);
    
    
   
    list.print();
    }



}
