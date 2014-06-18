package br.com.defaultproject.sgr.model.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Gutemberg A Da Silva
 * 
 */

@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract ID getId();

	public abstract void setId(ID id);

	// public abstract int hashCode();

	// public abstract boolean equals(Object object);

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);

		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof AbstractEntity)) {
			return false;
		}

		AbstractEntity<?> ent = (AbstractEntity<?>) object;

		if ((this.getId() == null && ent.getId() != null)
				|| (this.getId() != null && !this.getId().equals(ent.getId()))) {
			return false;
		}

		return true;
	}

	public abstract String toString();

}