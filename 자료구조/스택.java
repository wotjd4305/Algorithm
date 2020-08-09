package 자료구조;

public class 스택 {
    public static void main(String args[]){
        UserStack st = new UserStack(10);
        st.push(1);
        System.out.println(st.pop());


    }

    public static class UserStack{
        int top;
        int[] stack;
        int size;

        public UserStack(int size){
            top = -1;
            this.size = size;
            stack = new int[this.size];
        }

        void push(int input){
            if(top == this.size-1){
                System.out.println("FULL");
                return;
            }
            stack[++top] = input;
            System.out.println("push - " + input);
        }

        int pop(){
            if(top == -1){
                System.out.println("End");
                return -1;
            }
            System.out.println("Pop - " + stack[top]);
            return stack[top--];
        }

        void peek(){
            System.out.println("peek " + stack[top]);
        }
    }
}
