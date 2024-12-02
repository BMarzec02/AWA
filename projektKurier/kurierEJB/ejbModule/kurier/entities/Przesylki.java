package kurier.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the przesylki database table.
 * 
 */
@Entity
@NamedQuery(name="Przesylki.findAll", query="SELECT p FROM Przesylki p")
public class Przesylki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_przesylki")
	private int idPrzesylki;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_nadania")
	private Date dataNadania;

	@Column(name="imie_odbiorcy")
	private String imieOdbiorcy;

	@Column(name="kod_pocztowy")
	private int kodPocztowy;

	private String miasto;

	@Column(name="nazwisko_odbiorcy")
	private String nazwiskoOdbiorcy;

	@Column(name="numer_domu")
	private String numerDomu;

	@Column(name="numer_odbiorcy")
	private int numerOdbiorcy;

	@Column(name="numer_przesylki")
	private String numerPrzesylki;

	private String rozmiar;

	private String status;

	private String ulica;

	private int waga;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="id_uzytkownika")
	private Uzytkownicy uzytkownicy;

	public Przesylki() {
	}

	public int getIdPrzesylki() {
		return this.idPrzesylki;
	}

	public void setIdPrzesylki(int idPrzesylki) {
		this.idPrzesylki = idPrzesylki;
	}

	public Date getDataNadania() {
		return this.dataNadania;
	}

	public void setDataNadania(Date dataNadania) {
		this.dataNadania = dataNadania;
	}

	public String getImieOdbiorcy() {
		return this.imieOdbiorcy;
	}

	public void setImieOdbiorcy(String imieOdbiorcy) {
		this.imieOdbiorcy = imieOdbiorcy;
	}

	public int getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(int kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getNazwiskoOdbiorcy() {
		return this.nazwiskoOdbiorcy;
	}

	public void setNazwiskoOdbiorcy(String nazwiskoOdbiorcy) {
		this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
	}

	public String getNumerDomu() {
		return this.numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

	public int getNumerOdbiorcy() {
		return this.numerOdbiorcy;
	}

	public void setNumerOdbiorcy(int numerOdbiorcy) {
		this.numerOdbiorcy = numerOdbiorcy;
	}

	public String getNumerPrzesylki() {
		return this.numerPrzesylki;
	}

	public void setNumerPrzesylki(String numerPrzesylki) {
		this.numerPrzesylki = numerPrzesylki;
	}

	public String getRozmiar() {
		return this.rozmiar;
	}

	public void setRozmiar(String rozmiar) {
		this.rozmiar = rozmiar;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getWaga() {
		return this.waga;
	}

	public void setWaga(int waga) {
		this.waga = waga;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}