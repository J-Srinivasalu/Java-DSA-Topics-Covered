import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
    /*
     * Traversal: inorder, preorder, postorder and level order
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

    //Inorder Traversal
    //TC: O(N)
    //SC: O(N)
    static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //Preorder Traversal
    //TC: O(N)
    //SC: O(N)
    static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //Postorder Traversal
    //TC: O(N)
    //SC: O(N)
    static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    //Levelorder Traversal
    //TC: O(N)
    //SC: O(N)

    static void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()) break;
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
        }
    }
}
