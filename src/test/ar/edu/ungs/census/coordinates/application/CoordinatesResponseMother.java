package ar.edu.ungs.census.coordinates.application;

import ar.edu.ungs.census.coordinates.application.CoordinatesResponse;
import ar.edu.ungs.census.shared.domain.DoubleMother;

public class CoordinatesResponseMother {

    public static CoordinatesResponse random() {
        return new CoordinatesResponse(DoubleMother.random(), DoubleMother.random());
    }
}
