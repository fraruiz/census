package ar.edu.ungs.census.takers.domain;

import ar.edu.ungs.census.takers.TakersModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class TakerSaverShould extends TakersModuleUnitTestCase {
	private TakerSaver saver;
	@BeforeEach
	public void setUp() {
		super.setUp();

		this.saver = new TakerSaver(repository);
	}

	@Test
	void crete_a_valid_taker() {
		Taker taker = TakerMother.random();

		saver.save(taker.id(), taker.name());

		shouldSaved(taker);
	}
}