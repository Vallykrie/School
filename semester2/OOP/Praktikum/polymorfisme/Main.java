package OOP.Praktikum.polymorfisme;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1999, 5, 11);
        LocalDate dateNow = LocalDate.now();

        SalariedEmployee salariedEmployee = new SalariedEmployee("Daniel", "135", birthDate, 10, 100, 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karina", "234", birthDate, 20, 55, 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Keanu", "145", birthDate, 100, 20, 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bondan", "234",
                dateNow, 50, 50, 5000,
                .04, 300);

        Employee[] employees = new Employee[4];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        System.out.println("Employees diproses secara polimorfisme:\n");
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            double upahTambahan = currentEmployee.upahTambahan();
            System.out.println("upah tambahan: " + upahTambahan);
            if (currentEmployee.getBirthDate().getDayOfMonth() == dateNow.getDayOfMonth()
                    && currentEmployee.getBirthDate().getMonth() == dateNow.getMonth()) {
                System.out.println("Selamat Ulang Tahun! Anda mendapatkan bonus $100,000");
                System.out.printf("pendapatan: $%,.2f\n\n", currentEmployee.earnings() + 100_000 + upahTambahan);
            } else {
                System.out.printf("pendapatan: $%,.2f\n\n", currentEmployee.earnings() + upahTambahan);
            }
        }
    }
}