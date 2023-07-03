package Utilities;

import DataReader.JSONFileReader;

public class GenerateURL {
    public static String generateURL(){
        String url = JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.schema)+"://"+JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.username)+":"+JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.password)+"@"+JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.domain)+":"+JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.port)+"/"+JSONFileReader.getJSONKeyValue(Constants.fileNameTwo,Constants.subdomain);
        return url;
    }
}
