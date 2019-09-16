package com.lypgod.springboot.demo.cache.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lypgod
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
