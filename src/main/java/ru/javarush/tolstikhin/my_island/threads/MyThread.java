package ru.javarush.tolstikhin.my_island.threads;

public class MyThread implements Runnable{
    private MyCallbackTask myCallingBack;

    public MyThread(MyCallbackTask myCallingBack) {
        this.myCallingBack = myCallingBack;
    }

    @Override
    public void run() {
    }
}
