package ru.javarush.tolstikhin.my_island.threads;

public class MyThread implements Runnable{
    private MyCallingBack myCallingBack;

    public MyThread(MyCallingBack myCallingBack) {
        this.myCallingBack = myCallingBack;
    }

    @Override
    public void run() {
    }
}
