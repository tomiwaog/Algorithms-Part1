package stacksandQueues;

import java.util.Stack;

public class StackwithMax {
    Stack<Double> maximums = new Stack<>();
    Stack<Double> numbers = new Stack<>();

    public Double returnTheMaximum() {
        if (maximums.isEmpty())
            return null;
        return maximums.peek();
    }

    public void push(double number) {
        numbers.push(number);
        if (maximums.isEmpty())
            maximums.push(number);
        else if (number >= maximums.peek())
            maximums.push(number);
        else
            maximums.push(returnTheMaximum());
    }

    public Double pop() {
        if (numbers.isEmpty())
            return null;

        Double removedNum = numbers.pop();
        maximums.pop();
        return removedNum;
    }

    public static void main(String[] args) {
        StackwithMax myStack = new StackwithMax();
        myStack.push(2.9);
        myStack.push(4.0);
        myStack.push(1.0);
        myStack.push(7.092);
        myStack.push(7.09);
//        myStack.pop();
//        myStack.pop();
//        myStack.pop();
//        myStack.pop();

        System.out.println(myStack.returnTheMaximum());
    }
}
