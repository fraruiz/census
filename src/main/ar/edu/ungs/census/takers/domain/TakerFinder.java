package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class TakerFinder {
	private final TakerRepository repository;

	public TakerFinder(TakerRepository repository) {
		this.repository = repository;
	}

	public Taker find(Long id) {
		return repository.findById(id).orElseThrow(() -> new TakerNotExists(id));
	}
}
