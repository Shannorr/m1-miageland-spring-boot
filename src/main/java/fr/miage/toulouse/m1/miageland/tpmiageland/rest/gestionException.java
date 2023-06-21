package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.export.ErrorExport;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.AdresseMailUtilise;

import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.AttractionInexistante;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletInexistant;

import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.RoleInexistant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class gestionException {

    /**
     * Erreur 404 en cas de Parc Inconnu
     * @param request requête HTTP
     * @param exception exception
     * @return l'erreur 404
     */
    @ExceptionHandler(ParcInexistant.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, ParcInexistant exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleInexistant.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, RoleInexistant exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdresseMailUtilise.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, AdresseMailUtilise exception) {

    @ExceptionHandler(AttractionInexistante.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, AttractionInexistante exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BilletInexistant.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, BilletInexistant exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }
}
