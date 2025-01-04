class Solution {

    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;

        int temp[] = new int[matrix[0].length];

        for (char i[] : matrix) {
            add(i, temp);
            // System.out.println(Arrays.toString(temp));
            max = Math.max(largestRectangleArea(temp), max);
        }

        return max;
    }

    public void add(char[] a, int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            if (a[i] == '0') temp[i] = 0; else temp[i] = temp[i] + 1;
        }
    }

    int n;

    public int largestRectangleArea(int[] h) {
        n = h.length;
        int nse[] = nextSmallerElement(h);
        int pse[] = previousSmallerElement(h);

        // System.out.println(Arrays.toString(nse));
        // System.out.println(Arrays.toString(pse));

        int max = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = width * h[i];
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
