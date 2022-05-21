package ar.edu.ungs.census.blocks.application;

public class BlockRequestMother {

    public static BlockRequest random(){
        return new BlockRequest(10L, CoordinatesRequestMother.random());
    }
}
