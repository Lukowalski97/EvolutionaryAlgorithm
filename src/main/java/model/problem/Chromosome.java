package model.problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Chromosome implements Comparable<Chromosome>{


    private float chromosomeFitnessValue;

     List<Gene> genes;


    public int compareTo(Chromosome chr){
        return (int)this.chromosomeFitnessValue - (int)chr.chromosomeFitnessValue;
    }

    public Chromosome(){
        this.genes = new ArrayList<Gene>();
    }

    public Chromosome(List<Gene> genes){
        this.genes=genes;
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

    public float getChromosomeFitnessValue() {
        return chromosomeFitnessValue;
    }

    public void setChromosomeFitnessValue(float chromosomeFitnessValue) {
        this.chromosomeFitnessValue = chromosomeFitnessValue;
    }


}
