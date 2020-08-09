package 자료구조;


//엄연히 원형큐
public class 큐 {
    public static void main(String args[]){
        UserQueue q = new UserQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());

        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());


    }

    public static class UserQueue{
        int front;
        int rear;
        int[] queue;
        int size;

        public UserQueue(int size){
            front = -1;
            rear = -1;
            this.size = size;
            queue = new int[this.size];
        }

        boolean isEmpty(){
            return (rear == front);
        }

        boolean isFull(){
            return rear == this.size-1;
        }

        void enqueue(int input){
            if(isFull()){
                System.out.println("FULL");
                return;
            }
            rear = (++rear) % size;
            queue[rear] = input;
            System.out.println("enqueue - " + input);
        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("Under Flow");

                return -1;
            }
            front = (++front) % size;
            System.out.println("dequeue - " + queue[front]);
            return queue[front];
        }

    }
}
