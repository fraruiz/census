package ar.edu.ungs.census.ratios.application.find;

import ar.edu.ungs.census.ratios.application.RatioResponse;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioNotExists;
import ar.edu.ungs.census.ratios.domain.RatioRepository;

public final class RatioFinder {
    private final RatioRepository repository;

    public RatioFinder(RatioRepository repository) {
        this.repository = repository;
    }

    public RatioResponse find() {
        Ratio ratio = repository.find().orElseThrow(RatioNotExists::new);
        return RatioResponse.map(ratio);
    }

}
