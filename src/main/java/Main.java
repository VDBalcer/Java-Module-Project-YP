
public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.runRace();
        System.out.printf("Самая быстрая машина: %s", race.winner.name);
    }
}