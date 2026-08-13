class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            len = 1;
        }

        Node() {
            len = 0;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
        String str,
        String queryCharacters,
        int[] queryIndices
    ) {

        s = str.toCharArray();

        int n = s.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            s[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    // Build Segment Tree
    void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(s[start]);
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Merge two segments
    Node merge(Node left, Node right) {

        if (left.len == 0)
            return right;

        if (right.len == 0)
            return left;

        Node res = new Node();

        res.len = left.len + right.len;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        // Prefix
        res.prefix = left.prefix;

        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            res.prefix = left.len + right.prefix;
        }

        // Suffix
        res.suffix = right.suffix;

        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            res.suffix = right.len + left.suffix;
        }

        // Best
        res.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {

            res.best = Math.max(
                res.best,
                left.suffix + right.prefix
            );
        }

        return res;
    }

    // Point Update
    void update(
        int node,
        int start,
        int end,
        int index,
        char ch
    ) {

        if (start == end) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {

            update(
                node * 2,
                start,
                mid,
                index,
                ch
            );

        } else {

            update(
                node * 2 + 1,
                mid + 1,
                end,
                index,
                ch
            );
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }
}
