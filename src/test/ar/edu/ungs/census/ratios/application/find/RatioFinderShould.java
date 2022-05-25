package ar.edu.ungs.census.ratios.application.find;

import ar.edu.ungs.census.ratios.RatiosModuleUnitTestCase;
import ar.edu.ungs.census.ratios.application.RatioResponse;
import ar.edu.ungs.census.ratios.application.RatioResponseMother;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class RatioFinderShould extends RatiosModuleUnitTestCase {
    private RatioFinder finder;

    @BeforeEach
    public void setUp() {
        super.setUp();

        this.finder = new RatioFinder(repository);
    }
    @Test
    public void return_a_ratio(){
        Ratio ratio = RatioMother.random();
        RatioResponse expected = RatioResponse.map(ratio);

        shouldFind(ratio);
        RatioResponse actual = finder.find();

        assertEquals(expected, actual);
    }



}