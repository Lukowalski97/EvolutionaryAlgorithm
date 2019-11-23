package model.selector;

import model.problem.Chromosome;

import java.util.List;

public interface ISelectStrategy {
    void selectPersistentChromosomes(List<Chromosome> chromosomes);
}
