package ar.edu.ungs.census.ratios.infrastructure.persistence;

import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioRepository;

import java.util.Optional;

public final class InMemoryRatioRepository implements RatioRepository {
	@Override
	public void save(Ratio ratio) {

	}

	@Override
	public Optional<Ratio> find() {
		return Optional.empty();
	}
}
