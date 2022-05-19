package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.application.BlockRequest;
import ar.edu.ungs.census.blocks.application.CoordinatesRequest;

public class BlockRequestMother {

    public static BlockRequest random(){
        return new BlockRequest(10L, CoordinatesRequestMother.random());
    }
}
