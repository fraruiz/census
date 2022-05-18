package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;

import java.util.*;

public final class InMemoryTakerRepository implements TakerRepository {
	private final Map<Long, Taker> values;

	public InMemoryTakerRepository() {
		this.values = new HashMap<>();
	}

	@Override
	public void save(Taker taker) {
		this.values.put(taker.id(), taker);
	}

	@Override
	public Optional<Taker> findById(Long id) {
		return Optional.ofNullable(values.get(id));
	}

	@Override
	public List<Taker> searchAll() {
		return new ArrayList<>(values.values());
	}
}
