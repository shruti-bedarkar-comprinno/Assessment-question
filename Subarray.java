import java.util.*;

public class Subarray {

    public static int countSubarrays(long[] arr, long target) {
        HashMap<Long, Integer> map = new HashMap<>();
        
        long prefixSum = 0;
        int count = 0;

        map.put(0L, 1);

        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if(map.containsKey(prefixSum - target)) {
                count += map.get(prefixSum - target);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }


        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long target = sc.nextLong();

        int result = countSubarrays(arr, target);
        System.out.println(result);
    }
}
