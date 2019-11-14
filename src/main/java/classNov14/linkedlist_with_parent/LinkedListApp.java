package classNov14.linkedlist_with_parent;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(23);
        linkedList.add(45);
        linkedList.add(42);
        linkedList.add(67);

        System.out.println("LinkedList: " + linkedList);
        System.out.println("Value at index 0: " + linkedList.get(0));
        linkedList.remove(3);
        System.out.println("Value at index 3 removed: " + linkedList);
        linkedList.add(3);
        System.out.println("New Value added: " + linkedList);

        linkedList.add(3, 39);
        System.out.println("New value added to index 3: " + linkedList);

    }
}
