package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.takers.TakersModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class TakerFinderShould extends TakersModuleUnitTestCase {
	private TakerFinder finder;

	@BeforeEach
	public void setUp() {
		super.setUp();

		this.finder = new TakerFinder(repository);
	}

	@Test
	void return_a_taker() {
		Taker expected = TakerMother.random();

		shouldFindById(expected);

		Taker actual = this.finder.find(expected.id());

		assertEquals(expected, actual);
	}

	@Test
	void throws_taker_not_exists() {
		Taker expected = TakerMother.random();

		assertThrows(TakerNotExists.class, () -> this.finder.find(expected.id()));
	}
}