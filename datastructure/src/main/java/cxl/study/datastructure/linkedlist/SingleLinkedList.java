package cxl.study.datastructure.linkedlist;

import java.util.LinkedList;

public class SingleLinkedList<T> {

    private int size = 0;

    private Node head;

    private class Node{

        private T data;
        private Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public SingleLinkedList() {
        this.size = 0;
        this.head = new Node(null,null);
    }

    public void add(T t){
        Node current = head;
        while (current.next!=null){
            current = current.next;
        }
        current.next = new Node(t,null);
        this.size ++;
    }

    public Node get(T t){
        Node current = head;
        for(int i=0;i<size;i++){
            if(current.data!=null && current.data.equals(t)){
                return current;
            }else {
                current = current.next;
            }
        }
        return null;
    }

    public int size(){
        return this.size;
    }

    public void remove(T t){
        Node current = head;
        for(int i=0;i<size;i++){
            if(current.next.data.equals(t)){
                current.next =current.next.next;
            }else {
                current = current.next;
            }
        }
    }

    public LinkedList inverse(){
        Node prevNode = head;
        Node current = head.next;
        Node temp = null;
        while(head.next!=null){
            temp = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        System.out.println(singleLinkedList.get(2));
        singleLinkedList.remove(2);
        System.out.println(singleLinkedList);

    }

}
