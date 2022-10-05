import java.util.*;

public class BinaryTreeView {
    /*
     * View: Top, buttom, left and right
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
        topView(root);
        System.out.println();
        bottomView(root);
        System.out.println();
        leftView(root);
        System.out.println();
        rightView(root);
    }

    static class Pair{
        int hd;
        Node node;
        Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }

    static void topView(Node root){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            map.putIfAbsent(curr.hd, curr.node.data);
            if(curr.node.left != null) q.add(new Pair(curr.hd-1, curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.hd+1, curr.node.right));
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    static void bottomView(Node root){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            map.put(curr.hd, curr.node.data);
            if(curr.node.left != null) q.add(new Pair(curr.hd-1, curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.hd+1, curr.node.right));
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    static void leftView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        leftViewHelper(root, ans, 0);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    static void leftViewHelper(Node root, ArrayList<Integer> ans, int level){
        if(root == null){
            return;
        }
        try{
            ans.get(level);
        }catch(Exception e){
            ans.add(level, root.data);
        }
        leftViewHelper(root.left, ans, level+1);
        leftViewHelper(root.right, ans, level+1);
    }

    static void rightView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        rightViewHelper(root, ans, 0);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    static void rightViewHelper(Node root, ArrayList<Integer> ans, int level){
        if(root == null){
            return;
        }
        try{
            ans.set(level, root.data);
        }catch(Exception e){
            ans.add(level, root.data);
        }
        rightViewHelper(root.left, ans, level+1);
        rightViewHelper(root.right, ans, level+1);
    }
}
