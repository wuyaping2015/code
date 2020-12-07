import java.util.Stack;

public class TwoStack2Queue {

    static class MyQueue<T>{

        int size;

        Stack<T> s1 = new Stack();
        Stack<T> s2 = new Stack();
        private boolean flag = true;

        public void put(T t){
            s1.push(t);
            size ++;
        }

        public T pop(){
            T t = null;
            if(s2.isEmpty()){
                if(s1.isEmpty()){
                    throw new RuntimeException("空队列");
                }
                while (!s1.isEmpty()){
                    T pop = s1.pop();
                    s2.push(pop);
                }
            }
            t =  s2.pop();
            size --;
            return t;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue();
        queue.put(1);
        queue.put(2);
        queue.put(3);

        while (queue.size != 1){
            System.out.println(queue.pop());
        }
        queue.put(4);
        queue.put(5);

        while (queue.size != 0){
            System.out.println(queue.pop());
        }

    }


}
