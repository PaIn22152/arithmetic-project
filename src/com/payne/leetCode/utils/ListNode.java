package com.payne.leetCode.utils;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.utils
 * Date       2018/11/12 - 17:54
 * Author     Payne.
 * About      类描述：
 */

public class ListNode<T> {
    public T head;
    public ListNode<T> next;

    protected int len;

    public ListNode(T t) {
        this.head = t;
        this.next = null;
        this.len = 1;
    }

    public ListNode(T t, ListNode<T> next) {
        this.head = t;
        this.next = next;
        this.len = next.len + 1;
    }

    public int length() {
        if (next == null) {
            len = 1;
        } else {
            len = next.length() + 1;
        }
        return len;
    }

//    public T get(int position){
//        for(int i=0;i<position+1;i++){
//            return
//        }
//    }

    public T getTail(){
        ListNode<T> ref=this.next;
        for(int i=1;i<length()-1;i++){
            ref=ref.next;
        }
        return ref.head;
    }

//    public ListNode<T> addTail(T t) {
//        ListNode<T> ref = null;
//      while (this.next==null){
//
//      }
//        len++;
//    }

    public ListNode<T> addHead(T t) {
        ListNode<T> ref = new ListNode<>(t);
        ref.next = this;
        ref.len = 1 + this.len;
        return ref;
    }

//    public boolean del(int position) {
//        if (position >= len) {
//            return false;
//        }
//
//    }
//
//    public boolean del(int start, int length) {
//
//    }
//
//    public ListNode<T> reverse() {
//
//    }


    public boolean empty() {
        return len == 0;
    }
}
