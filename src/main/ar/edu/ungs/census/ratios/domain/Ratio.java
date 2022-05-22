package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.takers.domain.Taker;

import java.util.*;

public final class Ratio {
	private final Map<Block, Set<Block>> values;
	private final Map<Block, Taker> takers;

	public Ratio() {
		this.values = new HashMap<>();
		this.takers = new HashMap<>();
	}

	public void add(Block firstBlock, Block secondBlock) {
		ensureBlocksAreDifferent(firstBlock, secondBlock);

		if (!values.containsKey(firstBlock)) {
			values.put(firstBlock, new HashSet<>());
		}

		if (!values.containsKey(secondBlock)) {
			values.put(secondBlock, new HashSet<>());
		}

		values.get(firstBlock).add(secondBlock);
		values.get(secondBlock).add(firstBlock);
	}

	public void assign(Taker taker, Block block) {
		this.takers.put(block, taker);
	}

	public Optional<Taker> taker(Block block) {
		return takers.containsKey(block) ? Optional.ofNullable(takers.get(block)) : Optional.empty();
	}

	public Set<Block> neighbours(Block block) {
		return this.values.get(block);
	}

	public Set<Block> blocks() {
		return values.keySet();
	}

	private void ensureBlocksAreDifferent(Block firstBlock, Block secondBlock) {
		if (firstBlock.equals(secondBlock)) {
			throw new IllegalArgumentException("the blocks can not be equals");
		}
	}
}
