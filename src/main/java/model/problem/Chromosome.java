package model.problem;

import java.util.Collection;
import java.util.List;

public abstract class Chromosome implements Comparable<Chromosome>{
    int chromosomeFitnessValue;

    private List<Gene> genes;


    public int compareTo(Chromosome chr){
        return this.chromosomeFitnessValue - chr.chromosomeFitnessValue;
    }


    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + genes +
                '}';
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }


}
