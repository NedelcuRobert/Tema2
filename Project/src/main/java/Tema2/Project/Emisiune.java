package Tema2.Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Emisiune{
	
	private String genEmisiune;
    private String publicTinta;
    private int oraDifuzarii;
    private int durata;
    private String tipEmisiune;

    public String getGenEmisiune() {
		return genEmisiune;
	}

	public void setGenEmisiune(String genEmisiune) {
		this.genEmisiune = genEmisiune;
	}

	public String getPublicTinta() {
		return publicTinta;
	}

	public void setPublicTinta(String publicTinta) {
		this.publicTinta = publicTinta;
	}

	public int getOraDifuzarii() {
		return oraDifuzarii;
	}

	public void setOraDifuzarii(int oraDifuzarii) {
		this.oraDifuzarii = oraDifuzarii;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getTipEmisiune() {
		return tipEmisiune;
	}

	public void setTipEmisiune(String tipEmisiune) {
		this.tipEmisiune = tipEmisiune;
	}
    
   
	public void citire(Scanner sc) {
		System.out.println("Gen Emisiune:");
		String GenEm=sc.next();
		this.setGenEmisiune(GenEm);
		System.out.println("Public Tinta:");
		String Publ=sc.next();
		this.setPublicTinta(Publ);
		System.out.println("Ora Difuzare:");
		int o=sc.nextInt();
		this.setOraDifuzarii(o);
		System.out.println("Durata:");
		int d=sc.nextInt();
		this.setDurata(d);
		System.out.println("Tip Emisiune");
		String tip=sc.next();
		this.setTipEmisiune(tip);
	}
	
	@SuppressWarnings("unchecked")
	public void citireJSON() {
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(".\\jsonfiles\\emisiune.json"))
        {
            Object obj = jsonParser.parse(reader);
 
            JSONArray emisiuneList = (JSONArray) obj;
             
            emisiuneList.forEach( emp1 -> parseEmisiuneObject( (JSONObject) emp1 ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	private void parseEmisiuneObject(JSONObject canal) 
    {
		
        JSONObject emisiuneObject = (JSONObject) canal.get("Emisiune");

        genEmisiune = (String) emisiuneObject.get("genEmisiune");
        publicTinta = (String) emisiuneObject.get("publicTinta");
        oraDifuzarii = ((Number) emisiuneObject.get("genEmisiune")).intValue();
        durata = ((Number) emisiuneObject.get("durata")).intValue();
        tipEmisiune = (String) emisiuneObject.get("tip");    
    }


	@Override
	public String toString() {
		return "Emisiune [genEmisiune=" + genEmisiune + ", publicTinta=" + publicTinta + ", oraDifuzarii="
				+ oraDifuzarii + ", durata=" + durata + ", tipEmisiune=" + tipEmisiune + "]";
	}
	
}