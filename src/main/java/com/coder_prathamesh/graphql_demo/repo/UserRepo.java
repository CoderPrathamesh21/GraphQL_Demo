package com.coder_prathamesh.graphql_demo.repo;

import com.coder_prathamesh.graphql_demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


}
