package model.problem;

import java.util.ArrayList;
import java.util.List;

public class TspProblem implements IProblem<City> {
    private static ArrayList<City> destinationCities;
    private List<Chromosome<City>> chromosomes;

    public TspProblem(ArrayList<City> destinationCities) {
        this.destinationCities = destinationCities;
    }

    @Override
    public void setChromosomes(List<Chromosome<City>> chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public List<Chromosome<City>> getChromosomes() {
        return chromosomes;
    }


    public static ArrayList<City> getCities(){
        return destinationCities;
    }
}
