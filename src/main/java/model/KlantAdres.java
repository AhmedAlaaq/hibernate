/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Embedded;

/**
 *
 * @author Egelantier
 */
public class KlantAdres {
  
    private  String straatnaam;
    private  Integer nummer;
    private String plaats;
   @Embedded
    private PostCode postcode;
    
    
    private KlantAdres() {
        
    }
    
    private KlantAdres(AdresBuilder builder) {
        this.straatnaam = builder.straatnaam;
        this.nummer = builder.nummer;
        this.postcode = builder.postcode;
        this.plaats = builder.plaats;
    }

    public String getStraatNaam() {
        return straatnaam;
    }

    public Integer getNummer() {
        return nummer;
    }

    public PostCode getPostCode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }    
    
    // Inner builder class
    public static class AdresBuilder {
        private String straatnaam;
        private Integer nummer;
        private PostCode postcode;
        private String plaats;
        
        public AdresBuilder() {}
        
        public AdresBuilder straatNaam(String straatNaam) {
            this.straatnaam = straatNaam;
            return this;
        }
        
        public AdresBuilder nummer(Integer nummer) {
            this.nummer = nummer;
            return this;
        }
        
        public AdresBuilder postCode(PostCode postcode) {
            this.postcode = postcode;
            return this;
        }
        
        public AdresBuilder plaats(String plaats) {
            this.plaats = plaats;
            return this;
        }
        
        public KlantAdres build() {
            return new KlantAdres(this);
        }
    }
        
}

    

