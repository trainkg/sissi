package com.sissi.pipeline.in;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sissi.pipeline.Input;
import com.sissi.pipeline.InputCondition;
import com.sissi.pipeline.InputFinder;
import com.sissi.protocol.Protocol;

/**
 * @author kim 2013-11-4
 */
public class ChainedFinder implements InputFinder {

	private final Log log = LogFactory.getLog(this.getClass());

	private final List<InputCondition> conditions;

	public ChainedFinder(List<InputCondition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public Input find(Protocol protocol) {
		for (InputCondition each : this.conditions) {
			if (each.getMatcher().match(protocol)) {
				Input input = each.getInput();
				this.log.debug("Input for " + protocol.getClass());
				return input;
			}
		}
		return NothingProcessor.NOTHING;
	}
}
