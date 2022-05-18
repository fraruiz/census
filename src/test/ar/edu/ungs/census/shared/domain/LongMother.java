package ar.edu.ungs.census.shared.domain;

import java.util.Random;

public final class LongMother {
	public static Long random(Long min, Long max) {
		return min + (max - min) * new Random().nextLong();
	}

	public static Long random() {
		return random(1L, 10000L);
	}
}
