package br.com.defaultproject.sgr.view.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "menuMb")
@SessionScoped
public class MenuMb {

	private MenuModel menuModel;

	public MenuMb() {
		this.menuModel = new DefaultMenuModel();

		// First submenu
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Cadastro");

		DefaultMenuItem item = new DefaultMenuItem("Consultor");
		item.setUrl("./consultor.xhtml");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);

		item = new DefaultMenuItem("Cliente");
		item.setUrl("./cliente.xhtml");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);

		item = new DefaultMenuItem("Serviço");
		item.setUrl("./servico.xhtml");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);

		this.menuModel.addElement(firstSubmenu);

		item = new DefaultMenuItem("Saída");
		item.setIcon("ui-icon-home");

		this.menuModel.addElement(item);

		// Second submenu
		DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

		item = new DefaultMenuItem("Save");
		item.setIcon("ui-icon-disk");
		// item.setCommand("#{menuBean.save}");
		// item.setUpdate("messages");
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Delete");
		item.setIcon("ui-icon-close");
		// item.setCommand("#{menuBean.delete}");
		item.setAjax(false);
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Redirect");
		item.setIcon("ui-icon-search");
		// item.setCommand("#{menuBean.redirect}");
		secondSubmenu.addElement(item);

		// this.menuModel.addElement(secondSubmenu);
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

}