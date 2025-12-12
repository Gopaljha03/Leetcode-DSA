import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        Arrays.fill(online, true);

        // Make a copy and sort by timestamp ascending.
        // For the same timestamp, OFFLINE events must come before MESSAGE events.
        List<List<String>> sorted = new ArrayList<>(events);
        Collections.sort(sorted, (a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) return Integer.compare(ta, tb);
            // when timestamps equal, OFFLINE should come before MESSAGE
            if (!a.get(0).equals(b.get(0))) {
                if (a.get(0).equals("OFFLINE")) return -1;
                if (b.get(0).equals("OFFLINE")) return 1;
            }
            return 0;
        });

        int prevTime = -1;
        for (List<String> event : sorted) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String value = event.get(2);

            // If we're at a new timestamp, refresh users who auto-come-online at or before this time.
            if (time != prevTime) {
                for (int u = 0; u < numberOfUsers; u++) {
                    if (!online[u] && offlineUntil[u] <= time) {
                        online[u] = true;
                    }
                }
                prevTime = time;
            }

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(value);
                // go offline at time, for 60 units → back online at time + 60
                online[id] = false;
                offlineUntil[id] = time + 60;
            } else { // MESSAGE
                if (value.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) mentions[u]++;
                } else if (value.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        if (online[u]) mentions[u]++;
                    }
                } else {
                    // tokens like "id3 id1 id3"
                    String[] tokens = value.split(" ");
                    for (String t : tokens) {
                        if (t.startsWith("id")) {
                            int id = Integer.parseInt(t.substring(2));
                            mentions[id]++;
                        }
                    }
                }
            }
        }

        return mentions;
    }
}
