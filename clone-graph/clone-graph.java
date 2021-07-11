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
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
//      Add first node in queue
        q.add(node);
//      Add the same node in a map, with the node value and empty neigbours
        map.put(node, new Node(node.val));
//      Start BFS
        while(!q.isEmpty()){
//          Pop the first node
            Node h = q.poll();
//          Find its neighbors
            for(Node nbr: h.neighbors){
//              If Neighbor not already in map, ie. not visited
                if(!map.containsKey(nbr)){
//                  put it in map, with value and empty arraylist of neigbours
                    map.put(nbr, new Node(nbr.val));
//                  add the neigbour to queue(BFS)
                    q.add(nbr);
                }
//              Mandatorily add this connection to the list of neighbours of the parent which was just popped
                map.get(h).neighbors.add(map.get(nbr));
            }
        }
        
        return map.get(node);
        
    }
}