package model;

import model.problem.Chromosome;
import model.problem.Gene;

import java.util.List;

public interface IOperationStrategy <T extends Gene> {

    List<Chromosome<T>> executeOperation(List<Chromosome<T>> list);
}
