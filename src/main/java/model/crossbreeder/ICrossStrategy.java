package model.crossbreeder;

import model.problem.Chromosome;

import java.util.List;

public interface ICrossStrategy {
    List<Chromosome> crossChromosomes(List <Chromosome> chromosomes);
}
