package vane.com.generics;

/**
 * Created by wenshaobo on 2018/3/19.
 */
public class GenericMethod {
    public <U,V> void f(String x,U t,V y){
        System.out.println(x.getClass().getName()+"  "+t.getClass().getName()+"  "+y.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("",1,gm);
    }
}
