package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.takers.TakersModuleInfrastructureTestCase;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerMother;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class JsonFileTakerRepositoryShould extends TakersModuleInfrastructureTestCase {
	private JsonFileTakerRepository repository;

	private ObjectMapper objectMapper;
	@BeforeEach
	void setUp() {

		this.objectMapper = new ObjectMapper();
		this.repository = new JsonFileTakerRepository(objectMapper);
	}

	@Test
	void save_all_aggregates() {
		repository.clean();

		List<Taker> aggregates = TakerMother.randoms();

		repository.saveAll(aggregates);
	}

	@Test
	void return_an_existing_aggregate() {
		repository.clean();

		Taker aggregate = TakerMother.random();

		repository.saveAll(List.of(aggregate));

		assertTrue(repository.findById(aggregate.id()).isPresent());
	}

	@Test
	void not_return_a_non_existing_aggregate() {
		repository.clean();

		Taker aggregate = TakerMother.random();

		assertTrue(repository.findById(aggregate.id()).isEmpty());
	}
}