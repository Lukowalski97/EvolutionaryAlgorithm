package model.evaluator;

import model.problem.Chromosome;

import java.util.List;

public interface IEvalStrategy {
    void evaluateChromosomes(List<Chromosome> chromosomes);
}
