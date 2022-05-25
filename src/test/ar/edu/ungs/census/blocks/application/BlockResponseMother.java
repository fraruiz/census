package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.coordinates.application.CoordinatesResponseMother;
import ar.edu.ungs.census.takers.application.TakerResponseMother;

import java.util.Optional;

public class BlockResponseMother {

    public static BlockResponse random(){
        return new BlockResponse(CoordinatesResponseMother.random(), Optional.of(TakerResponseMother.random()));
    }
}
