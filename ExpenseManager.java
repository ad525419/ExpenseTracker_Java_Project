import java.io.*;
import java.util.*;

public class ExpenseManager {
    private static final String FILE_NAME = "expenses.txt";
    private List<Expense> expenses = new ArrayList<>();

    public ExpenseManager() {
        loadExpenses();
    }

    private void loadExpenses() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    expenses.add(new Expense(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3],
                        data[4]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous expenses found.");
        }
    }

    private void saveExpenses() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    public void addExpense(String category, double amount, String date, String note) {
        int id = expenses.size() + 1;
        expenses.add(new Expense(id, category, amount, date, note));
        saveExpenses();
        System.out.println("Expense added successfully!");
    }

    public void viewAll() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("\n--- Expense List ---");
        for (Expense e : expenses) {
            System.out.println("ID: " + e.getId() + " | " + e.getCategory() + " | ₹" + e.getAmount() +
                               " | " + e.getDate() + " | " + e.getNote());
        }
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
        saveExpenses();
        System.out.println("Expense deleted.");
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No expense found in this category.");
    }
}
