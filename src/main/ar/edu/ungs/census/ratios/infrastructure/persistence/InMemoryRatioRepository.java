package ar.edu.ungs.census.ratios.infrastructure.persistence;

import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioRepository;
import ar.edu.ungs.census.shared.domain.Service;

import java.util.Optional;

@Service
public final class InMemoryRatioRepository implements RatioRepository {
	@Override
	public void save(Ratio ratio) {

	}

	@Override
	public Optional<Ratio> find() {
		return Optional.empty();
	}
}
