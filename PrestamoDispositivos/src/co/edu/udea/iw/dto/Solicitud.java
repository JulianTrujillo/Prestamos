package co.edu.udea.iw.dto;

public class Solicitud {
	
	private Integer idSolicitud;
	private Usuario usuarioSolicita;
	private Usuario usuarioAprueba;
	private Dispositivo dispositivo;
	private String estadoSolicitud;
	public Integer getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public Usuario getUsuarioSolicita() {
		return usuarioSolicita;
	}
	public void setUsuarioSolicita(Usuario usuarioSolicita) {
		this.usuarioSolicita = usuarioSolicita;
	}
	public Usuario getUsuarioAprueba() {
		return usuarioAprueba;
	}
	public void setUsuarioAprueba(Usuario usuarioAprueba) {
		this.usuarioAprueba = usuarioAprueba;
	}
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
}
