package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.blocks.application.CoordinatesRequest;
import ar.edu.ungs.census.shared.domain.DoubleMother;

public class CoordinatesRequestMother {

    public static CoordinatesRequest random() {
        return new CoordinatesRequest(DoubleMother.random(), DoubleMother.random());
    }
}
