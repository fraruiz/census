package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.BlockMother;

public final class RatioMother {

	/**
	 * Ratio:
	 * 1 2
	 * 3 4
	 * 5 6
	 * 7 8
	 * 9 10
	 *
	 * Blocks -> Neighbours
	 * 1 -> 2, 3
	 * 2 -> 1, 4
	 * 3 -> 1, 4, 5
	 * 4 -> 2, 3, 6
	 * 5 -> 7, 3, 6
	 * 6 -> 4, 5, 8
	 * 7 -> 5, 8, 9
	 * 8 -> 6, 7, 10
	 * 9 -> 7, 10
	 * 10 -> 8, 9
	 * **/
	public static Ratio random() {
		Ratio ratio = new Ratio();

		Block oneBlock = BlockMother.random(1L);
		Block twoBlock = BlockMother.random(2L);
		Block threeBlock = BlockMother.random(3L);
		Block fourBlock = BlockMother.random(4L);
		Block fiveBlock = BlockMother.random(5L);
		Block sixBlock = BlockMother.random(6L);
		Block sevenBlock = BlockMother.random(7L);
		Block eightBlock = BlockMother.random(8L);
		Block nineBlock = BlockMother.random(9L);
		Block tenBlock = BlockMother.random(10L);

		ratio.add(oneBlock, twoBlock);
		ratio.add(oneBlock, threeBlock);

		ratio.add(twoBlock, oneBlock);
		ratio.add(twoBlock, fourBlock);

		ratio.add(threeBlock, oneBlock);
		ratio.add(threeBlock, fourBlock);
		ratio.add(threeBlock, fiveBlock);

		ratio.add(fourBlock, twoBlock);
		ratio.add(fourBlock, threeBlock);
		ratio.add(fourBlock, sixBlock);

		ratio.add(fiveBlock, sevenBlock);
		ratio.add(fiveBlock, threeBlock);
		ratio.add(fiveBlock, sixBlock);

		ratio.add(sixBlock, fourBlock);
		ratio.add(sixBlock, fiveBlock);
		ratio.add(sixBlock, eightBlock);

		ratio.add(sevenBlock, fiveBlock);
		ratio.add(sevenBlock, eightBlock);
		ratio.add(sevenBlock, nineBlock);

		ratio.add(eightBlock, sixBlock);
		ratio.add(eightBlock, sevenBlock);
		ratio.add(eightBlock, tenBlock);

		ratio.add(nineBlock, sevenBlock);
		ratio.add(nineBlock, tenBlock);

		ratio.add(tenBlock, eightBlock);
		ratio.add(tenBlock, nineBlock);

		return ratio;
	}
}