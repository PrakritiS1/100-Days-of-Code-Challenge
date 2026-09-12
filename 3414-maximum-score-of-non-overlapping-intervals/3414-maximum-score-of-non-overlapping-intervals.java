import java.util.*;

class Solution {

    class Node {
        int l, r, w, idx;

        Node(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    class Result {
        long score;
        List<Integer> list;

        Result(long score, List<Integer> list) {
            this.score = score;
            this.list = list;
        }
    }

    Node[] arr;
    Result[][] dp;
    int n;

    // Find first interval with left > current right
    int findNext(int right) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid].l > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Compare two lists lexicographically
    boolean smaller(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }

    Result better(Result a, Result b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return smaller(a.list, b.list) ? a : b;
    }

    Result solve(int pos, int k) {

        if (pos >= n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[pos][k] != null) {
            return dp[pos][k];
        }

        // Don't take current interval
        Result skip = solve(pos + 1, k);

        // Take current interval
        int next = findNext(arr[pos].r);

        Result nextResult = solve(next, k - 1);

        List<Integer> takeList = new ArrayList<>();
        takeList.add(arr[pos].idx);
        takeList.addAll(nextResult.list);

        // IMPORTANT:
        // Lexicographical order is based on ORIGINAL indices
        Collections.sort(takeList);

        Result take = new Result(
            arr[pos].w + nextResult.score,
            takeList
        );

        dp[pos][k] = better(skip, take);

        return dp[pos][k];
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }

            return Integer.compare(a.r, b.r);
        });

        dp = new Result[n][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.list.size()];

        for (int i = 0; i < ans.list.size(); i++) {
            result[i] = ans.list.get(i);
        }

        return result;
    }
}