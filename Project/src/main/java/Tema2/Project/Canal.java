package Tema2.Project;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Canal extends Program {
	
	private Program[] programe;
    private String frecventa;
    private int ziRevizie;

    public Program[] getPrograme() {
		return programe;
	}

	public void setPrograme(Program[] programe) {
		this.programe = programe;
	}

	public String getFrecventa() {
		return frecventa;
	}

	public void setFrecventa(String frecventa) {
		this.frecventa = frecventa;
	}

	public int getZiRevizie() {
		return ziRevizie;
	}

	public void setZiRevizie(int ziRevizie) {
		this.ziRevizie = ziRevizie;
	}
	
	
	public void citire(Scanner sc) {
    	System.out.println("Numar Programe:");
    	int n=sc.nextInt();
    	programe = new Program[n];
    	for(int i=0;i<n;i++) {
    		programe[i] = new Program();
    		programe[i].citire(sc);
    	}
    	System.out.println("Frecventa:");
    	String f=sc.next();
    	this.setFrecventa(f);
    	System.out.println("Zi Revizie:");
    	int zi=sc.nextInt();
    	this.setZiRevizie(zi);
    }
	
	@SuppressWarnings("unchecked")
	public void citireJSON() {
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(".\\jsonfiles\\canal.json"))
        {
            Object obj = jsonParser.parse(reader);
 
            JSONArray canalList = (JSONArray) obj;
             
            canalList.forEach( emp1 -> parseCanalObject( (JSONObject) emp1 ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	private void parseCanalObject(JSONObject canal) 
    {
		
        JSONObject canalObject = (JSONObject) canal.get("Canal");

        int n = ((Number) canalObject.get("nrPrograme")).intValue();
        programe = new Program[n];
        for(int i=0;i<n;i++) {
        	programe[i] = new Program();
        	programe[i].citireJSON();
        }
    	frecventa = (String) canalObject.get("frecventa");
    	ziRevizie = ((Number) canalObject.get("ziRevizie")).intValue();        
    }

	@Override
    public String toString() {
        return "Canal{" +
                "programe=" + Arrays.toString(programe) +
                ", frecventa='" + frecventa + '\'' +
                ", ziRevizie=" + ziRevizie +
                '}';
    }

}