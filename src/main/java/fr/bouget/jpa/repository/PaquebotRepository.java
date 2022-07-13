package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bouget.jpa.model.Paquebot;

/**
 * @author Philippe
 *
 */
public interface PaquebotRepository extends JpaRepository<Paquebot, Integer> {

}
