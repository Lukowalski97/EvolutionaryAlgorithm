package model.problem;

import java.util.Collection;

public class Chromosome <T>{
    Collection <T> genes;

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + genes +
                '}';
    }

    public Collection<T> getGenes() {
        return genes;
    }

    public void setGenes(Collection<T> genes) {
        this.genes = genes;
    }
}
