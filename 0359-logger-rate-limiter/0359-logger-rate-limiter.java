class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap();
    }

    public boolean shouldPrintMessage(int ts, String message) {
        if (!map.containsKey(message)) {
            map.put(message, ts);
            return true;
        } else {
            int old = map.get(message);
            if (ts < old + 10) return false; else {
                map.put(message, ts);
                return true;
            }
        }
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
