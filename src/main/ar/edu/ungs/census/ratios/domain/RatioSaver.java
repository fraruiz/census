package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class RatioSaver {
	private final RatioRepository repository;

	public RatioSaver(RatioRepository repository) {
		this.repository = repository;
	}

	public void save(Ratio ratio) {
		this.repository.save(ratio);
	}
}
