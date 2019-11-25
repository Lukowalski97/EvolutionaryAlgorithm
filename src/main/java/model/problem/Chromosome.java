package model.problem;

import java.util.Collection;

public abstract class Chromosome implements Comparable<Chromosome>{
    int chromosomeFitnessValue;

    Collection<Gene> genes;


    public int compareTo(Chromosome chr){
        return this.chromosomeFitnessValue - chr.chromosomeFitnessValue;
    }


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
