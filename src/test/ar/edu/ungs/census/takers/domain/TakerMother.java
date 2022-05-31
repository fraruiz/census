package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.shared.domain.LongMother;
import ar.edu.ungs.census.shared.domain.WordMother;

import java.util.List;

public final class TakerMother {
	public static Taker build(Long id, String name) {
		return new Taker(id, name);
	}

	public static List<Taker> randoms() {
		return List.of(random(1L), random(2L), random(3L));
	}

	public static Taker random() {
		return build(LongMother.random(), WordMother.random());
	}

	public static Taker random(Long id) {
		return build(id, WordMother.random());
	}
}