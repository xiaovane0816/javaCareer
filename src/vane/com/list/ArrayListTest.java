package vane.com.list;

import java.util.Arrays;

/**
 * Created by wenshaobo on 2018/4/10.
 */
public class ArrayListTest<T> {
    //用来存储list数据
    private Object[] element ;

    private Object[] DEFAULT_EMPYT_ElEMENT = {};
    private int ARRAY_MAX_LENGTH = Integer.MAX_VALUE - 8;

    private int size = 0;
    private int DEFAULT_SIZE = 10;

    public ArrayListTest(){
        element = DEFAULT_EMPYT_ElEMENT;
    }

    private void ensureCapacityInternal(int l) {
        if (element == DEFAULT_EMPYT_ElEMENT) {
            l = Math.max(DEFAULT_SIZE,l);
        }
        if(l - element.length>0) {
            //增加长度
            grow(l);
        }
    }

    private void grow(int l){
        int oldSize = element.length;
        int newSize = oldSize + (oldSize>>1);
        if(newSize - l<0){
            newSize = l;
        }
        if (newSize - ARRAY_MAX_LENGTH > 0) {
            newSize = hugeSize(l);
        }
        element = Arrays.copyOf(element,newSize);
    }

    private int hugeSize(int l) {
        if(l < 0) {
            System.out.println("越界！");
        }
        return (l > ARRAY_MAX_LENGTH)? Integer.MAX_VALUE : ARRAY_MAX_LENGTH;
    }

    public boolean add(T o) {
        ensureCapacityInternal(size + 1);
        element[size++] = o;
        return true;
    }

    public T set (int index,T o) {
        rangeCheck(index);
        T oldElement = element(index);
        element[index] = o;
        return oldElement;
    }

    private T element(int index){
        return (T)element[index];
    }

    private boolean rangeCheck(int index) {
        if(index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    public T get (int index) {
        rangeCheck(index);
        return element(index);
    }

    public boolean remove(T o) {
        if(o == null){
            for(int index = 0; index < element.length; index ++) {
                if (element[index] == null) {
                    //删除
                    fastRemove(index);
                    return true;
                }
            }
        }else {
            for(int index = 0; index < element.length; index ++) {
                if(element[index].equals(o)){
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove (int index ) {
        int count = size - index - 1;
        if (count > 0) {
            System.arraycopy(element, index + 1, element, index, count);
        }
        element[--size] = null;
    }

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();

    }
}
