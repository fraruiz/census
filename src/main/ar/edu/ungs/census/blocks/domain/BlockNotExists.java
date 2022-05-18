package ar.edu.ungs.census.blocks.domain;

public final class BlockNotExists extends RuntimeException {
	public BlockNotExists() {
		super("the block not exists");
	}
}
