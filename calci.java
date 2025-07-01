import java.util.Scanner;

class Calci {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multi(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calci p1 = new Calci();
        int a, b, choice;

        System.out.println("Enter two numbers:");
        System.out.print("First number: ");
        a = sc.nextInt();
        System.out.print("Second number: ");
        b = sc.nextInt();

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        int result;

        switch (choice) {
            case 1:
                result = p1.add(a, b);
                System.out.println("Addition: " + result);
                break;
            case 2:
                result = p1.sub(a, b);
                System.out.println("Subtraction: " + result);
                break;
            case 3:
                result = p1.multi(a, b);
                System.out.println("Multiplication: " + result);
                break;
            case 4:
                result = p1.div(a, b);
                System.out.println("Division: " + result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
