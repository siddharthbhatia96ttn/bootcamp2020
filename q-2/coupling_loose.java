package loose_coupling;
public class coupling_loose {
    public static void main(String[] args) {
        vehicle v=new plane_loose();
        traveller_loose t=new traveller_loose();
        t.setV(v);
        t.start_journey();
    }
}
