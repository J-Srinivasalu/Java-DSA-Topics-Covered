public class Trie2Imp {
    static class Node{
        Node[] links = new Node[26];
        int countEndWith = 0;
        int countPrefix = 0;

        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

    }

    static class Trie{
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
                node.countPrefix++;
            }
            node.countEndWith++;
            node.countPrefix++;
        }
        int countEndWith(String s){
            Node node = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                node = node.get(ch);
            }
            return node.countEndWith;
        }

        int countStartsWith(String s){
            Node node = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                node = node.get(ch);
            }
            return node.countPrefix;
        }

        void erase(String s){
            Node node = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                node = node.get(ch);
                node.countPrefix--;
            }
            node.countEndWith--;
            node.countPrefix--;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("applications");

        System.out.println(trie.countEndWith("apple"));
        System.out.println(trie.countStartsWith("app"));
        System.out.println(trie.countEndWith("apps"));
        trie.erase("apps");
        System.out.println(trie.countStartsWith("app"));
        System.out.println(trie.countEndWith("apps"));

    }

}
