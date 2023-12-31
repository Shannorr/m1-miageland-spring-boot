package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.export.ErrorExport;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.JaugePleine;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.*;

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
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AttractionInexistante.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, AttractionInexistante exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BilletInexistant.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, BilletInexistant exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasLesDroits.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, PasLesDroits exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BilletDejaUtilise.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, BilletDejaUtilise exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BilletPerime.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, BilletPerime exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BilletNonAssocie.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, BilletNonAssocie exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonneInnexistante.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, PersonneInnexistante exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JaugePleine.class)
    public ResponseEntity<ErrorExport> gereAutreException(HttpServletRequest request, JaugePleine exception) {
        return new ResponseEntity<ErrorExport>(new ErrorExport(exception.getMessage(), exception.getClass().getName()), HttpStatus.NOT_FOUND);
    }
}
