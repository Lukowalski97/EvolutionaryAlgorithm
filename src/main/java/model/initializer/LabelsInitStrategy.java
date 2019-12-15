package model.initializer;

import model.problem.Chromosome;
import model.problem.LabelChromosome;
import model.problem.LabelGene;

import java.util.ArrayList;
import java.util.List;

public class LabelsInitStrategy implements  IInitStrategy<LabelGene>{


    @Override
    public List<Chromosome<LabelGene>> initChromosomes(int chromosomesAmount, int chromosomeSize) {
        List<Chromosome<LabelGene>> outp = new ArrayList<>();
        for(int i=0;i<chromosomesAmount;i++){
            outp.add(new LabelChromosome(initGenes(chromosomeSize)));
        }
        return outp;
    }

    @Override
    public List<LabelGene> initGenes(int genesAmount) {
        List<LabelGene> outp = new ArrayList<>();
        for(int i=0;i<genesAmount;i++){
            outp.add(new LabelGene(i));
        }
        return outp;
    }
}
