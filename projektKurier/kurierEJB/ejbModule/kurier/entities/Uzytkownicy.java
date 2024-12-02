package kurier.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the uzytkownicy database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownicy.findAll", query="SELECT u FROM Uzytkownicy u")
public class Uzytkownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="kiedy_utworzono")
	private Date kiedyUtworzono;

	@Column(name="kto_edytowal")
	private String ktoEdytowal;

	private String login;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ostatnia_edycja")
	private Date ostatniaEdycja;

	private String password;

	@Column(name="phone_number")
	private int phoneNumber;

	private String role;

	//bi-directional many-to-one association to Przesylki
	@OneToMany(mappedBy="uzytkownicy")
	private List<Przesylki> przesylkis;

	public Uzytkownicy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getKiedyUtworzono() {
		return this.kiedyUtworzono;
	}

	public void setKiedyUtworzono(Date kiedyUtworzono) {
		this.kiedyUtworzono = kiedyUtworzono;
	}

	public String getKtoEdytowal() {
		return this.ktoEdytowal;
	}

	public void setKtoEdytowal(String ktoEdytowal) {
		this.ktoEdytowal = ktoEdytowal;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getOstatniaEdycja() {
		return this.ostatniaEdycja;
	}

	public void setOstatniaEdycja(Date ostatniaEdycja) {
		this.ostatniaEdycja = ostatniaEdycja;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Przesylki> getPrzesylkis() {
		return this.przesylkis;
	}

	public void setPrzesylkis(List<Przesylki> przesylkis) {
		this.przesylkis = przesylkis;
	}

	public Przesylki addPrzesylki(Przesylki przesylki) {
		getPrzesylkis().add(przesylki);
		przesylki.setUzytkownicy(this);

		return przesylki;
	}

	public Przesylki removePrzesylki(Przesylki przesylki) {
		getPrzesylkis().remove(przesylki);
		przesylki.setUzytkownicy(null);

		return przesylki;
	}

}