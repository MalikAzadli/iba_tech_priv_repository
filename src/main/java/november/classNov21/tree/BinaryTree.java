package november.classNov21.tree;

public class BinaryTree {

    Node root;

    public BinaryTree() {}

    public void add(int number) {
        if (root == null) root = new Node(number);
        else root.add(number);


    }

    public boolean contains(int num) {
        return root.contains(num);
    }

    public void remove(int number){
        if(!root.contains(number)) return;
        root.remove(number);
    }


    @Override
    public String toString() {
        return root.toString();
    }
}
