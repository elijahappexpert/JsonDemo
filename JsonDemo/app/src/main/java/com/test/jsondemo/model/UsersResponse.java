package com.test.jsondemo.model;

/**
 * Created by filippo on 22/02/2018.
 */

public class UsersResponse {

    private int id;
    private String name;
    private String phone;
    private String website;
    private String username;
    private String email;
    private Address address;
    private Company company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}';
    }
}
