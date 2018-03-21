public class DieRunTester {
    public static void main(String[] args) {
        DiceRun run = new DiceRun(20);
        run.fillArray();
        System.out.println(run.formatLongest());
    }
}
