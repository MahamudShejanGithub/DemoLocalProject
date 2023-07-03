package DataReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONFileReader {
    private static Object obj;
    private static final String directory=".\\TestData\\";

    private static final String directoryOne=".\\src\\main\\resources\\";

    public static String getJSONKeyValue(String key,String fileName)  {
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(directory+fileName)) {
            Object obj=parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject JSONObj = (JSONObject)obj;
        String value= (String) JSONObj.get(key);
        return value;
    }

    public static JSONArray getJSONArray(String key, String fileName) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(directory+fileName)){
            Object obj=parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject JSONObj = (JSONObject)obj;
        JSONArray array = (JSONArray) JSONObj.get(key);
        return array;
    }

    public static JSONObject getJSONObject(String fileName){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(directory+fileName)) {
           Object obj=parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject JSONObj = (JSONObject)obj;
        return JSONObj;
    }
    public static String getJSONKeyValueFromResources(String key,String fileName)  {
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(directoryOne+fileName)) {
            Object obj=parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject JSONObj = (JSONObject)obj;
        String value= (String) JSONObj.get(key);
        return value;
    }
    public static String getJSONKeyValueFromResources(String jsonObjectKey,String key,String fileName) {
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(directoryOne+fileName)) {
            obj=parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject JSONObj = (JSONObject)obj;
        JSONObject jsonObject= (JSONObject) JSONObj.get(jsonObjectKey);
        String value= (String) jsonObject.get(key);

        return value;
    }
}
