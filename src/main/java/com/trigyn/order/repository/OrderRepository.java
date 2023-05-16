package com.trigyn.order.repository;

import com.trigyn.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
   public List<OrderEntity> findOrderById(Long orderId);

   @Query(value = "Select * from order_entity where id =:orderId",nativeQuery = true)
   OrderEntity findOrderByIdName(Long orderId);

}
