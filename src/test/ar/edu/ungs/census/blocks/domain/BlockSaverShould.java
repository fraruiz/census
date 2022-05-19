package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.BlocksModuleUnitTestCase;
import ar.edu.ungs.census.blocks.application.BlockRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class BlockSaverShould extends BlocksModuleUnitTestCase {
    private BlockSaver saver;

    @BeforeEach
    public void setUp(){
        super.setUp();

        this.saver = new BlockSaver(repository);
    }
    @Test
    public void create_valid_block(){
        BlockRequest request = BlockRequestMother.random();
        Block expected = BlockRequest.map(request);

        saver.save(request);

        shouldSaved(expected);
    }


}