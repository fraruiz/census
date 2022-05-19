package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.application.BlockRequest;

public class BlockRequestMother {

    public static BlockRequest random(){
        return new BlockRequest(10L, CoordinatesMother.random());
    }
}
