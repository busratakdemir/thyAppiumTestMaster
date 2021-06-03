package com.thy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElementInfo {

  @SerializedName("key")
  @Expose
  private String key;
  @SerializedName("androidValue")
  @Expose
  private String androidValue;
  @SerializedName("androidType")
  @Expose
  private String androidType;
  @SerializedName("androidIndex")
  @Expose
  private int androidIndex;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getAndroidValue() {
    return androidValue;
  }

  public void setAndroidValue(String androidValue) {
    this.androidValue = androidValue;
  }

  public String getAndroidType() {
    return androidType;
  }

  public void setAndroidType(String androidType) {
    this.androidType = androidType;
  }

  public int getAndroidIndex() {
    return androidIndex;
  }

  public void setAndroidIndex(int androidIndex) {
    this.androidIndex = androidIndex;
  }



  @Override
  public String toString() {
    return "ElementInfo{" +
            "key='" + key + '\'' +
            ", androidValue='" + androidValue + '\'' +
            ", androidType='" + androidType + '\'' +
            ", androidIndex=" + androidIndex +
            '}';
  }
}
