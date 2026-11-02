import java.util.Scanner;

public class MethodsLab {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        // Task 1
        greetUser();

        // Task 2
        System.out.print("Enter Two Integers Separated By A Space: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        arithmeticMethods(num1, num2);

        // Task 3
        System.out.print("Enter An Integer For Factorial: ");
        int factnum = input.nextInt();
        int factResult = factorial(factnum);
        System.out.println("Factorial: " + factResult + "\n");

        // Task 4
        int[] arraynumbers = new int[5];
        System.out.println("Enter 5 Numbers, And I'll Find The Sum: ");
        for (int i = 0; i < arraynumbers.length; i++) {
            System.out.print("Enter Number " + (i + 1) + ": ");
            arraynumbers[i] = input.nextInt();
        }

        int total = sumArray(arraynumbers);
        System.out.println("Total: " + total + "\n");

        // Task 5
        System.out.print("Enter a number, and I'll check If It Is Prime: ");
        int primevalue = input.nextInt();

        if (isPrime(primevalue)) {
            System.out.println("The Number " + primevalue + " Is Prime." + "\n");
        } else {
            System.out.println("The Number " + primevalue + " Is Not Prime." + "\n");
        }

        // Array Max Option
        System.out.print("Would You Like To Receive The Largest Integer In Your Previous Array? (y/n): ");
        String choice = input.next().toLowerCase().trim();

        switch (choice) {
            case "y", "yes":
                int maxArrayValue = maxInArray(arraynumbers);
                System.out.println("Largest Element In The Array: " + maxArrayValue + "\n");
                break;
            case "n", "no":
                System.out.println("Understood");
                break;
            default:
                System.out.println("Unsure, Will Proceed With Next Program Instead..." + "\n");
                break;
        }

        // Task 7: GCD AND LCM 
        System.out.print("Enter two positive integers for GCD and LCM: ");
        int a = input.nextInt();
        int b = input.nextInt();

        int gcdVal = gcd(a, b);
        int lcmVal = lcm(a, b);

        System.out.println("GCD of " + a + " and " + b + " is: " + gcdVal);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcmVal + "\n");

        // Challenges
        System.out.print("Would you like to use the other goodies within the program?: (y/n) ");
        choice = input.next().toLowerCase().trim();

        switch (choice) {
            case "y", "yes":
                goodieMenu();
                int goodieChoice = input.nextInt();
                switch (goodieChoice) {
                    case 1:
                        // Recursive Factorial
                        System.out.print("Enter An Integer For Factorial: ");
                        int rFactNumber = input.nextInt();
                        int recursiveFactResult = recursiveFactorial(rFactNumber);
                        System.out.println("Factorial: " + recursiveFactResult);
                        break;
                    case 2:
                        // Recursive Fibonacci
                        System.out.print("Enter A Value For Nth Fibonacci: ");
                        int nthvalue = input.nextInt();
                        int fibonacciResult = fib(nthvalue);
                        System.out.println("Your Fibonacci Value: " + fibonacciResult);
                        break;
                    case 3:
                        // Challenge 3: Palindrome 
                        System.out.print("Enter A Word: ");
                        String word = input.next();
                        if (isPalindrome(word)) {
                            System.out.println("\"" + word + "\" is a palindrome.");
                        } else {
                            System.out.println("\"" + word + "\" is NOT a palindrome.");
                        }
                        break;
                    case 0:
                        System.out.println("Good day! Thank you for using the program!");
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
                break;
            case "n", "no":
                System.out.println("Understood");
                break;
            default:
                System.out.println("Good day! Thank you for using the program!");
                break;
        }

        input.close();
    }

    public static void greetUser() {
        System.out.println("Good Day, Chap! Welcome to this precarious math program!" + "\n");
    }

    public static void arithmeticMethods(int value1, int value2) {
        System.out.println("Addition: " + (value1 + value2));
        System.out.println("Subtraction: " + (value1 - value2));
        System.out.println("Multiplication: " + (value1 * value2));
        double value3 = value1;
        double value4 = value2;
        if (value2 != 0) {
            System.out.println("Division: " + (value3 / value4) + "\n");
        } else {
            System.out.println("Division: Undefined (cannot divide by zero)");
        }
    }

    public static int factorial(int factvalue) {
        int res = 1;
        for (int i = 1; i <= factvalue; i++) {
            res *= i;
        }
        return res;
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    public static boolean isPrime(int pvalue) {
        if (pvalue <= 1) {
            return false;
        }
        for (int i = 2; i < pvalue; i++) {
            if (pvalue % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int maxInArray(int[] array) {
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > res) {
                res = array[i];
            }
        }
        return res;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void goodieMenu() {
        System.out.println("\nTerrific! Choose a program: ");
        System.out.println("1. Recursive Factorial");
        System.out.println("2. Recursive Fibonacci");
        System.out.println("3. Palindrome Checker");
        System.out.println("0. Exit Program");
    }

    // Challenge 1: Recursive Factorial
    public static int recursiveFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    // Challenge 2: Recursive Fibonacci
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Challenge 3: Palindrome
    public static boolean isPalindrome(String str) {
        String clean = str.toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }
}
