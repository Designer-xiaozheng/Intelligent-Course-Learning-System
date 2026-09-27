package com.project.demo.controller;

import com.project.demo.entity.EmployeeAbsenteeism;
import com.project.demo.service.EmployeeAbsenteeismService;
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
 * 员工旷班：(EmployeeAbsenteeism)表控制层
 *
 */
@RestController
@RequestMapping("/employee_absenteeism")
public class EmployeeAbsenteeismController extends BaseController<EmployeeAbsenteeism, EmployeeAbsenteeismService> {

    /**
     * 员工旷班对象
     */
    @Autowired
    public EmployeeAbsenteeismController(EmployeeAbsenteeismService service) {
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
