public class HelloWorldExend extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(
                "Hello World"
        );
    }

    public static void main(String[] args) {
        Thread thread = new HelloWorldExend();
        System.out.println(thread.getName());
        thread.start();
        thread.start();
    }

}
