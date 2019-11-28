package november.classNov14.linkedlist_with_parent;

public class LinkedList<T> {

    private Node<T> root;
    private Node<T> current;

    public LinkedList() {
    }

    public void add(T t) {
        Node<T> node = new Node<>(t, null);
        if (root == null) {
            current = node;
            root = node;
        } else {
            node.setParent(current);
            current.setNext(node);
            current = node;
        }
    }

    public void add(int index, T t){
        Node<T> node = new Node<>(t, null);
        int i=0;
        Node<T> temp = root;

        while (i<=index){
            if(i == index){
                if(temp.getParent()==null) {
                    node.setNext(temp);
                    root=node;
                } else {
                    temp.getParent().setNext(node);
                    node.setParent(temp.getParent());
                    node.setNext(temp);
                    break;
                }
            }
            temp = temp.getNext();
            i++;
        }
    }

    public T get(int index) {
        int i = 0;
        T value;
        Node<T> temp = root;
        while (i <= index) {
            if (i == index) return temp.getValue();
            temp = temp.getNext();
            i++;
        }
        throw new IndexOutOfBoundsException("Not a valid index");
    }

    public void remove(int index) {
        int i = 0;
        T value;
        Node<T> temp = root;
        while (i <= index) {
            if (i == index) {
                if(temp.getNext()==null){ current = temp.getParent(); }
                if(temp.getParent() == null) {root = temp.getNext();}
                else temp.getParent().setNext(temp.getNext());
            }
            temp = temp.getNext();
            i++;
        }

    }

    public T lastElement(){
        return current.getValue();
    }

    public T firstElement(){
        return root.getValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> temp = root;
        while (true) {
            stringBuilder.append(String.format("%d", temp.getValue()));
            if(temp.getNext() == null) {stringBuilder.append("]"); break;}
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }
}
