package by.bsuir.rmi_server.exchangeObject;

import java.io.Serializable;
import java.util.Objects;

public class exchangeObject implements Serializable{
    private String date;
    private String song;
    private String congrat;

    public String getDate() {
        return date;
    }

    public String getSong() {
        return song;
    }

    public String getCongrat() {
        return congrat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setCongrat(String congrat) {
        this.congrat = congrat;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.song);
        hash = 59 * hash + Objects.hashCode(this.congrat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final exchangeObject other = (exchangeObject) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.song, other.song)) {
            return false;
        }
        if (!Objects.equals(this.congrat, other.congrat)) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "exchangeObject{" + "date=" + date + ", song=" + song + ", congrat=" + congrat + '}';
    }
    
    
}
