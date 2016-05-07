package co.edu.udea.iw.dto;

public class Sancion {
	
	private Integer idSancion;
	private String tipoSancion;
	private Prestamo prestamo;
	private String descripcion;
	private Usuario usuarioSanciona;
	public Integer getIdSancion() {
		return idSancion;
	}
	public void setIdSancion(Integer idSancion) {
		this.idSancion = idSancion;
	}
	public String getTipoSancion() {
		return tipoSancion;
	}
	public void setTipoSancion(String tipoSancion) {
		this.tipoSancion = tipoSancion;
	}
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuarioSanciona() {
		return usuarioSanciona;
	}
	public void setUsuarioSanciona(Usuario usuarioSanciona) {
		this.usuarioSanciona = usuarioSanciona;
	}
	
}
