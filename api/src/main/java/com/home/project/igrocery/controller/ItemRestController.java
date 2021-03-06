package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable int id) {
        return itemRepository.findById(id).get();
    }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item theItem) {
        return itemRepository.save(theItem);
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item theItem) {
        return itemRepository.save(theItem);
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable int id) {
        Item theItem = itemRepository.findById(id).get();
        itemRepository.delete(theItem);
        return "Delete successfully. ";
    }


}
