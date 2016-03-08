package jsontest;
/*
 * I. Задано текстовий файл з інформацією про музичний альбом. Кожний запис містить прізвище виконавця,
назву пісні та її тривалість. Створити відповідний клас, для зберігання інформації використати одну з колекцій; 
 * відсортувати дані за назвою пісні. Відсортовані записи вивести на екран. Передбачити обробку виключних ситуацій.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		InputStream input = new FileInputStream("src/album.json");

		ObjectMapper objectMapper = new ObjectMapper();

		TypeFactory typeFactory = TypeFactory.defaultInstance();

		List<Record> song = objectMapper.readValue(input,
		typeFactory.constructCollectionType(ArrayList.class, Record.class));
		
		 List<Record> list = new ArrayList<Record>();
		 System.out.println("~~~~BEFORE SORTING~~~~");
		 for (int i = 0; i < 10; i++){
		 list.add(new Record(song.get(i).getSongName() , song.get(i).getSingerName(), song.get(i).getSongTime()));
		 }
		 for (Record record : list) {
			 System.out.println(record);
			 }
		
			
			 System.out.println("\n" + "~~~~AFTER SORTING~~~~");
			 Collections.sort(list);
			 for (Record record : list) {
			 System.out.println(record);
			 }
	}
}