package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //

import com.example.domain.User;

@Repository //
public interface UsersRepository extends JpaRepository<User, Integer> {
	public User findById(int id);
}