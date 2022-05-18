package ar.edu.ungs.census.ratios.domain;

import java.util.Optional;

public interface RatioRepository {
	void save(Ratio ratio);

	Optional<Ratio> find();
}
