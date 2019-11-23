package model.problem;

import java.util.Collection;

public abstract class Chromosome implements Comparable{
    long chromosomeValue;
    Collection<Gene> genes;

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + genes +
                '}';
    }

    public Collection<Gene> getGenes() {
        return genes;
    }

    public void setGenes(Collection<Gene> genes) {
        this.genes = genes;
    }
}
