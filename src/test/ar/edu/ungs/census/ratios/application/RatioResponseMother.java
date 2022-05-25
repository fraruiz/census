package ar.edu.ungs.census.ratios.application;

import ar.edu.ungs.census.blocks.application.BlockResponse;
import ar.edu.ungs.census.blocks.application.BlockResponseMother;

import java.util.HashSet;
import java.util.Set;

public class RatioResponseMother {

    public static RatioResponse random() {
        Set<BlockResponse> blockResponses = new HashSet<>();

        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());
        blockResponses.add(BlockResponseMother.random());

        return new RatioResponse(blockResponses);
    }
}
