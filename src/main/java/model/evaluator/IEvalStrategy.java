package model.evaluator;

import model.IOperationStrategy;
import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;

import java.util.List;

public interface IEvalStrategy <T extends Gene> extends IOperationStrategy<T> {
    List<Chromosome<T>> evaluateChromosomes(List<Chromosome<T>> chromosomes);
}
