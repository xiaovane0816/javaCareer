package vane.com.generics;

/**
 * Created by wenshaobo on 2018/3/30.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.ceate(CountedObject.class);
        for(int i = 0; i < 5; i ++) {
            System.out.println(((CountedObject)gen.next()).id());

        }
    }
}
