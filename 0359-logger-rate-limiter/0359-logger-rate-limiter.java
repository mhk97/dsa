class Logger {
    Map<String, Integer> timestampToMessageMap;

    public Logger() {
        timestampToMessageMap = new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestampToMessageMap.containsKey(message)){
            int ts = timestampToMessageMap.get(message)+10;
            if(ts > timestamp) return false;
            timestampToMessageMap.put(message, timestamp);
            return true;
        }else {
            timestampToMessageMap.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */