package basics;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.push(5);
        queue.pop();
        queue.pop();
        queue.pop();
    }
}


class MyQueue {
    Stack<Integer> stack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        if(stack.isEmpty()) stack.add(x);
        else{
            int[] temp = new int[stack.size()];
            int i=0;
            while(!stack.isEmpty()){
                temp[i] = stack.pop();
                i++;
            }
            stack.push(x);
            for(int j=temp.length-1; j>=0; j--){
                stack.push(temp[j]);
            }
        }

    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();

    }

    public boolean empty() {
        return stack.isEmpty()?true:false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */