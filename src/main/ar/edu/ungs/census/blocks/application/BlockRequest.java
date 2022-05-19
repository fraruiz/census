package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.Coordinates;

import java.util.Objects;

public class BlockRequest {

    private final Long id;
    private final Coordinates coordinates;

    public BlockRequest(Long id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public static Block map(BlockRequest request) {
        return new Block(request.getId(), request.getCoordinates());
    }

    public Long getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockRequest that = (BlockRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordinates);
    }
}
