package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes(fileHandler.readRecipes());
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes(ArrayList<String> list) {
        if(list != null){ //RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
            System.out.println("");
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for(String a : list){
                String b[] = a.split(",");
                System.out.println("Recipe Name: " + b[0]);
                System.out.print("Main Ingredients: ");
                for(int j = 1; j < b.length-1 ; j++){
                    System.out.print(b[j] + ",");
                }
                System.out.print(b[b.length-1] );
                System.out.println("");
                System.out.println("-----------------------------------");
            }
        } else { //読み込んだレシピデータが空の場合は、 No recipes available. というメッセージを出力します。
            System.out.println("No recipes available.");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        String recipeName;
        String ingredients;
        System.out.print("Enter recipe name: "); //ユーザーからレシピ名と主な材料を入力させます
        recipeName = reader.readLine();
        System.out.print("Enter main ingredients (comma separated): ");
        ingredients = reader.readLine();

        RecipeFileHandler add = new RecipeFileHandler(); //RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
        add.addRecipe(recipeName, ingredients);

        System.out.println("Recipe added successfully.");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

