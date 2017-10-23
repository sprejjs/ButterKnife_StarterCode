package com.spreys.butterknife.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String firstName;
    private String lastName;
    private String mobile;
    private String landline;

    public Contact(String firstName, String lastName, String mobile, String landline) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.landline = landline;
    }

    protected Contact(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        mobile = in.readString();
        landline = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLandline() {
        return landline;
    }

    public String getName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(mobile);
        parcel.writeString(landline);
    }
}
