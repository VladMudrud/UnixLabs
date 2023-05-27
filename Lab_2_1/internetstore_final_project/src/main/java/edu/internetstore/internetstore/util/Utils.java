package edu.internetstore.internetstore.util;

import edu.internetstore.internetstore.dto.CategoriesDto;

import java.util.Set;

public class Utils {

    /**
     * TODO: Add possibility for multiple category set
     * */
    public static Set<CategoriesDto> categoryStringToCategorySet(CategoriesDto category) {
        return  Set.of(category);
    }
}
