package ar.edu.ungs.census.ratios.application.generate;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.ratios.domain.DomainRatioFinder;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioSaver;
import ar.edu.ungs.census.shared.domain.Service;
import ar.edu.ungs.census.takers.domain.AllTakersSearcher;
import ar.edu.ungs.census.takers.domain.Taker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class RatioGenerator {
	private final DomainRatioFinder finder;
	private final AllTakersSearcher allTakersSearcher;

	private final RatioSaver saver;

	private final static Integer MAX_ASSIGNS_ATTEMPT_BY_TAKER = 3;

	private Ratio ratio;
	private List<Taker> takers;
	private Map<Taker, Integer> blocksAssignedByTaker;
	private Map<Block, Boolean> blocksAssignStatus;
	private Integer takerIndex ;

	public RatioGenerator(DomainRatioFinder finder, AllTakersSearcher allTakersSearcher, RatioSaver saver) {
		this.finder = finder;
		this.allTakersSearcher = allTakersSearcher;
		this.saver = saver;
	}

	public void generate() {
		this.ratio = finder.find();
		this.takers = allTakersSearcher.search();

		List<Block> blocks = ratio.blocks();

		this.blocksAssignedByTaker = buildBlocksAssignedByTaker(takers);
		this.blocksAssignStatus = buildBlocksAssignStatus(blocks);
		this.takerIndex = 0;

		for (Block block : blocks) {
			if (!blocksAssignStatus.get(block) && takerIndex < takers.size()) {
				assignBlock(block);

				takerIndex++;
			}
		}

		saver.save(ratio);
	}

	private void assignBlock(Block block) {
		Boolean isAssigned = assignTakerToBlock(block);

		if (isAssigned) {
			ratio.neighbours(block).forEach(this::assignTakerToBlock);
		}
	}

	public Boolean assignTakerToBlock(Block block) {
		Taker taker = takers.get(takerIndex);
		Integer blocksAssigned = blocksAssignedByTaker.get(taker);

		if (this.ratio.isAssigned(block) || blocksAssigned >= MAX_ASSIGNS_ATTEMPT_BY_TAKER){
			return false;
		}

		ratio.assign(taker, block);
		blocksAssignedByTaker.put(taker, ++blocksAssigned);
		blocksAssignStatus.put(block, true);

		return true;
	}

	private Map<Block, Boolean> buildBlocksAssignStatus(List<Block> blocks) {
		Map<Block, Boolean> values = new HashMap<>();

		blocks.forEach(block -> values.put(block, false));

		return values;
	}

	private Map<Taker, Integer> buildBlocksAssignedByTaker(List<Taker> takers) {
		Map<Taker, Integer> values = new HashMap<>();

		takers.forEach(taker -> values.put(taker, 0));

		return values;
	}
}
