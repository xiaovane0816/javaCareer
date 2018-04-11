package vane.com.generics;

/**
 * Created by wenshaobo on 2018/3/30.
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type = type;
    }
    @Override
    public T next() {
        try {
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public static <T>Generator<T> ceate(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
