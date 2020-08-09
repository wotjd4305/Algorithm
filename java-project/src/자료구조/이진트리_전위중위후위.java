package 자료구조;

public class 이진트리_전위중위후위 {
    public static Node root;

    public static void main(String args[]){

        // 7 2 8 1 3 9 10 6
        insert(7);
        insert(2);
        insert(8);
        insert(1);
        insert(3);
        insert(9);
        insert(10);
        insert(6);

        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();

    }

    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data){
            left = null;
            right = null;
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    /*삽입 연산*/
    public static void insert(int data) {
        Node newNode = new Node(data); // 왼쪽, 오른쪽 자식 노드가 null 이며 data 의 값이 저장된 새 노드 생성
        if(root == null){// 루트 노드가 없을때, 즉 트리가 비어있는 상태일 때,
            root = newNode;
            return;
        }

        Node currentNode = root;
        Node parentNode = null;

        while(true) {

            parentNode = currentNode;

            if(data < currentNode.getData()) { // 해당 노드보다 클 떄.
                currentNode = currentNode.getLeft();
                if(currentNode == null) {
                    parentNode.setLeft(newNode);
                    return ;
                }
            }else { // 해당 노드보다 작을 때.
                currentNode = currentNode.getRight();
                if(currentNode == null){
                    parentNode.setRight(newNode);
                    return ;
                }
            }
        }

    }



    private static void preOrder(Node index) {

        System.out.print(index.data + " ");// 부모 정점 (방문해서 할일 : 출력)
        if(index.left != null) preOrder(index.left);// 왼쪽 자식
        if(index.right != null) preOrder(index.right);// 오른쪽 자식

    }


    private static void inOrder(Node index) {
        if(index.left != null) preOrder(index.left);// 왼쪽 자식
        System.out.print(index.data + " ");// 부모 정점 (방문해서 할일 : 출력)
        if(index.right != null) preOrder(index.right);// 오른쪽 자식
    }

    private static void postOrder(Node index) {
        if(index.left != null) preOrder(index.left);// 왼쪽 자식
        if(index.right != null) preOrder(index.right);// 오른쪽 자식
        System.out.print(index.data + " ");// 부모 정점 (방문해서 할일 : 출력)
    }



}
