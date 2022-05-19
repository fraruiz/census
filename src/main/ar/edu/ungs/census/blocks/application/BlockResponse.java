package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.blocks.domain.Coordinates;

import java.util.Objects;

public class BlockResponse {
    private final Long id;
    private final Coordinates coordinates;

    public BlockResponse(Long id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public static BlockResponse map(Block block){
        return new BlockResponse(block.id(),block.coordinates());
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
        BlockResponse that = (BlockResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordinates);
    }

    @Override
    public String toString() {
        return "BlockResponse{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                '}';
    }
}
