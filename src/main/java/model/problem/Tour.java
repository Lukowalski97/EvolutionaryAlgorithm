package model.problem;

import java.util.ArrayList;
import java.util.List;

public class Tour extends Chromosome<City> {
    public Tour(List<City> genes) {
        super(genes);
    }

    public Tour() {
        super();
    }

    public int tourSize() {
        return this.getGenes().size();
    }

    public City getCity(int i) {
        return this.getGenes().get(i);
    }
}
