package com.project.demo.controller;

import com.project.demo.entity.Staff;
import com.project.demo.service.StaffService;
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
 * 员工：(Staff)表控制层
 *
 */
@RestController
@RequestMapping("/staff")
public class StaffController extends BaseController<Staff, StaffService> {

    /**
     * 员工对象
     */
    @Autowired
    public StaffController(StaffService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapemployee_no = new HashMap<>();
        mapemployee_no.put("employee_no",String.valueOf(paramMap.get("employee_no")));
        List listemployee_no = service.select(mapemployee_no, new HashMap<>()).getResultList();
        if (listemployee_no.size()>0){
            return error(30000, "字段员工工号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
