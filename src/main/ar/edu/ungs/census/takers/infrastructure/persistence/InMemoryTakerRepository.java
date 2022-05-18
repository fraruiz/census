package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;

import java.util.List;
import java.util.Optional;

public final class InMemoryTakerRepository implements TakerRepository {
	@Override
	public void save(Taker taker) {

	}

	@Override
	public Optional<Taker> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public List<Taker> searchAll() {
		return null;
	}
}
