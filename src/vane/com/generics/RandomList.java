package vane.com.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * 通过泛型实现随机获取list中的一个元素
 * @author wenshaobo
 * @date 2018/3/19
 */
public class RandomList<T> {
    private ArrayList<T> storeList = new ArrayList<T>();
    private Random random = new Random(47);
    public void add(T item){
        storeList.add(item);
    }
    public T select (){
        return storeList.get(random.nextInt(storeList.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<String>();
        for(String s:"The quick brown fox jumped over the lazy brown dog".split(" ")){
            randomList.add(s);
        }
        for(int i = 0; i < 11; i++){
            System.out.print(randomList.select()+" ");
        }
    }
}
