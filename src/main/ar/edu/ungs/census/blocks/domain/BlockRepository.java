package ar.edu.ungs.census.blocks.domain;

import java.util.List;
import java.util.Optional;

public interface BlockRepository {
	void save(Block block);

	Optional<Block> findById(Long id);

	List<Block> searchAll();
}
