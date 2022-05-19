package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.application.BlockRequest;

public final class BlockSaver {
    private final BlockRepository repository;

    public BlockSaver(BlockRepository repository) {
        this.repository = repository;
    }

    public void save(BlockRequest request) {
        Block block = BlockRequest.map(request);

        repository.save(block);
    }
}
