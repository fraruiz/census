package ar.edu.ungs.census.ratios.domain;

public final class CanNotAssignBlockAssigned extends RuntimeException {
	public CanNotAssignBlockAssigned(Long id, Long takerNotAssigned, Long takerAssigned) {
		super(String.format("can no assign a block <%s> with taker <%s> because it was assigned for <%s> taker", id,
		                    takerNotAssigned, takerAssigned));
	}
}
