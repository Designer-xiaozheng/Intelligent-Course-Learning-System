package com.project.demo.controller;

import com.project.demo.entity.OrderSigning;
import com.project.demo.service.OrderSigningService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 订单状态：(OrderSigning)表控制层
 *
 */
@RestController
@RequestMapping("/order_signing")
public class OrderSigningController extends BaseController<OrderSigning, OrderSigningService> {

    /**
     * 订单状态对象
     */
    @Autowired
    public OrderSigningController(OrderSigningService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
