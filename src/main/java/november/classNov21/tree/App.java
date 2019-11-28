package november.classNov21.tree;

public class App {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(30);
        binaryTree.add(10);
        binaryTree.add(35);
        binaryTree.add(30);
        binaryTree.add(25);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.contains(25));
    }
}
