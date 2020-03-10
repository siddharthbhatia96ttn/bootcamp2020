package loose_coupling;

public class car_loose implements  vehicle {
    @Override
    public void move() {
        System.out.println("I am on a car");
    }
}
