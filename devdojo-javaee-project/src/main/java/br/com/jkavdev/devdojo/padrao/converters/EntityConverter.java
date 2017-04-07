package br.com.jkavdev.devdojo.padrao.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.jkavdev.devdojo.padrao.persistence.model.AbstractEntity;

public class EntityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || value.matches("\\d+"))
			return null;

		return this.getAttributesFrom(component).get(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {
			AbstractEntity entity = (AbstractEntity) value;
			if (entity.getId() != null) {
				this.addAttribute(component, entity);
				return entity.getId().toString();
			}

			return value.toString();
		}

		return "";
	}

	private void addAttribute(UIComponent component, AbstractEntity abstractEntity) {
		this.getAttributesFrom(component).put(abstractEntity.getId().toString(), abstractEntity);
	}

	private Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
