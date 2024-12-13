class Solution {
    HashMap<String, List<String>> map = new HashMap();
    HashSet<String> visited = new HashSet();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // build map
        for (List<String> list : accounts) {
            String first = list.get(1);
            for (int i = 2; i < list.size(); i++) {
                String second = list.get(i);
                map.computeIfAbsent(first, k -> new ArrayList()).add(second);
                map.computeIfAbsent(second, k -> new ArrayList()).add(first);
            }
        }

        List<List<String>> res = new ArrayList();
        for (List<String> list : accounts) {
            String name = list.get(0), first = list.get(1);

            if (!visited.contains(first)) {
                List<String> merged = new ArrayList();
                merged.add(name);
                dfs(merged, first);
                Collections.sort(merged.subList(1, merged.size()));
                res.add(merged);
            }
        }

        return res;
    }

    public void dfs(List<String> merged, String u) {
        visited.add(u);
        merged.add(u);

        for (String v : map.getOrDefault(u, new ArrayList<String>())) {
            if (!visited.contains(v)) dfs(merged, v);
        }
    }
}
