package ar.edu.ungs.census.ratios.domain;

public final class RatioSaver {
	private final RatioRepository repository;

	public RatioSaver(RatioRepository repository) {
		this.repository = repository;
	}

	public void save(Ratio ratio) {
		this.repository.save(ratio);
	}
}
