package com.lypgod.springboot.demo.cache.user;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lypgod
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public void insert(User user) {
        userRepository.save(user);
    }

    /** 查询数据库后，数据添加到缓存 */
    @Cacheable(value = "lypgod.user", key = "#id", unless = "#result == null")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /** 清除一条缓存，key为要清空的数据 */
    @CacheEvict(value = "lypgod.user",  key = "#id")
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /** 清除所有User缓存 */
    @CacheEvict(value = "lypgod.user",  allEntries = true)
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    /** 修改数据后更新缓存 */
    @CachePut(value = "lypgod.user", key = "#user.id", unless = "#result == null")
    public void update(User user) {
        userRepository.save(user);
    }

    public Page<User> getPagedUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
