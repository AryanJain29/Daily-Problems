class Solution {
    /* Function to get the single 
    number in the given array */
    public int singleNumber(int[] nums) {
        
        /* Map to store the elements 
        and their frequencies */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Iterate on the array
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1); // Update the map
        }
        
        // Iterate on the map
        for (HashMap.Entry<Integer, Integer> it : mpp.entrySet()) {
            // If frequency is 1
            if (it.getValue() == 1) {
                // Return the element
                return it.getKey();
            }
        }
        
        /* Return -1, if there is no 
        number having frequency 1 */
        return -1;
    }

}
