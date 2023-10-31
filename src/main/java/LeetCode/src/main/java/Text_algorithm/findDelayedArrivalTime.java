package LeetCode.src.main.java.Text_algorithm;

public class findDelayedArrivalTime {
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

