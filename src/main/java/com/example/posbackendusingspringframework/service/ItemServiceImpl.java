package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.customObj.ItemResponse;
import com.example.posbackendusingspringframework.dao.ItemDAO;
import com.example.posbackendusingspringframework.dto.ItemDTO;
import com.example.posbackendusingspringframework.entity.ItemEntity;
import com.example.posbackendusingspringframework.exception.DataPersistentException;
import com.example.posbackendusingspringframework.exception.ItemNotFoundException;
import com.example.posbackendusingspringframework.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity save = itemDAO.save(mapping.convertItemDTOToItemEntity(itemDTO));
        if (save == null){
            throw new DataPersistentException("couldn't save item");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertItemEntityListToItemDTOList(itemDAO.findAll());
    }

    @Override
    public ItemResponse getItemById(String id) {
        if(itemDAO.existsById(id)){
            return mapping.convertItemEntityToItemDTO(itemDAO.getReferenceById(id));
        }else {
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<ItemEntity> tmp = itemDAO.findById(id);
        if(!tmp.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            tmp.get().setItemName(itemDTO.getItemName());
            tmp.get().setQty(itemDTO.getQty());
            tmp.get().setUnitPrice(itemDTO.getUnitPrice());
        }
    }

    @Override
    public void deleteItem(String id) {
        Optional<ItemEntity> tmp = itemDAO.findById(id);
        if(!tmp.isPresent()){
            throw new ItemNotFoundException("Item not found");

        }else {
            itemDAO.deleteById(id);
        }
    }
}
