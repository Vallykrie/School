package OOP.Praktikum.BAB8;

interface Payable {
    double getPayableAmount();
}

class Invoice implements Payable {
    public String productName;
    public int quantity;
    public int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    public String toString() {
        return "Name: " + productName + ", Quantity: " + quantity + ", Price per Item: " + pricePerItem;
    }
}

class Employee implements Payable {
    public int registrationNumber;
    public String name;
    public int salaryPerMonth;
    public Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    public double getPayableAmount() {
        double totalInvoiceAmount = 0;
        for (Invoice invoice : invoices) {
            totalInvoiceAmount += invoice.getPayableAmount();
        }
        return salaryPerMonth - totalInvoiceAmount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", Number : ").append(registrationNumber)
                .append(", Salary: ").append(salaryPerMonth).append("\n");
        sb.append("\nInvoices:\n");
        for (Invoice invoice : invoices) {
            sb.append(invoice.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Invoice[] invoices = {
                new Invoice("Mouse", 2, 50),
                new Invoice("Keyboard", 1, 100),
                new Invoice("Monitor", 1, 300)
        };

        Employee employee = new Employee(123456, "John Doe", 2000, invoices);

        System.out.println(employee.toString() + "\n");
        System.out.println("Sebelum pengurangan:");
        System.out.println("Total Salary: " + employee.salaryPerMonth);

        System.out.println("\nSetelah pengurangan:");
        System.out.println("Total Salary after deduction: " + employee.getPayableAmount());
    }
}
