package Tema2.Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

public class Program extends Emisiune {

	private String tipProgram;
	private int durataMedie;
    private int emisiuniLive;
    private int emisiuniInregistrate;
    private String publicTinta;
    private int oraPreponderentaEmisiune;
    
    public String getTipProgram() {
		return tipProgram;
	}

	public void setTipProgram(String tipProgram) {
		this.tipProgram = tipProgram;
	}

	public int getDurataMedie() {
		return durataMedie;
	}

	public void setDurataMedie(int durataMedie) {
		this.durataMedie = durataMedie;
	}

	public int getEmisiuniLive() {
		return emisiuniLive;
	}

	public void setEmisiuniLive(int emisiuniLive) {
		this.emisiuniLive = emisiuniLive;
	}

	public int getEmisiuniInregistrate() {
		return emisiuniInregistrate;
	}

	public void setEmisiuniInregistrate(int emisiuniInregistrate) {
		this.emisiuniInregistrate = emisiuniInregistrate;
	}

	public String getPublicTinta() {
		return publicTinta;
	}

	public void setPublicTinta(String publicTinta) {
		this.publicTinta = publicTinta;
	}

	public int getOraPreponderentaEmisiune() {
		return oraPreponderentaEmisiune;
	}

	public void setOraPreponderentaEmisiune(int oraPreponderentaEmisiune) {
		this.oraPreponderentaEmisiune = oraPreponderentaEmisiune;
	}
    

	public void citire(Scanner sc) {
		System.out.println("Tip Program:");
		String tip=sc.next();
    	this.setTipProgram(tip);
    	System.out.println("Durata Medie:");
    	int dur=sc.nextInt();
        this.setDurataMedie(dur);
        System.out.println("Emisiuni Live:");
        int emL=sc.nextInt();
        this.setEmisiuniLive(emL);
        System.out.println("Emisiuni Inregistrare:");
        int emI=sc.nextInt();
        this.setEmisiuniInregistrate(emI);
        System.out.println("Public Tinta:");
        String pbT=sc.next();
        this.setPublicTinta(pbT);
        System.out.println("Ora Emisiune:");
        int ora=sc.nextInt();
        this.setOraPreponderentaEmisiune(ora);
	}
	
	@SuppressWarnings("unchecked")
	public void citireJSON() {
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(".\\jsonfiles\\program.json"))
        {
            Object obj = jsonParser.parse(reader);
 
            JSONArray programList = (JSONArray) obj;
             
            programList.forEach( emp -> parseProgramObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	private void parseProgramObject(JSONObject program) 
    {
        JSONObject programObject = (JSONObject) program.get("Program");

        tipProgram = (String) programObject.get("TipProgram");  
         
        durataMedie = ((Number) programObject.get("durataMedie")).intValue();
        
        emisiuniLive = ((Number) programObject.get("emisiuniLive")).intValue();    
        
        emisiuniInregistrate = ((Number) programObject.get("emisiuniInregistrare")).intValue(); 

        publicTinta = (String) programObject.get("publicTinta");    
        
        oraPreponderentaEmisiune = ((Number) programObject.get("oraPreponderentaEmisiune")).intValue();
        
    }
    
	@Override
	public String toString() {
		return "Program [tipProgram=" + tipProgram + ", durataMedie=" + durataMedie + ", emisiuniLive=" + emisiuniLive
				+ ", emisiuniInregistrate=" + emisiuniInregistrate + ", publicTinta=" + publicTinta
				+ ", oraPreponderentaEmisiune=" + oraPreponderentaEmisiune + "]";
	}  
	       
}