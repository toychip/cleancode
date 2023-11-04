package Section6;

public class ConcurrentThreadInterrupt {
    public static void main(String[] args){
        /**
         * Runable()이 Functional Interface로 바뀌었기 때문에 아래와 같이 가능하다.
         */
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());

                try{
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    // 누군가 Interupt를 하면 종료가 되게 설계
                    System.out.println("exit!!");
                    /**
                     * return하지 않으면 Exit를 Print하고 계속 반복됨
                     */
//                    return;
                }
            }
        });
        thread.start();

        System.out.println("Main Thread, Hello: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}
