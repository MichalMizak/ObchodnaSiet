package sk.upjs.ics.paz1c.obchodnaSiet.entity;


/**
 *
 * @author Mikey
 */
public class StatnyPoplatok {

    private Long id;
    private String krajina;
    private double percent;

    public StatnyPoplatok(Long id, String krajina, double percent) {
        this.id = id;
        this.krajina = krajina;
        this.percent = percent;
    }

    public StatnyPoplatok() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKrajina() {
        return krajina;
    }

    public void setKrajina(String krajina) {
        this.krajina = krajina;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return krajina;
    }

    
}
