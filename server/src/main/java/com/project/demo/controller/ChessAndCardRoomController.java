package com.project.demo.controller;

import com.project.demo.entity.ChessAndCardRoom;
import com.project.demo.service.ChessAndCardRoomService;
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
 * 棋牌房间：(ChessAndCardRoom)表控制层
 *
 */
@RestController
@RequestMapping("/chess_and_card_room")
public class ChessAndCardRoomController extends BaseController<ChessAndCardRoom, ChessAndCardRoomService> {

    /**
     * 棋牌房间对象
     */
    @Autowired
    public ChessAndCardRoomController(ChessAndCardRoomService service) {
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
