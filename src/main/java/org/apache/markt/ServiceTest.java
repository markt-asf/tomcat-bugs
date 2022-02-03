package org.apache.markt;

public class ServiceTest {

    private static volatile boolean running = true;
    private static Thread service;



    /**
     * Start test service.
     *
     * @param args  Ignored
     */
    static void start(String[] args) {
        System.out.println("Entering start()");

        service = new Thread() {
            @Override
            public void run() {
                while (running) {
                    System.out.println("Running loop");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        service.start();

        System.out.println("Leaving start()");
    }


    /**
     * Stop test service.
     *
     * @param args  Ignored
     */
    static void stop(String[] args) {
        System.out.println("Entering stop()");

        running = false;
        try {
            service.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Leaving stop()");
    }
}
