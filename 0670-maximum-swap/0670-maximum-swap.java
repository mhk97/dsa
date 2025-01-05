class Solution {

    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        int n = sb.length();

        int[] nge = new int[n];

        nge[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            char curr = sb.charAt(i);
            if (curr > sb.charAt(nge[i + 1])) {
                nge[i] = i;
            } else {
                nge[i] = nge[i + 1];
            }
        }

        // System.out.println(Arrays.toString(nge));

        for (int i = 0; i < n; i++) {
            char nextChar = sb.charAt(nge[i]);
            if (nextChar > sb.charAt(i)) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, nextChar);
                sb.setCharAt(nge[i], temp);
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
