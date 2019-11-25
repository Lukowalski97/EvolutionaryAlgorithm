package model.problem;

public class IntGene extends Gene {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntGene{" +
                "value=" + value +
                '}';
    }
}
