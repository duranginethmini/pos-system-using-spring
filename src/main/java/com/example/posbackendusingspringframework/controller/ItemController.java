package com.example.posbackendusingspringframework.controller;

import com.example.posbackendusingspringframework.customObj.ItemResponse;
import com.example.posbackendusingspringframework.dto.ItemDTO;
import com.example.posbackendusingspringframework.exception.DataPersistentException;
import com.example.posbackendusingspringframework.exception.ItemNotFoundException;
import com.example.posbackendusingspringframework.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                itemService.saveItem(itemDTO);
                logger.info("Item saved successfully: {}", itemDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistentException e) {
                logger.error("Failed to persist item data: {}", itemDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                logger.error("Unexpected error occurred while saving item: {}", itemDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        logger.info("fetching all the items");
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItemById(@RequestParam("id") String id) {
        logger.info("fetching customer with Id ");
        return itemService.getItemById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("id") String id, @RequestBody ItemDTO itemDTO) {
        try {
            if (itemDTO == null && (id == null || itemDTO.equals(""))) {
                logger.warn("Invalid item data", itemDTO);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(id, itemDTO);
            logger.info("Item update successfully", itemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            logger.error("Item not found", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while updating items", itemDTO, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> deleteItem(@PathVariable ("id") String id){
        try {
            itemService.deleteItem(id);
            logger.info("Item deleted successfully" , id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            logger.error("Customer do not exist ", id,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("An error occurs", id , e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


