package fr.miage.toulouse.m1.miageland.tpmiageland.export;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reservation {
    private Long idPers;
    private Long idBillet;
}
