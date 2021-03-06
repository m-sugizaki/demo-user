package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.UserService;

@RestController
@RequestMapping("users")
public class UserRestController {
    @Autowired
    UserService userService;
    
    /**
     * メンバー一覧取得API
     * @return List<user>
     */
	@CrossOrigin
	@GetMapping
    List<User> getUsers() {
        List<User> customers = userService.findAll();
        return customers;
    }

    /**
     * メンバー取得API
     * @return List<user>
     */
	@CrossOrigin
	@GetMapping(path = "{id}")
    User getUser(@PathVariable Integer id) {
        Optional<User> customers = userService.findById(id);
//        User customers = userService.findById(id);
        return customers.get();
    }

    /**
     *メンバー登録API
     * @param user
     * @return user
     */
	@CrossOrigin
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User postUser(@RequestBody User user) {
    	return userService.create(user);
    }

    /**
     * 商品削除API
     * @param id
     */
	@CrossOrigin
	@DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Integer id) {
    	userService.delete(id);
    }

    /**
     * 商品更新API
     * @param id
     * @param item
     * @return item
     */
	@CrossOrigin
	@PutMapping(path = "{id}")
    User putUser(@PathVariable Integer id, @RequestBody User user) {
    	user.setId(id);
    	return userService.update(user);
    }
    
}