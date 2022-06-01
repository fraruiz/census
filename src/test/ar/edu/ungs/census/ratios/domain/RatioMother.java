package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.BlockMother;
import ar.edu.ungs.census.coordinates.domain.CoordinatesMother;
import ar.edu.ungs.census.takers.domain.Taker;

import java.util.Collections;
import java.util.List;

public final class RatioMother {

	/**
	 * Ratio:
	 * 1 2
	 * 3 4
	 * 5 6
	 * 7 8
	 * 9 10
	 * <p>
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
	 **/
	public static Ratio random() {
		Ratio ratio = new Ratio();

		Block oneBlock = BlockMother.build(1L, CoordinatesMother.build(-34.516314392803885, -58.705777227889776));
		Block twoBlock = BlockMother.build(2L, CoordinatesMother.build(-34.51700867025102, -58.706355856676));
		Block threeBlock = BlockMother.build(3L, CoordinatesMother.build(-34.51776937311428, -58.70719056536397));
		Block fourBlock = BlockMother.build(4L, CoordinatesMother.build(-34.51872805661517, -58.70821500101895));
		Block fiveBlock = BlockMother.build(5L, CoordinatesMother.build(-34.52010353845447, -58.70980861212688));
		Block sixBlock = BlockMother.build(6L, CoordinatesMother.build(-34.520593293133516, -58.71023864994652));
		Block sevenBlock = BlockMother.build(7L, CoordinatesMother.build(-34.5211038875183, -58.7106813425368));
		Block eightBlock = BlockMother.build(8L, CoordinatesMother.build(-34.52149985435305, -58.7111240350168));
		Block nineBlock = BlockMother.build(9L, CoordinatesMother.build(-34.522114644984526, -58.711769113442166));
		Block tenBlock = BlockMother.build(10L, CoordinatesMother.build(-34.52256271076481, -58.71226241554275));
		Block eleven = BlockMother.build(11L, CoordinatesMother.build(-34.51729000254123, -58.70450938156608));
		Block twelve = BlockMother.build(12L, CoordinatesMother.build(-34.51818618603309, -58.70506584105236));
		Block thirteen = BlockMother.build(13L, CoordinatesMother.build(-34.51875932512413, -58.70558437178396));
		Block fourteen = BlockMother.build(14L, CoordinatesMother.build(-34.519436667340045, -58.70658350937224));
		Block fifteen = BlockMother.build(15L,CoordinatesMother.build(-34.5201140019816, -58.7074688356238));
		Block sixteen = BlockMother.build(16L,CoordinatesMother.build(-34.52101016367921, -58.70834153492267));
		Block seventeen = BlockMother.build(17L,CoordinatesMother.build(-34.521583287719245, -58.70891069754742));
		Block eighteen = BlockMother.build(18L,CoordinatesMother.build(-34.521979257405995, -58.70955574924209));
		Block nineteen = BlockMother.build(19L,CoordinatesMother.build(-34.52243775331132, -58.71003638881295));
		Block twenty = BlockMother.build(20L, CoordinatesMother.build(-34.522990031796795, -58.71060557637608));

		ratio.add(oneBlock, twoBlock);
		ratio.add(oneBlock, eleven);

		ratio.add(twoBlock, threeBlock);
		ratio.add(twoBlock, twelve);

		ratio.add(threeBlock, thirteen);
		ratio.add(threeBlock, fourBlock);

		ratio.add(fourBlock, fourteen);
		ratio.add(fourBlock, fifteen);
		ratio.add(fourBlock, fiveBlock);

		ratio.add(fiveBlock, sixteen);
		ratio.add(fiveBlock, sixBlock);

		ratio.add(sixBlock, seventeen);
		ratio.add(sixBlock, sevenBlock);

		ratio.add(sevenBlock, eighteen);
		ratio.add(sevenBlock, eightBlock);

		ratio.add(eightBlock, nineteen);
		ratio.add(eightBlock, nineBlock);

		ratio.add(nineBlock, twenty);
		ratio.add(nineBlock, tenBlock);

		ratio.add(tenBlock, nineBlock);

		ratio.add(eleven, twelve);

		ratio.add(twelve, thirteen);

		ratio.add(thirteen, fourteen);

		ratio.add(fourteen, fifteen);
		ratio.add(fifteen, sixteen);
		ratio.add(sixteen, seventeen);
		ratio.add(seventeen, eighteen);
		ratio.add(eighteen, nineteen);
		ratio.add(nineteen, twenty);

		return ratio;
	}

	public static Ratio random(List<Taker> takersToAssign) {
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

		if (takersToAssign.isEmpty()) {
			return ratio;
		}

		ratio.assign(takersToAssign.get(0), oneBlock);
		ratio.assign(takersToAssign.get(0), twoBlock);
		ratio.assign(takersToAssign.get(0), threeBlock);

		ratio.assign(takersToAssign.get(1), fourBlock);
		ratio.assign(takersToAssign.get(1), sixBlock);

		ratio.assign(takersToAssign.get(2), fiveBlock);
		ratio.assign(takersToAssign.get(2), sevenBlock);

		return ratio;
	}
}