package br.com.letscode.rebeldes;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public class InteligenciaCentral {
    @Getter
    List<Rebelde> rebeldes;

    public boolean solicitarIngressoDeRebelde(Rebelde rebelde) {
        return false;
    }

}
