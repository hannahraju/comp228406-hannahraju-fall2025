/*
 * @author Hannah Raju
 * @date December 7, 2025
 * @info COMP 228 Lab Assignment 5
 * @filename PlayerInfo.java
 *
 * This class acts as the Model for Player
 */

package com.exercise1;

public class PlayerInfo {

    public int id;
    String firstName;
    String lastName;
    String address;
    String postalCode;
    String province;
    String phoneNumber;

    public PlayerInfo(String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        String player = "Name: " + firstName + " " + lastName + "\nAddress:" + address + "\nPostal code: " + postalCode + "\nProvince: " +province+"\nPhone number: " + phoneNumber;
        return player;
    }

    public void setId(int id){
        this.id = id;
    }
}