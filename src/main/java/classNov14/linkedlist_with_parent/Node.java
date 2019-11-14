package classNov14.linkedlist_with_parent;

public class Node<T> {

    private final T value;
    private Node<T> next;
    private Node<T> parent;

    public Node(T value, Node<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> t){
        this.next = t;
    }

    public Node<T> getParent(){
        return parent;
    }

    public void setParent(Node<T> node){
        this.parent = node;
    }

    @Override
    public String toString() {
        return String.format("%d",value);
    }
}
