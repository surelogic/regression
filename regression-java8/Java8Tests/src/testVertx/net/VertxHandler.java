package testVertx.net;

import testVertx.ContextImpl;
import io.netty.channel.*;

public abstract class VertxHandler<C extends ConnectionBase> extends ChannelDuplexHandler {
	protected abstract C getConnection(Channel ch);	
	
	protected ContextImpl getContext(C connection) {
		return connection.getContext();
	}	
	
	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		Channel ch = ctx.channel();
		C conn = getConnection(ch);
		if (conn != null) {
			ContextImpl context = getContext(conn);
			context.executeFromIO(conn::handleInterestedOpsChanged);
		}
	}
}
