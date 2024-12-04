class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        rand = new Random();
        list = new ArrayList();
        map = new HashMap();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // System.out.println("mk  " + list);

        int lastEl = list.get(list.size() - 1);

        int currI = map.get(val);
        swap(list.size() - 1, currI);

        map.put(lastEl, currI);
        map.remove(val);
        list.remove(list.size() - 1);

        // System.out.println("mk  " + list);

        return true;
    }

    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp); 
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
