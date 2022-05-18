package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.shared.domain.LongMother;
import ar.edu.ungs.census.shared.domain.WordMother;

public final class TakerMother {
	public static Taker build(Long id, String name) {
		return new Taker(id, name);
	}

	public static Taker random() {
		return build(LongMother.random(), WordMother.random());
	}

	public static Taker random(Long id) {
		return build(id, WordMother.random());
	}
}