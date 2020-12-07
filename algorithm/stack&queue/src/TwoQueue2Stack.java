import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoQueue2Stack {
    static class MyStack<T>{

        int size = 0;

        Queue<T> q1;
        Queue<T> q2;

        boolean flag = true;
        {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void offer(T t){
            if (flag)
                q1.offer(t);
            else
                q2.offer(t);

            size++;
        }

        public T poll(){
            T t = null;
            if (size == 0){
                throw new RuntimeException("空栈");
            }
            if (flag){
                while (q1.size() > 1){
                    q2.offer(q1.poll());
                }
                t = q1.poll();
            }else{
                while (q2.size() > 1){
                    q1.offer(q2.poll());
                }
                t = q2.poll();
            }
            flag = !flag;
            size --;
            return t;
        }

    }

    public static void main(String[] args) {
//        MyStack<Integer> stack = new MyStack<>();
//        stack.offer(1);
//        stack.offer(2);
//        stack.offer(3);
//        while (stack.size != 1){
//            System.out.println(stack.poll());
//        }
//        stack.offer(4);
//        stack.offer(5);
//        while (stack.size != 0){
//            System.out.println(stack.poll());
//        }
        MyStack<Integer> stack = new MyStack<>();
        Stack<Integer> test = new Stack();
        int times = 10000;
        int max = 100000;

        System.out.println("开始");
        for (int i = 0; i < times; i++){
            int val = (int) Math.random() * max;
            stack.offer(val);
            test.push(val);
        }

        for (int i = 0; i < times; i++){
            if(stack.poll() != test.pop()){
                System.out.println("1111");
            }
        }

        System.out.println("结束");
    }



}


