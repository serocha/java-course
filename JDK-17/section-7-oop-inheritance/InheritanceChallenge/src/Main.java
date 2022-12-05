public class Main {
    public static void main(String[] args) {

        Worker bill = new Worker("Bill", "01/12/1985");
        System.out.println(bill);
        bill.terminate("11/25/2022");
        System.out.println(bill);

        // Employee ID generation could be handled in the constructor. I'd personally put the logic outside the hierarchy
        Employee steve = new Employee("Steve", "08/28/1988",
                231101, "04/12/2019");
        System.out.println(steve);
        steve.terminate("10/14/2022");
        System.out.println(steve);

        HourlyEmployee janice = new HourlyEmployee("Janice", "02/02/1990",
                232002, "06/20/2021", 17.0);
        System.out.println(janice);
        janice.collectPay(80); // pay period
        janice.doublePay(20);

        SalariedEmployee lily = new SalariedEmployee("Lily", "07/15/1968",
                232003, "07/08/2000", 52000L);
        lily.collectPay();
        System.out.println(lily);
        lily.retire("11/20/2022");
        System.out.println(lily);
        lily.collectPay();
    }
}