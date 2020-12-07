import java.util.Stack;

public class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int val,BinaryTree left,BinaryTree right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    BinaryTree(int val){
        this.val = val;
    }

    public static void zhongxu(BinaryTree head){
        if (head == null){
            return;
        }
        BinaryTree cur = head;
        Stack<BinaryTree> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            while (cur != null ){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                BinaryTree pop = stack.pop();
                System.out.print(pop.val);
                if(pop != null){
                    cur = pop.right;
                }
            }
        }
    }

    public static void houxu(BinaryTree head){
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> s1 = new Stack<>();
        BinaryTree cur = head;
        if (cur == null){
            return;
        }
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            s1.push(head);
            if (head.left != null){
                stack.push(head.left);
            }
            if (head.right != null){
                stack.push(head.right);
            }

        }
        while (!s1.isEmpty()){
            System.out.print(s1.pop().val);
        }
    }

    public static void qianxu(BinaryTree head){
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree cur = head;
        if (cur == null){
            return;
        }
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.val);
            if (head.right != null){
                stack.push(head.right);
            }
            if (head.left != null){
                stack.push(head.left);
            }
        }

    }

    public static void print(BinaryTree head){
        if (head == null){
            return;
        }
        print(head.left);
        print(head.right);
        System.out.print(head.val);
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree(1,new BinaryTree(2,new BinaryTree(4),new BinaryTree(5)),new BinaryTree(3,new BinaryTree(5),new BinaryTree(7)));
        print(b);
        System.out.println("-----");
        houxu(b);
    }

}
