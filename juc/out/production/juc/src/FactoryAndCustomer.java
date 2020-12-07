import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FactoryAndCustomer {

    static class Factory{
        final int stockMax = 200;
        final int productivity = 10;
        volatile int stockCur = 0;

        public void product()  {
            int x = productivity;
            while (x > 0){
                if(stockCur<stockMax){
                    synchronized (this){
                        if(stockCur<stockMax){
                            stockCur += 1;
                            System.out.println("当前库存"+stockCur);
                            x --;
                        }else{
                            return;
                        }
                    }
                }
            }

        }



    }

    static class Consumer{
        final int consumerNumbyDay = 1;
        int stock = 0;
        public synchronized void consume(Factory f)  {
                if (f.stockCur > 0){
                    f.stockCur -= consumerNumbyDay;
                    stock += consumerNumbyDay;
                    System.out.println("库存-1:"+f.stockCur);
                }else{
                    System.out.println("库存不足");
                }
            }
        }



    public static void main(String[] args) {
        final Factory factory = new Factory();
        int i = 10;
        while (i > 0){
            factory.product();
            int x = 10;
            while (x>0){
                Consumer c = new Consumer();
                Thread t = new Thread(()-> c.consume(factory));
                t.start();
                x--;
            }
            i--;
        }
    }
}
