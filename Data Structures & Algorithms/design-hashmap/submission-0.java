class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;
    Node[] map;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        int idx = hash(key);

        if (map[idx] == null) {
            map[idx] = new Node(key, value);
            return;
        }

        Node cur = map[idx];

        while (true) {

            if (cur.key == key) {
                cur.value = value;
                return;
            }

            if (cur.next == null)
                break;

            cur = cur.next;
        }

        cur.next = new Node(key, value);
    }

    public int get(int key) {

        int idx = hash(key);

        Node cur = map[idx];

        while (cur != null) {

            if (cur.key == key)
                return cur.value;

            cur = cur.next;
        }

        return -1;
    }

    public void remove(int key) {

        int idx = hash(key);

        Node cur = map[idx];
        Node prev = null;

        while (cur != null) {

            if (cur.key == key) {

                if (prev == null)
                    map[idx] = cur.next;
                else
                    prev.next = cur.next;

                return;
            }

            prev = cur;
            cur = cur.next;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */