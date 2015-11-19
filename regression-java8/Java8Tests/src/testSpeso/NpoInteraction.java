package testSpeso;

public class NpoInteraction {
	//TODO: Should probably be an enum
	public static final String BLANK_STATUS = "";
	public static final String INITIAL_STATUS = "Initial Email Sent";
	public static final String SCHEDULED_STATUS = "Scheduled";
	public static final String FOLLOW_UP_STATUS = "Follow Up (Did not reach)";
	public static final String DECLINED_STATUS = "Declined";
	// public static final String APT_SCHEDULED_STATUS =
	// "Appointment Scheduled";
	public static final String ATTENDED_APT_STATUS = "Attended Appointment";
	public static final String DID_NOT_ATTEND_APT_STATUS = "Did not attend Appointment";

	public static final ImmutableSet<String> STATUSES = ImmutableSet.of(
			// INITIAL_STATUS,
			BLANK_STATUS,
			SCHEDULED_STATUS, FOLLOW_UP_STATUS, DECLINED_STATUS,
			// APT_SCHEDULED_STATUS,
			ATTENDED_APT_STATUS, DID_NOT_ATTEND_APT_STATUS);
	
	public static final ImmutableSet<String> COMPLETE_STATUSES = ImmutableSet
			.of(ATTENDED_APT_STATUS, DID_NOT_ATTEND_APT_STATUS, DECLINED_STATUS);
			
}
