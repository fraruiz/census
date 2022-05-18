package ar.edu.ungs.census.ratios;

import ar.edu.ungs.census.UnitTestCase;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class RatiosModuleUnitTestCase extends UnitTestCase {
	protected RatioRepository repository;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(RatioRepository.class);
	}

	public void shouldFindById(Ratio expected) {
		when(this.repository.find()).thenReturn(Optional.of(expected));
	}

	protected void shouldSaved(Ratio expected) {
		verify(this.repository, atLeastOnce()).save(expected);
	}
}
