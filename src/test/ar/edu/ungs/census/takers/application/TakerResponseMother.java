package ar.edu.ungs.census.takers.application;

import ar.edu.ungs.census.shared.domain.LongMother;

public class TakerResponseMother {
    public static TakerResponse random(){
        return new TakerResponse(LongMother.random(), "random");
    }
}
