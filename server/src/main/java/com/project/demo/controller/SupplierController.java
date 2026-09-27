package com.project.demo.controller;

import com.project.demo.entity.Supplier;
import com.project.demo.service.SupplierService;
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
 * 供应商：(Supplier)表控制层
 *
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController extends BaseController<Supplier, SupplierService> {

    /**
     * 供应商对象
     */
    @Autowired
    public SupplierController(SupplierService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapsupplier_no = new HashMap<>();
        mapsupplier_no.put("supplier_no",String.valueOf(paramMap.get("supplier_no")));
        List listsupplier_no = service.select(mapsupplier_no, new HashMap<>()).getResultList();
        if (listsupplier_no.size()>0){
            return error(30000, "字段供应商编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
