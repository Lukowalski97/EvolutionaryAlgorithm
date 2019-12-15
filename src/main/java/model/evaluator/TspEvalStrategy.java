package model.evaluator;

import model.problem.Chromosome;
import model.problem.LabelChromosome;
import model.problem.LabelGene;
import model.problem.TravellingSalesmanProblem;

import java.util.List;

public class TspEvalStrategy implements  IEvalStrategy<LabelGene> {

    private TravellingSalesmanProblem problem;

    public TspEvalStrategy(TravellingSalesmanProblem problem){
        this.problem=problem;
    }

    @Override
    public List<Chromosome<LabelGene>> evaluateChromosomes(List<Chromosome<LabelGene>> chromosomes) {
        for(Chromosome chromosome:chromosomes){
            chromosome.setChromosomeFitnessValue(evaluateFitnessValue((LabelChromosome) chromosome));
        }
        return chromosomes;
    }

    private float evaluateFitnessValue(LabelChromosome chromosome){
        float sum =0;
        int i;
        for( i=0;i< chromosome.getGenes().size()-1;i++){
            sum+=problem.getDistancesMatrix()
                    [(chromosome.getGenes().get(i)).getNumber()]
                    [(chromosome.getGenes().get(i+1)).getNumber()];
        }

        sum+=problem.getDistancesMatrix()
                [(chromosome.getGenes().get(i)).getNumber()]
                [(chromosome.getGenes().get(0)).getNumber()];

        return -sum;
    }
}
