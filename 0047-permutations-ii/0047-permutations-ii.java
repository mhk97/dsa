class Solution {
    List<List<Integer>> res = new ArrayList();
    int n = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        n  = nums.length;
        for(int i: nums)map.put(i, map.getOrDefault(i, 0)+1);

        solve(map, new ArrayList());
        return res;
    }

    public void solve(Map<Integer, Integer> map, List<Integer> temp){

        if(temp.size() == n){
            res.add(new ArrayList(temp));
            return;
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == 0){
                continue;
            }
            
            temp.add(m.getKey());
            map.put(m.getKey(), m.getValue()-1);

            solve(map, temp);

            temp.remove(temp.size()-1);
            map.put(m.getKey(), m.getValue()+1);
        }
    }
}