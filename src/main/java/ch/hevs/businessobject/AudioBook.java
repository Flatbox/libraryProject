package ch.hevs.businessobject;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class AudioBook extends Book {
	
	private Boolean taken;
	//Relations
	@ManyToOne(cascade = CascadeType.PERSIST)
	private AudioReader reader;

	//Constructors
	public AudioBook() {
		super();
		this.setTaken(false);
		// TODO Auto-generated constructor stub
	}

	public AudioBook(String title, String publicationDate, String isbn) {
		super(title, publicationDate, isbn);
		this.setTaken(false);
		// TODO Auto-generated constructor stub
	}
	
	public void setAudioReader (AudioReader audioReader){
		this.reader = audioReader;
	}
	
	public AudioReader getAudioReader (){
		return reader;
	}

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}


}
