package thedailyscribbles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import thedailyscribbles.model.Moderator;

/**
*Repository interface for {@link Moderator} entity.
*@author Puthin Kumar
*/
public interface ModeratorRepository extends JpaRepository<Moderator,Integer> {
	public Optional<Moderator> findByModeratorName(String moderatorName);
}
