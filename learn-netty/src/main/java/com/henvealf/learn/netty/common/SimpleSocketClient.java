package com.henvealf.learn.netty.common;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.function.Supplier;

/**
 * @author hongliang.yin/Henvealf on 2018/8/15
 */
public class SimpleSocketClient {

    private final int port;
    private final Supplier<ChannelHandler>[] channelHandlerSuppliers;
    private final String host;

    public SimpleSocketClient(String host, int port, Supplier<ChannelHandler>... channelHandlerSuppliers) {
        this.port = port;
        this.host = host;
        this.channelHandlerSuppliers = channelHandlerSuppliers;
    }

    public void run() throws InterruptedException {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    for (Supplier<ChannelHandler> supplier : channelHandlerSuppliers) {
                        pipeline.addLast(supplier.get());
                    }
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
