package ar.edu.ungs.census.coordinates.domain;

import ar.edu.ungs.census.coordinates.domain.Coordinates;
import ar.edu.ungs.census.shared.domain.DoubleMother;

final class CoordinatesMother {
	public static Coordinates build(Double latitude, Double longitude) {
		return new Coordinates(latitude, longitude);
	}
	public static Coordinates random() {
		return build(DoubleMother.random(-100D), DoubleMother.random(-100D));
	}
}