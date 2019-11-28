package november.classNov14.warmup;

import november.classNov14.linkedlist_with_parent.LinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void before(){
        linkedList = new LinkedList<>();
    }

    @Test
    public void add() {
        linkedList.add(43);
        linkedList.add(45);
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(43, 45));
        assertEquals(arrayList.toString(), linkedList.toString() );
    }

    @Test
    public void get() {
        linkedList.add(56);
        linkedList.add(78);
        linkedList.add(89);
        Integer value = linkedList.get(2);
    }

    @Test
    public void remove() {
    }
}