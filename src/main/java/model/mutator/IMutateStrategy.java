package model.mutator;

import model.problem.Chromosome;
import model.problem.IProblem;

import java.util.List;

public interface IMutateStrategy {
    List<Chromosome> mutateChromosomes(List<Chromosome> chromosomes);
}
