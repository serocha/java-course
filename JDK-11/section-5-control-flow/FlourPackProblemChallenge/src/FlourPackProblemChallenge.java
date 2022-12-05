public class FlourPackProblemChallenge {
    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
    }

    // bigCount are 5kg bags, smallCount are 1kg bags, goal is the amt needed
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false; // validate
        // do we have enough flour overall? do we have enough small bags?
        return (bigCount*5 + smallCount >= goal) && (goal%5 <= smallCount);
    }
}
