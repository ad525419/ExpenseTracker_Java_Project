import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        int choice;

        do {
            System.out.println("\n==== PERSONAL EXPENSE TRACKER ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Note: ");
                    String note = sc.nextLine();
                    manager.addExpense(cat, amt, date, note);
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    manager.searchByCategory(category);
                    break;

                case 4:
                    System.out.print("Enter Expense ID to Delete: ");
                    int id = sc.nextInt();
                    manager.deleteExpense(id);
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
