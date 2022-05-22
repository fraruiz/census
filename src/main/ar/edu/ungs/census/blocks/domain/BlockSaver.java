package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class BlockSaver {
    private final BlockRepository repository;

    public BlockSaver(BlockRepository repository) {
        this.repository = repository;
    }

    public void save(Long id, Coordinates coordinates) {
        Block block = new Block(id, coordinates);

        repository.save(block);
    }
}
