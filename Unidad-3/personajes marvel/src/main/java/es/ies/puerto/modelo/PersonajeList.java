package es.ies.puerto.modelo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "personajes")
public class PersonajeList {

    @ElementList(inline = true)
    private List<Personaje> personajes;


    public PersonajeList() {
        personajes=new ArrayList<>();
    }
    public PersonajeList(List<Personaje> personajes) {

        this.personajes = personajes;
    }

    public List<Personaje> getPersonajes() {

        return personajes;
    }

    public void setPersonas(List<Personaje> personajes) {

        this.personajes = personajes;
    }
}
