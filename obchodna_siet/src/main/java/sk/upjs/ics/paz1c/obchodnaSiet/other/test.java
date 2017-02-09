package sk.upjs.ics.paz1c.obchodnaSiet.other;

import java.util.Locale;

/**
 *
 * @author Mikey
 */
public class test {

    public static void main(String[] args) {
        
        Locale locale = Locale.ENGLISH;
        Locale.Builder builder = new Locale.Builder();
        builder.setScript(locale.getScript());
        Locale krajina = new Locale(locale.getLanguage());
        
        System.out.println(krajina.getCountry());
    }
}
