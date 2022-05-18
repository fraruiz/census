package ar.edu.ungs.census.takers.domain;

import java.util.List;
import java.util.Optional;

public interface TakerRepository {
	void save(Taker taker);

	Optional<Taker> findById(Long id);

	List<Taker> searchAll();
}
