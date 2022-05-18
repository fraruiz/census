package ar.edu.ungs.census.takers.domain;

public final class TakerNotExists extends RuntimeException {
	public TakerNotExists(Long id) {
		super(String.format("the census taker <%s> not exists", id));
	}
}
