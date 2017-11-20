package Scripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDemo {
	public void JsonRead() {
		try {
		JSONParser parser = new JSONParser();
		Object obj;
		obj = parser.parse(new FileReader("D:\\Java_Test\\SeleniumDemo\\Files\\Demo.json"));
		JSONObject jobj = (JSONObject) obj;
		System.out.println(jobj);
		
		String name = (String) jobj.get("name");
		System.out.println(name);
		
		String age = (String) jobj.get("age");
		System.out.print(age);
		
		JSONArray msg = (JSONArray) jobj.get("messages");
		Iterator<String> it = msg.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void JsonWrite() {
		try {
		JSONObject jobj = new JSONObject();
		jobj.put("name", "madhura");
		jobj.put("age", "22");
		
		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		
		jobj.put("messages", list);
		
		FileWriter file = new FileWriter("D:\\Java_Test\\SeleniumDemo\\Files\\Demo.json");
		file.write(jobj.toJSONString());
		file.flush();
		
		System.out.println(jobj);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		
		JsonDemo jd = new JsonDemo();
		jd.JsonWrite();
		jd.JsonRead();
	}

}
