package de.kvconnect.bundle.common;

/**
 * The Class Games.
 * 
 * @author caipi-connect
 */
public class Games
{
	private static final int CHAR_PRINT_SLEEPING_TIME_IN_MILLIS = 20;
	private static final int LINE_PRINT_SLEEPING_TIME_IN_MILLIS = 180;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/** The games. */
	private String[] games = {
			LINE_SEPARATOR + LINE_SEPARATOR + LINE_SEPARATOR,
			"GREETINGS PROFESSOR FALKEN" + LINE_SEPARATOR, // - 
			LINE_SEPARATOR, // -
			"HELLO" + LINE_SEPARATOR, // - 
			LINE_SEPARATOR, // -
			"DO YOU WANT TO PLAY A GAME?" + LINE_SEPARATOR, // -
			LINE_SEPARATOR, // -
			"CHESS" + LINE_SEPARATOR, // -
			"POKER" + LINE_SEPARATOR, // -
			"FIGHTER COMBAT" + LINE_SEPARATOR, // -
			"GUERILLA ENGAGEMENT" + LINE_SEPARATOR, // -
			"DESERT WARFARE" + LINE_SEPARATOR, // -
			"AIR-TO-GROUND ACTIONS" + LINE_SEPARATOR, // -
			"THEATERWIDE TACTICAL WARFARE" + LINE_SEPARATOR,
			"THEATERWIDE BIOTOXIC AND CHEMICAL WARFARE" + LINE_SEPARATOR, // -
			LINE_SEPARATOR, // -
			"GLOBAL THERMONUCLEAR WAR" + LINE_SEPARATOR, // -
			LINE_SEPARATOR, // -
			"A STRANGE GAME." + LINE_SEPARATOR, // -
			"THE ONLY WINNING MOVE IS" + LINE_SEPARATOR, // -
			"NOT TO PLAY." + LINE_SEPARATOR, // -
			LINE_SEPARATOR + LINE_SEPARATOR + ". . . . . . CHEERS CAIPI CONNECT." + LINE_SEPARATOR };

	/**
	 * Instantiates a new games.
	 */
	public Games()
	{
		start();
	}

	/**
	 * Start.
	 */
	public void start()
	{
		for (String game : games)
		{
			for (char character : game.toCharArray())
			{
				System.out.print(character);
				waitInMillis(CHAR_PRINT_SLEEPING_TIME_IN_MILLIS);
			}
			waitInMillis(LINE_PRINT_SLEEPING_TIME_IN_MILLIS);
		}
	}

	/**
	 * This method starts a sleeping thread and waits the specify time in millis.<br>
	 * Exceptions are ignored.
	 * 
	 * @param sleepingTimeInMillis the length of time to sleep in milliseconds
	 */
	private void waitInMillis(long sleepingTimeInMillis)
	{
		try
		{
			Thread.sleep(sleepingTimeInMillis);
		}
		catch (InterruptedException ignore)
		//CHECKSTYLE:OFF 
		{
			//CHECKSTYLE:ON 
		}
	}
}
