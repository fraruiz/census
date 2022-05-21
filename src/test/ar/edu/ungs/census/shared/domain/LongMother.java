package ar.edu.ungs.census.shared.domain;

import java.util.Random;

public final class LongMother {
	public static Long random(Long min, Long max) {
		long leftLimit = min;
		long rightLimit = max;
		return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	}

	public static Long random() {
		return random(1L, 10000L);
	}
}
