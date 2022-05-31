package ar.edu.ungs.census.takers.application.create;

import ar.edu.ungs.census.takers.TakersModuleUnitTestCase;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

final class TakerSaverShould extends TakersModuleUnitTestCase {
	private TakerSaver saver;

	@BeforeEach
	public void setUp() {
		super.setUp();

		this.saver = new TakerSaver(repository);
	}

	@Test
	void crete_a_valid_takers() {
		List<Taker> expects = TakerMother.randoms();

		this.saver.save(expects.stream().map(Taker::name).collect(Collectors.toList()));

		shouldSaved(expects);
	}
}