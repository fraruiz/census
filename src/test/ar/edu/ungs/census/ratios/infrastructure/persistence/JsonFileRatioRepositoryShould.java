package ar.edu.ungs.census.ratios.infrastructure.persistence;

import ar.edu.ungs.census.ratios.RatiosModuleInfrastructureTestCase;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioMother;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class JsonFileRatioRepositoryShould extends RatiosModuleInfrastructureTestCase {
	private JsonFileRatioRepository repository;

	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		this.objectMapper = new ObjectMapper();

		this.repository = new JsonFileRatioRepository(objectMapper);
	}

	@Test
	void save_an_aggregate() {
		repository.clean();

		Ratio aggregate = RatioMother.random();

		repository.save(aggregate);
	}

	@Test
	void return_an_existing_aggregate() {
		repository.clean();

		Ratio aggregate = RatioMother.random();

		repository.save(aggregate);

		assertTrue(repository.find().isPresent());
	}

	@Test
	void not_return_a_non_existing_aggregate() throws JsonProcessingException {
		repository.clean();

		assertTrue(repository.find().isEmpty());
	}
}