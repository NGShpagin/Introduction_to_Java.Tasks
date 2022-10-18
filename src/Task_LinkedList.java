public class Task_LinkedList {
    public static void main(String[] args) {
//        MyStack ms = new MyStack();
//        System.out.println("7 строка" + ms.print());
//        ms.push(1);
//        ms.push(12);
//        ms.push(134);
//        ms.push(1345);
//
//        System.out.println("12 строка" + ms.print());
//        System.out.println(ms.pop());
//        System.out.println("14 строка" + ms.print());
        Node root = new Node("5");
        Node l1 = new Node("3");
        Node l11 = new Node("1");
        Node r12 = new Node("2");

        Node r2 = new Node("7");
        Node l21 = new Node("6");
        Node r21 = new Node("11");
        Node l221 = new Node("10");

        r2.left = l21;
        r2.right = r21;

        l1.left = l11;
        l1.right = r12;

        r21.left = l221;

        root.right = r2;
        root.left = l1;


        System.out.println("Скобочная запись");
        IterrBrace.View(root); // скобочная запись
        System.out.println("Прямой обход");
        Iterr1.View(root, " ");
        System.out.println("Центрированный обход");
        Iterr2.View(root, " ");
        System.out.println("Обратный обход");
        Iterr3.View(root, " ");
    }
}

class MyStack {
    private int[] storage = new int[100];
    private int count = 0;

    void push(int item) {
        storage[count++] = item;
    }

    int pop() {
        return storage[--count];
    }

    String print() {
        String res = "";
        for (int i = 0; i < count; i++) {
            res += storage[i] + " ";
        }
        return res;
    }
}

class MyList {
    int value;
    MyList next;
}

class Node {
    public Node(String v) {
        value = v;
    }

    String value;
    Node left;
    Node right;
}

// Прямой обход
class Iterr1 {
    static void View(Node n, String space) {
        if (n != null) {
            System.out.printf("%s%s\n", space, n.value);
            if (n.left != null) {
                View(n.left, space + "  ");
            }
            if (n.right != null) {
                View(n.right, space + "  ");
            }
        }
    }
}

// Центрированный обход
class Iterr2 {
    static void View(Node n, String space) {
        if (n == null) return;
//        System.out.printf("%s%s\n", space, n.value);
        View(n.left, space + "  ");
        System.out.printf("%s%s\n", space, n.value);
        View(n.right, space + "  ");
    }
}

// Обратный обход
class Iterr3 {
    static void View(Node n, String space) {
        if (n == null) return;
        View(n.left, space + "  ");
        View(n.right, space + "  ");
        System.out.printf("%s%s\n", space, n.value);
    }
}

class IterrBrace {
    static void View(Node n) {
        if (n != null) {
            System.out.printf("%s", n.value);

            if (n.left != null || n.right != null) {
                System.out.print("(");
                if (n.left != null) {
                    View(n.left);
                } else {
                    System.out.print("null");
                }
                System.out.print(",");
                if (n.right != null) {
                    View(n.right);
                } else {
                    System.out.print("null");
                }
                System.out.printf(")");
            }
        }
    }
}
