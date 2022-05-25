package ar.edu.ungs.census.takers.domain;

import java.util.List;
import java.util.Optional;

public interface TakerRepository {
	void saveAll(List<Taker> takers);

	Optional<Taker> findById(Long id);

	List<Taker> searchAll();
}
