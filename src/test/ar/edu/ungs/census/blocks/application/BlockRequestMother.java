package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.coordinates.application.CoordinatesRequestMother;

public class BlockRequestMother {

	public static BlockRequest random() {
		return new BlockRequest(10L, CoordinatesRequestMother.random());
	}
}
