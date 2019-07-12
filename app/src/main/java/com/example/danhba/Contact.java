package com.example.danhba;

public class Contact {
    String name, phoneNumber, group;
    boolean icon;

    public Contact(String name, String phoneNumber, String group, boolean icon) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }
}
