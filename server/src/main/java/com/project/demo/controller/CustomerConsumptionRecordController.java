package com.project.demo.controller;

import com.project.demo.entity.CustomerConsumptionRecord;
import com.project.demo.service.CustomerConsumptionRecordService;
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
 * 客户消费记录：(CustomerConsumptionRecord)表控制层
 *
 */
@RestController
@RequestMapping("/customer_consumption_record")
public class CustomerConsumptionRecordController extends BaseController<CustomerConsumptionRecord, CustomerConsumptionRecordService> {

    /**
     * 客户消费记录对象
     */
    @Autowired
    public CustomerConsumptionRecordController(CustomerConsumptionRecordService service) {
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
