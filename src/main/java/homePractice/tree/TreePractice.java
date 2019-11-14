package homePractice.tree;

import java.util.LinkedList;

public class TreePractice {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(0, 4);
        linkedList.add(8);

        System.out.println(linkedList.toString());
    }
}
