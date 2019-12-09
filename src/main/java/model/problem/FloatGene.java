package model.problem;

public class FloatGene extends Gene {

    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public FloatGene(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FloatGene{" +
                "value=" + value +
                '}';

    }


}
