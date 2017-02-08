package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.util.Locale;

/**
 *
 * @author Mikey
 */
public class PoplatokZaDovoz {

    private Locale krajina;
    private double dan; // ??

    public PoplatokZaDovoz(Locale krajina, double dan) {
        this.krajina = krajina;
        this.dan = dan;
    }

    
    
    public Locale getKrajina() {
        return krajina;
    }

    public void setKrajina(Locale krajina) {
        this.krajina = krajina;
    }

    public double getDan() {
        return dan;
    }

    public void setDan(double dan) {
        this.dan = dan;
    }

}
