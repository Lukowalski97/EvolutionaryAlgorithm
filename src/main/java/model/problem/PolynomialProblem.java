package model.problem;

import java.util.List;

public class PolynomialProblem implements IProblem {

    private final  float[] polynomial;
    private List<Chromosome> chromosomes;
    private final float minX,maxX;
    private final boolean isSearchingForMax;

    public PolynomialProblem(float[] polynomial){
        this.polynomial=polynomial;
        this.minX=-10;
        this.maxX=10;
        this.isSearchingForMax=true;
    }

    public PolynomialProblem(float[] polynomial, float minX, float maxX, boolean isSearchingForMax){
        this.polynomial=polynomial;
        this.minX=minX;
        this.maxX=maxX;
        this.isSearchingForMax=isSearchingForMax;
    }

    public boolean isSearchingForMax() {
        return isSearchingForMax;
    }

    public float getMinX() {
        return minX;
    }


    public float getMaxX() {
        return maxX;
    }


    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public float[]  getPolynomial(){
        return this.polynomial;
    }

}
