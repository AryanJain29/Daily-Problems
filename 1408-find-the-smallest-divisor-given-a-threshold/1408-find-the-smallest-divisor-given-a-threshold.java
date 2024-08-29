
class Solution {

    // Helper function to calculate the sum based on the divisor
    private int sumByD(int[] arr, int div) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    // Function to find the smallest divisor such that the sum is within the limit
    public int smallestDivisor(int[] arr, int limit) {
        int n = arr.length;
        if (n > limit) return -1;

        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}