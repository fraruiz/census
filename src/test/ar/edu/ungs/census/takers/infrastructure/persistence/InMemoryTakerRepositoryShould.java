package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.takers.TakersModuleInfrastructureTestCase;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class InMemoryTakerRepositoryShould extends TakersModuleInfrastructureTestCase {
	private InMemoryTakerRepository repository;

	@BeforeEach
	void setUp() {
		this.repository = new InMemoryTakerRepository();
	}

	@Test
	void save_an_aggregate() {
		Taker aggregate = TakerMother.random();

		repository.save(aggregate);
	}

	@Test
	void return_an_existing_aggregate() {
		Taker aggregate = TakerMother.random();

		repository.save(aggregate);

		assertTrue(repository.findById(aggregate.id()).isPresent());
	}

	@Test
	void not_return_a_non_existing_aggregate() {
		Taker aggregate = TakerMother.random();

		assertTrue(repository.findById(aggregate.id()).isEmpty());
	}
}