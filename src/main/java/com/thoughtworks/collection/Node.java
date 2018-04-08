package com.thoughtworks.collection;

public class Node {
    private Object data;
    private Node next;
    public Node()
    {
    }
    public Node(Object data,Node next)
    {
        this.data = data;
        this.next = next;
    }
}
