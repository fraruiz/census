package ar.edu.ungs.census.coordinates.application;

import ar.edu.ungs.census.coordinates.domain.Coordinates;

import java.util.Objects;

public class CoordinatesResponse {

    private final Double latitude;
    private final Double longitude;

    public CoordinatesResponse(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static CoordinatesResponse map(Coordinates coordinates) {
        return new CoordinatesResponse(coordinates.latitude(), coordinates.longitude());
    }

    public Double latitude() {
        return latitude;
    }

    public Double longitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatesResponse that = (CoordinatesResponse) o;
        return Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
