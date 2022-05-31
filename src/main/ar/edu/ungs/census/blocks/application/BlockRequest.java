package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.coordinates.application.CoordinatesRequest;

import java.util.Objects;

public class BlockRequest {

	private final Long id;
	private final CoordinatesRequest coordinates;

	public BlockRequest(Long id, CoordinatesRequest coordinates) {
		this.id = id;
		this.coordinates = coordinates;
	}

	public static Block map(BlockRequest request) {
		return new Block(request.getId(), CoordinatesRequest.map(request.getCoordinates()));
	}

	public Long getId() {
		return id;
	}

	public CoordinatesRequest getCoordinates() {
		return coordinates;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BlockRequest that = (BlockRequest) o;
		return Objects.equals(id, that.id) && Objects.equals(coordinates, that.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, coordinates);
	}
}
