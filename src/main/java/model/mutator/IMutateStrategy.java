package model.mutator;

import model.problem.Chromosome;

import java.util.List;

public interface IMutateStrategy {
    void mutateChromosomes(List<Chromosome> chromosomes);
}
