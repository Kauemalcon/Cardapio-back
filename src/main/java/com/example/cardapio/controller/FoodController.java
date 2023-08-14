package com.example.cardapio.controller;

import com.example.cardapio.entities.Food;
import com.example.cardapio.entities.FoodRepository;
import com.example.cardapio.entities.FoodRequestDTO;
import com.example.cardapio.entities.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void SaveFood(@RequestBody FoodRequestDTO foodData){
        Food food = new Food(foodData);
        foodRepository.save(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodlist = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodlist;
    }
}
