package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.coordinates.domain.Coordinates;
import ar.edu.ungs.census.coordinates.domain.CoordinatesMother;
import ar.edu.ungs.census.shared.domain.LongMother;

public final class BlockMother {
	public static Block build(Long id, Coordinates coordinates) {
		return new Block(id, coordinates);
	}

	public static Block random() {
		return build(LongMother.random(), CoordinatesMother.random());
	}

	public static Block random(Long id) {
		return build(id, CoordinatesMother.random());
	}
}