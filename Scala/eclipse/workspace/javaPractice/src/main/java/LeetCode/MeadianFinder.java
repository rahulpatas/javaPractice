package LeetCode;

        import java.util.Comparator;
        import java.util.PriorityQueue;

public class MeadianFinder {

    static class MedianFinder {

        class Descend implements Comparator<Integer> {
            public int compare(Integer A, Integer B) {
                return B - A;
            }
        }

        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Descend());
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        // Adds a number into the data structure.
        public void addNum(int num) {

            maxQueue.add(num);
            minQueue.add(maxQueue.poll());

            if (minQueue.size() > maxQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {

            int minSize = minQueue.size();
            int maxSize = maxQueue.size();

            if (minSize == 0 && maxSize == 0) {
                return 0.0;
            }

            return minSize == maxSize ? (maxQueue.peek() + minQueue.peek()) / 2.0 : maxQueue.peek();

        }

        public static void main(String[] args) {

            MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());

            medianFinder.addNum(6);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(10);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(2);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(6);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(5);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(0);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(6);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(3);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(1);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(0);
            System.out.println(medianFinder.findMedian());
            medianFinder.addNum(0);
            System.out.println(medianFinder.findMedian());
        }
    }
}
