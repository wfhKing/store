package com.nf147.ssm.dao;

import com.nf147.ssm.entity.Pet;
import java.util.List;

public interface PetMapper {

    int deleteByPrimaryKey(Integer petId);

    int insert(Pet record);

    Pet selectByPrimaryKey(Integer petId);

    List<Pet> selectAll();

    int updateByPrimaryKey(Pet record);

    Pet findByStatus(String pet_status);
}