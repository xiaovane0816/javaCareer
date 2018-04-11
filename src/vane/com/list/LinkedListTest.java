package vane.com.list;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by wenshaobo on 2018/4/9.
 */
public class LinkedListTest<T> {
    private Node<T> frist;
    private Node<T> last;
    private int size;
    public LinkedListTest(){
        this.frist = null;
        this.last = null;
        this.size = 0;
    }
    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
        Node(Node<T> prev,T item,Node<T> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private void linkFirst(T e){
        Node<T> f = frist;
        Node<T> n = new Node(null,e,f);
        frist = n;
        if (n.next == null) {
            last = n;
        } else {
            f.prev = n;
        }
        size++;
    }
    private void linkLast(T e) {
        Node<T> l = last;
        Node<T> n = new Node<>(last,e,null);
        last = n;
        if (l == null) {
            frist = n;
        } else {
            l.next=n; // ==>n.prev.next = n
        }
        size++;
    }
    private void linkBefore(T e,Node<T> n){
        Node<T> prev = n.prev;
        Node<T> newNode = new Node<>(null,e,n);
        n.prev = newNode;
        if (prev == null) {
            frist = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }
    private T popLinkFrist(Node<T> n){
        T i = n.item;
        Node<T> next = n.next;
        n.item = null;
        n.next = null;
        frist = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return i;
    }
    private T popLinkLast(Node<T> n) {
        T i = n.item;
        Node<T> prev = n.prev;
        n.item = null;
        n.prev = null;
        last = prev;
        if (prev == null) {
            frist = null;
        } else {
            prev.next = null;
        }
        return i;
    }
    private T popLinkNode(Node<T> n) {
        T i = n.item;
        Node<T> prev = n.prev;
        Node<T> next = n.next;
        if (prev == null) {
            frist = n.next;
        } else {
            prev .next = next;
            n.prev = null;
        }
        if (next == null) {
            last = n.prev;
        } else {
            next.prev = prev;
            n.next = null;
        }
        n.item = null;
        size--;
        return i;
    }

    public T getFirst(){
        Node<T> n = frist;
        return n.item;
    }

    public T getLast(){
        Node<T> n = last;
        return n.item;
    }

    public void addFrist(T item) {
        linkFirst(item);
    }

    public void addLast(T item) {
        linkLast(item);
    }

    public T deleteFirst(){
        Node<T> n = frist;
        if(n == null) {
            System.out.println("链表为空，无法删除");
        }
        return popLinkFrist(n);
    }

    public T deleteLast(){
        Node<T> n = last;
        if(n==null){
            System.out.println("链表为空，无法删除");
        }
        return popLinkLast(n);
    }

    public boolean deleteIndex(Object obj) {
        if (obj == null) {
            for (Node<T> n = frist; n != null; n = n.next) {
                if (n.item == null) {
                    popLinkNode(n);
                    return true;
                }
            }
        } else {
            for(Node<T> n = frist; n != null; n = n.next) {
                if(n.item.equals(obj)){
                    popLinkNode(n);
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    private int indexOf(Object object) {
        int index = 0;
        if (object == null) {
            for (Node<T> n = frist; n != null; n = n.next) {
                if (n.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> n = frist; n != null; n = n.next) {
                if (n.item.equals(object)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedListTest<Integer> linkedListTest = new LinkedListTest<>();
        linkedListTest.addFrist(1);
        linkedListTest.addFrist(2);
        linkedListTest.addLast(3);
        System.out.println(linkedListTest);
        System.out.println("Size: "+linkedListTest.getSize());
        System.out.println("Frist: "+linkedListTest.getFirst());
        System.out.println("Last: "+linkedListTest.getLast());
    }
}
