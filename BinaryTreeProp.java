public class BinaryTreeProp {

    /*
     * Properties: Height, Count, Diameter
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
        int[] arr = {1,2,4,7,8,-1,-1,-1,-1,5,-1,-1,3,6,-1,-1,-1};
        Node root = buildBT(arr);
        System.out.println(height(root));
        System.out.println(countNodes(root));
        System.out.println(diameter(root));
        System.out.println(diameterFast(root));
        System.out.println(diameterFast(root));
    }

    static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }

    static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);

        return Math.max(heightLeft+heightRight+1, Math.max(diameterLeft, diameterRight));
    }

    static int ans = 0;

    static int diameterFast(Node root){
        diameterWithHeight(root);
        return ans;
    }

    static int diameterWithHeight(Node root){
        if(root == null) return 0;
        int heightLeft = diameterWithHeight(root.left);
        int heightRight = diameterWithHeight(root.right);

        ans = Math.max(ans, 1+ heightLeft + heightRight);
        return 1+Math.max(heightLeft, heightRight); 
    }


}
