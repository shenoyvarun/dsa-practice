class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int s: stones)
            pq.add(s);

        while(pq.size() >= 2) {
            int n1 = pq.poll();
            int n2 = pq.poll();

            if(n1-n2 > 0)
                pq.add(n1-n2);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}



