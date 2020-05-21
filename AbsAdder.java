public class AbsAdder implements IAdder {

    @Override
    public int add(int a, int b) {
        return Math.abs(a) + Math.abs(b);
    }
}
