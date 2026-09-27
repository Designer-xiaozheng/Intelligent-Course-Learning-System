package com.project.demo.controller;

import com.project.demo.entity.CommodityRetail;
import com.project.demo.service.CommodityRetailService;
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
 * 商品零售：(CommodityRetail)表控制层
 *
 */
@RestController
@RequestMapping("/commodity_retail")
public class CommodityRetailController extends BaseController<CommodityRetail, CommodityRetailService> {

    /**
     * 商品零售对象
     */
    @Autowired
    public CommodityRetailController(CommodityRetailService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(commodity_retail_id) AS max FROM "+"`commodity_retail`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `product_information` INNER JOIN `commodity_retail` ON product_information.article_no=commodity_retail.article_no WHERE product_information.stock < commodity_retail.purchase_quantity AND commodity_retail.commodity_retail_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"commodity_retail"+" WHERE "+"commodity_retail_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足!");
        }
        sql = "UPDATE `product_information` INNER JOIN `commodity_retail` ON product_information.article_no=commodity_retail.article_no SET product_information.stock= product_information.stock - commodity_retail.purchase_quantity WHERE commodity_retail.commodity_retail_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
