package vane.com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by wenshaobo on 2018/3/27.
 */
public class CilentHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object obj) throws Exception{
        try {
//            ByteBuf buf = (ByteBuf)obj;
//            byte[] data= new byte[buf.readableBytes()];
//            buf.readBytes(data);
            System.out.println("Cilent: " + obj);
        }finally {
            ReferenceCountUtil.release(obj);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
        cause.printStackTrace();
        ctx.close();
    }
}
