package model.initializer;

import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;

import java.util.Collection;
import java.util.List;


public interface IInitStrategy {
    List<Chromosome> initChromosomes(int chromosomesAmount, int chromosomeSize);

    Collection<Gene> initGenes(int genesAmount);
}
