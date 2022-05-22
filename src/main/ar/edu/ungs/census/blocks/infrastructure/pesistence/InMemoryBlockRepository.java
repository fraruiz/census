package ar.edu.ungs.census.blocks.infrastructure.pesistence;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.BlockRepository;
import ar.edu.ungs.census.shared.domain.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryBlockRepository implements BlockRepository {
	@Override
	public void save(Block block) {

	}

	@Override
	public Optional<Block> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public List<Block> searchAll() {
		return null;
	}
}
