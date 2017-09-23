package cn.cc.mysbm.mysbm;

import java.util.Date;

public class Spittle {

  private Long id;
  private String message;
  private Date time;
  private Double latitude;
  private Double longitude;

  public Spittle() {}
  
  public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
    this.id = id;
    this.message = message;
    this.time = time;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public Date getTime() {
    return time;
  }
  
  public Double getLongitude() {
    return longitude;
  }
  
  public Double getLatitude() {
    return latitude;
  }
  
//  @Override
//  public boolean equals(Object that) {
//    return EqualsBuilder.reflectionEquals(this, that, "id", "time");
//  }
  
//  @Override
//  public int hashCode() {
//    return HashCodeBuilder.reflectionHashCode(this, "id", "time");
//  }

@Override
public String toString() {
	return "Spittle [id=" + id + ", message=" + message + ", time=" + time + ", latitude=" + latitude + ", longitude="
			+ longitude + "]";
}
  
  
  
}
