package LeetCode.src.main.java.leetcode;

public class LeetCode2651 {
    public int findDelayedArrivalTime1(int arrivalTime, int delayedTime) {
        if(arrivalTime + delayedTime >= 24) {
            return (arrivalTime + delayedTime) - 24;
        }
        return arrivalTime + delayedTime;
    }

    public int findDelayedArrivalTime2(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}

