package framework.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public void getJsonDataToMap() throws IOException {
		// reading Json to string
		@SuppressWarnings("deprecation")
		String JsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\ParchesOrder.json"));
		
		// string to HashMap
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			
		}
	
}
