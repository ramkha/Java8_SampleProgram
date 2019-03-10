package com.ramesh.example.sampleprogram.ThreadLambasExample;

public class ThreadExample implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Child Thread");
        }
    }
}

class DemoThread {
    public static void main(String[] args) {
        Runnable r = new ThreadExample();
        Thread t = new Thread(r);           //By this time there is only one thread, i.e Main thread
        t.start();                          // By this time there is two thread i.e main thread and child thread which is t

        for (int i = 0; i <10 ; i++) {
            System.out.println("Main Thread");
        }
    }
}

interface Anonymous {
    void exampleMethod();
}
