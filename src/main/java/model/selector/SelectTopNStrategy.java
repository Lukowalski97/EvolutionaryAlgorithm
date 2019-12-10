package model.selector;

import model.problem.Chromosome;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SelectTopNStrategy implements ISelectStrategy {
    private int n;

    public SelectTopNStrategy(int n) {
        this.n = n;
    }

    public List<Chromosome> selectPersistentChromosomes(List<Chromosome> chromosomes) {
        return chromosomes.stream().sorted().limit(n).collect(Collectors.toList());
    }
}
