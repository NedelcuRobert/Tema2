package Tema2.Project;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class WriteJSON
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        JSONObject program_details = new JSONObject();
        program_details.put("TipProgram", "Sport");
        program_details.put("durataMedie", 30);
        program_details.put("emisiuniLive", 5);
        program_details.put("emisiuniInregistrare", 3);
        program_details.put("publicTinta", "18+");
        program_details.put("oraPreponderentaEmisiune", 5);
         
        JSONObject programObject = new JSONObject(); 
        programObject.put("Program", program_details);
        
        JSONObject program_details2 = new JSONObject();
        program_details2.put("TipProgram", "Actiune");
        program_details2.put("durataMedie", 10);
        program_details2.put("emisiuniLive", 25);
        program_details2.put("emisiuniInregistrare", 8);
        program_details2.put("publicTinta", "18+");
        program_details2.put("oraPreponderentaEmisiune", 2);
         
        JSONObject programObject2 = new JSONObject(); 
        programObject2.put("Program", program_details2);
        
        JSONObject program_details3 = new JSONObject();
        program_details3.put("nrPrograme", 2);
        program_details3.put("frecventa", "5ds");
        program_details3.put("ziRevizie", 25);
        
        JSONObject programObject3 = new JSONObject(); 
        programObject3.put("Canal", program_details3);
        
        JSONArray programList = new JSONArray();
        programList.add(programObject);
        programList.add(programObject2);
        
        JSONArray programList2 = new JSONArray();
        programList2.add(programObject3);
        
        JSONObject program_details4 = new JSONObject();
        program_details4.put("genEmisiune", "Telenovela");
        program_details4.put("publicTinta", "18+");
        program_details4.put("oraDifuzarii", 17);
        program_details4.put("durata", 19);
        program_details4.put("tip", "Divertiment");
        
        JSONObject programObject4 = new JSONObject(); 
        programObject4.put("Emisiune", program_details4);
        
        JSONObject program_details5 = new JSONObject();
        program_details5.put("genEmisiune", "Market");
        program_details5.put("publicTinta", "16+");
        program_details5.put("oraDifuzarii", 7);
        program_details5.put("durata", 1);
        program_details5.put("tip", "Drama");
        
        JSONObject programObject5 = new JSONObject(); 
        programObject5.put("Emisiune", program_details4);
        
        JSONArray programList3 = new JSONArray();
        programList3.add(programObject4);
        programList3.add(programObject5);
        
        try (FileWriter file = new FileWriter(".\\jsonfiles\\emisiune.json")) {
            file.write(programList3.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (FileWriter file = new FileWriter(".\\jsonfiles\\canal.json")) {
            file.write(programList2.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try (FileWriter file = new FileWriter(".\\jsonfiles\\program.json")) {
            file.write(programList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}