package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.shared.domain.DoubleMother;

public class CoordinatesResponseMother {

    public static CoordinatesResponse random() {
        return new CoordinatesResponse(DoubleMother.random(), DoubleMother.random());
    }
}
