import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class Translation {
    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        Scanner sc = new Scanner(System.in);

        //Без выбора языка(на английский)
        System.out.println("пиши слова");
        String userWords = sc.nextLine();
        String url = "https://api.mymemory.translated.net/get?q=" + userWords + "!&langpair=ru|eng"; //получаем слова и вписываем их в ссылку

        String response = restTemplate.getForObject(url, String.class); // получаем всю инфу

        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response); // парсим

        System.out.println("Перевод: " + obj.get("responseData").get("translatedText")); //результат

        //С выбором
        /*String rus = "rus";
        String eng = "eng";
        String ita = "ita"; //языки перевода

        System.out.println("пиши слова");
        String userWords = sc.nextLine();
        String demoUrl = "https://api.mymemory.translated.net/get?q=" + userWords + "!&langpair="; //получаем слова и вписываем их в ссылку

        System.out.println("С какого на какой?");
        System.out.println("Русский - rus");
        System.out.println("Английский - eng");
        System.out.println("Итальянский - ita");
        String userChooseOne = sc.nextLine();
        String userChooseTwo = sc.nextLine(); //выбор языка

        String url = demoUrl + userChooseOne + "|" + userChooseTwo; //дописывание ссылки

        String response = restTemplate.getForObject(url, String.class); // получаем всю инфу

        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response); // парсим

        System.out.println("Перевод: " + obj.get("responseData").get("translatedText")); */ //результат

        //https://mymemory.translated.net/doc/spec.php //брал отсюда
        //String url = "https://api.mymemory.translated.net/get?q=Привет, мир!&langpair=ru|eng"; //база
    }
}
