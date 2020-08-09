package 자료구조;

import java.util.Stack;

public class 큐_2개의스택 {
    public static void main(String[] args) {
        StackQueue q = new StackQueue();


        q.inQueue(1);
        q.inQueue(2);

        System.out.println(q.outQueue());

        q.inQueue(3);

        System.out.println(q.outQueue());
        System.out.println(q.outQueue());

    }


    static class StackQueue{
        Stack in_queue;
        Stack out_queue;

        StackQueue(){
            this.in_queue = new Stack<>();
            this.out_queue = new Stack<>();

        }

        void inQueue(int v){
            in_queue.add(v);

        }

        int outQueue(){
            if(out_queue.isEmpty())//** point **
                while(!in_queue.isEmpty()){
                    out_queue.add(in_queue.pop());
                }
            return (int) out_queue.pop();
        }


    }
}
