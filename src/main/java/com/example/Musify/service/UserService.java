package com.example.Musify.service;

import com.example.Musify.model.User;
import com.example.Musify.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {


private final UserRepository userRepository;


public UserService(UserRepository userRepository) {
this.userRepository = userRepository;
}


public User upsert(String provider, String providerId, String email, String name, String picture) {
return userRepository.findByProviderAndProviderId(provider, providerId)
.map(existing -> {
existing.setEmail(email);
existing.setName(name);
existing.setPicture(picture);
return userRepository.save(existing);
})
.orElseGet(() -> userRepository.save(new User(provider, providerId, email, name, picture)));
}
}