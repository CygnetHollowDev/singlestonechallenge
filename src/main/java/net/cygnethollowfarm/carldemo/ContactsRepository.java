package net.cygnethollowfarm.carldemo;

import net.cygnethollowfarm.carldemo.data.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Basic JPA repository interface for contact access
 * @author carl@cygnethollowfarm.net
 */
public interface ContactsRepository extends JpaRepository<ContactEntity, Long> {
}
