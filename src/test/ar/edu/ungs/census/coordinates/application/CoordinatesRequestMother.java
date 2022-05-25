package ar.edu.ungs.census.coordinates.application;

import ar.edu.ungs.census.coordinates.application.CoordinatesRequest;
import ar.edu.ungs.census.shared.domain.DoubleMother;

public class CoordinatesRequestMother {

    public static CoordinatesRequest random() {
        return new CoordinatesRequest(DoubleMother.random(), DoubleMother.random());
    }
}
