package vane.com.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by wenshaobo on 2018/3/27.
 */
public class GzipUtils {
    //压缩
    public static byte[] gzip(byte[] val) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream(val.length);
        GZIPOutputStream gos = null;
        try{
            gos = new GZIPOutputStream(bos);
            gos.write(val,0,val.length);
            gos.finish();
            gos.flush();
            bos.flush();
            val = bos.toByteArray();
        }finally {
            if(gos != null) {
                gos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return val;
    }
    //解压
    public static byte[] unGzip(byte[] buf) throws Exception {
        GZIPInputStream gis = null;
        ByteArrayOutputStream bos = null;
        try {
            gis = new GZIPInputStream(new ByteArrayInputStream(buf));
            bos = new ByteArrayOutputStream(buf.length);
            int count = 0 ;
            byte[] tmp = new byte[2048];
            while((count = gis.read(tmp))!= -1){
                bos.write(tmp,0,count);
            }
            buf = bos.toByteArray();
        }finally {
            if(bos != null) {
                bos.close();
            }
            if(gis != null) {
                gis.close();
            }
        }
        return buf;
    }
}
