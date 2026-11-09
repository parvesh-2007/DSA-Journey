/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> mp = new HashMap<>(); // Class level
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
            mp.clear();
            // clone the given node
            Node clone_node = new Node(node.val);
            // Now, clone its neighnours and recursively their neighbours
            
               //But if a node reappears then we need to acess that cloned node
               //So store them in map 

            mp.put(node, clone_node);
            DFS(node, clone_node);
            return  clone_node;

        }
        void DFS(Node node, Node clone_node){
        for(Node n : node.neighbors){
          if(!mp.containsKey(n)){
            Node clone = new Node(n.val);
            mp.put(n, clone);
            clone_node.neighbors.add(clone);
            DFS(n,clone);
          }else{
            clone_node.neighbors.add(mp.get(n));
          }
        }
    }

        
}
    
