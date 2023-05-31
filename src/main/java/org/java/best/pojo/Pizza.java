package org.java.best.pojo;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "il nome non può essere vuoto")
	private String nome;
	@NotBlank(message = "la descrizione non può essere vuota")
	private String descrizione;
	@NotBlank(message = "l'url non può essere vuoto")
	private String foto;
	@Min(value = 1, message = "Il prezzo non può essere minore di 0")
	private int price;
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, String foto, int price) {
		
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrice(price);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] "
				+ "\nnome: " + getNome()
				+ "\ndescrizione: " + getDescrizione()
				+ "\nurl foto: " + getFoto()
				+ "\n prezzo:" + getPrice();
	}
}
