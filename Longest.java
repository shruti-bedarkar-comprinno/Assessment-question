import java.util.*;

public class Longest {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        
        for (int num : set) {
        
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int count = 1;
             
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(longestConsecutive(arr));
    }
}