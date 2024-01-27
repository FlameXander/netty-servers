package com.flamexander.netty.servers.proto_file;

import com.flamexander.netty.servers.offtop_callbacks.Callback;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DemoHandler extends ChannelInboundHandlerAdapter {
    private Callback onReceivedCallback;

    public void setOnReceivedCallback(Callback onReceivedCallback) {
        this.onReceivedCallback = onReceivedCallback;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // file receiving
        onReceivedCallback.callback();
    }
}
