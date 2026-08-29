class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            pq.add(freq);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            ArrayList<Integer> temp = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < n + 1 && !pq.isEmpty(); i++) {

                int freq = pq.remove();

                if (freq > 1) {
                    temp.add(freq - 1);
                }

                time++;
                count++;
            }

            for (int i = 0; i < temp.size(); i++) {
                pq.add(temp.get(i));
            }

            // Idle time
            if (!pq.isEmpty()) {
                time += (n + 1) - count;
            }
        }

        return time;
    }
}