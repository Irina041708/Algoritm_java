package DZ3;

// 1.Реализуем метод добавления новых элементов в конец списка и удаление 
// последнего элемента связного списка. 
// 2.Теперь, когда мы понимаем, как можно искать значения внутри связного 
// списка, мы можем сделать методы добавления и удаления элементов в конец 
// нашего односвязного списка.




public class Main {
    public static void main(String[] args) {
    LinList list = new LinList();
    list.addFirst(1);
    list.addLast(2);
    list.addFirst(3);
    list.addFirst(6);
    list.addFirst(10);
    list.print();
    System.out.println();
    System.out.println("Список в обратном порядке");
    list.revert();

    list.print();
    }
}
