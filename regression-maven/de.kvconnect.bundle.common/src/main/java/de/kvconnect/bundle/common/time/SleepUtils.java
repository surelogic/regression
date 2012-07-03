package de.kvconnect.bundle.common.time;

import java.util.concurrent.TimeUnit;

/**
 * Helper Methoden fuer den Wartezustand.
 * 
 * @author hartmann_t
 */
public final class SleepUtils
{
	/**
	 * Sleeping Mode mit Angabe der Zeiteinheit.
	 * 
	 * @param timeUnit Zeiteinheit (z.B. Millis, Nanos, Sekunden,..)
	 * @param duration Wartezeit
	 */
	public static void safeSleep(final TimeUnit timeUnit, final long duration)
	{
		safeSleep(timeUnit.toMillis(duration));
	}

	/**
	 * Sleeping Mode.
	 * 
	 * @param durationInMilliSecs Wartezeit in Millis
	 */
	public static void safeSleep(final long durationInMilliSecs)
	{
		try
		{
			Thread.sleep(durationInMilliSecs);
		}
		catch (final InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

	private SleepUtils()
	{
	}
}
