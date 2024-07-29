package com.ahmetvatansever;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*
            StringBuilder : 19999
            StringBuffer  : 20000
        */

        StringBuilder myStringBuilder = new StringBuilder();
        StringBuffer myStringBuffer = new StringBuffer();

        Runnable myRunnable1 = () -> {
            for(int i=0; i<10000; i++) {
                myStringBuilder.append("a");
                myStringBuffer.append("a");
            }
        };

        Runnable myRunnable2 = () -> {
            for(int i=0; i<10000; i++) {
                myStringBuilder.append("b");
                myStringBuffer.append("b");
            }
        };

        Thread myTheread1 = new Thread(myRunnable1);
        Thread myTheread2 = new Thread(myRunnable2);

        myTheread1.start();
        myTheread2.start();

        myTheread1.join();
        myTheread2.join();

        System.out.println("StringBuilder : "+myStringBuilder.toString().length());
        System.out.println("StringBuffer  : "+myStringBuffer.toString().length());
    }
}
