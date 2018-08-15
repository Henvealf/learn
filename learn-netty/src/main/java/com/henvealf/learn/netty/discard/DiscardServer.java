package com.henvealf.learn.netty.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author hongliang.yin/Henvealf on 2018/8/1
 */
public class DiscardServer {
     private int port;
     public DiscardServer(int port) {
         this.port = port;
     }

     public void run() throws InterruptedException {
         // boss 负责接受连接
         EventLoopGroup bossGroup = new NioEventLoopGroup();
         // boss 会将接受到的连接注册给 worker，由worker处理被接受连接的相关请求。
         EventLoopGroup workerGroup = new NioEventLoopGroup();

         try {
             // 帮助设置一个服务。
             ServerBootstrap b = new ServerBootstrap();

             b.group(bossGroup, workerGroup)
                     // 使用NioServerSocketChannel来接受进入的连接。。
                     .channel(NioServerSocketChannel.class)
                     // 使用ChannelInitializer来帮助用户配置一个新的 channel
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel socketChannel) throws Exception {
                             // 设置一个流水线，流水线的最后一个是通过DiscardServerHandler来实现网络应用
                             socketChannel.pipeline()
                              .addLast(new DiscardServerHandler());
                                // echo
//                                .addLast(new EchoServerHandler());
                         }
                     })
                     // 配置 TCP/IP 属性
                     .option(ChannelOption.SO_BACKLOG, 128)
                     .childOption(ChannelOption.SO_KEEPALIVE, true);
             // 绑定端口，你能调用多次来绑定不同的端口。来处理不同端口发来的请求。
             ChannelFuture f = b.bind(port).sync();

             // Wait until the server socket is closed.
             // In this example, this does not happen, but you can do that to gracefully
             // shut down your server.
             f.channel().closeFuture().sync();
         } finally {
             workerGroup.shutdownGracefully();
             bossGroup.shutdownGracefully();
         }
     }

    public static void main(String[] args) throws InterruptedException {
        int port = 9099;
        new DiscardServer(port).run();
    }
}
