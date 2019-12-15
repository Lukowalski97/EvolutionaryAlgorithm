package model.initializer;

import model.problem.Chromosome;
import model.problem.LabelGene;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LabelsInitStrategyTest {

    LabelsInitStrategy strategy;
    int chromAmount;
    int chromSize;
    List<Chromosome<LabelGene>> chromosomesList;
    List<LabelGene> genesList;

    @Before
    public void init(){
        strategy= new LabelsInitStrategy();
        chromAmount=2;
        chromSize=3;

    }

    @Test
    public void initChromosomes() {
        chromosomesList = strategy.initChromosomes(chromAmount,chromSize);

       assertThat(chromosomesList,hasSize(chromAmount));
       assertThat(chromosomesList.get(0).getGenes(),hasSize(chromSize));
       assertThat(chromosomesList.get(1).getGenes(),hasSize(chromSize));

    }

    @Test
    public void initGenes() {
        int p=4;
       genesList = strategy.initGenes(p);

       assertThat(genesList,hasSize(p));

       assertThat(genesList.get(0),equalTo(new LabelGene(0)));
       assertThat(genesList.get(3),equalTo(new LabelGene(3)));


    }
}