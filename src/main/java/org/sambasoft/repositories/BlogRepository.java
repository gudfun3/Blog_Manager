package org.sambasoft.repositories;
 
import org.sambasoft.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
