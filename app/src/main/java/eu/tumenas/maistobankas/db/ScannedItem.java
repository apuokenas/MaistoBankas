package eu.tumenas.maistobankas.db;

import com.google.common.base.Objects;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @author M. Tumėnas mantas@tumenas.eu
 * @since 2014-02-08 14:50
 */
@DatabaseTable(tableName = "scanned_item")
public class ScannedItem {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String barcode;
    @DatabaseField(canBeNull = false)
    private Date time;
    @DatabaseField
    private String place;
    @DatabaseField
    private String volunteer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("barcode", barcode)
                .add("time", time)
                .add("place", place)
                .add("volunteer", volunteer)
                .toString();
    }
}
