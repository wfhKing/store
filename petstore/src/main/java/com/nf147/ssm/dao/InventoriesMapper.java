package com.nf147.ssm.dao;

import com.nf147.ssm.entity.Inventories;
import java.util.List;

public interface InventoriesMapper {

    int deleteByPrimaryKey(Integer inventoriesId);

    int insert(Inventories record);

    int returnInventories(Inventories record);

    Inventories selectByPrimaryKey(Integer inventoriesId);

    List<Inventories> selectAll();

    int updateByPrimaryKey(Inventories record);
}