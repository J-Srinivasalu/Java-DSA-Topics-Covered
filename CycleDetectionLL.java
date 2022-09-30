public class CycleDetectionLL {

    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {

        Node node0 = new Node(0, null);
        Node node1 = new Node(1, node0); // 1 -> 0
        Node node2 = new Node(2, node1); // 2 - > 1 -> 0
        Node node3 = new Node(3, node2); // 3 - > 2 - > 1 -> 0
        Node node4 = new Node(4, node3); // 4 - > 3 - > 2 - > 1 -> 0
        Node node5 = new Node(5, node4); // 5 -> 4 - > 3 - > 2 - > 1 -> 0
        // node0.next = node2; // used to introduce cycle into linked list
        /*
         * 5 -> 4 - > 3 - > 2 - > 1 -> 0
         *                  ^          |
         *                  |__________|
         *                  
         */

        System.out.println(hasCycle(node5));

    }

    static boolean hasCycle(Node head){
        if(head == null || head.next == null) return false;

        Node slow = head;
        Node fast = slow.next.next;

        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

