import java.util.HashMap;

public class NodeDemo {

    static class Node {
        int val;
        Node next;
        Node(){};
        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            String s = "";
            s += this.val;
            Node n = this;
            while (n.next != null){
                s += n.next.val;
                n = n.next;
            }
            return s;
        }
    }

    static class DoubleNode {
        int val;
        DoubleNode pre;
        DoubleNode next;
        DoubleNode(){};
        DoubleNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            String s = "";
            s += this.val;
            DoubleNode n = this;
            while (n.next != null){
                s += n.next.val;
                n = n.next;
            }
            return s;
        }
    }


    public static Node getNode(){
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(1);
        n.next.next.next.next = new Node(5);
        return n;
    }
    public static DoubleNode getDoubleNode(){
        DoubleNode n = new DoubleNode(1);
        n.next = new DoubleNode(2);
        n.next.next = new DoubleNode(3);
        n.next.pre = n;
        n.next.next.pre = n.next;
        return n;
    }
    /*
        将翻转的过程抽象成 头部和指针的变化
     */
    public static Node reverseNode(Node head){
        // next记录下一个指针指向的位置，pre保存新的链表
        Node next,pre = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /*
    将翻转的过程抽象成 头部和指针的变化
 */
    public static DoubleNode reverseDoubleNode(DoubleNode head){
        // next记录下一个指针指向的位置，pre保存新的链表
        DoubleNode next,pre = null;
        while(head != null){
         next = head.next;
         head.next = head.pre;
         head.pre = next;
         pre = head;
         head = next;
        }
        return pre;
    }

    /**
     * 删除链表上值为x的节点
     * @param head 目标链表
     * @param x 删除的值
     * @return
     */
    public static Node remove(Node head, int x){
        while (head != null && head.val == x){
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        // pre 和 cur 都是链表中的一个元素，pre操作的是链表中的链，cur是用来将指针指向一个节点
        while (cur != null){
            if(cur.val == x){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = getNode();
        System.out.println(node);
        Node node1 = reverseNode(node);
        System.out.println(node1);
        //为什么node=1？因为node的next=null
        System.out.println(node);
        DoubleNode doubleNode = getDoubleNode();
        System.out.println(doubleNode);
        DoubleNode doubleNode1 =  (doubleNode);
        System.out.println(doubleNode1);
        System.out.println(doubleNode);
        Node node2 = remove(getNode(), 1);
        System.out.println(node2);
    }
}
