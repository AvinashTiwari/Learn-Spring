package stackwaave;

import java.util.Stack;

public class stackweave {
    static Stack<Integer> res = new Stack<Integer>();
    static Stack<Integer> tmpStack = new Stack<Integer>();

    // Sorts input stack and returns
    // sorted stack.
    static void sortStack(Stack<Integer> input)
    {
        while (input.size() != 0)
        {
            // pop out the first element
            int tmp = input.peek();
            input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (tmpStack.size() != 0 &&
                    tmpStack.peek() > tmp)
            {

                // pop from temporary stack and push
                // it to the input stack
                input.push(tmpStack.peek());
                tmpStack.pop();
            }

            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
    }

    static void sortedMerge(Stack<Integer> s1,
                            Stack<Integer> s2)
    {
        // Push contents of both stacks in result
        while (s1.size() != 0) {
            res.push(s1.peek());
            s1.pop();
        }

        while (s2.size() != 0) {
            res.push(s2.peek());
            s2.pop();
        }

        // Sort the result stack.
        sortStack(res);
    }

    // main function
    public static void main(String args[])
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(34);
        s1.push(3);
        s1.push(31);

        s2.push(1);
        s2.push(12);
        s2.push(23);

        sortedMerge(s1, s2);
        System.out.println("Sorted and merged stack :");

        while (tmpStack.size() != 0) {
            System.out.print(tmpStack.peek() + " ");
            tmpStack.pop();
        }
    }
}
