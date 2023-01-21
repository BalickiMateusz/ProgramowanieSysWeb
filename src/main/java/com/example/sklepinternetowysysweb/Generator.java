//package com.example.sklepinternetowysysweb;
//
//import com.example.sklepinternetowysysweb.data.model.Category;
//import com.example.sklepinternetowysysweb.data.model.Product;
//import com.github.javafaker.Faker;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Generator {
//
//    public void generate(){
//        Faker faker = new Faker();
//
//        Map<String, String> foodCategories = new HashMap<>();
//        foodCategories.put("Dairy", "Products made from milk, such as cheese, yogurt, and butter");
//        foodCategories.put("Fruits", "Fresh or dried fruits, such as apples, bananas, and berries");
//        foodCategories.put("Vegetables", "Fresh or cooked vegetables, such as carrots, broccoli, and spinach");
//        foodCategories.put("Grains", "Products made from cereal grains, such as wheat, rice, and oats");
//        foodCategories.put("Meats", "Animal or their parts used as food, such as beef, pork, and chicken");
//        foodCategories.put("Seafood", "Fish, shellfish, and other sea animals used as food, such as salmon, shrimp, and crab");
//        foodCategories.put("Bakery", "Baked goods, such as bread, pastries, and cakes");
//        foodCategories.put("Confectionery", "Sweets, such as candy, chocolate, and ice cream");
//        foodCategories.put("Sauces", "Condiments and dressings, such as ketchup, mustard, and mayonnaise");
//        foodCategories.put("Snacks", "Foods that are typically eaten between meals, such as chips, popcorn, and pretzels");
//        foodCategories.put("Beverages", "Drinks, such as water, juice, and soda");
//        foodCategories.put("Frozen Foods", "Food that is frozen and sold in a frozen state, such as ice cream, frozen vegetables, and frozen meals");
//        foodCategories.put("Organic Foods", "Food produced without the use of synthetic chemicals or pesticides");
//        foodCategories.put("Non-veg", "Food that is not vegetarian");
//        foodCategories.put("Fast Foods", "Foods typically sold by restaurants and food stands that are quick to prepare and serve");
//        foodCategories.put("Breakfast Foods", "Foods typically eaten for breakfast, such as cereal, eggs, and bacon");
//        foodCategories.put("Soups", "Liquids typically served as an appetizer or a main course, such as chicken noodle soup and tomato soup");
//        foodCategories.put("Canned Foods", "Foods that are packaged in cans or jars, such as canned fruits, vegetables, and soups");
//        foodCategories.put("Ethnic Foods", "Foods from different ethnic cuisines, such as Chinese, Indian, and Mexican");
//        foodCategories.put("Gluten-Free Foods", "Foods that do not contain gluten, a protein found in wheat, barley, and rye");
//        foodCategories.put("Desserts", "Sweet dishes typically served after a meal, such as pie, cake, and ice cream");
//        foodCategories.put("Herbs and Spices", "Leaves, seeds, or bark used to add flavor to food, such as basil, oregano, and cinnamon");
//        foodCategories.put("Nuts and Seeds", "Fruits or seeds of plants that are high in fat and protein, such as almonds, walnuts, and sunflower seeds");
//        foodCategories.put("Cereals", "Breakfast foods made from processed grains, such as corn flakes and oatmeal");
//        foodCategories.put("Deli Foods", "Foods typically sold at deli counters, such as deli meats");
//
//        List<Category> categories = new ArrayList<>();
//
//        Map<String, Map<String, String>> foodProducts = new HashMap<>();
//
//        for (Map.Entry<String, String> entry : foodCategories.entrySet()) {
//            String category = entry.getKey();
//            String description = entry.getValue();
//            Map<String, String> products = new HashMap<>();
//            if (category.equals("Dairy")) {
//                products.put("Cheese", "A food made from the pressed curds of milk");
//                products.put("Yogurt", "A food made from fermented milk");
//                products.put("Butter", "A food made from cream or milk that is solid at room temperature");
//            }  else if (category.equals("Fruits")) {
//                products.put("Apple", "A round fruit with a red, green, or yellow skin and a white inside");
//                products.put("Banana", "A long curved fruit with a yellow skin and a soft inside");
//                products.put("Berry", "A small juicy fruit, such as a strawberry, raspberry, or blueberry");
//            } else if (category.equals("Vegetables")) {
//                products.put("Carrot", "A long, thin orange vegetable");
//                products.put("Broccoli", "A green vegetable with small clusters of flowers");
//                products.put("Spinach", "A leafy green vegetable");
//            } else if (category.equals("Grains")) {
//                products.put("Wheat", "A cereal grain that is the most important kind used to make flour for bread, pasta, pastry, and crackers.");
//                products.put("Rice", "A cereal grain that is the second most important staple food for people in the world, after maize.");
//                products.put("Oats", "A cereal grain that is typically eaten in the form of oatmeal or rolled oats.");
//            } else if (category.equals("Meats")) {
//                products.put("Beef", "Meat from a cow or bull that is typically sold as steaks or ground beef.");
//                products.put("Pork Belly", "Meat from a pig that is typically sold as bacon, ham, or pork chops.");
//                products.put("Chicken", "Meat from a chicken that is typically sold as whole birds or boneless, skinless breasts.");
//            } else if (category.equals("Seafood")) {
//                products.put("Salmon", "A type of fish that is typically sold as steaks or fillets.");
//                products.put("Shrimp", "A type of shellfish that is typically sold as large or small, cooked or uncooked.");
//                products.put("Crab", "A type of shellfish that is typically sold as legs or claws.");
//            } else if (category.equals("Bakery")) {
//                products.put("Bread", "A baked product made of flour, water, and yeast or other leavening agent.");
//                products.put("Pastries", "A sweet or savory filled dough or pastry, such as croissant or empanada.");
//                products.put("Cakes", "A sweet baked product made of flour, sugar, and eggs, often decorated with icing or frosting.");
//            } else if (category.equals("Confectionery")) {
//                products.put("Candy", "A sweet made from sugar or chocolate.");
//                products.put("Chocolate", "A food made from cocoa beans, often used as a sweet.");
//                products.put("Frozen Cake", "A frozen food made from cream, milk and sugar, often flavored and sweetened.");
//            } else if (category.equals("Sauces")) {
//                products.put("Ketchup", "A sauce made from tomatoes, vinegar, and spices.");
//                products.put("Mustard", "A sauce made from mustard seeds, vinegar, and spices.");
//                products.put("Mayonnaise", "A sauce made from oil, egg yolks, and vinegar or lemon juice.");
//            } else if (category.equals("Snacks")) {
//                products.put("Chips", "A food made from potatoes or other vegetables, sliced thin and fried or baked until crisp.");
//                products.put("Popcorn", "A snack food made from corn kernels that have been heated until they explode.");
//                products.put("Pretzels", "A type of baked bread product made from dough that is shaped into knots or twists and then boiled in a baking soda solution.");
//            } else if (category.equals("Beverages")) {
//                products.put("Water", "A clear, colorless, odorless, and tasteless liquid.");
//                products.put("Juice", "A liquid that is naturally contained in fruit or vegetable tissue.");
//                products.put("Soda", "A sweet carbonated drink.");
//            } else if (category.equals("Frozen Foods")) {
//                products.put("Ice Cream", "A frozen food made from cream, milk and sugar, often flavored and sweetened.");
//                products.put("Frozen Vegetables", "Vegetables that are picked, cleaned, and quickly frozen to lock in their freshness and nutritional value.");
//                products.put("Frozen Meals", "Complete meals that are frozen and sold in a frozen state, such as lasagna, pizza, and chicken pot pie.");
//            } else if (category.equals("Organic Foods")) {
//                products.put("Organic Apples", "Apples grown without the use of synthetic chemicals or pesticides.");
//                products.put("Organic Eggs", "Eggs produced by chickens that are fed an organic diet and not given hormones or antibiotics.");
//                products.put("Organic Milk", "Milk produced by cows that are fed an organic diet and not given hormones or antibiotics.");
//            } else if (category.equals("Non-veg")) {
//                products.put("Beef Belly", "Meat from a cow or bull that is typically sold as steaks or ground beef.");
//                products.put("Pork", "Meat from a pig that is typically sold as bacon, ham, or pork chops.");
//                products.put("Chicken Breast", "Meat from a chicken that is typically sold as whole birds or boneless, skinless breasts.");
//            }else if (category.equals("Fast Foods")) {
//                products.put("Hamburgers", "A sandwich typically made of one or more cooked patties of ground meat.");
//                products.put("French Fries", "A type of fried potatoes.");
//                products.put("Hot Dogs", "A cooked sausage.");
//            } else if (category.equals("Breakfast Foods")) {
//                products.put("Cereal", "A type of breakfast food made from processed grains.");
//                products.put("Eggs", "A common breakfast food that is often cooked by frying or scrambling.");
//                products.put("Bacon", "A type of salt-cured pork that is typically sliced thin and cooked until crispy.");
//            } else if (category.equals("Soups")) {
//                products.put("Chicken Noodle Soup", "A soup made with chicken broth, noodles, and vegetables.");
//                products.put("Tomato Soup", "A soup made with tomatoes and vegetables.");
//                products.put("Clam Chowder", "A type of thick soup made with clams and potatoes.");
//            }else if (category.equals("Canned Foods")) {
//                products.put("Canned Fruits", "Fruits that are packaged in cans or jars, such as peaches, pears, and pineapples.");
//                products.put("Canned Vegetables", "Vegetables that are packaged in cans or jars, such as green beans, corn, and tomatoes.");
//                products.put("Canned Soups", "Soups that are packaged in cans or jars, such as chicken noodle, tomato, and minestrone.");
//            } else if (category.equals("Ethnic Foods")) {
//                products.put("Chinese Food", "Foods from Chinese cuisine, such as Kung Pao chicken and fried rice.");
//                products.put("Indian Food", "Foods from Indian cuisine, such as chicken tikka masala and biryani.");
//                products.put("Mexican Food", "Foods from Mexican cuisine, such as tacos and enchiladas.");
//            }else if (category.equals("Gluten-Free Foods")) {
//                products.put("Gluten-Free Bread", "A bread made without wheat, barley, or rye.");
//                products.put("Gluten-Free Pasta", "Pasta made without wheat, barley, or rye.");
//                products.put("Gluten-Free Cookies", "Cookies made without wheat, barley, or rye.");
//            } else if (category.equals("Desserts")) {
//                products.put("Pie", "A sweet dish made with a pastry crust and filled with fruit or custard.");
//                products.put("Cake", "A sweet baked dish made with flour, sugar, and eggs.");
//                products.put("Frozen Dessert", "A frozen food made from cream, milk, and sugar, often flavored and sweetened.");
//            } else if (category.equals("Herbs and Spices")) {
//                products.put("Basil", "A herb commonly used in Italian cuisine.");
//                products.put("Oregano", "A herb commonly used in Mediterranean cuisine.");
//                products.put("Cinnamon", "A spice commonly used in sweet and savory dishes.");
//            } else if (category.equals("Nuts and Seeds")) {
//                products.put("Almonds", "A type of nut.");
//                products.put("Walnuts", "A type of nut.");
//                products.put("Sunflower Seeds", "A type of seed.");
//            } else if (category.equals("Cereals")) {
//                products.put("Corn Flakes", "A type of cereal made from corn.");
//                products.put("Oatmeal", "A type of cereal made from oats.");
//                products.put("Rice Krispies", "A type of cereal made from rice.");
//            }else if (category.equals("Deli Foods")) {
//                products.put("Deli Meats", "Meats typically sold at deli counters, such as turkey, ham, and roast beef.");
//                products.put("Deli Cheeses", "Cheeses typically sold at deli counters, such as cheddar, Swiss, and mozzarella.");
//                products.put("Deli Salads", "Salads typically sold at deli counters, such as potato salad and coleslaw.");
//            }
//            foodProducts.put(category, products);
//        }
//
//        for(Map.Entry<String, String> entry : foodCategories.entrySet()) {
//
//            Category kategoria = new Category();
//
//            kategoria.setName(entry.getKey());
//            kategoria.setDescription(entry.getValue());
//            categoryRepository.save(kategoria);
//
//            for(Map.Entry<String, String> dane : foodProducts.get(entry.getKey()).entrySet()){
//                Product produkt = new Product();
//                produkt.setCategory(kategoria);
//                produkt.setName(dane.getKey());
//                produkt.setDescription(dane.getValue());
//                produkt.setPrice(Float.valueOf(faker.commerce().price().replace(",", ".")));
//                produkt.setStock(faker.random().nextInt(100));
//                produkt.setWeight(Float.valueOf(faker.commerce().price().replace(",", ".")));
//                produkt.setDimensions(faker.random().nextInt(100) + "X" + faker.random().nextInt(100) + "X" + faker.random().nextInt(100));
//                productRepository.save(produkt);
//
//            }
//        }
//
//
//
//
//
//
//
//    }
//}
