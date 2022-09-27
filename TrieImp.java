public class TrieImp {
    public class Node{
        Node links[] = new Node[26];
        boolean flag;

        boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    class Trie{
        Node root;

        void insert(String s){
            if(root == null){
                root = new Node();
            }
            Node node = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        boolean search(String s){
            Node node = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return node.isEnd();
        }
    }

    public static void main(String[] args) {
        
    }

}
