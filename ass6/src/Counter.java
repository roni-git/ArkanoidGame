/*32867077*/
/**
 * @author roni gilboa
 * this class save a int value and can to increse/sicrease/return the value
 */
public class Counter {
    //field
    private int num;
    /**.
     * A constructor
     * @param num - a value for the counter
     */
    public Counter(int num) {
        this.num = num;
    }
    /**
     * this function add number to current count.
     * @param number - a number to add to current count
     */
    void increase(int number) {
        this.num = this.num + number;
    }
    /**
     * this function subtract number from current count.
     * @param number - a number to subtract from current count.
     */
    void decrease(int number) {
        this.num = this.num - number;
    }
    /**
     * this function get current count.
     * @return num - this current value
     */
    int getValue() {
        return this.num;
    }
}
