package Section6;

public class ConcurrentThread1 {
    public static void main(String[] args) {

//        System.out.println("나는 main Thread");
//        System.out.println(Thread.currentThread().getName());

        /*
        code 상으로는 THread: 가 먼저 실행되고 hello가 실행될 줄 알았느데 아래처럼 나옴
         */

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");
    }

    /*
    main Thread에서 다른 Thread를 만들 수 있음
    크게 2가지가 있음 아래는 불편한 방법
     */

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }

}
