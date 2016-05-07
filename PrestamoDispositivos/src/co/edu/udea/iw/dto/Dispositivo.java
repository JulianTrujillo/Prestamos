package co.edu.udea.iw.dto;

public class Dispositivo {
	
	private Integer idDispositivo;
	private String nombre;
	private String estadoDispositivo;
	private Integer valor;
	
	public Integer getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstadoDispositivo() {
		return estadoDispositivo;
	}
	public void setEstadoDispositivo(String estadoDispositivo) {
		this.estadoDispositivo = estadoDispositivo;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
