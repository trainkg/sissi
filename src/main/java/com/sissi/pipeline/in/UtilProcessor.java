package com.sissi.pipeline.in;

import com.sissi.addressing.Addressing;
import com.sissi.broadcast.PresenceQueue;
import com.sissi.broadcast.ProtocolQueue;
import com.sissi.context.JIDBuilder;
import com.sissi.pipeline.Input;
import com.sissi.relation.RelationContext;

/**
 * @author kim 2013-11-16
 */
abstract public class UtilProcessor implements Input {

	protected JIDBuilder jidBuilder;

	protected Addressing addressing;

	protected PresenceQueue presenceQueue;

	protected ProtocolQueue protocolQueue;

	protected RelationContext relationContext;

	public void setAddressing(Addressing addressing) {
		this.addressing = addressing;
	}

	public void setJidBuilder(JIDBuilder jidBuilder) {
		this.jidBuilder = jidBuilder;
	}

	public void setRelationContext(RelationContext relationContext) {
		this.relationContext = relationContext;
	}

	public void setPresenceQueue(PresenceQueue presenceQueue) {
		this.presenceQueue = presenceQueue;
	}

	public void setProtocolQueue(ProtocolQueue protocolQueue) {
		this.protocolQueue = protocolQueue;
	}
}