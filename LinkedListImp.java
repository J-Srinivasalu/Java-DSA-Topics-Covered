public class LinkedListImp {
    private Node head;
    private int size = 0;

    int length(){
        return size;
    }

    boolean isEmpty(){
        return head == null;
    }

    Node headNode(){
        return head;
    }

    void insert(int data){
        size++;
        if(isEmpty()){
            head = new Node(data);
            return;
        }
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(data);
    }

    int delete(){
        if(isEmpty()){
            return -1;
        }
        size--;
        Node node = head;
        if(node.next == null){
            int data = head.data;
            head = null;
            return data;
        }
        Node deletedNode = node.next;
        while(deletedNode.next != null){
            node = deletedNode;
            deletedNode = deletedNode.next;
        }
        node.next = null;
        return deletedNode.data;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();

        st.append("{ ");
        Node node = head;
        if(head == null){
            return "{}";
        }
        while(node.next != null){
            st.append(node.data);
            st.append(", ");
            node = node.next;
        }

        st.append(node.data);
        st.append("}");

        return st.toString();
    }


}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
