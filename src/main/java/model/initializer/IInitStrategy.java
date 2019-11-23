package model.initializer;

import model.problem.Chromosome;
import model.problem.Gene;
import java.util.Collection;
import java.util.List;


public interface IInitStrategy {
    List<Chromosome> initChromosomes();

    Collection<Gene> initGenes(int genesAmount);
}
