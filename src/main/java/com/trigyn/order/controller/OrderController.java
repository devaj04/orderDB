package com.trigyn.order.controller;

import com.trigyn.order.model.OrderVO;
import com.trigyn.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/order")
    public boolean addOrder(@RequestBody OrderVO order){
        return orderService.addOrder(order);
    }

    @GetMapping("/order")
    public List<OrderVO> getOrder(@RequestParam(required = false) Long id){
        if(id!=null){
            return orderService.findOrderByName(id);
        }else{
            return orderService.getAll();
        }
    }

    @DeleteMapping("/order")
    public boolean deleteOrder(@RequestParam Long id){
        return orderService.deleteOrder(id);
    }

    @PutMapping("/order")
    public boolean updateOrder(@RequestBody OrderVO order){
        return orderService.updateOrder(order);
    }

}
