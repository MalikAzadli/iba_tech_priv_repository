package classNov21.tree;

public class Node {
    Node right;
    Node left;
    Integer value;

    public Node(int value) {
        this.value = value;
    }

    public void add(int number) {
        if (value < number && right == null) right = new Node(number);
        else if (value > number && left == null) left = new Node(number);
        else if (value < number) right.add(number);
        else if (value > number) left.add(number);
    }

    public boolean contains(int number) {
        if (value < number && right == null) return false;
        else if (value > number && left == null) return false;
        else if (value < number) return right.contains(number);
        else if (value > number) return left.contains(number);
        else return true;
    }

    public void remove(int number) {
        if (value == number) {
            if (right != null && left != null) {
                if ((right.value > left.value) && right.right == null && right.left == null) {
                    value = right.value;
                    right = null;
                } else if ((right.value > left.value) && right.right != null && right.left == null) {
                    value = right.value;
                    right = right.right;
                } else if ((right.value > left.value) && right.right == null && right.left != null) {
                    value = right.value;
                    right = right.left;
                } else if ((right.value > left.value) && right.right != null && right.left != null) {
                    value = right.value;
                    right = right.right;
//                    right.left =
                }
            }
        }
    }

    @Override
    public String toString() {
        if (right == null && left == null) return String.format("val: %s", value);
        else if (right == null && left != null) return String.format("[val: %s, l:%s, r:NA]", value, left.toString());
        else if (left == null && right != null) return String.format("[val: %s, l:NA, r:%s]", value, right.toString());
        else return String.format("[val: %s l: %s r: %s]", value, left.toString(), right.toString());
    }
}
