class Solution {
    int n;

    public int largestRectangleArea(int[] h) {
        n = h.length;
        int nse[] = nextSmallerElement(h);
        int pse[] = previousSmallerElement(h);

        // System.out.println(Arrays.toString(nse));
        // System.out.println(Arrays.toString(pse));

        int max = 0;

        for (int i = 0; i < n; i++) {
            int temp = nse[i] - pse[i] - 1;
            int area = temp * h[i];
            max = Math.max(Math.max(area, h[i]), max);
        }

        return max;
    }

    public int[] nextSmallerElement(int[] h) {
        int res[] = new int[n];
        Stack<int[]> st = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()[0] >= h[i]) st.pop();
            if (st.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = st.peek()[1];
            }
            st.push(new int[] { h[i], i });
        }

        return res;
    }

    public int[] previousSmallerElement(int[] h) {
        int res[] = new int[n];
        Stack<int[]> st = new Stack();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek()[0] >= h[i]) st.pop();
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek()[1];
            }
            st.push(new int[] { h[i], i });
        }

        return res;
    }
}
