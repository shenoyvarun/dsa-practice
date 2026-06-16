class LRUCache {
    int key;
    int val;
    Node prev;
    Node next;
    Node start, end;
    int capacity;
    Map<Integer, Node> map;

    private class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        start = new Node(-1, -1);
        end = start;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node rec = map.get(key);

        if (rec == end)
            return rec.val;

        rec.prev.next = rec.next;
        if (rec.next != null)
            rec.next.prev = rec.prev;

        rec.prev = end;
        end.next = rec;
        rec.next = null;
        end = rec;

        return rec.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node rec = map.get(key);
            rec.val = value;
            if (rec != end) { // ADD: move to MRU
                rec.prev.next = rec.next;
                if (rec.next != null)
                    rec.next.prev = rec.prev;
                rec.prev = end;
                end.next = rec;
                rec.next = null;
                end = rec;
            }
            return;
        }

        Node newNode = new Node(key, value);

        end.next = newNode;
        newNode.prev = end;
        end = end.next;

        map.put(key, newNode);

        if (map.size() > capacity) {
            Node temp = start.next;
            start.next = start.next.next;
            if (start.next != null)
                start.next.prev = start;
            map.remove(temp.key);
        }
    }
}