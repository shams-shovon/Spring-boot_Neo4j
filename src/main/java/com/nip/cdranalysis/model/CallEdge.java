package com.nip.cdranalysis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Data
@Getter
@Setter
@Builder
@JsonIgnoreProperties
public class CallEdge {
    @Id
    @GeneratedValue
    private Long id;
    @Property("Time_stamp")
    private String time_stamp;
    @Property("usage_type")
    private String usage_type;
    @Property("Score")
    private double score;
    @Property("Lat")
    private double latitude;
    @Property("Lon")
    private double longitude;

    @TargetNode
    private Target target;

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getUsage_type() {
        return usage_type;
    }

    public void setUsage_type(String usage_type) {
        this.usage_type = usage_type;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
