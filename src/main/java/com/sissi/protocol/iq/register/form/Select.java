package com.sissi.protocol.iq.register.form;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.sissi.protocol.iq.register.form.Form.Type;

/**
 * @author kim 2013年12月5日
 */
@XmlRootElement(name = "field")
public class Select extends Input {

	private List<Option> option;

	public Select() {

	}

	public Select(String name, String var) {
		super(Type.LIST_SINGLE.toString(), null, name, var);
	}

	public Select(String value, String name, String var) {
		super(Type.LIST_SINGLE.toString(), value, name, var, null);
	}

	public Select(String name, String var, Required required) {
		super(Type.LIST_SINGLE.toString(), null, name, var, required);
	}

	public Select(String name, String var, Required required, Option... option) {
		super(Type.LIST_SINGLE.toString(), null, name, var, required);
		for (Option each : option) {
			this.add(each);
		}
	}

	public Select add(Option option) {
		if (this.option == null) {
			this.option = new ArrayList<Option>();
		}
		this.option.add(option);
		return this;
	}

	@XmlElements({ @XmlElement(name = "option", type = Option.class) })
	public List<Option> getOption() {
		return option;
	}
}
