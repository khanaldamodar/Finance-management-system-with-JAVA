import java.util.ArrayList;
import java.util.Scanner;

class Income {
    private String source;
    private double amount;

    public Income(String source, double amount) {
        this.source = source;
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Source: " + source + ", Amount: " + amount;
    }
}

class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: " + amount;
    }
}

class FinanceManager {
    private ArrayList<Income> incomeList = new ArrayList<>();
    private ArrayList<Expense> expenseList = new ArrayList<>();
    
    public void addIncome(Income income) {
        incomeList.add(income);
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void viewIncome() {
        System.out.println("Income Details:");
        for (Income income : incomeList) {
            System.out.println(income);
        }
    }

    public void viewExpenses() {
        System.out.println("Expense Details:");
        for (Expense expense : expenseList) {
            System.out.println(expense);
        }
    }

    public double getTotalIncome() {
        double total = 0;
        for (Income income : incomeList) {
            total += income.getAmount();
        }
        return total;
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }
        return total;
    }

    public double calculateSavings() {
        return getTotalIncome() - getTotalExpenses();
    }
}

public class PersonalFinanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager financeManager = new FinanceManager();

        while (true) {
            System.out.println("\nPersonal Finance Management System");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Income");
            System.out.println("4. View Expenses");
            System.out.println("5. View Savings");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter income source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double incomeAmount = scanner.nextDouble();
                    financeManager.addIncome(new Income(source, incomeAmount));
                    break;
                case 2:
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double expenseAmount = scanner.nextDouble();
                    financeManager.addExpense(new Expense(category, expenseAmount));
                    break;
                case 3:
                    financeManager.viewIncome();
                    break;
                case 4:
                    financeManager.viewExpenses();
                    break;
                case 5:
                    System.out.println("Total Savings: " + financeManager.calculateSavings());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
