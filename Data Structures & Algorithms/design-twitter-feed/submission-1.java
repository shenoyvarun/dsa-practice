class Twitter {
    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<int[]>> tweets;
    PriorityQueue<int[]> pq;
    int time;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
    }

    private void ensureUser(int userId) {
        followers.putIfAbsent(userId, new HashSet<>());
        followers.get(userId).add(userId); 
        tweets.putIfAbsent(userId, new ArrayList<>());
    }
    
    public void postTweet(int userId, int tweetId) {
        ensureUser(userId);
        tweets.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        pq.clear();
        ensureUser(userId);

        for(Integer f: followers.get(userId)) {
            for(int[] t: tweets.get(f)) {
                pq.add(new int[]{t[0], t[1]});
                if(pq.size() > 10)
                    pq.poll();
            }
        }

        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            res.add(t[1]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        ensureUser(followerId);
        
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }
}
