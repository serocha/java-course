public class Main {

    public static void main(String[] args) {

        Mitsubishi sporty = new Mitsubishi("Lancer Evo X", 4);
        Ford truck = new Ford("F-450", 8);
        Holden beater = new Holden("Gemini", 4);

        System.out.println("# of cylinders: " + sporty.getCylinders());
        System.out.println(sporty.startEngine());
        System.out.println(sporty.accelerate());
        System.out.println(sporty.brake());

        System.out.println("# of cylinders: " + truck.getCylinders());
        System.out.println(truck.startEngine());
        System.out.println(truck.accelerate());
        System.out.println(truck.brake());

        System.out.println("# of cylinders: " + beater.getCylinders());
        System.out.println(beater.startEngine());
        System.out.println(beater.accelerate());
        System.out.println(beater.brake());
    }
}