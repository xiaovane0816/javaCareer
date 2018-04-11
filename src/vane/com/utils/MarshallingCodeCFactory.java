package vane.com.utils;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.*;

/**
 * Marshaling工具类
 * Created by wenshaobo on 2018/3/27.
 */
public final class MarshallingCodeCFactory {

    /**
     * 创建JBoss Marshalling解码器MarshallingDecoder
     * @return MarshllingDecoder
     */
    public static MarshallingDecoder buildMarshallingDecoder(){
        //首先通过Marshalling工具类的精通方法获取Marshalling实例对象 参数serial标识创建的是java序列化工厂对象。
        final MarshallerFactory marshallingCodeCFactory = Marshalling
                .getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        //根据Factory和Configuration创建provider
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallingCodeCFactory,configuration);
        MarshallingDecoder decoder = new MarshallingDecoder(provider,1024 * 1024 * 1);
        return decoder;
    }

    public static MarshallingEncoder buildMarshallingEncoder(){
        final MarshallerFactory marshallerFactory = Marshalling
                .getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(
                marshallerFactory,configuration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }
}
