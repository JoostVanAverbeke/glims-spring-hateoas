package eu.ten.fingers.glims.repositories;

import java.util.List;

import eu.ten.fingers.glims.models.Order;

public interface OrderRepository {

	public abstract List<Order> findAll();

	public abstract Order findById(Long id);

}