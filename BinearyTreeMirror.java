import java.util.*;

public class BinearyTreeMirror {
    /*
     * Mirror 
     * Is Symmetric
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
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        int[] sym = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        Node root = buildBT(arr);
        i = -1;
        Node root2 = buildBT(sym);
        levelOrder(root);
        root = mirror(root);
        levelOrder(root);
        levelOrder(root2);
        System.out.println(isSymmetric(root, root));
        System.out.println(isSymmetric(root2, root2));
    }

    static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    static boolean isSymmetric(Node first, Node second){
        if(first == null && second == null) return true;

        if(first.data == second.data) return isSymmetric(first.left, second.right) && isSymmetric(first.right, second.left);
        
        return false;
    }

    static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }

    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        int space = height(root)-1;
        boolean first = true;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr== null){
                first = true;
                System.out.println();
                space--;
                if(!q.isEmpty()){
                    q.add(null);
                }else{
                    break;
                }
            }else{
                if(first) for(int i=0;i<space;i++) System.out.print(" ");
                first = false;
                System.out.print(curr.data+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

}
