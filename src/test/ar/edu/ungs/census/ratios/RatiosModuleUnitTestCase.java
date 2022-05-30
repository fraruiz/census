package ar.edu.ungs.census.ratios;

import ar.edu.ungs.census.UnitTestCase;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioRepository;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class RatiosModuleUnitTestCase extends UnitTestCase {
	protected RatioRepository repository;
	protected TakerRepository takerRepository;

	@BeforeEach
	protected void setUp() {
		this.repository = mock(RatioRepository.class);
		this.takerRepository = mock(TakerRepository.class);
	}

	public void shouldFind(Ratio expected) {
		when(this.repository.find()).thenReturn(Optional.of(expected));
	}

	public void shouldSearchAll(List<Taker> takers) {
		when(this.takerRepository.searchAll()).thenReturn(takers);
	}

	protected void shouldSaved(Ratio expected) {
		verify(this.repository, atLeastOnce()).save(expected);
	}
}
