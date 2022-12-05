public class Main {

    public static void main(String[] args) {

        /*Player player = new Player();   // no constructor set
        player.name = "Bill";           // can access -> set to public
        player.health = 20;
        player.weapon = "sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health: " + player.healthRemaining());

        player.health = 200; // bypass restoreHealth() method -> no validation

        player.loseHealth(11);
        System.out.println("Remaining health: " + player.healthRemaining());*/

        EnhancedPlayer bill = new EnhancedPlayer("Bill Pullman", 200, "Sword");
        System.out.println("Initial health is " + bill.healthRemaining());
    }
}