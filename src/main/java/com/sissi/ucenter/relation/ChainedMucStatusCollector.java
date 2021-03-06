package com.sissi.ucenter.relation;

import java.util.List;

import com.sissi.ucenter.MucStatusCollector;
import com.sissi.ucenter.MucStatusComputer;
import com.sissi.ucenter.MucStatusJudge;

/**
 * @author kim 2014年2月21日
 */
public class ChainedMucStatusCollector implements MucStatusComputer {

	private final List<MucStatusComputer> chained;

	public ChainedMucStatusCollector(List<MucStatusComputer> chained) {
		super();
		this.chained = chained;
	}

	@Override
	public MucStatusComputer collect(MucStatusCollector status, MucStatusJudge judge) {
		for (MucStatusComputer collector : this.chained) {
			collector.collect(status, judge);
		}
		return this;
	}
}
