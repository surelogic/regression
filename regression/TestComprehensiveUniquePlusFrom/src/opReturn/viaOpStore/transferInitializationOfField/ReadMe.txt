There is no way to trigger error messages from opReturn via opStore when 
performing an initialization of a field.  This is because there can never be
any formal parameters in scope when fields are initialized.  @Borrowed fields
must be initialized in a constructor.
