package model.crossbreeder;

import model.problem.Chromosome;

import java.util.List;

public interface ICrossStrategy {
    void crossChromosomes(List <Chromosome> chromosomes);
}
