package org.hfeng.c03.e01;

public class TwoThread extends Thread {
    private Thread creatorThread;

    public TwoThread() {
        creatorThread = Thread.currentThread();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread t = Thread.currentThread();

        if (t == creatorThread) {
            System.out.println("Creator thread");
        } else if (t == this) {
            System.out.println("New thread");
        } else {
            System.out.println("Mystery thread - unexpected!");
        }
    }

    public static void main(String[] args) {
        TwoThread tt = new TwoThread();
        tt.start(); // start() will internally trigger the run()

        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }
    }
}
