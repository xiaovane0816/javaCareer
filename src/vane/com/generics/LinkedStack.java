package vane.com.generics;

/**
 * 不使用linkedList实现栈
 * @author wenshaobo
 * @date 2018/3/19
 */
public class LinkedStack<T> {
    private class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item=null;
            next=null;
        }
        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean isEnd(){
            return this.item==null&&this.next==null;
        }
    }
    private Node<T> stack = new Node<T>();
    public T pop(){
        T result = stack.item;
        if(!stack.isEnd()){
            stack = stack.next;
        }
        return result;
    }
    public void push(T item){
        stack = new Node<T>(item,stack);
    }

    public static void main(String[] args) {
        LinkedStack<Character> stringLinkedStack = new LinkedStack<Character>();
        for(char s : "u evol I".toCharArray()){
            stringLinkedStack.push(s);
        }
        Character a ;
        while (null != (a = stringLinkedStack.pop())){
            System.out.print(a);
        }
    }
}
