package com.ebayk;

import com.ebayk.data.user.User;
import com.ebayk.service.RatingAnalyzer;
import com.ebayk.service.RatingAnalyzer.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{id}")
public class UserController {

  @Autowired
  private RatingAnalyzer ratingAnalyzer;


  @RequestMapping("/rated-users")
  public List<User> listAd(@PathVariable("id") Integer userId) throws UserNotFoundException {
    return this.ratingAnalyzer.getRatedUserForRatingCreator(userId);
  }

}
