package edu.esprit.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.persistance.Chercheur;
import edu.esprit.persistance.Technicien;
import edu.esprit.persistance.Utilisateur;
import edu.esprit.services.UtilisateurService;

@ManagedBean // (name="lbean")
@SessionScoped
public class LoginBean {

	private String login;
	private String password;

	private Utilisateur user = new Utilisateur();

	@EJB
	UtilisateurService service;

	public String doIdentifier() {

		String navigateTo = null;

		user = service.identifierUtisateur(login, password);

		if (user != null) {
			if (user instanceof Technicien)
				navigateTo = "/technicien/welcome";
			if (user instanceof Chercheur)
				navigateTo = "/chercheur/welcome?faces-redirect=true";
		} else
			navigateTo = "erreur";

		return navigateTo;
	}

	public String doLogout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
