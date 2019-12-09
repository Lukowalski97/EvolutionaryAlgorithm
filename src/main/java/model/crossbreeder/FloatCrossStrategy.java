package model.crossbreeder;

import model.problem.*;

import java.util.ArrayList;
import java.util.List;

public class FloatCrossStrategy implements  ICrossStrategy {

    int chromosomesListTargetSize;

    public FloatCrossStrategy(int chromosomesListTargetSize){
        this.chromosomesListTargetSize=chromosomesListTargetSize;
    }

    public List<Chromosome> crossChromosomes(List<Chromosome> chromosomes) {

        int i=0;
        while(chromosomes.size()!= chromosomesListTargetSize && i<chromosomes.size()){
            chromosomes.add(crossMeanValue(chromosomes.get(i++), chromosomes.get(i++)));
        }

        return chromosomes;

    }

    private FloatChromosome crossMeanValue(Chromosome firstChromosome, Chromosome secondChromosome){
        List<Gene> tmp = new ArrayList<Gene>();
        tmp.add(crossMeanValue ( (FloatGene)(firstChromosome.getGenes().get(0))
                , (FloatGene)secondChromosome.getGenes().get(0)));
        return new FloatChromosome(tmp);
    }

    private FloatGene crossMeanValue(FloatGene firstGene, FloatGene secondGene){
        return new FloatGene((firstGene.getValue() + secondGene.getValue()) /2);
    }
}
