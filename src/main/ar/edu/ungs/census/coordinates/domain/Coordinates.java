package ar.edu.ungs.census.coordinates.domain;

import java.util.Objects;

public final class Coordinates {
	private final Double latitude;
	private final Double longitude;

	public Coordinates(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double latitude() {
		return latitude;
	}

	public Double longitude() {
		return longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Coordinates that = (Coordinates) o;
		return Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}

	@Override
	public String toString() {
		return "Coordinates{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
	}
}
