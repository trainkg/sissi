package com.sissi.pipeline.in.iq.register;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.pipeline.in.iq.IQProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.IQ;
import com.sissi.protocol.iq.register.Register;
import com.sissi.ucenter.RegisterContext;
import com.sissi.ucenter.field.Fields;

/**
 * @author kim 2013年12月5日
 */
abstract class RegisterStoreProcessor implements Input {

	private final RegisterContext registerContext;

	private final IQProcessor processor;

	public RegisterStoreProcessor(RegisterContext registerContext, IQProcessor processor) {
		super();
		this.registerContext = registerContext;
		this.processor = processor;
	}

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		return this.registerContext.register(this.process(protocol.cast(Register.class))) ? true : this.processor.input(context, protocol.getParent().cast(IQ.class).clear());
	}

	abstract protected Fields process(Fields fields);
}
