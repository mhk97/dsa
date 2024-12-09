class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) 
        map.computeIfAbsent(nums[i], m -> new ArrayList()).add(i);

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            if(list.size() <=1) continue;
            for(int i=0; i< list.size()-1;i++){
                if(Math.abs(list.get(i) - list.get(i+1)) <= k) return true;
            }
        }
        return false;
    }
}
