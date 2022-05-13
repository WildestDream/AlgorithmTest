package binarytree;

import lombok.SneakyThrows;

public class Test {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new Task(lock1, lock2));
        t1.setName("T1");
        t1.start();

        Thread t2 = new Thread(new Task(lock2, lock1));
        t2.setName("T2");
        t2.start();

        t2.stop();
    }

    private static class Task implements Runnable {

        private final Object lock1;
        private final Object lock2;

        public Task(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @SneakyThrows
        @Override
        public void run() {



            Thread thread = Thread.currentThread();
            String t = thread.getName();
            synchronized (lock1) {
                System.out.println(t + " get lock " + lock1);
                Thread.sleep(100);
                System.out.println(t + " wait lock " + lock2);
                synchronized (lock2) {
                    System.out.println(t + " get lock " + lock2);
                }
            }
        }
    }
}
