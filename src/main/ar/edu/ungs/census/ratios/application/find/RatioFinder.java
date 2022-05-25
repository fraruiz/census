package ar.edu.ungs.census.ratios.application.find;

import ar.edu.ungs.census.ratios.application.RatioResponse;
import ar.edu.ungs.census.ratios.domain.DomainRatioFinder;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioNotExists;
import ar.edu.ungs.census.ratios.domain.RatioRepository;
import ar.edu.ungs.census.shared.domain.Service;

@Service
public final class RatioFinder {
    private final DomainRatioFinder domainRatioFinder;


    public RatioFinder(RatioRepository repository) {
        this.domainRatioFinder = new DomainRatioFinder(repository);
    }

    public RatioResponse find() {
        Ratio ratio = domainRatioFinder.find();

        return RatioResponse.map(ratio);
    }
}
