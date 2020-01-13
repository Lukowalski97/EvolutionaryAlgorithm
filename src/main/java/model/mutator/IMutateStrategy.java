package model.mutator;

import model.IOperationStrategy;
import model.problem.Chromosome;
import model.problem.Gene;

import java.util.List;

public interface IMutateStrategy<T extends Gene>  extends IOperationStrategy<T> {
    List<Chromosome<T>> mutateChromosomes(List<Chromosome<T>> chromosomes);

     float getMutationChance();
     void setMutationChance(float mutationChance);
}
