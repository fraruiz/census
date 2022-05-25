package ar.edu.ungs.census.takers;

import ar.edu.ungs.census.UnitTestCase;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class TakersModuleUnitTestCase extends UnitTestCase {
	protected TakerRepository repository;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(TakerRepository.class);
	}

	public void shouldFindById(Taker expected) {
		when(this.repository.findById(expected.id())).thenReturn(Optional.of(expected));
	}

	public void shouldSearchAll(List<Taker> expected) {
		when(this.repository.searchAll()).thenReturn(expected);
	}

	protected void shouldSaved(List<Taker> expects) {
		verify(this.repository, atLeastOnce()).saveAll(expects);
	}
}
