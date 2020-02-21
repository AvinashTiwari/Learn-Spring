package learn.avinash.spring.springit.repository;

import learn.avinash.spring.springit.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
