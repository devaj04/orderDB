package com.trigyn.order.service;

import com.trigyn.order.entity.OrderEntity;
import com.trigyn.order.model.OrderVO;
import com.trigyn.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public boolean addOrder(OrderVO order) {
        OrderEntity orderEntity = convertOrderEntity(order);
        try {
            orderRepository.save(orderEntity);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private OrderEntity convertOrderEntity(OrderVO order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductName(order.getProductName());
        orderEntity.setPrice(order.getPrice());
        return orderEntity;
    }

    public List<OrderVO> findOrderByName(Long orderId) {
        List<OrderVO> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orderRepository.findOrderById(orderId)) {
            orderList.add(convertOrderModel(orderEntity));
        }
        return orderList;
    }

    public List<OrderVO> getAll() {
        List<OrderVO> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orderRepository.findAll()) {
            orderList.add(convertOrderModel(orderEntity));
        }
        return orderList;
    }

    private OrderVO convertOrderModel(OrderEntity orderEntity) {
        OrderVO order = new OrderVO();
        order.setOrderId(orderEntity.getId());
        order.setProductName(orderEntity.getProductName());
        order.setPrice(orderEntity.getPrice());
        return order;
    }

    public boolean deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return true;
    }

    public boolean updateOrder(OrderVO order) {
        OrderEntity orderEntity = orderRepository.findOrderByIdName(order.getOrderId());
        orderEntity.setProductName(order.getProductName());
        orderRepository.save(orderEntity);
        return true;
    }
}
