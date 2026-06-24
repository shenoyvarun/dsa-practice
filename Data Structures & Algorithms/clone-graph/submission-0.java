/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if(node == null)
            return null;

        if(map.containsKey(node))
            return map.get(node);

        Node curr = new Node(node.val);
        map.put(node, curr);

        for(Node neigh: node.neighbors) {
            curr.neighbors.add(dfs(neigh, map));
        }

        return curr;
    }
}
