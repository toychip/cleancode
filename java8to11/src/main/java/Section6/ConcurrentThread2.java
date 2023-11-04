package Section6;

public class ConcurrentThread2 {

    public static void main(String[] args) {

        /**
         * Runable()이 Functional Interface로 바뀌었기 때문에 아래와 같이 가능하다.
         */
        Thread thread = new Thread(
                () -> {
                    try {
                        /**
                         * Thread를 대기시킬 수 있음.
                         * 다른 Thread에게 우선권이 감
                         * Java8이전의 사용 방법이 아닌 아래의 Hello 메인 메서드가 먼저 실행이 될것임.
                         */
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        // 누군가 깨우면 이곳에 들어옴
                        e.printStackTrace();
                    }
                    System.out.println("Java8이전의 사용 방법 Thread: " + Thread.currentThread().getName());
                });

        thread.start();

        System.out.println("Main Thread, Hello: " + Thread.currentThread().getName());
    }
}
