package model.selector;

import model.problem.Chromosome;

import java.util.List;

public interface ISelectStrategy {

    List<Chromosome> selectPersistentChromosomes(List<Chromosome> chromosomes);

    List<Chromosome> selectChromosomesWithBiggestFitness(List<Chromosome> chromosomes);
}
