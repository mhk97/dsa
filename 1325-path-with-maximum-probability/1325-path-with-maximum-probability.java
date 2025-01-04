class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];
            map.computeIfAbsent(u, k -> new ArrayList()).add(new Pair(v, cost));
            map.computeIfAbsent(v, k -> new ArrayList()).add(new Pair(u, cost));
        }

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair(1d, start_node));

        double res[] = new double[n];
        Arrays.fill(res, Double.MIN_VALUE);
        res[start_node] = 1;

        while (!pq.isEmpty()) {
            Pair<Double, Integer> curr = pq.poll();
            int u = curr.getValue();
            double ucost = curr.getKey();
            if (u == end_node) return ucost;
            for (Pair<Integer, Double> v : map.getOrDefault(u, new ArrayList<Pair<Integer, Double>>())) {
                int vnode = v.getKey();
                double vcost = v.getValue();
                double newcost = ucost * vcost;

                if (newcost >= res[vnode]) {
                    res[vnode] = newcost;
                    pq.add(new Pair(newcost, vnode));
                }
            }
            map.remove(u);
        }

        return res[end_node];
    }
}
