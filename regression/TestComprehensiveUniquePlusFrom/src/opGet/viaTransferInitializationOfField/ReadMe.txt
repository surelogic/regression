Cannot figure out how to trigger this with via transferInitializationOfField.
(1) there is no way to have a @Unique receiver inside a constructor
(2) previously noted in transferUseReceiver that there isn't a way to trigger
    the error with a borrowed receiver.
    