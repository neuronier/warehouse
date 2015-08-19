package hu.neuron.java.warehouse.whCore.dao;

import java.util.List;

import hu.neuron.java.warehouse.whCore.entity.Manager;
import hu.neuron.java.warehouse.whCore.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerDao extends JpaRepository<Manager,Long> {

	@Query("select m from Manager m where m.userName=?1")
	List<Manager> findUserByName(String name) throws Exception;
}
