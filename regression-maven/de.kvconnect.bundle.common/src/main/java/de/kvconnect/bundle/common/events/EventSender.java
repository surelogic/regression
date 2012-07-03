package de.kvconnect.bundle.common.events;

import java.util.Collections;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public final class EventSender
{

	private EventSender()
	{
	}

	public static void trayMsg(String msg, BundleContext context)
	{
		final String topic = context.getProperty("event.tray.msg");
		if (topic != null)
		{
			sendEvent(topic, "MSG", msg, context);
		}
	}

	public static void sendEvent(String topic, String type, String msg, BundleContext context)
	{
		final ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
		if (ref != null)
		{
			final EventAdmin eventAdmin = (EventAdmin) context.getService(ref);

			final Map<String, String> propMap = Collections.singletonMap(type, msg);

			final Event reportGeneratedEvent = new Event(topic, propMap);

			eventAdmin.sendEvent(reportGeneratedEvent);
		}
	}
}
