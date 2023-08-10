/**
 * 
 */
package br.com.porto.app.ref.rs;

import java.io.Serializable;

/**
 * @author rafael
 *
 */
public class EmpresaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7389207674214254900L;

	private Integer codigoEmpresa;
	private String nomeEmpresa;
	private String fantasia;
	private String numCnpj;
	private String filialCnpj;
	private String dvCnpj;
	private String grupoEmpresa;
	private String flagAtivo;
	private String comentario;
	private String dataUltimaAtualizacao;
	private Integer codigoTipoUsuarioUltimaAlteracao;
	private Integer codigoEmpresaUsuarioUltimaAlteracao;
	private Integer codigoMatriculaUsuarioUltimaAlteracao;

	/**
	 * 
	 */
	public EmpresaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Integer codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getNumCnpj() {
		return numCnpj;
	}

	public void setNumCnpj(String numCnpj) {
		this.numCnpj = numCnpj;
	}

	public String getFilialCnpj() {
		return filialCnpj;
	}

	public void setFilialCnpj(String filialCnpj) {
		this.filialCnpj = filialCnpj;
	}

	public String getDvCnpj() {
		return dvCnpj;
	}

	public void setDvCnpj(String dvCnpj) {
		this.dvCnpj = dvCnpj;
	}

	public String getGrupoEmpresa() {
		return grupoEmpresa;
	}

	public void setGrupoEmpresa(String grupoEmpresa) {
		this.grupoEmpresa = grupoEmpresa;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Integer getCodigoTipoUsuarioUltimaAlteracao() {
		return codigoTipoUsuarioUltimaAlteracao;
	}

	public void setCodigoTipoUsuarioUltimaAlteracao(
			Integer codigoTipoUsuarioUltimaAlteracao) {
		this.codigoTipoUsuarioUltimaAlteracao = codigoTipoUsuarioUltimaAlteracao;
	}

	public Integer getCodigoEmpresaUsuarioUltimaAlteracao() {
		return codigoEmpresaUsuarioUltimaAlteracao;
	}

	public void setCodigoEmpresaUsuarioUltimaAlteracao(
			Integer codigoEmpresaUsuarioUltimaAlteracao) {
		this.codigoEmpresaUsuarioUltimaAlteracao = codigoEmpresaUsuarioUltimaAlteracao;
	}

	public Integer getCodigoMatriculaUsuarioUltimaAlteracao() {
		return codigoMatriculaUsuarioUltimaAlteracao;
	}

	public void setCodigoMatriculaUsuarioUltimaAlteracao(
			Integer codigoMatriculaUsuarioUltimaAlteracao) {
		this.codigoMatriculaUsuarioUltimaAlteracao = codigoMatriculaUsuarioUltimaAlteracao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoEmpresa == null) ? 0 : codigoEmpresa.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EmpresaDTO)) {
			return false;
		}
		EmpresaDTO other = (EmpresaDTO) obj;
		if (codigoEmpresa == null) {
			if (other.codigoEmpresa != null) {
				return false;
			}
		} else if (!codigoEmpresa.equals(other.codigoEmpresa)) {
			return false;
		}
		return true;
	}
	

}
