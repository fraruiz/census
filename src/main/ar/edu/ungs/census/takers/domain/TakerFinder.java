package ar.edu.ungs.census.takers.domain;

public final class TakerFinder {
	private final TakerRepository repository;

	public TakerFinder(TakerRepository repository) {
		this.repository = repository;
	}

	public Taker find(Long id) {
		return repository.findById(id).orElseThrow(() -> new TakerNotExists(id));
	}
}
