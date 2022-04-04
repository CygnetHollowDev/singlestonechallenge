package net.cygnethollowfarm.carldemo;

import java.util.Collection;
import net.cygnethollowfarm.carldemo.data.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Basic JPA repository interface. Provides a custom query that returns only stored
 * phone records for home phones.
 * 
 * @author carl@cygnethollowfarm.net
 */
public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {
   @Query(value = "SELECT * FROM PHONE WHERE type='home'", nativeQuery = true)
   Collection<PhoneEntity> findAllHomePhones();
}
