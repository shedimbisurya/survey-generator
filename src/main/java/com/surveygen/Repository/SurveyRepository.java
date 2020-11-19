package com.surveygen.Repository;

import com.surveygen.model.Survey;
import com.surveygen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<User, Integer> {

    Survey findById(int id);

}
