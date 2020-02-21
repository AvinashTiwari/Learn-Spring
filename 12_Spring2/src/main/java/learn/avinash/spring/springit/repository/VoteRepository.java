package learn.avinash.spring.springit.repository;

import learn.avinash.spring.springit.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
