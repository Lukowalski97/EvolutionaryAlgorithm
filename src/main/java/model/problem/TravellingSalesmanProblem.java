package model.problem;

import java.util.List;

public class TravellingSalesmanProblem implements IProblem<LabelGene> {

    private final float[][] distancesMatrix;


    private List<Chromosome<LabelGene>> chromosomes;

    public TravellingSalesmanProblem(float[][] distancesMatrix) {
        this.distancesMatrix = distancesMatrix;
    }

    public float[][] getDistancesMatrix() {
        return distancesMatrix;
    }

    @Override
    public void setChromosomes(List<Chromosome<LabelGene>> chromosomes) {

        this.chromosomes = chromosomes;
    }

    @Override
    public List<Chromosome<LabelGene>> getChromosomes() {
        return this.chromosomes;
    }
}
