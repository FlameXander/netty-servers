package com.flamexander.netty.servers.offtop_callbacks;

public class MyConsoleApp {
    public static void main(String[] args) {
        MyNet.sendMsg(() -> {
            System.out.println("Все отправлено");
        });
    }
}
