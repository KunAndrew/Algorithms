package lesson4;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> pre; //первый
    private Node<T> post; //последний

    public DoubleLinkedList() {
        pre = new Node<>(null);
        post = new Node<>(null);
        pre.next = post;
        post.prev = pre;
    }

    public void insertTail(T value) {
        Node<T> last = post.prev;
        Node<T> newNode = new Node<>(value);
        newNode.next = post;
        newNode.prev = last;
    }

    public void insertHead(T value) {
        Node<T> newNode = new Node<>(value);

        if (pre.value == null) {
            pre.value = value;
            post.value = value;
        } else {
            newNode.next = null;
            newNode.prev = post;
            newNode.prev.next = newNode;
            post = newNode;
        }
    }

    public T deleteHead() {
        T deletedValue = pre.value;
        pre = pre.next;
        if (pre == null) {
            post = null;
        }
        return deletedValue;
    }

    public T deleteTail() {
        T deletedValue = post.value;
        Node<T> prev = post.prev;
        post = post.prev;
        if (post == null) {
            pre = null;
        } else {
            prev.next = null;
        }
        return deletedValue;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            DoubleLinkedList.Node<T> curr = pre;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertHead(2);
        doubleLinkedList.insertHead(3);
        doubleLinkedList.insertHead(5);
        doubleLinkedList.forEach(System.out::println);
        doubleLinkedList.deleteHead();
        System.out.println("delete head");
        doubleLinkedList.forEach(System.out::println);
        System.out.println("delete tail");
        doubleLinkedList.deleteTail();
        doubleLinkedList.forEach(System.out::println);
    }
}
