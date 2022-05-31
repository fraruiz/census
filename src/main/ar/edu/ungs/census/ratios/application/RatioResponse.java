package ar.edu.ungs.census.ratios.application;

import ar.edu.ungs.census.blocks.application.BlockResponse;
import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.ratios.domain.Ratio;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class RatioResponse {
	private final Set<BlockResponse> blocks;

	public RatioResponse(Set<BlockResponse> blocks) {
		this.blocks = blocks;
	}

	public static RatioResponse map(Ratio ratio) {
		Set<BlockResponse> blocks = ratio.blocks()
		                                 .stream()
		                                 .map(block -> BlockResponse.map(block, ratio.taker(block)))
		                                 .collect(Collectors.toSet());
		return new RatioResponse(blocks);
	}

	public Set<BlockResponse> blocks() {
		return blocks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RatioResponse that = (RatioResponse) o;
		return Objects.equals(blocks, that.blocks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocks);
	}
}
