package vane.com.generics;

/**
 * Created by wenshaobo on 2018/4/2.
 */
public class GenericArray<T> {
    private T[] array;
    public GenericArray(int sz) {
        array = (T[])new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }

    public T get (int index) {
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray =
                new GenericArray<>(10);
        for(int i = 0;i < 10;i ++) {
            genericArray.put(i,i);
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(genericArray.get(i));
        }
        Object[] oa = genericArray.rep();
    }
}
