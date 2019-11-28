package november.classNov14.casualLinkedList;

import java.util.StringJoiner;

public class XLinkedList {

    class XItem {
        int value;
        XItem next;

        public XItem(int value) {
            this.value = value;
        }
    }

    private XItem head;

    public XItem getHead() {
        return head;
    }

    public boolean contains(int value) {
//    XItem item = head;
//    while (item.next != null){
//      if(item.value==value) return true;
//      item = item.next;
//    }
//    return false;

//    XItem item = head;
//    int c = 1;
//    for(int i = 0; i < c; i++){
//      if (head.value == value) return true;
//      if(head.next != null) break;
//      item = head.next;
//    }
//    return false;

        for (XItem item = head; item != null; item = item.next) {
            if (item.value == value) return true;
        }
        return false;
    }

    public void add(int value) {
        XItem item = new XItem(value);
        if (head == null) {
            head = item;
        } else {
            XItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = item;
        }
    }

    public void remove(int value) {
        XItem curr = head;
        XItem prev = null;
        while (curr != null) {
            if (curr.value == value) {
                if (prev == null) {
                    head = head.next;
                    break;
                }
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public int count() {
        int count = 0;
        for (XItem item = head; item != null; item = item.next, count++) ;
        return count;
    }

    public int lengthRecursive(XItem item) {
        if (item == null) return 0;
        return 1 + lengthRecursive(item.next);
    }

    public int lengthRecursive() {
        return lengthRecursive2(head, 0);
    }

    public int lengthRecursive2(XItem item, int i) {
        if (item == null) return i;
        return lengthRecursive2(item.next, i + 1);
    }

    public void revert_while() {

    }

    public void revert(XItem item) {
        if (head.next == null) head = item;
        item.value = head.value;
        revert(item.next);
    }

    public void revert_recursion() {
        revert(head);
    }

    private void revert_for() {

    }

    @Override
    public String toString() {

//    StringBuilder stringBuilder = new StringBuilder("[");
//    for(XItem item = head; item != null; item=item.next){
//      stringBuilder.append(String.format("%d", item.value));
//      if(item.next != null) stringBuilder.append(", ");
//    }
//    stringBuilder.append("]");

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (XItem item = head; item != null; item = item.next) {
            stringJoiner.add(String.format("%s", item.value));
        }
        return stringJoiner.toString();
    }
}
