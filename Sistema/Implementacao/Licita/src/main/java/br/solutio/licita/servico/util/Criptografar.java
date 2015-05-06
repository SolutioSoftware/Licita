/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Oliveira
 */
public class Criptografar {

    private final String algoritmo;
    private final String encoding;
    private MessageDigest md;
    private Logger log;
    private static Criptografar cript;

    private Criptografar() {
        this.algoritmo = "MD5";
        this.encoding = "UTF-8";
        this.log = Logger.getGlobal();
    }

    public String criptografar(String senha) {
        try {
            md = MessageDigest.getInstance(this.algoritmo);
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes(this.encoding)));
            log.info("Criptografia Realizada com sucesso!");
            return hash.toString(32);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.severe(e.getMessage());
            return null;
        }

    }

    public static Criptografar getInstance() {
        if (Criptografar.cript == null) {
            return new Criptografar();
        } else {
            return Criptografar.cript;
        }
    }
}
