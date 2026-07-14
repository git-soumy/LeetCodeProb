class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();

        for (String s : deadends) {
            dead.add(s);
        }

        if (dead.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String curr = q.poll();

                if (curr.equals(target))
                    return moves;

                char[] arr = curr.toCharArray();

                for (int i = 0; i < 4; i++) {

                    char original = arr[i];

                    // Rotate forward
                    arr[i] = (char) ((original - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }

                    // Rotate backward
                    arr[i] = (char) ((original - '0' + 9) % 10 + '0');
                    next = new String(arr);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }

                    // Restore original digit
                    arr[i] = original;
                }
            }

            moves++;
        }

        return -1;
    }
}