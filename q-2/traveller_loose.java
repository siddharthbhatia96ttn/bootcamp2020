package loose_coupling;

public class traveller_loose {
    vehicle v;

    public vehicle getV() {
        return v;
    }

    public void setV(vehicle v) {
        this.v = v;
    }
    public void  start_journey()
    {
        v.move();
    }
}
