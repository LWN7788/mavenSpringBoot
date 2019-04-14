package com.sunvua.ljy.service;


import com.sunvua.ljy.model.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAreaList();
    Area getAreaById(int areaId);
    boolean addArea(Area area);
    boolean modifyArea(Area area);
    boolean deleteArea(int areaId);


}
