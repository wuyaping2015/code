import java.util.Stack;

public class StackMin {

    static class MyStack<T extends Comparable>{
         Stack<T> data = new Stack<>();
         Stack<T> min = new Stack<>();

        public void put(T t){
            if (data.size() == 0){
                min.push(t);
            }else {
                if (getMin().compareTo(t)>=0){
                    min.push(t);
                }else {
//                    min.push(min.peek());
                }
            }
            data.push(t);
        }

        public T pop(){
            if (data.size()==0){
                throw new RuntimeException("空栈");
            }
            if (data.peek().compareTo(getMin()) == 0){
                min.pop();
            }
            return data.pop();
        }

        public T getMin(){
            if (min.size()==0){
                throw new RuntimeException("空栈");
            }
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.put(3);
        stack.put(2);
        stack.put(1);
        stack.put(2);
        stack.put(4);
        System.out.println("----------------");
        while (stack.data.size()!=0){
            System.out.println("min:"+stack.getMin());
            System.out.println("data:"+stack.pop());
        }
        stack.pop();
    }
}
