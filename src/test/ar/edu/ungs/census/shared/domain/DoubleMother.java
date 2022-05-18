package ar.edu.ungs.census.shared.domain;

import java.util.Random;

public final class DoubleMother {
	public static Double random(Double min, Double max) {
		return min + (max - min) * new Random().nextDouble();
	}

	public static Double random(Double min) {
		return random(min, 10000D);
	}

	public static Double random() {
		return random(1D, 10000D);
	}
}
