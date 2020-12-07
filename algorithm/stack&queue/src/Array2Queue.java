public class Array2Queue {

    static class Queue<T>{

        private T[] arr;

        private int size;
        private int limit;
        private int first;
        private int last;

        Queue(T[] arr){
            this.arr = arr;
            this.size = arr.length;
            this.limit = 0;
        }

        public T get(){
            if(limit == 0){
                throw new RuntimeException("当前队列为空");
            }
            T t = arr[first];
            first = move(first);
            limit --;
            return t;
        }

        public void put(T t){
            if (limit == size){
                throw new RuntimeException("当前队列已满");
            }
            arr[last] = t;
            last = move(last);
            limit ++;
        }

        private int move(int index){
            return index < size - 1 ? index + 1 : 0;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(new Integer[2]);
        queue.put(1);
        queue.put(2);
        for (int i = 0 ; i < 3 ; i ++){
            System.out.println(queue.get());
        }
    }

}
