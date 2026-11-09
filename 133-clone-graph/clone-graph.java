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
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        map.clear();
        Node clone_node = new Node(node.val);
        map.put(node, clone_node);
        DFS(node, clone_node);
        return clone_node;
        
    }
    void DFS(Node node, Node clone_node){
        for(Node n : node.neighbors){
            if(!map.containsKey(n)){
                Node clone = new Node(n.val);
                map.put(n, clone);
                clone_node.neighbors.add(clone);
                DFS(n, clone);
            } else{
                clone_node.neighbors.add(map.get(n));
            }
        }
    }
}