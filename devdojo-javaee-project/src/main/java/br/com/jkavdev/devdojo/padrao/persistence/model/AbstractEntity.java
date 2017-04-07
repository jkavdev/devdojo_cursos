package br.com.jkavdev.devdojo.padrao.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractEntity)
			if (obj.getClass() == this.getClass())
				if (id != null && ((AbstractEntity) obj).id.equals(id))
					return true;

		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{id=" + id + "}";
	}

}