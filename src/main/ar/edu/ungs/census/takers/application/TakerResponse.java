package ar.edu.ungs.census.takers.application;

import ar.edu.ungs.census.takers.domain.Taker;

import java.util.Objects;

public class TakerResponse {
    private final Long id;
    private final String name;

    public TakerResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TakerResponse map(Taker taker) {
        return new TakerResponse(taker.id(), taker.name());
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakerResponse that = (TakerResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
