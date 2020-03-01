package learn.avinash.spring.springit.repository;

import learn.avinash.spring.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkedRepository extends JpaRepository<Link, Long> {
    Link findByTitle(String title);
    //List<Link> findAllByTitleLikeOrderByCreationDateDesc(String title);
}
