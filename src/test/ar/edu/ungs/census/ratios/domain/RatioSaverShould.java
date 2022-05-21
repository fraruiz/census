package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.ratios.RatiosModuleUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class RatioSaverShould extends RatiosModuleUnitTestCase {
    private RatioSaver saver;

    @BeforeEach
    public void setUp(){
        super.setUp();

        this.saver = new RatioSaver(repository);
    }

    @Test
    public void create_a_valid_ratio(){
        Ratio ratio = RatioMother.random();

        saver.save(ratio);

        shouldSaved(ratio);
    }
}