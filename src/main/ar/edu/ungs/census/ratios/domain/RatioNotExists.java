package ar.edu.ungs.census.ratios.domain;

public final class RatioNotExists extends RuntimeException {
	public RatioNotExists() {
		super("the ratio not exists");
	}
}
