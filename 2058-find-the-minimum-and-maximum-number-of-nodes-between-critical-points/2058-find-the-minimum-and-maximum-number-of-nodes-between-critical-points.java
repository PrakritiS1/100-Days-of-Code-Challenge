class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // First node
        ListNode prev = head;

        // Second node
        ListNode curr = head.next;

        // Position of current node (1-based indexing)
        int index = 2;

        // Position of first critical point
        int first = -1;

        // Position of previously found critical point
        int prevCritical = -1;

        // Minimum distance
        int minDist = Integer.MAX_VALUE;

        // Current node must have a next node
        while (curr.next != null) {

            // Check if current node is a critical point
            boolean isMax = curr.val > prev.val &&
                            curr.val > curr.next.val;

            boolean isMin = curr.val < prev.val &&
                            curr.val < curr.next.val;

            if (isMax || isMin) {

                // First critical point
                if (first == -1) {
                    first = index;
                } else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, index - prevCritical);
                }

                // Update previous critical point
                prevCritical = index;
            }

            // Move all pointers forward
            prev = curr;
            curr = curr.next;
            index++;
        }

        // Less than 2 critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        // Maximum distance = last critical - first critical
        int maxDist = prevCritical - first;

        return new int[]{minDist, maxDist};
    }
}