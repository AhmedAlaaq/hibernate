/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Egelantier
 */
public class PostCode {

    private Integer number ;
    private String ch ;

    public PostCode() {
    }
    

    public PostCode(Integer number, String ch) {
        this.number = number;
        this.ch = ch;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCh() {
        return ch;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return number + ch;
    }

}
