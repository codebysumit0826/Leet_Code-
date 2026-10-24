class Solution {
    // Time Complexity: O(1)
    // Space Complexity: O(1)

    int mnth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Converts MM-DD into the day number of the year
    int nthDay(String str) {
        int month = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        int day = (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');

        // Add the days in previous months to get the day number
        return mnth[month] + day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int d = 0;

        // Convert the number of days in each month into cumulative day offsets
        for (int i = 0; i < 13; i++) {
            int v = mnth[i];
            mnth[i] = d;
            d += v;
        }

        // Find the later arrival date (start of the overlap)
        int min = Math.max(nthDay(arriveAlice), nthDay(arriveBob));

        // Find the earlier departure date (end of the overlap)
        int max = Math.min(nthDay(leaveAlice), nthDay(leaveBob));

        // No overlap if the start date is after the end date
        if (min > max) return 0;

        // +1 because both arrival and departure dates are inclusive
        return max - min + 1;
    }
}