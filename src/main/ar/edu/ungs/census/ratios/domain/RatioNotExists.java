package ar.edu.ungs.census.ratios.domain;

public final class RatioNotExists extends RuntimeException {
	public RatioNotExists(Long id) {
		super(String.format("the ratio <%s> not exists", id));
	}
}
