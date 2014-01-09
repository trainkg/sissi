package com.sissi.pipeline.in.iq.disco;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.Protocol.Type;
import com.sissi.protocol.iq.disco.Info;
import com.sissi.protocol.iq.disco.feature.Blocking;
import com.sissi.protocol.iq.disco.feature.Bytestreams;
import com.sissi.protocol.iq.disco.feature.Identity;
import com.sissi.protocol.iq.disco.feature.Muc;
import com.sissi.protocol.iq.disco.feature.Si;
import com.sissi.protocol.iq.disco.feature.SiFileTransfer;
import com.sissi.protocol.iq.disco.feature.VCard;

/**
 * @author kim 2013年12月18日
 */
public class DiscoInfo2RobotProcessor implements Input {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		context.write(Info.class.cast(protocol).add(Identity.FEATURE_PROXY).add(Bytestreams.FEATURE).add(SiFileTransfer.FEATURE).add(Si.FEATURE).add(VCard.FEATURE).add(Blocking.FEATURE).add(Muc.FEATURE).getParent().reply().setTo(context.getJid().asStringWithBare()).setType(Type.RESULT));
		return true;
	}
}
