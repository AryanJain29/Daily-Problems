class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) { // Only assign for the first pass
                if (!st.empty()) {
                    nge[i] = st.peek();
                } else {
                    nge[i] = -1;
                }
            }
            
            st.push(nums[i % n]); // Push the current element to the stack for the next iteration
        }

        return nge;
    }
}