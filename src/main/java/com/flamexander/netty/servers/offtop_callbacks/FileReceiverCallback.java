package com.flamexander.netty.servers.offtop_callbacks;

import java.nio.file.Path;

public interface FileReceiverCallback {
    void callback(Path path);
}
