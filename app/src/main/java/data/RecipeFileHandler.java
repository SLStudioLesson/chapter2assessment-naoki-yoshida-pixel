package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */

    // recipes.txtからレシピデータを読み込み、それをリスト形式で返します
    public ArrayList<String> readRecipes() {
        // recipes.txtからレシピデータを読み込み、それをリスト形式で返します
        String filename1 = filePath;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename1))) {
            String line ;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
            // IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return list;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName  レシピ名
     * @param ingredients 材料名
     */
    //
    public void addRecipe(String recipeName, String ingredients) {
        String filename2 = filePath;
        File dataFile = new File(filename2);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile,true))){
            writer.write("\n"+recipeName+","+ingredients); //レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage()); //IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
        }
    }
}
