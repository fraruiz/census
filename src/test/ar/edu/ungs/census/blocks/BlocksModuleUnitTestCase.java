package ar.edu.ungs.census.blocks;

import ar.edu.ungs.census.UnitTestCase;
import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.BlockRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class BlocksModuleUnitTestCase extends UnitTestCase {
	protected BlockRepository repository;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(BlockRepository.class);
	}

	public void shouldFindById(Block expected) {
		when(this.repository.findById(expected.id())).thenReturn(Optional.of(expected));
	}

	public void shouldSearchAll(List<Block> expects) {
		when(this.repository.searchAll()).thenReturn(expects);
	}

	protected void shouldSaved(Block expected) {
		verify(this.repository, atLeastOnce()).save(expected);
	}
}
