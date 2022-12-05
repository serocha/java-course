import java.text.DecimalFormat;
import java.time.LocalDate;

public class Worker {

    protected String name;
    private String birthDate; // note that this is a birth YEAR for simplicity, otherwise might use Regex
    protected String endDate;

    public Worker (String name, String birthDate) {
        this(name, birthDate, "");
    }

    public Worker (String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - Integer.parseInt(birthDate.substring(6)); // start at year, format DD/MM/YYYY
    }

    public double collectPay(double payment) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(name + " was paid $" + df.format(payment));
        return payment;
    }

    public void terminate(String endDate) {
        System.out.println(name + " left on " + endDate);
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\n" + "Name: " + name + "\n" +
                "Birthday: " + birthDate + "\n" +
                "Age: " + getAge() +
                (!endDate.isEmpty() ? ("\n" + "Employment terminated: " + endDate) : "");
    }
}
