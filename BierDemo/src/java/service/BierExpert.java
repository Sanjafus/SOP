/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frankcoenen
 */
public class BierExpert {

    public BierExpert() {
    }

    public List<String> getBierOpKleur(String kleur) {
        List<String> merken = new ArrayList<String>();
        if (kleur.equals("amber")) {
            merken.add("Palm");
            merken.add("Kwak");
        } else {
            merken.add("Westmall");
            merken.add("La Trappe");
        }
        return merken;
    }

    public List<String> getBierOpLand(String land) {
        List<String> merken = new ArrayList<String>();
        if (land.equals("nl")) {
            merken.add("Heineken");
            merken.add("Brand");
        } else {
            merken.add("Jupiler");
        }
        return merken;
    }
}
