class Solution {

    public boolean canChange(String s, String t) {
        int sid = 0, tid = 0, n = s.length();

        while (sid < n || tid < n) {
            while (sid < n && s.charAt(sid) == '_') sid++;
            while (tid < n && t.charAt(tid) == '_') tid++;

            if (sid >= n && tid >= n) return true;
            if (sid >= n || tid >= n) return false;

            if (s.charAt(sid) != t.charAt(tid) || (s.charAt(sid) == 'L' && sid < tid) || (s.charAt(sid) == 'R' && sid > tid)) return false;

            sid++;
            tid++;
        }

        return true;
    }
}
