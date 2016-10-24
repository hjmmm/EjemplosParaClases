package co.edu.javeriana.objectify.presentacion.gui;

import co.edu.javeriana.objectify.negocio.Objectify;

public interface IPanelObjectify {
	void setNegocio(Objectify negocio);
	void refrescar();
}
