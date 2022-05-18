package ar.edu.ungs.census.takers.domain;

import java.util.Objects;

public final class Taker {
	private final Long id;
	private final String name;

	public Taker(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Taker taker = (Taker) o;
		return Objects.equals(id, taker.id) && Objects.equals(name, taker.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "Taker{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
