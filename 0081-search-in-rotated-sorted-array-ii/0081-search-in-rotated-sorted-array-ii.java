class Solution {
    public boolean search(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) return true;

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }

            // If left side is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k < arr[mid]) {
                    high = mid - 1;  // target is in the left half
                } else {
                    low = mid + 1;  // target is in the right half
                }
            } 
            // If right side is sorted
            else {
                if (arr[mid] < k && k <= arr[high]) {
                    low = mid + 1;  // target is in the right half
                } else {
                    high = mid - 1;  // target is in the left half
                }
            }
        }
        return false;  // target not found
    }
}