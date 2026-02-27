import java.util.*;

public class Meeting {

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxRooms = 0;
        int i = 0, j = 0;

        while(i < n) {
            if(start[i] < end[j]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println(minMeetingRooms(intervals));
    }
}
