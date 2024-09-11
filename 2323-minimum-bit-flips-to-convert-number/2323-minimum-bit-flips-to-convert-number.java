class Solution {
    public int minBitFlips(int start, int goal) {
        // Calculate the XOR to find differing bits
        int xor = start ^ goal;
        
        // Count the number of 1's in the XOR result
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }
        
        return count;
    }
}
