package model.initializer;

import model.problem.*;
import sun.tracing.ProbeSkeleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.problem.TspProblem.getCities;

public class TspInitStrategy implements IInitStrategy<City> {

    @Override
    public List<Chromosome<City>> initChromosomes(int chromosomesAmount, int chromosomeSize) {
        List<Chromosome<City>> outp = new ArrayList<>();

        for(int i=0;i<chromosomesAmount;i++){
            outp.add(new Tour(initGenes(chromosomeSize)));
        }
        return outp;
    }

    @Override
    public List<City> initGenes(int genesAmount) {
        ArrayList<City> cities = getCities();
        Collections.shuffle(cities);
        return cities;
    }
}
