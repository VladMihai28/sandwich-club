package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        /* The names of the fields that make up the array */

        final String SANDWICH_NAME = "name";

        final String SANDWICH_MAIN_NAME = "mainName";

        final String SANDWICH_ALIASES = "alsoKnownAs";

        final String SANDWICH_PLACE_OF_ORIGIN = "placeOfOrigin";

        final String SANDWICH_DESCRIPTION = "description";

        final String SANDWICH_IMAGE = "image";

        final String SANDWICH_INGREDIENTS = "ingredients";

        /* Parse JSON */
        JSONObject sandwichJson = new JSONObject(json);
        Sandwich sandwich = new Sandwich();

        JSONObject sandwichName = sandwichJson.getJSONObject(SANDWICH_NAME);

        sandwich.setMainName(sandwichName.getString(SANDWICH_MAIN_NAME));

        JSONArray sandwichAliases = sandwichName.getJSONArray(SANDWICH_ALIASES);
        List<String> aliases = new ArrayList<>();
        for (int i=0; i < sandwichAliases.length(); i++){
            aliases.add(sandwichAliases.getString(i));
        }
        sandwich.setAlsoKnownAs(aliases);

        sandwich.setPlaceOfOrigin(sandwichJson.getString(SANDWICH_PLACE_OF_ORIGIN));

        sandwich.setDescription(sandwichJson.getString(SANDWICH_DESCRIPTION));

        sandwich.setImage(sandwichJson.getString(SANDWICH_IMAGE));

        JSONArray sandwichIngredients = sandwichJson.getJSONArray(SANDWICH_INGREDIENTS);
        List<String> ingredients = new ArrayList<>();
        for (int i=0; i < sandwichIngredients.length(); i++){
            ingredients.add(sandwichIngredients.getString(i));
        }
        sandwich.setIngredients(ingredients);

        return sandwich;
    }
}
