class Solution {

    public String largestNumber(int[] nums) {
        List<Integer> lis = mergeSort(nums, 0, nums.length - 1);
        if (lis.get(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : lis) {
            sb.append(num);
        }
        return sb.toString();
    }

    public List<Integer> mergeSort(int[] nums, int l, int r) {
        if (l >= r) return List.of(nums[l]);

        int mid = l + (r - l) / 2;

        List<Integer> left = mergeSort(nums, l, mid);
        List<Integer> right = mergeSort(nums, mid + 1, r);

        return merge(left, right);
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sorted = new ArrayList();
        int i = 0, j = 0, llen = left.size(), rlen = right.size();

        while (i < llen && j < rlen) {
            int first = left.get(i);
            int second = right.get(j);

            if (compare(first, second) == true) {
                sorted.add(first);
                i++;
            } else {
                sorted.add(second);
                j++;
            }
        }

        while (i < llen) {
            sorted.add(left.get(i++));
        }

        while (j < rlen) {
            sorted.add(right.get(j++));
        }

        return sorted;
    }

    public boolean compare(int i, int j) {
        String s1 = String.valueOf(i) + String.valueOf(j);
        String s2 = String.valueOf(j) + String.valueOf(i);

        return s1.compareTo(s2) > 0;
    }
}
