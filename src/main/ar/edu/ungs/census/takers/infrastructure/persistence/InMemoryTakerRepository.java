package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.shared.domain.Service;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;

import java.util.*;

@Service
public final class InMemoryTakerRepository implements TakerRepository {
	private final Map<Long, Taker> values;

	public InMemoryTakerRepository() {
		this.values = new HashMap<>();
	}

	@Override
	public void saveAll(List<Taker> takers) {
		takers.forEach(taker -> values.put(taker.id(), taker));
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
