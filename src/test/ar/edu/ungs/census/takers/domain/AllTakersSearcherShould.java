package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.takers.TakersModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class AllTakersSearcherShould extends TakersModuleUnitTestCase {
	private AllTakersSearcher searcher;

	@Override
	@BeforeEach
	protected void setUp() {
		super.setUp();

		this.searcher = new AllTakersSearcher(repository);
	}

	@Test
	void return_a_takers() {
		List<Taker> expected = TakerMother.randoms();

		shouldSearchAll(expected);

		List<Taker> actual = this.searcher.search();

		assertEquals(expected, actual);
	}

	@Test
	void return_an_empty_takers() {
		List<Taker> expected = Collections.emptyList();

		List<Taker> actual = this.searcher.search();

		assertEquals(expected, actual);
	}
}