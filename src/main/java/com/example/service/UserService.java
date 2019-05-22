package com.example.service;

import java.util.List;
import java.util.Optional;

//CORS
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.User;
import com.example.repository.UsersRepository;

@Service
@Transactional
public class UserService {
  @Autowired
  UsersRepository usersRepository;

  /*
   *  メンバー一覧の取得サービス
   * @return List<user>
   */
  @CrossOrigin
  public List<User> findAll() {
    return usersRepository.findAll();
  }

  /*
    *  メンバー詳細取得サービス
   * @return List<user>
   */
  @CrossOrigin
  public Optional<User> findById(Integer id) {
    return usersRepository.findById(id);
  }

  /*
   *メンバー登録サービス
   * @param user
   * @return user
   */
  @CrossOrigin
  public User create(User user) {
    return usersRepository.save(user);
  }

  /*
   * メンバー削除サービス
   * @param id
   */
  @CrossOrigin
  public void delete(Integer id) {
    usersRepository.deleteById(id);
  }

  /*
   * メンバー更新サービス
   * @param user
   * @return user
   */
  @CrossOrigin
  public User update(User user) {
    return usersRepository.save(user);
  }
}
