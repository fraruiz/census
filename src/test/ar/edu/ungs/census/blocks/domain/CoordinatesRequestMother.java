package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.application.CoordinatesRequest;

public class CoordinatesRequestMother {

    public static CoordinatesRequest random() {
        return new CoordinatesRequest(10d, 10d);
    }
}
