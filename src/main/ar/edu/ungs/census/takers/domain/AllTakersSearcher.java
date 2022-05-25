package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.shared.domain.Service;

import java.util.List;

@Service
public final class AllTakersSearcher {
	private final TakerRepository repository;

	public AllTakersSearcher(TakerRepository repository) {
		this.repository = repository;
	}

	public List<Taker> search() {
		return repository.searchAll();
	}
}
