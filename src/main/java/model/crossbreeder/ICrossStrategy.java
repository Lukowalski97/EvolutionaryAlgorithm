package model.crossbreeder;

import model.IOperationStrategy;
import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;

import java.util.List;

public interface ICrossStrategy<T extends Gene>  extends IOperationStrategy<T> {
    List<Chromosome<T>> crossChromosomes(List <Chromosome<T>> chromosomes);
}
