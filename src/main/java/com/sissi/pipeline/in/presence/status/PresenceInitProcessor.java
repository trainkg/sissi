package com.sissi.pipeline.in.presence.status;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;

/**
 * @author kim 2014年1月21日
 */
public class PresenceInitProcessor implements Input {

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		return context.presence() ? true : context.online().presence();
	}
}
