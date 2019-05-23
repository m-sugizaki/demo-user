package com.example.repository;

import java.util.List;

import com.example.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //

@Repository //
public interface UsersRepository extends JpaRepository<User, Integer> {
  public User findById(int id);
  public User save(User user);
  public void deleteById(String id);
}