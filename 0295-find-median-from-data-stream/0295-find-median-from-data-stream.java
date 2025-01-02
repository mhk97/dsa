class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        if (maxHeap.peek() < num) minHeap.offer(num); else maxHeap.offer(num);

        while (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());

        while (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 1) return maxHeap.peek(); else return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
