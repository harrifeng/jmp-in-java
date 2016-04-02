package org.hfeng.c03.e05;

public class TwoThreadSetName extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }

    public static void main(String[] args) {
        TwoThreadSetName tt = new TwoThreadSetName();
        tt.setName("my worker thread");
        tt.start();

        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }
    }
}
