package com.example.posbackendusingspringframework.service;

import com.example.posbackendusingspringframework.customObj.ItemResponse;
import com.example.posbackendusingspringframework.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemResponse getItemById(String id);

    void updateItem(String id, ItemDTO itemDTO);

    void deleteItem(String id);
}
