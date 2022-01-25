package br.com.letscode.rebeldes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Rebelde {
    private String Nome;
    private int Idade;
    private Raça Raça;
}
