package ar.edu.ungs.census.blocks.application;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.takers.application.TakerResponse;
import ar.edu.ungs.census.takers.domain.Taker;

import java.util.Objects;
import java.util.Optional;

public class BlockResponse {
    private final CoordinatesResponse coordinates;
    private final Optional<TakerResponse> taker;


    public BlockResponse(CoordinatesResponse coordinates, Optional<TakerResponse> taker) {
        this.coordinates = coordinates;
        this.taker = taker;
    }

    public static BlockResponse map(Block block, Optional<Taker> taker) {
        if (taker.isPresent())
            return new BlockResponse(CoordinatesResponse.map(block.coordinates()), Optional.of(TakerResponse.map(taker.get())));
        return new BlockResponse(CoordinatesResponse.map(block.coordinates()), Optional.empty());
    }

    public CoordinatesResponse getCoordinates() {
        return coordinates;
    }

    public Optional<TakerResponse> getTaker() {
        return taker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockResponse that = (BlockResponse) o;
        return Objects.equals(coordinates, that.coordinates) && Objects.equals(taker, that.taker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, taker);
    }
}
