package ar.edu.ungs.census.blocks.domain;

import java.util.Objects;

public final class Block {
	private final Long id;
	private final Coordinates coordinates;

	public Block(Long id, Coordinates coordinates) {
		ensureIdValid(id);

		this.id = id;
		this.coordinates = coordinates;
	}

	private void ensureIdValid(Long id) {
		if (id <= 0) {
			throw new IllegalArgumentException(String.format("the id <%s> can not be less than zero", id));
		}
	}

	public Long id() {
		return id;
	}

	public Coordinates coordinates() {
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
		Block block = (Block) o;
		return Objects.equals(id, block.id) && Objects.equals(coordinates, block.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, coordinates);
	}

	@Override
	public String toString() {
		return "Block{" + "id=" + id + ", coordinates=" + coordinates + '}';
	}
}
