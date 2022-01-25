package br.com.letscode.rebeldes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteligenciaCentral {
    @Getter
    List<Rebelde> rebeldes;

    public InteligenciaCentral(){
        this.rebeldes = new ArrayList<>();
    }

    public boolean solicitarIngressoDeRebelde(Rebelde rebelde) {
        int randNumber = new Random().nextInt(10);

        if(randNumber <= 5) {
            this.rebeldes.add(rebelde);
            return true;
        }
        else
            return false;
    }

    public void gerarRelatorioDeRebeldes() {

    }
}
