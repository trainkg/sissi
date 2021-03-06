package com.sissi.pipeline.in.iq.vcard;

import com.sissi.context.JIDContext;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;

/**
 * @author kim 2014年1月26日
 */
public class VCardGetCheckRelation4EmptyProcessor extends VCardGetCheckRelationProcessor {

	protected boolean writeAndReturn(JIDContext context, Protocol protocol) {
		context.write(protocol.clear().getParent().reply().setType(ProtocolType.RESULT));
		return false;
	}
}
