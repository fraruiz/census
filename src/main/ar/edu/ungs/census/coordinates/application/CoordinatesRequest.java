package ar.edu.ungs.census.coordinates.application;

import ar.edu.ungs.census.coordinates.domain.Coordinates;

import java.util.Objects;

public class CoordinatesRequest {

	private final Double latitude;
	private final Double longitude;

	public CoordinatesRequest(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static Coordinates map(CoordinatesRequest request) {
		return new Coordinates(request.latitude(), request.latitude());
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
		CoordinatesRequest that = (CoordinatesRequest) o;
		return Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}
}
