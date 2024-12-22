class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) maxHeap.offer(num); else minHeap.offer(num);

        //balance
        if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        return (size % 2 == 1) ? maxHeap.peek() : (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
