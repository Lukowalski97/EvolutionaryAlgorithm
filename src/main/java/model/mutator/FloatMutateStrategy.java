package model.mutator;

import model.problem.Chromosome;
import model.problem.FloatGene;
import model.problem.Gene;

import java.util.List;
import java.util.Random;

public class FloatMutateStrategy implements IMutateStrategy {

    private float mutationChance;
    private float mutationMaxDelta;
    private Random random;

    public FloatMutateStrategy(float mutationChance, float mutationMaxDelta) {
        this.mutationChance = mutationChance;
        this.mutationMaxDelta = mutationMaxDelta;
        this.random = new Random();
    }

    public List<Chromosome> mutateChromosomes(List<Chromosome> chromosomes) {
        for (Chromosome chromosome : chromosomes) {
            if (random.nextFloat() <= getMutationChance()) {
                for (Gene gene : chromosome.getGenes()) {
                    ((FloatGene) gene).setValue(((FloatGene) gene).getValue() + getDelta());
                }
            }
        }
        return chromosomes;
    }

    private float getDelta() {
        return random.nextFloat() * (2 * mutationMaxDelta) - mutationMaxDelta;
    }

    public float getMutationChance() {
        return this.mutationChance;
    }

    public void setMutationChance(float mutationChance) {
        this.mutationChance = mutationChance;
    }
}
