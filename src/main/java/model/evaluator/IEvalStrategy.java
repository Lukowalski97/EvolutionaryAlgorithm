package model.evaluator;

import model.problem.Chromosome;
import model.problem.IProblem;

import java.util.List;

public interface IEvalStrategy {
    List<Chromosome> evaluateChromosomes(List<Chromosome> chromosomes);
}
