package com.flamexander.netty.servers.proto_file;

import javafx.scene.control.Label;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

public class ProtoClient {
    public static void main(String[] args) throws Exception {
        CountDownLatch networkStarter = new CountDownLatch(1);
        new Thread(() -> Network.getInstance().start(networkStarter)).start();
        networkStarter.await();
        Network.getInstance().setOnReceivedCallback(() -> {
            // refreshLocalFilesList();
        });

        ProtoFileSender.sendFile(Paths.get("demo.txt"), Network.getInstance().getCurrentChannel(), future -> {
            if (!future.isSuccess()) {
                future.cause().printStackTrace();
            }
            if (future.isSuccess()) {
                System.out.println("Файл успешно передан");
            }
        });
//        Thread.sleep(2000);
        ProtoFileSender.sendFile(Paths.get("demo1.txt"), Network.getInstance().getCurrentChannel(), future -> {
            if (!future.isSuccess()) {
                future.cause().printStackTrace();
            }
            if (future.isSuccess()) {
                System.out.println("Файл успешно передан");
            }
        });
    }
}
