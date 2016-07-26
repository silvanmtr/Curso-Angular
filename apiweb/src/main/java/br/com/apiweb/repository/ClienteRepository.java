/**
 * 
 */
package br.com.apiweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiweb.model.Cliente;


/**
 * @author Silvan de Jesus
 *
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

