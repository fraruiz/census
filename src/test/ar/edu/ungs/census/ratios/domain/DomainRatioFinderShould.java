package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.ratios.RatiosModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class DomainRatioFinderShould extends RatiosModuleUnitTestCase {
	private DomainRatioFinder finder;

	@BeforeEach
	public void setUp() {
		super.setUp();

		this.finder = new DomainRatioFinder(repository);
	}

	@Test
	public void return_a_ratio() {
		Ratio expected = RatioMother.random();

		shouldFind(expected);

		Ratio actual = finder.find();

		assertEquals(expected, actual);
	}

    @Test
    public void throws_ratio_not_exists() {
        assertThrows(RatioNotExists.class, () -> finder.find());
    }
}