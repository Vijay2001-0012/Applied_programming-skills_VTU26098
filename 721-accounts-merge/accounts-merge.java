class Solution {

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        Map<String, List<String>> graph =
                new HashMap<>();

        Map<String, String> emailToName =
                new HashMap<>();

        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                graph.putIfAbsent(
                        email,
                        new ArrayList<>()
                );

                emailToName.put(email, name);

                if (i == 1) {
                    continue;
                }

                String firstEmail = account.get(1);

                graph.get(firstEmail).add(email);

                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();

        List<List<String>> result =
                new ArrayList<>();

        for (String email : graph.keySet()) {

            if (!visited.contains(email)) {

                List<String> emails =
                        new ArrayList<>();

                dfs(email, graph, visited, emails);

                Collections.sort(emails);

                List<String> account =
                        new ArrayList<>();

                account.add(
                        emailToName.get(email)
                );

                account.addAll(emails);

                result.add(account);
            }
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> emails) {

        visited.add(email);

        emails.add(email);

        for (String neighbor : graph.get(email)) {

            if (!visited.contains(neighbor)) {

                dfs(neighbor,
                    graph,
                    visited,
                    emails);
            }
        }
    }
}