package vane.com.generics;

import java.util.Iterator;

/**
 * Created by wenshaobo on 2018/3/19.
 */
public class IterableFibonacci implements Iterable<Integer> {
    private int count = 0;
    private int max = 0;
    private Fibonacci fibonacci = new Fibonacci();
    public IterableFibonacci(int n){
        max=n;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return ++count<=max;
            }

            @Override
            public Integer next() {
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for(int i :new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}
