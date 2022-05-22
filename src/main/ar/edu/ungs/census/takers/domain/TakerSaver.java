package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class TakerSaver {
	private final TakerRepository repository;

	public TakerSaver(TakerRepository repository) {
		this.repository = repository;
	}

	public void save(Long id, String name) {
		Taker taker = new Taker(id, name);

		this.repository.save(taker);
	}
}
