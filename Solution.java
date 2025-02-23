import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(scanner.nextLine());
            Map<String, List<String>> friendships = new HashMap<>();

            for (int j = 0; j < K; j++) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                String person = parts[0];
                friendships.putIfAbsent(person, new ArrayList<>());

                if (parts.length > 1) {
                    String[] friends = parts[1].split(" ");
                    for (String friend : friends) {
                        friendships.get(person).add(friend);
                        friendships.putIfAbsent(friend, new ArrayList<>());
                        friendships.get(friend).add(person);
                    }
                }
            }

            for (String key : friendships.keySet()) {
                Collections.sort(friendships.get(key));
            }

            String[] query = scanner.nextLine().split(" ");
            String start = query[0], end = query[1];

            if (!friendships.containsKey(start) || !friendships.containsKey(end)) continue;

            Map<String, String> parent = new HashMap<>();
            int degree = bfs(friendships, start, end, parent);

            System.out.println("The degree of separation between " + start + " and " + end + " is " + degree + ".");
            printPath(parent, start, end);
        }
        scanner.close();
    }

    private static int bfs(Map<String, List<String>> friendships, String start, String end, Map<String, String> parent) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        parent.put(start, null);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String person = queue.poll();
                if (person.equals(end)) return level;

                for (String friend : friendships.get(person)) {
                    if (!visited.contains(friend)) {
                        queue.add(friend);
                        visited.add(friend);
                        parent.put(friend, person);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static void printPath(Map<String, String> parent, String start, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = parent.get(at)) path.add(at);
        Collections.reverse(path);
        System.out.println(String.join(" is a friend of ", path) + ".");
    }
}
