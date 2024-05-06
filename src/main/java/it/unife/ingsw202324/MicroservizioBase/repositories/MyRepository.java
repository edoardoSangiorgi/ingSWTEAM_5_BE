package it.unife.ingsw202324.MicroservizioBase.repositories;

import it.unife.ingsw202324.MicroservizioBase.models.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;
/* CLASSE CHE DEFINISCE IL REPOSITORY (DATABASE)  */
public interface MyRepository extends JpaRepository<MyTable, Long> {

}
