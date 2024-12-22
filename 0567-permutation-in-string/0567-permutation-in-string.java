class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : s1.toCharArray()) arr1[c - 'a']++;

        int i = 0, j = 0, n = s2.length();

        while (j < n) {
            char temp = s2.charAt(j);
            arr2[temp - 'a']++;

            while (j - i + 1 > s1.length()) {
                char itemp = s2.charAt(i++);
                arr2[itemp - 'a']--;
            }

            if (checkArrs(arr1, arr2) == true) return true;

            j++;
        }

        return false;
    }

    public boolean checkArrs(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }

        return true;
    }
}
