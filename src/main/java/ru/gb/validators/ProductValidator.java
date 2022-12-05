package ru.gb.validators;

import org.springframework.stereotype.Component;
import ru.gb.DTO.ProductDTO;
import ru.gb.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public void validate (ProductDTO productDTO) {
        List<String> errors = new ArrayList<>();
        if (productDTO.getCost() < 1) {
            errors.add("Product cost can't be less 1");
        }
        if (productDTO.getTitle().isBlank()) {
            errors.add("Product title can't be empty");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
