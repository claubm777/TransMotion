package models;

/**
 * Created by Asus on 11/04/2015.
 */
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PieceRoute extends Model {

    @Id
    public int id;

    public String nombreEstacion11;
    public String nombreEstacion12;
    public String nombreBus1;
    public int tiempo;
    public int congestion;

}
