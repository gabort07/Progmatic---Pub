package company.Comparatorok.Pub;

public class Main {
    public static void main(String[] args) {
        Pub pub = new Pub();
        OperatePub operator = new OperatePub(pub);
        operator.setUpPub();
        operator.printOut(pub.getDrinkStorage(), pub.getGuests());
        operator.pubRunning(pub.getGuests(), pub.getDrinkStorage());


    }
}
