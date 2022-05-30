package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.takers.domain.Taker;

import java.util.*;
import java.util.stream.Collectors;

public final class Ratio {
	private final Map<Block, List<Block>> values;
	private final Map<Block, Taker> blocksAssigned;

	public Ratio() {
		this.values = new HashMap<>();
		this.blocksAssigned = new HashMap<>();
	}

	public void add(Block firstBlock, Block secondBlock) {
		ensureBlocksAreDifferent(firstBlock, secondBlock);

		if (!values.containsKey(firstBlock)) {
			values.put(firstBlock, new ArrayList<>());
		}

		if (!values.containsKey(secondBlock)) {
			values.put(secondBlock, new ArrayList<>());
		}

		if (!values.get(firstBlock).contains(secondBlock)) {
			values.get(firstBlock).add(secondBlock);
		}

		if (!values.get(secondBlock).contains(firstBlock)) {
			values.get(secondBlock).add(firstBlock);
		}
	}

	public Boolean isNotAssigned(Block block) {
		return !isAssigned(block);
	}

	public Boolean isAssigned(Block block) {
		return this.blocksAssigned.containsKey(block) && this.blocksAssigned.get(block) != null;
	}

	public void assign(Taker taker, Block block) {
		if (isAssigned(block)) {
			throw new CanNotAssignBlockAssigned(block.id(), taker.id(), this.blocksAssigned.get(block).id());
		}

		this.blocksAssigned.put(block, taker);
	}

	public Optional<Taker> taker(Block block) {
		return blocksAssigned.containsKey(block)
		       ? Optional.ofNullable(blocksAssigned.get(block))
		       : Optional.empty();
	}

	public List<Block> neighbours(Block block) {
		return this.values.get(block);
	}

	public List<Block> blocks() {
		return values.keySet().stream().sorted(Comparator.comparing(Block::id)).collect(Collectors.toList());
	}

	public Taker assigned(Block block) {
		return this.blocksAssigned.get(block);
	}

	private void ensureBlocksAreDifferent(Block firstBlock, Block secondBlock) {
		if (firstBlock.equals(secondBlock)) {
			throw new IllegalArgumentException("the blocks can not be equals");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ratio ratio = (Ratio) o;
		return Objects.equals(values, ratio.values) && Objects.equals(blocksAssigned, ratio.blocksAssigned);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values, blocksAssigned);
	}

	@Override
	public String toString() {
		return "Ratio{" + "values=" + values + ", blocksAssigned=" + blocksAssigned + '}';
	}
}
