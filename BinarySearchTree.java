import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree{

    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 8);
        root = insert(root, 4);
        root = insert(root, 10);
        root = insert(root, 6);
        root = insert(root,1);
        root = insert(root, 14);
        root = insert(root, 4);
        root = insert(root, 4);
        levelOrder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        delete(root, 12);
        levelOrder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        
    }

    static Node insert(Node root, int val){
        if(root == null) return new Node(val);
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    static boolean search(Node root, int val){
        if(root == null) return false;
        if(root.data == val) return true;
        if(root.data > val) search(root.left, val);
        return search(root.right, val);
    }

    static Node delete(Node root,int val){
        if(root == null) return root;
        if(root.data>val) root.left = delete(root.left, val);
        else if(root.data < val) root.right = delete(root.right, val);
        else{
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            Node inorderSuccessor = findIS(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);
        }
        return root;
    }

    static Node findIS(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()) break;
                q.add(null);
            }else{
                System.out.print(curr.data+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}