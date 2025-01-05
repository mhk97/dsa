class Solution {

    public int takeCharacters(String s, int k) {
        if (s.length() < k * 3) return -1;

        int i = 0, j = 0, delete = 0, n = s.length();

        int[] arr = new int[3];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int l : arr) if (l < k) return -1;

        while (j < n) {
            int curr = s.charAt(j) - 'a';
            arr[curr]--;

            if (arr[curr] >= k) {
                delete = Math.max(delete, j - i + 1);
            } else {
                while (i <= j && arr[curr] < k) {
                    int curri = s.charAt(i++) - 'a';
                    arr[curri]++;
                }
            }

            j++;
        }

        return n - delete;
    }
}
