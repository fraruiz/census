package ar.edu.ungs.census.ratios.application.generate;

import ar.edu.ungs.census.ratios.RatiosModuleUnitTestCase;
import ar.edu.ungs.census.ratios.domain.DomainRatioFinder;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioMother;
import ar.edu.ungs.census.ratios.domain.RatioSaver;
import ar.edu.ungs.census.takers.domain.AllTakersSearcher;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

final class RatioGeneratorShould extends RatiosModuleUnitTestCase {
	private RatioGenerator generator;

	private DomainRatioFinder finder;
	private AllTakersSearcher allTakersSearcher;
	private RatioSaver saver;

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();

		this.finder = new DomainRatioFinder(repository);
		this.allTakersSearcher = new AllTakersSearcher(takerRepository);
		this.saver = new RatioSaver(repository);

		this.generator = new RatioGenerator(finder, allTakersSearcher, saver);
	}

	@Test
	void generate_a_valid_ratio() {
		List<Taker> takers = TakerMother.randoms();
		Ratio expected = RatioMother.random();

		shouldFind(expected);
		shouldSearchAll(takers);

		this.generator.generate();

		shouldSaved(expected);
	}
}