class Solution {

    public boolean canChange(String start, String target) {
        int sid = 0, tid = 0, slen = start.length(), tlen = target.length();

        while (sid < slen && tid < tlen) {
            while (sid < slen && start.charAt(sid) == '_') sid++;
            while (tid < tlen && target.charAt(tid) == '_') tid++;

            if (start.charAt(sid) != target.charAt(tid) || (start.charAt(sid) == 'L' && sid < tid) || (start.charAt(sid) == 'R' && sid > tid)) return false;

            sid++;
            tid++;
        }

        return true;
    }
}
