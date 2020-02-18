package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface RoomRepository extends CrudRepository<Room, Integer> {
	Room findRoomByRoomId(int id);
	void deleteAll();
	Iterable<Room> findAll();
}
