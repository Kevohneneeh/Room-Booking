package com.kevohmunene.roombooking;

public class  ItemAdapter {
    String checkin,checkout,rooms,adults,child,name,email,phone;

    public ItemAdapter(String checkin, String checkout, String rooms, String adults, String child, String name, String email, String phone) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.rooms = rooms;
        this.adults = adults;
        this.child = child;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ItemAdapter() {
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
