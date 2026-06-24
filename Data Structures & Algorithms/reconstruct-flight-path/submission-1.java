class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> t: tickets) {
            adj.putIfAbsent(t.get(0), new PriorityQueue<>());
            adj.get(t.get(0)).add(t.get(1));
        }

        List<String> res = new ArrayList<>();

        dfs(adj, res, "JFK");

        Collections.reverse(res);

        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, List<String> res, String curr) {
        PriorityQueue<String> neigh = adj.get(curr);

        while(neigh != null && !neigh.isEmpty()) {
            String n = neigh.poll();
            dfs(adj, res, n);
        }

        res.add(curr);
    }
}