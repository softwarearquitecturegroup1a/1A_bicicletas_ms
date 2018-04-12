package models;

import io.ebean.Model;
import io.ebean.Finder;

import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Bicicleta extends Model{

	@Id
	public BigInteger serial;
	public String marca;
	public String color;
	public String ubicacion;
	public String estado;


	public static final Finder<Integer, Bicicleta> find = new Finder<>(Bicicleta.class);


	public void setSerial(BigInteger serial){
        this.serial = serial;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
    
}

