package ch.zhaw.gpi.twitterreview;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    
}