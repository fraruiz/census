package ar.edu.ungs.census.ratios.domain;

import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class DomainRatioFinder {
    private final RatioRepository repository;

    public DomainRatioFinder(RatioRepository repository) {
        this.repository = repository;
    }

    public Ratio find() {
        return repository.find().orElseThrow(RatioNotExists::new);
    }
}
