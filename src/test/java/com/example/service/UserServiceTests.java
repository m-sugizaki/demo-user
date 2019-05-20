package com.example.service;

import com.example.domain.User;
import com.example.repository.UsersRepository;
import com.example.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTests {

    private final static Integer TEST_ID = 1;
    private final static String TEST_NAME = "杉崎";
    private final static String TEST_PASS = "sugisugi";

    private Optional<User> testUser;
    private User testUser2;

    @Mock
    
    private UsersRepository usersRepository;
    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
//    	this.testUser = User.builder()
//                .id(TEST_ID)
//                .name(TEST_NAME)
//                .pass(TEST_PASS)
//                .build();
    }

    @Test
    public void メンバー詳細() {
        when(this.usersRepository.findById(TEST_ID)).thenReturn(this.testUser);
        Optional<User> actual = this.userService.findById(TEST_ID);
        assertThat(actual).isEqualTo(this.testUser);
        verify(this.usersRepository, times(1)).findById(TEST_ID);
    }

    @Test
    public void メンバー更新() {
        when(this.usersRepository.save(this.testUser2)).thenReturn(this.testUser2);
        User actual = this.userService.update(this.testUser2);
        assertThat(actual).isEqualTo(this.testUser2);
        verify(this.usersRepository, times(1)).save(this.testUser2);
    }

/*
	@Test
	public void test() {
		fail("まだ実装されていません");
	}
 */

}
