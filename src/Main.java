import java.util.*;

public class Main {
    public static void main(String[] args) {
        //class variables
        Stack<Integer> theStack = new Stack<>();
        Queue<Integer> theQueue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int count = 0; //use ton get the length of the array


        //Get array length from user
        while (count <= 0){
            System.out.print("How many values would you like to enter? ");
            try{
                count = scan.nextInt();

                if (count <= 0)
                    System.out.println("Number values must be greater than zero.");

            }catch (Exception e){
                System.out.println("You must enter a valid integer.");
                scan.nextLine(); //consumes user input even without using it
            }
        }

        //Declare the array
        int[] theArray = new int[count];

        //Get values for each index
        for (int i = 0; i < count; i++){
           int number;
           System.out.print("Enter number: ");
           try {
               number = scan.nextInt();
               theArray[i] = number;
               theStack.push(number);
               theQueue.add(number);

           }catch (Exception e){
               System.out.println("You must enter a valid integer.");
               scan.nextLine();
           }
        }

        //Display original collections
        System.out.println("\nOriginal Collections: ");
        System.out.println("The Array: ");
        printArray(theArray);
        System.out.print("\nThe Stack: ");
        printStack(theStack);
        System.out.print("\nThe Queue: ");
        printQueue(theQueue);

        //Reverse and print collections
        reverseArray(theArray);
        theStack = reverseStack(theStack);
        reverseQueue(theQueue);

        System.out.println("\n\nReversed Collections: ");

        System.out.print("Array: ");
        printArray(theArray);
        System.out.print("\nStack: ");
        printStack(theStack);
        System.out.print("\nQueue: ");
        printQueue(theQueue);

    }

    //Helper methods to print collections
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void printStack(Stack<Integer> stack){
        for (int i = 0; i < stack.size(); i++){
            System.out.print(stack.elementAt(i) + " ");
        }
    }

    public static void printQueue(Queue<Integer> queue){
        for (int number : queue){
            System.out.print(number + " ");
        }
    }

    //Helper methods to reverse collections
    public static void reverseArray(int[] array){
        int left = 0;
        int right = array.length - 1;

        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            //Increment inwards
            left++;
            right--;
        }
    }


    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        Stack<Integer> reversed = new Stack<>();

        while (!stack.isEmpty()){
            reversed.push(stack.pop());
        }
        return reversed;
    }

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> temp = new Stack<>();

        //Empty the queue into stack
        while (!queue.isEmpty())
            temp.push(queue.remove());


        //Empty the stack back into queue
        while (!temp.isEmpty())
            queue.add(temp.pop());

    }
}
