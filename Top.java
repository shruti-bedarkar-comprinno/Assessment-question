import java.util.*;

public class Top {

    public static int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

    
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for(int num : map.keySet()) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] ans = topKFrequent(nums, k);

        for(int num : ans) {
            System.out.print(num + " ");
        }
    }
}
