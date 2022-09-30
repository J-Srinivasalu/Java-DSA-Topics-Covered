public class LinkedListOp {
    public static void main(String[] args) {
        LinkedListImp ll = new LinkedListImp();
        System.out.println(ll.length());
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        System.out.println(ll);
        System.out.println(ll.delete());
        System.out.println(ll.delete());
        System.out.println(ll);
        System.out.println(ll.length());
    }
}
