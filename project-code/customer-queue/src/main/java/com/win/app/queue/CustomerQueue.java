package com.win.app.queue;


public class CustomerQueue<T> implements Queue<T> {

    private ListNode<T> first;

    private ListNode<T> last;
    @Override
    public T pop() {
        if (first == null) {
            return null;
        }
        ListNode<T> firstNode = this.first;
        ListNode<T> suffixNode = this.first.suffixNode;
        if (suffixNode != null){
            this.first.suffixNode = null;
            suffixNode.prefixNode = null;
        }
        first = suffixNode;
        return firstNode.value;
    }

    @Override
    public void push(T value) {
        ListNode<T> current = new ListNode<>(value);
        if (last == null) {
            last = current;
            first = last;
        }else{
            last.suffixNode = current;
            current.prefixNode = last;
        }

    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    static class ListNode<T>{
        private ListNode<T> prefixNode;

        private ListNode<T> suffixNode;

        private T value;

        public ListNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" + "value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        return "CustomerQueue{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
