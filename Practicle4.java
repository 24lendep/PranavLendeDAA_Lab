public class MaximumSumSubarrayFinalVersion {
    public int maximumSubarraySum(int arr[], int low, int high, int constraint) {
        if (low == high) {
            if (arr[low] <= constraint) {
                return arr[low];
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int mid = (low + high) / 2;
        int left_sum = maximumSubarraySum(arr, low, mid, constraint);
        int right_sum = maximumSubarraySum(arr, mid + 1, high, constraint);
        int cross_sum = maximumCrossingSum(arr, low, mid, high, constraint);
        int max = Math.max(left_sum, right_sum);
        max = Math.max(max, cross_sum);
        if (max <= constraint) {
            return max;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int maximumCrossingSum(int arr[], int low, int mid, int high, int constraint) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum <= constraint) {
                if (sum > left_sum) {
                    left_sum = sum;
                }
            }

        }
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum <= constraint) {
                if (sum > right_sum) {
                    right_sum = sum;
                }
            }
        }
        int total = 0;
        if (left_sum != Integer.MIN_VALUE) {
            total += left_sum;
        }
        if (right_sum != Integer.MIN_VALUE) {
            total += right_sum;
        }
        if (total <= constraint) {
            return total;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 3, 1 };
        int constraint = 5;
        MaximumSumSubarrayFinalVersion m = new MaximumSumSubarrayFinalVersion();
        int maxSum;
        maxSum = m.maximumSubarraySum(arr, 0, arr.length - 1, constraint);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSum);
    }
}
