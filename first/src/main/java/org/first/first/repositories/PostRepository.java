package org.first.first.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.first.first.models.Post;
import org.first.first.repositories.PostRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
}
