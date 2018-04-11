package vane.com.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenshaobo on 2018/4/2.
 */
class Building{}
class House extends Building{}
public class ClassTypeCapture<T , V> {
    Class<T> kind ;
    Map<String, Class<?>> mapKind = new HashMap();
    public void addType(String typename, Class<?> kind) throws IllegalAccessException, InstantiationException {
        mapKind.put(typename, (Class<?>) kind.newInstance());
    }

    public V ceateNew(String typename) throws ClassNotFoundException {
        return (V) Class.forName(typename);

    }

    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
    }
    public boolean f (Object obj) {
        return kind.isInstance(obj);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassTypeCapture<Building,Building> ctt1 =
                new ClassTypeCapture<Building,Building>(Building.class);
        ctt1.addType("Building",Building.class);
        ctt1.addType("House",House.class);
        System.out.println(ctt1.mapKind);
//        System.out.println(Building.class.getName());
//        System.out.println(ctt1.ceateNew(Building.class.getName()));
//        System.out.println(ctt1.ceateNew("House"));
    }
}
