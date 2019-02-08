package 贪心法;


@SuppressWarnings("ALL")
public class 柠檬水找零_860 {
    /**
     * 一杯柠檬水5美元,判断能否正确进行找零工作.
     * 进行每一步判断,如果来的是五美元,
     * 那么直接收着
     * 如果来的是十美元,找一找是否存在5美元
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills
        ) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
