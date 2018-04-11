package vane.com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import vane.com.utils.MarshallingCodeCFactory;

/**
 * Created by wenshaobo on 2018/3/27.
 */
public class Server {
    private int port; //端口
    public Server(int port) {
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //用于处理服务器端接受客户端链接
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //用于处理网络通信（读写）
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap(); //用于服务器通道的一系列配置
            serverBootstrap.group(bossGroup,workerGroup) //绑定两个线程组
                            .channel(NioServerSocketChannel.class) //指定NIO的模式
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                                    socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                                    socketChannel.pipeline().addLast(new ServerHandler());
                                }
                            }).handler(new LoggingHandler(LogLevel.INFO))
                            .option(ChannelOption.SO_BACKLOG,1024) //设置TCP缓冲区
                            .option(ChannelOption.SO_SNDBUF,32 * 1024) //设置发送数据缓冲区大小
                            .option(ChannelOption.SO_RCVBUF,32 * 1024) //设置接受数据缓冲区大小
                            .childOption(ChannelOption.SO_KEEPALIVE, true); //保持连接
            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.println("服务器启动");
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new Server(8379).run();
    }
}
