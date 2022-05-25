package ar.edu.ungs.census.takers.application.create;

import ar.edu.ungs.census.shared.domain.Service;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public final class TakerSaver {
	private final TakerRepository repository;

	public TakerSaver(TakerRepository repository) {
		this.repository = repository;
	}

	public void save(List<String> names) {
		List<Taker> takers = IntStream.range(0, names.size())
		                              .mapToObj(index -> buildTaker(names, index))
		                              .collect(Collectors.toList());

		repository.saveAll(takers);
	}

	private Taker buildTaker(List<String> names, int index) {
		Long id = Long.valueOf(index) + 1;
		return new Taker(id, names.get(index));
	}
}
