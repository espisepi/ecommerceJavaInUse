package com.guideJavainuse.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guideJavainuse.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
