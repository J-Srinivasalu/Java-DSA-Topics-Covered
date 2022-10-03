import java.util.Stack;

public class BinaryTreeTraversal2 {
    /*
     * Traversal: inorder, preorder, postorder without using recursion and level order with recursion
     * 
     */

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static int i = -1;

    static Node buildBT(int[] arr){
        i++;
        if(arr[i] == -1){
            return null;
        }
        Node node = new Node(arr[i]);
        node.left = buildBT(arr);
        node.right = buildBT(arr);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,-1};
        Node root = buildBT(arr);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
    }

    static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }

    static void levelorder(Node root){
        int height = height(root);
        for(int i=0;i<height;i++){
            levelorderHelper(root, i);
            System.out.println();
        }
    }

    static void levelorderHelper(Node root, int level){
        if(root == null){
            return;
        }
        if(level == 0){
            System.out.print(root.data+" ");
            return;
        }
        levelorderHelper(root.left, level-1);
        levelorderHelper(root.right, level-1);
    }
    static void preorder(Node root){
        Stack<Node> st = new Stack<>();
        Node curr = root;
        st.push(curr);
        while(!st.isEmpty()){
            curr = st.pop();
            System.out.print(curr.data+" ");
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
    }
    static void postorder(Node root){
        Stack<Node> first = new Stack<>();
        Stack<Node> second = new Stack<>();
        Node curr = root;
        first.push(curr);
        while(!first.isEmpty()){
            curr = first.pop();
            second.push(curr);
            if(curr.left != null) first.push(curr.left);
            if(curr.right != null) first.push(curr.right);
        }
        while(!second.isEmpty()){
            System.out.print(second.pop().data+ " ");
        }
    }
    static void inorder(Node root){
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }

}
