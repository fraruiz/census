package ar.edu.ungs.census.blocks.domain;

import ar.edu.ungs.census.blocks.BlocksModuleUnitTestCase;
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
        Block block = BlockMother.random();
        saver.save(block.id(), block.coordinates());

        shouldSaved(block);
    }


}