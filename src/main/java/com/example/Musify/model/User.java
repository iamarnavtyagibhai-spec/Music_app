package com.example.Musify.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {
@Id
private String id;
private String provider;
private String providerId;
private String email;
private String name;
private String picture;


// Getters & Setters
public String getId() { return id; }
public void setId(String id) { this.id = id; }


public String getProvider() { return provider; }
public void setProvider(String provider) { this.provider = provider; }


public String getProviderId() { return providerId; }
public void setProviderId(String providerId) { this.providerId = providerId; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getPicture() { return picture; }
public void setPicture(String picture) { this.picture = picture; }

public User(String provider, String providerId, String email, String name, String picture) {
    this.provider = provider;
    this.providerId = providerId;
    this.email = email;
    this.name = name;
    this.picture = picture;
}

}

