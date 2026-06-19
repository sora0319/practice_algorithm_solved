package no_401_binary_watch;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> hours = List.of(1, 2, 4, 8);
    List<Integer> minutes = List.of(1, 2, 4, 8, 16, 32);
    List<String> times = new ArrayList<>();

    public static void main(String[] args) {
        Solution sol = new Solution();

        int turnedOn = 2;

        List<String> result = sol.readBinaryWatch(turnedOn);

        System.out.println(result);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        checkingMinutes(turnedOn, 0, 0, 0, 0);
        checkingTime(turnedOn, 0, 0, 0, 0);

        return times;
    }

    private void checkingTime(int turnedOn, int count, int hour, int minute, int h_start) {
        if (turnedOn == count) {
            if (hour > 11) return;

            StringBuilder sb = new StringBuilder();

            sb.append(hour);
            sb.append(':');

            if (minute < 10) {
                sb.append(0);
            }
            sb.append(minute);

            times.add(sb.toString());
            return;
        }

        for (int h = h_start; h < hours.size(); h++) {
            hour += hours.get(h);
            count++;

            checkingMinutes(turnedOn, count, hour, minute, 0);
            checkingTime(turnedOn, count, hour, minute, h + 1);

            count--;
            hour -= hours.get(h);
        }
    }

    private void checkingMinutes(int turnedOn, int count, int hour, int minute, int m_start) {
        if (turnedOn == count) {
            if (hour > 11) return;
            if (minute >= 60 || minute == 0) return;

            StringBuilder sb = new StringBuilder();

            sb.append(hour);
            sb.append(':');

            if (minute < 10) {
                sb.append(0);
            }
            sb.append(minute);

            times.add(sb.toString());
            return;
        }

        for (int m = m_start; m < minutes.size(); m++) {
            minute += minutes.get(m);
            count++;

            checkingMinutes(turnedOn, count, hour, minute, m + 1);

            count--;
            minute -= minutes.get(m);
        }
    }
}
