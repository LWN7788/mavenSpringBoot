package com.sunvua.ljy.controller;

import com.sunvua.ljy.model.Area;
import com.sunvua.ljy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/root")
public class AreaController {
    @Autowired
    AreaService areaService;
    @RequestMapping("/listArea")
    private Map<String,Object> listArea(){
        Map<String,Object> modeMap=new HashMap<String,Object>();
        List<Area> list=areaService.getAreaList();
        modeMap.put("areaList",list);
        return modeMap;
    }
    @RequestMapping("/getareabyid")
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modeMap=new HashMap<String,Object>();
        Area area=areaService.getAreaById(areaId);
        modeMap.put("area",area);
        return modeMap;
    }
    @PostMapping("/addarea")
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modeMap=new HashMap<String,Object>();
        modeMap.put("successs",areaService.addArea(area));
        return modeMap;
    }
    @PostMapping("/updatearea")
    private Map<String,Object> updataArea(@RequestBody Area area){
        Map<String,Object> modeMap=new HashMap<String,Object>();
        modeMap.put("successs",areaService.modifyArea(area));
        return modeMap;
    }
    @RequestMapping("/deletearea")
    private Map<String,Object> deleteArea(Integer areaId){
        Map<String,Object> modeMap=new HashMap<String,Object>();
        modeMap.put("successs",areaService.deleteArea(areaId));
        return modeMap;
    }

}
