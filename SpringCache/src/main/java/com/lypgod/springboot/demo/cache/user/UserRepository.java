package com.lypgod.springboot.demo.cache.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lypgod
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
